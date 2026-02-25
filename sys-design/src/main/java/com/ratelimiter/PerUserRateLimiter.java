package com.ratelimiter;

import org.redisson.Redisson;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.api.RateIntervalUnit;
import org.redisson.api.RateType;
import java.util.concurrent.TimeUnit;

public class PerUserRateLimiter {
    public static void main(String[] args) throws InterruptedException {
        // Connect to Redis
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://127.0.0.1:6379");

        RedissonClient redisson = Redisson.create(config);

        // Simulate multiple users


        for (int i=0; i < 20;i++) {
            Thread.sleep(1000);
            if (isRequestAllowed(redisson, "1")) {
                System.out.println("✅ count:" + i + " allowed");
            } else {
                System.out.println("✅ count:" + i + " not allowed");
            }
        }

        Thread.sleep(3000);
        redisson.shutdown();
    }

    private static boolean isRequestAllowed(RedissonClient redisson, String userId) {
        String limiterKey = "rate_limiter:user:" + userId;
        RRateLimiter limiter = redisson.getRateLimiter(limiterKey);

        // Initialize: 3 requests per 15 seconds
        boolean init = limiter.trySetRate(RateType.OVERALL, 3, 5, RateIntervalUnit.SECONDS);

        System.out.println("Init:" + init);
        limiter.expire(30, TimeUnit.SECONDS);

        return limiter.tryAcquire();  // returns false if limit exceeded
    }
}

