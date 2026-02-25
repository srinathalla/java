package com.lld.likesdislikes;

public  enum UserTier {
    FREE(1),    // Max 100 reactions per day
    PREMIUM(100), // Max 1000 reactions per day
    UNLIMITED(Integer.MAX_VALUE);

    private final int dailyLimit;
    UserTier(int dailyLimit) { this.dailyLimit = dailyLimit; }
    public int getDailyLimit() { return dailyLimit; }
}
