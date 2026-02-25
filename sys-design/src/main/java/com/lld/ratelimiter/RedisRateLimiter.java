package com.lld.ratelimiter;

import org.redisson.Redisson;
import org.redisson.api.RScript;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.Arrays;
import java.util.List;

public class RedisRateLimiter {

    private static final String LUA = """
        local maxTokens = tonumber(tostring(ARGV[1])) or 5
        local refillRate = tonumber(tostring(ARGV[2])) or 5
      
        local time = redis.call("TIME")
        local now = (time[1] * 1000) + math.floor(time[2] / 1000)

        local lastRefill = tonumber(redis.call("GET", KEYS[2]))
        if lastRefill == nil then lastRefill = now end

        local tokens = tonumber(redis.call("GET", KEYS[1]))
        if tokens == nil then tokens = maxTokens end

        local delta = math.max(0, now - lastRefill)
        local refill = (delta / 1000) * refillRate
        tokens = math.min(maxTokens, tokens + refill)

        if tokens < 1 then
            redis.call("SET", KEYS[1], tokens)
            redis.call("SET", KEYS[2], now)
            return 0
        else
            tokens = tokens - 1
            redis.call("SET", KEYS[1], tokens)
            redis.call("SET", KEYS[2], now)
            return 1
        end
        """;
    private final static RedissonClient redissonClient = createClient();
    public static RedissonClient createClient() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://127.0.0.1:6379")
                .setConnectionMinimumIdleSize(5)
                .setConnectionPoolSize(20)
                .setTimeout(3000)
                .setRetryAttempts(3)
                .setRetryInterval(1500);

        return Redisson.create(config);
    }
    public boolean allowRequest(String userId, int maxTokens, int refillRate) {



        RScript script = redissonClient.getScript();
        List<Object> keys = Arrays.asList(
                "rate:" + userId + ":tokens",
                "rate:" + userId + ":ts"
        );

        Object[] args = new Object[]{String.valueOf(maxTokens), String.valueOf(refillRate)};
        Long result = script.eval(
                RScript.Mode.READ_WRITE,
                LUA,
                RScript.ReturnType.INTEGER,
                keys,
                args
        );

        return result == 1;
    }

    public static void main(String[] args) throws Exception {

        RedisRateLimiter limiter = new RedisRateLimiter();

        for (int i = 1; i <= 15; i++) {
            boolean allowed = limiter.allowRequest("user123", 10, 10);
            System.out.println("Request " + i + " -> " + (allowed ? "ALLOWED" : "BLOCKED"));
            Thread.sleep(100); // simulate traffic
        }
    }

}
