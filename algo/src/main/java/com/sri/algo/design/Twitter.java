package com.sri.algo.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Twitter {

	/** Initialize your data structure here. */
	Map<Integer, Set<Integer>> userFolloweeMap = new HashMap<>();
	Map<Integer, List<int[]>> userTweetsMap = new HashMap<>();
	int tweetCount = 0;

	public Twitter() {

	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		if (!userTweetsMap.containsKey(userId)) {
			userTweetsMap.put(userId, new ArrayList<>());
		}
		userTweetsMap.get(userId).add(new int[] {  tweetId, ++tweetCount });

	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
	 * the news feed must be posted by users who the user followed or by the user
	 * herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {

		List<int[]> tweets = new ArrayList<>();
		if (userTweetsMap.containsKey(userId)) {
			tweets.addAll(userTweetsMap.get(userId));
		}
		if (userFolloweeMap.containsKey(userId)) {
			for (int followee : userFolloweeMap.get(userId)) {
				if (followee != userId && userTweetsMap.containsKey(followee)) {
					tweets.addAll(userTweetsMap.get(followee));
				}
			}
		}
		Collections.sort(tweets, (a, b) -> (int) (b[1] - a[1]));
		List<Integer> res = new ArrayList<>();
        int i =0;
		for (int[] tweet : tweets) {
			res.add(tweet[0]);
            if(++i == 10)
            {
                break;
            }
		}
		return res;

	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {

		if (!userFolloweeMap.containsKey(followerId)) {
			userFolloweeMap.put(followerId, new HashSet<>());
		}
		userFolloweeMap.get(followerId).add(followeeId);
	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void unfollow(int followerId, int followeeId) {
        if(userFolloweeMap.containsKey(followerId) && userFolloweeMap.get(followerId).contains(followeeId))
        {
		    userFolloweeMap.get(followerId).remove(followeeId);
        }
	}

	public static void main(String[] args) {

		Twitter twitter = new Twitter();
		twitter.postTweet(1, 5);
		twitter.postTweet(1, 3);

		System.out.println(twitter.getNewsFeed(1));


	}
}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj =
 * new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
