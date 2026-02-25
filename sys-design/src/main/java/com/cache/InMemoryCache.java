package com.cache;

import java.util.Map;
import java.util.concurrent.*;

public class InMemoryCache<K,V> {

    Map<K, Entry<V>> map = new ConcurrentHashMap<>();
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    InMemoryCache(long cleanupInterval) {
        executor.schedule(this::cleanUp, cleanupInterval, TimeUnit.SECONDS);
    }

    void cleanUp() {
        map.entrySet().removeIf(e -> e.getValue().isExpired());
    }

    V get(K key)
    {
        Entry<V> entry = map.get(key);
        if(entry == null || entry.isExpired())
        {
            return null;
        }
        return entry.value;
    }

    void put(K key, V value,long ttl)
    {
        Entry<V> entry = new Entry<>(value,ttl);
        map.put(key, entry);
    }


    static class Entry<V> {
        V value;
        long expiryTime;

        Entry(V value, long ttl) {
            this.value = value;
            expiryTime = System.currentTimeMillis() + ttl;
        }

        boolean isExpired() {
            return System.currentTimeMillis() > expiryTime;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        InMemoryCache<String, String> cache = new InMemoryCache<>(2000); // cleanup every 2s

        cache.put("token1", "sri", 3000); // 3s TTL
        cache.put("token2", "sri1", 2500);
        System.out.println("Before expiry: " + cache.get("token1"));
        System.out.println("Before expiry: " + cache.get("token2"));

        Thread.sleep(4000);
        System.out.println("After expiry: " + cache.get("token1"));
        System.out.println("After expiry: " + cache.get("token2"));
    }
}


