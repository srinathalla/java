package com.lld.ratelimiter;

// =============================================================================
// API Rate Limiter Implementation in Java
// Supports multiple algorithms: Token Bucket, Sliding Window, Fixed Window
// =============================================================================

import java.util.*;
import java.util.concurrent.*;

// =============================================================================
// INTERFACES AND ENUMS
// =============================================================================

interface RateLimiter {
    boolean allowRequest(String clientId);
    boolean allowRequest(String clientId, int tokens);
    void reset(String clientId);
    RateLimitStatus getStatus(String clientId);
}

enum RateLimitType {
    TOKEN_BUCKET,
    SLIDING_WINDOW,
    FIXED_WINDOW
}

class RateLimitStatus {
    private final boolean allowed;
    private final int remainingRequests;
    private final long resetTimeMillis;
    private final String message;

    public RateLimitStatus(boolean allowed, int remainingRequests, long resetTimeMillis, String message) {
        this.allowed = allowed;
        this.remainingRequests = remainingRequests;
        this.resetTimeMillis = resetTimeMillis;
        this.message = message;
    }

    // Getters
    public boolean isAllowed() { return allowed; }
    public int getRemainingRequests() { return remainingRequests; }
    public long getResetTimeMillis() { return resetTimeMillis; }
    public String getMessage() { return message; }

    @Override
    public String toString() {
        return String.format("RateLimitStatus{allowed=%s, remaining=%d, resetTime=%d, message='%s'}",
                allowed, remainingRequests, resetTimeMillis, message);
    }
}

// =============================================================================
// 1. TOKEN BUCKET ALGORITHM
// =============================================================================

class TokenBucketRateLimiter implements RateLimiter {
    private final int capacity;
    private final int refillRate; // tokens per second
    private final ConcurrentHashMap<String, TokenBucket> buckets;

    private static class TokenBucket {
        private final int capacity;
        private final int refillRate;
        private volatile int tokens;
        private volatile long lastRefillTime;

        public TokenBucket(int capacity, int refillRate) {
            this.capacity = capacity;
            this.refillRate = refillRate;
            this.tokens = capacity;
            this.lastRefillTime = System.currentTimeMillis();
        }

        public synchronized boolean consume(int tokensRequired) {
            refill();
            if (tokens >= tokensRequired) {
                tokens -= tokensRequired;
                return true;
            }
            return false;
        }

        private void refill() {
            long now = System.currentTimeMillis();
            long timePassed = now - lastRefillTime;

            if (timePassed > 0) {
                int tokensToAdd = (int) (timePassed * refillRate / 1000);
                tokens = Math.min(capacity, tokens + tokensToAdd);
                lastRefillTime = now;
            }
        }

        public synchronized int getAvailableTokens() {
            refill();
            return tokens;
        }
    }

    public TokenBucketRateLimiter(int capacity, int refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.buckets = new ConcurrentHashMap<>();
    }

    @Override
    public boolean allowRequest(String clientId) {
        return allowRequest(clientId, 1);
    }

    @Override
    public boolean allowRequest(String clientId, int tokens) {
        TokenBucket bucket = buckets.computeIfAbsent(clientId,
                k -> new TokenBucket(capacity, refillRate));
        return bucket.consume(tokens);
    }

    @Override
    public void reset(String clientId) {
        buckets.remove(clientId);
    }

    @Override
    public RateLimitStatus getStatus(String clientId) {
        TokenBucket bucket = buckets.get(clientId);
        if (bucket == null) {
            return new RateLimitStatus(true, capacity, 0, "New client");
        }

        int remaining = bucket.getAvailableTokens();
        boolean allowed = remaining > 0;
        String message = allowed ? "Request allowed" : "Rate limit exceeded";

        return new RateLimitStatus(allowed, remaining, 0, message);
    }
}

// =============================================================================
// 2. SLIDING WINDOW LOG ALGORITHM
// =============================================================================

class SlidingWindowRateLimiter implements RateLimiter {
    private final int maxRequests;
    private final long windowSizeMillis;
    private final ConcurrentHashMap<String, Queue<Long>> requestLogs;

    public SlidingWindowRateLimiter(int maxRequests, long windowSizeSeconds) {
        this.maxRequests = maxRequests;
        this.windowSizeMillis = windowSizeSeconds * 1000;
        this.requestLogs = new ConcurrentHashMap<>();
    }

    @Override
    public boolean allowRequest(String clientId) {
        return allowRequest(clientId, 1);
    }

    @Override
    public boolean allowRequest(String clientId, int tokens) {
        long now = System.currentTimeMillis();
        Queue<Long> log = requestLogs.computeIfAbsent(clientId,
                k -> new ConcurrentLinkedQueue<>());

        synchronized (log) {
            // Remove old entries
            while (!log.isEmpty() && now - log.peek() > windowSizeMillis) {
                log.poll();
            }

            // Check if request can be allowed
            if (log.size() + tokens <= maxRequests) {
                // Add current request timestamps
                for (int i = 0; i < tokens; i++) {
                    log.offer(now);
                }
                return true;
            }

            return false;
        }
    }

    @Override
    public void reset(String clientId) {
        requestLogs.remove(clientId);
    }

    @Override
    public RateLimitStatus getStatus(String clientId) {
        Queue<Long> log = requestLogs.get(clientId);
        if (log == null) {
            return new RateLimitStatus(true, maxRequests, 0, "New client");
        }

        long now = System.currentTimeMillis();
        synchronized (log) {
            // Clean old entries
            while (!log.isEmpty() && now - log.peek() > windowSizeMillis) {
                log.poll();
            }

            int currentRequests = log.size();
            int remaining = Math.max(0, maxRequests - currentRequests);
            boolean allowed = remaining > 0;

            // Calculate reset time (when oldest request expires)
            long resetTime = log.isEmpty() ? 0 : log.peek() + windowSizeMillis;

            String message = allowed ? "Request allowed" : "Rate limit exceeded";
            return new RateLimitStatus(allowed, remaining, resetTime, message);
        }
    }
}

// =============================================================================
// 3. FIXED WINDOW COUNTER ALGORITHM
// =============================================================================

class FixedWindowRateLimiter implements RateLimiter {
    private final int maxRequests;
    private final long windowSizeMillis;
    private final ConcurrentHashMap<String, WindowCounter> counters;

    private static class WindowCounter {
        private volatile int count;
        private volatile long windowStart;
        private final long windowSize;

        public WindowCounter(long windowSize) {
            this.windowSize = windowSize;
            this.count = 0;
            this.windowStart = System.currentTimeMillis();
        }

        public synchronized boolean consume(int tokens, int maxRequests) {
            long now = System.currentTimeMillis();

            // Check if we need to reset the window
            if (now - windowStart >= windowSize) {
                count = 0;
                windowStart = now;
            }

            // Check if request can be allowed
            if (count + tokens <= maxRequests) {
                count += tokens;
                return true;
            }

            return false;
        }

        public synchronized int getCurrentCount() {
            long now = System.currentTimeMillis();
            if (now - windowStart >= windowSize) {
                return 0;
            }
            return count;
        }

        public synchronized long getWindowResetTime() {
            return windowStart + windowSize;
        }
    }

    public FixedWindowRateLimiter(int maxRequests, long windowSizeSeconds) {
        this.maxRequests = maxRequests;
        this.windowSizeMillis = windowSizeSeconds * 1000;
        this.counters = new ConcurrentHashMap<>();
    }

    @Override
    public boolean allowRequest(String clientId) {
        return allowRequest(clientId, 1);
    }

    @Override
    public boolean allowRequest(String clientId, int tokens) {
        WindowCounter counter = counters.computeIfAbsent(clientId,
                k -> new WindowCounter(windowSizeMillis));
        return counter.consume(tokens, maxRequests);
    }

    @Override
    public void reset(String clientId) {
        counters.remove(clientId);
    }

    @Override
    public RateLimitStatus getStatus(String clientId) {
        WindowCounter counter = counters.get(clientId);
        if (counter == null) {
            return new RateLimitStatus(true, maxRequests, 0, "New client");
        }

        int currentCount = counter.getCurrentCount();
        int remaining = Math.max(0, maxRequests - currentCount);
        boolean allowed = remaining > 0;
        long resetTime = counter.getWindowResetTime();

        String message = allowed ? "Request allowed" : "Rate limit exceeded";
        return new RateLimitStatus(allowed, remaining, resetTime, message);
    }
}

// =============================================================================
// 4. RATE LIMITER FACTORY
// =============================================================================

class RateLimiterFactory {
    public static RateLimiter createRateLimiter(RateLimitType type, int maxRequests, long windowSeconds) {
        switch (type) {
            case TOKEN_BUCKET:
                return new TokenBucketRateLimiter(maxRequests, maxRequests / (int)windowSeconds);
            case SLIDING_WINDOW:
                return new SlidingWindowRateLimiter(maxRequests, windowSeconds);
            case FIXED_WINDOW:
                return new FixedWindowRateLimiter(maxRequests, windowSeconds);
            default:
                throw new IllegalArgumentException("Unknown rate limit type: " + type);
        }
    }
}

// =============================================================================
// 5. API RATE LIMITER SERVICE (PRODUCTION-READY)
// =============================================================================

class ApiRateLimiterService {
    private final Map<String, RateLimiter> rateLimiters;
    private final RateLimitType defaultType;

    // Configuration for different API endpoints
    private static class EndpointConfig {
        final int maxRequests;
        final long windowSeconds;
        final RateLimitType type;

        EndpointConfig(int maxRequests, long windowSeconds, RateLimitType type) {
            this.maxRequests = maxRequests;
            this.windowSeconds = windowSeconds;
            this.type = type;
        }
    }

    public ApiRateLimiterService() {
        this.rateLimiters = new ConcurrentHashMap<>();
        this.defaultType = RateLimitType.TOKEN_BUCKET;
        initializeDefaultRateLimiters();
    }

    private void initializeDefaultRateLimiters() {
        // Configure rate limits for different API endpoints
        Map<String, EndpointConfig> configs = new HashMap<>();
        configs.put("login", new EndpointConfig(5, 60, RateLimitType.FIXED_WINDOW)); // 5 per minute
        configs.put("api/users", new EndpointConfig(100, 3600, RateLimitType.TOKEN_BUCKET)); // 100 per hour
        configs.put("api/search", new EndpointConfig(1000, 3600, RateLimitType.SLIDING_WINDOW)); // 1000 per hour
        configs.put("api/upload", new EndpointConfig(10, 60, RateLimitType.TOKEN_BUCKET)); // 10 per minute

        for (Map.Entry<String, EndpointConfig> entry : configs.entrySet()) {
            String endpoint = entry.getKey();
            EndpointConfig config = entry.getValue();
            rateLimiters.put(endpoint, RateLimiterFactory.createRateLimiter(
                    config.type, config.maxRequests, config.windowSeconds));
        }
    }

    public boolean isRequestAllowed(String endpoint, String clientId) {
        RateLimiter limiter = rateLimiters.get(endpoint);
        if (limiter == null) {
            // Default rate limiter for unknown endpoints
            limiter = RateLimiterFactory.createRateLimiter(defaultType, 60, 60); // 60 per minute
            rateLimiters.put(endpoint, limiter);
        }

        return limiter.allowRequest(clientId);
    }

    public RateLimitStatus getRequestStatus(String endpoint, String clientId) {
        RateLimiter limiter = rateLimiters.get(endpoint);
        if (limiter == null) {
            return new RateLimitStatus(true, 60, 0, "Default rate limit");
        }

        return limiter.getStatus(clientId);
    }

    public void resetClientLimits(String endpoint, String clientId) {
        RateLimiter limiter = rateLimiters.get(endpoint);
        if (limiter != null) {
            limiter.reset(clientId);
        }
    }

    public void addCustomEndpoint(String endpoint, int maxRequests, long windowSeconds, RateLimitType type) {
        rateLimiters.put(endpoint, RateLimiterFactory.createRateLimiter(type, maxRequests, windowSeconds));
    }
}

// =============================================================================
// 6. HTTP FILTER INTEGRATION (Spring Boot Style)
// =============================================================================

class RateLimitFilter {
    private final ApiRateLimiterService rateLimiterService;

    public RateLimitFilter(ApiRateLimiterService rateLimiterService) {
        this.rateLimiterService = rateLimiterService;
    }

    public FilterResult filterRequest(String endpoint, String clientId, String clientIp) {
        // Use client ID if available, otherwise use IP address
        String identifier = clientId != null ? clientId : clientIp;

        RateLimitStatus status = rateLimiterService.getRequestStatus(endpoint, identifier);

        if (!rateLimiterService.isRequestAllowed(endpoint, identifier)) {
            return new FilterResult(false, 429, createRateLimitHeaders(status),
                    "Rate limit exceeded. Try again later.");
        }

        // Request allowed
        RateLimitStatus newStatus = rateLimiterService.getRequestStatus(endpoint, identifier);
        return new FilterResult(true, 200, createRateLimitHeaders(newStatus), "Request allowed");
    }

    private Map<String, String> createRateLimitHeaders(RateLimitStatus status) {
        Map<String, String> headers = new HashMap<>();
        headers.put("X-RateLimit-Remaining", String.valueOf(status.getRemainingRequests()));
        headers.put("X-RateLimit-Reset", String.valueOf(status.getResetTimeMillis() / 1000));
        headers.put("X-RateLimit-Limit", "Varies by endpoint");
        return headers;
    }

    static class FilterResult {
        private final boolean allowed;
        private final int httpStatus;
        private final Map<String, String> headers;
        private final String message;

        public FilterResult(boolean allowed, int httpStatus, Map<String, String> headers, String message) {
            this.allowed = allowed;
            this.httpStatus = httpStatus;
            this.headers = headers;
            this.message = message;
        }

        // Getters
        public boolean isAllowed() { return allowed; }
        public int getHttpStatus() { return httpStatus; }
        public Map<String, String> getHeaders() { return headers; }
        public String getMessage() { return message; }
    }
}

// =============================================================================
// 7. EXAMPLE USAGE AND TESTING
// =============================================================================

public class RateLimiterDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== API Rate Limiter Demo ===\n");

        // Test different algorithms
        testTokenBucket();
        //testSlidingWindow();
        //testFixedWindow();
        //testApiService();
    }

    private static void testTokenBucket() {
        System.out.println("1. Token Bucket Test:");
        RateLimiter limiter = new TokenBucketRateLimiter(5, 2); // 5 tokens, refill 2 per second

        String clientId = "user1";

        // Make 7 requests quickly
        for (int i = 1; i <= 7; i++) {
            boolean allowed = limiter.allowRequest(clientId);
            RateLimitStatus status = limiter.getStatus(clientId);
            System.out.printf("Request %d: %s (remaining: %d)\n",
                    i, allowed ? "ALLOWED" : "DENIED", status.getRemainingRequests());
        }
        System.out.println();
    }

    private static void testSlidingWindow() {
        System.out.println("2. Sliding Window Test:");
        RateLimiter limiter = new SlidingWindowRateLimiter(3, 5); // 3 requests per 5 seconds

        String clientId = "user2";

        // Make requests and show status
        for (int i = 1; i <= 5; i++) {
            boolean allowed = limiter.allowRequest(clientId);
            RateLimitStatus status = limiter.getStatus(clientId);
            System.out.printf("Request %d: %s (remaining: %d)\n",
                    i, allowed ? "ALLOWED" : "DENIED", status.getRemainingRequests());
        }
        System.out.println();
    }

    private static void testFixedWindow() {
        System.out.println("3. Fixed Window Test:");
        RateLimiter limiter = new FixedWindowRateLimiter(4, 10); // 4 requests per 10 seconds

        String clientId = "user3";

        for (int i = 1; i <= 6; i++) {
            boolean allowed = limiter.allowRequest(clientId);
            RateLimitStatus status = limiter.getStatus(clientId);
            System.out.printf("Request %d: %s (remaining: %d, reset: %d)\n",
                    i, allowed ? "ALLOWED" : "DENIED", status.getRemainingRequests(),
                    status.getResetTimeMillis());
        }
        System.out.println();
    }

    private static void testApiService() {
        System.out.println("4. API Service Test:");
        ApiRateLimiterService service = new ApiRateLimiterService();
        RateLimitFilter filter = new RateLimitFilter(service);

        String clientId = "testuser";
        String[] endpoints = {"login", "api/users", "api/search"};

        for (String endpoint : endpoints) {
            System.out.printf("Testing endpoint: %s\n", endpoint);

            for (int i = 1; i <= 3; i++) {
                RateLimitFilter.FilterResult result = filter.filterRequest(endpoint, clientId, "192.168.1.1");
                System.out.printf("  Request %d: %s (%d) - %s\n",
                        i, result.isAllowed() ? "ALLOWED" : "DENIED",
                        result.getHttpStatus(), result.getMessage());
            }
        }

        System.out.println("\n=== Demo Complete ===");
    }
}

