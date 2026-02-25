package com.ratelimiter;

public class App {
    public static void main(String[] args) {
        JedisRateLimiter limiter = new JedisRateLimiter("localhost", 5, 60); // 5 requests per 60 seconds

        String userId = "user123";
        if (limiter.isAllowed(userId)) {
            System.out.println("Request allowed");
        } else {
            System.out.println("Rate limit exceeded");
        }
    }
}
