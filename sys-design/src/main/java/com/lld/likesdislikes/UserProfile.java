package com.lld.likesdislikes;

public class UserProfile {


    String userId;
    UserTier tier;
    long dailyCount;
    long lastResetTime;


    public UserProfile(String userId, UserTier tier)
    {
        this.userId = userId;
        this.tier = tier;
        this.dailyCount = 0;
        this.lastResetTime = System.currentTimeMillis();
    }


    public boolean canReact()
    {
        long now = System.currentTimeMillis();

        if(now - lastResetTime > 24*60*60*1000)
        {
            dailyCount = 0;
            lastResetTime = System.currentTimeMillis();
        }

        if(dailyCount < tier.getDailyLimit())
        {
            dailyCount++;
            return true;
        }
        return false;
    }
}
