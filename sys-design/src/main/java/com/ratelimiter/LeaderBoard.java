package com.ratelimiter;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;

public class LeaderBoard {

    public static RedissonClient createClient() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://127.0.0.1:6379")
                .setConnectionMinimumIdleSize(1);
        return Redisson.create(config);
    }

    public static void main(String[] args) {
        RedissonClient redisson = createClient();

        // Get sorted set
        RScoredSortedSet<String> leaderboard = redisson.getScoredSortedSet("leaderboard");

        // Add members with scores
        leaderboard.add(100, "Alice");
        leaderboard.add(200, "Bob");
        leaderboard.add(150, "Charlie");

        // Increase score
        leaderboard.addScore("Alice", 50);

        // Get rank (0-based, lowest score first)
        int rank = leaderboard.rank("Alice");
        System.out.println("Alice's ascending rank: " + rank);

        // Reverse rank (highest score first)
        int revRank = leaderboard.revRank("Alice");
        System.out.println("Alice's descending rank: " + revRank);

        // Get score
        double score = leaderboard.getScore("Alice");
        System.out.println("Alice's score: " + score);

        // Get top N players
        System.out.println("Top 2 players:");
        leaderboard.entryRangeReversed(0, 1).forEach(e ->
                System.out.println(e.getValue() + ": " + e.getScore())
        );

        // Clean up
        leaderboard.delete();
        redisson.shutdown();
    }
}
