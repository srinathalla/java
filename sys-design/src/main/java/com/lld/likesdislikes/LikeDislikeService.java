package com.lld.likesdislikes;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class LikeDislikeService {

    ConcurrentHashMap<String, Set<String>> likes = new ConcurrentHashMap<>();
    ConcurrentHashMap<String, Set<String>> dislikes = new ConcurrentHashMap<>();
    ConcurrentHashMap<String,Object> locks = new ConcurrentHashMap<>();
    ConcurrentHashMap<String,UserProfile> profiles = new ConcurrentHashMap<>();

  Object getLock(String postId)
  {
      return locks.computeIfAbsent(postId, k-> new Object());
  }

  void registeerUser(String userId, UserTier tier)
  {
      profiles.computeIfAbsent(userId, k -> new UserProfile(userId,tier));
  }
    boolean like(String postId, String userId)
    {
        UserProfile profile = profiles.get(userId);
        if(profile == null || !profile.canReact())
        {
            return false;
        }
        synchronized (getLock(postId)) {
            likes.computeIfAbsent(postId, k -> ConcurrentHashMap.newKeySet());
            dislikes.computeIfAbsent(postId, k -> ConcurrentHashMap.newKeySet());

            dislikes.get(postId).remove(userId);
            likes.get(postId).add(userId);
        }

        return true;
    }

    boolean dislike(String postId, String userId)
    {
        UserProfile profile = profiles.get(userId);
        if(profile == null || !profile.canReact())
        {
            return false;
        }
        synchronized (getLock(postId)) {
            likes.computeIfAbsent(postId, k -> ConcurrentHashMap.newKeySet());
            dislikes.computeIfAbsent(postId, k -> ConcurrentHashMap.newKeySet());

            likes.get(postId).remove(userId);
            dislikes.get(postId).add(userId);
        }

        return true;
    }

    public int getLikesCount(String postId) {
        return likes.getOrDefault(postId,ConcurrentHashMap.newKeySet()).size();
    }

    public int getDisLikesCount(String postId) {
        return dislikes.getOrDefault(postId,ConcurrentHashMap.newKeySet()).size();
    }

    void removeReaction(String postId, String userId)
    {
        likes.getOrDefault(postId,ConcurrentHashMap.newKeySet()).remove(userId);
        dislikes.getOrDefault(postId,ConcurrentHashMap.newKeySet()).remove(userId);
    }

    public static void main(String[] args) {
        LikeDislikeService likeDislikeService = new LikeDislikeService();
        likeDislikeService.registeerUser("u1", UserTier.FREE);
        likeDislikeService.like("p1","u1");

        System.out.println(likeDislikeService.getLikesCount("p1"));

        likeDislikeService.dislike("p1","u1");

        System.out.println(likeDislikeService.getLikesCount("p1"));
        System.out.println(likeDislikeService.getDisLikesCount("p1"));

    }
}
