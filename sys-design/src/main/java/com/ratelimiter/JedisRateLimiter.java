package com.ratelimiter;
import redis.clients.jedis.Jedis;
import java.time.Instant;

public class JedisRateLimiter {
    private final Jedis jedis;
    private final int limit;
    private final int windowInSeconds;

    public JedisRateLimiter(String redisHost, int limit, int windowInSeconds) {
        this.jedis = new Jedis(redisHost,6379);
        this.limit = limit;
        this.windowInSeconds = windowInSeconds;
    }

    public boolean isAllowed(String userId) {
        long currentWindow = Instant.now().getEpochSecond() / windowInSeconds;
        String key = "rate_limiter:" + userId + ":" + currentWindow;

        Long count = jedis.incr(key);
        if (count == 1) {
            jedis.expire(key, windowInSeconds);
        }

        return count <= limit;
    }
}

