package com.ratelimiter;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.*;

public class ConsistentHashing<T> {

    private final TreeMap<Integer, T> ring = new TreeMap<>();
    private final int virtualNodeCount;
    private final MessageDigest md;

    public ConsistentHashing(List<T> nodes, int virtualNodeCount) {
        this.virtualNodeCount = virtualNodeCount;
        try {
            this.md = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            throw new RuntimeException("MD5 not available", e);
        }

        for (T node : nodes) {
            addNode(node);
        }
    }

    public void addNode(T node) {
        for (int i = 0; i < virtualNodeCount; i++) {
            int hash = hash(node.toString() + "#" + i);
            ring.put(hash, node);
        }
    }

    public void removeNode(T node) {
        for (int i = 0; i < virtualNodeCount; i++) {
            int hash = hash(node.toString() + "#" + i);
            ring.remove(hash);
        }
    }

    public T getNodeForKey(String key) {
        if (ring.isEmpty()) return null;

        int hash = hash(key);
        Map.Entry<Integer, T> entry = ring.ceilingEntry(hash);
        if (entry == null) {
            return ring.firstEntry().getValue(); // wrap around
        }
        return entry.getValue();
    }

    private int hash(String input) {
        byte[] digest = md.digest(input.getBytes(StandardCharsets.UTF_8));
        return ((digest[0] & 0xFF) << 24) | ((digest[1] & 0xFF) << 16)
                | ((digest[2] & 0xFF) << 8)  | (digest[3] & 0xFF);
    }

    // Debug helper
    public void printRing() {
        for (Map.Entry<Integer, T> entry : ring.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        List<String> nodes = Arrays.asList("RedisNode-A", "RedisNode-B", "RedisNode-C");

        ConsistentHashing<String> ch = new ConsistentHashing<>(nodes, 100);

        for (String key : List.of("user:1", "user:2", "session:XYZ", "cart:45")) {
            String node = ch.getNodeForKey(key);
            System.out.println("Key '" + key + "' is mapped to: " + node);
        }

        System.out.println("\nAfter removing RedisNode-B...\n");
        ch.removeNode("RedisNode-B");

        for (String key : List.of("user:1", "user:2", "session:XYZ", "cart:45")) {
            String node = ch.getNodeForKey(key);
            System.out.println("Key '" + key + "' is now mapped to: " + node);
        }
    }
}
