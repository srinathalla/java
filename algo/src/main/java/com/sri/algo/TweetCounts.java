package com.sri.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.sri.algo.array.PrintArray;

public class TweetCounts {

	Map<String, TreeSet<Integer>> map = new HashMap<>();

	public TweetCounts() {

	}

	public void recordTweet(String tweetName, int time) {

		if (!map.containsKey(tweetName)) {
			map.put(tweetName, new TreeSet<>());
		}
		map.get(tweetName).add(time);
	}

	public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {

		List<Integer> list = new ArrayList<>();
		int seconds = freq.equals("minute") ? 60 : freq.equals("hour") ? 60 * 60 : 24 * 60 * 60;
		TreeSet<Integer> set = map.get(tweetName);

		Integer f = 0, count = 1, time = set.ceiling(startTime);
		while (time != null && time <= endTime) {
			f++;

			if (time - startTime + 1 >= count * seconds && time != endTime) {
				list.add(f);
				f = 0;
				count++;
			}
			time = set.higher(time);
		}
		if (set.last() < endTime) {
			list.add(f);
			f = 0;
			count++;
		}

		list.add(f);

		return list;
	}

	public static void main(String[] args) {

		TweetCounts tweetCounts = new TweetCounts();
		tweetCounts.recordTweet("tweet0", 13);
		tweetCounts.recordTweet("tweet1", 16);
		tweetCounts.recordTweet("tweet2", 12); 
		tweetCounts.recordTweet("tweet3", 18); 
		tweetCounts.recordTweet("tweet4", 82);
		tweetCounts.recordTweet("tweet3", 89);
		PrintArray.print(tweetCounts.getTweetCountsPerFrequency("day", "tweet0", 89, 9471)); 
		PrintArray.print(tweetCounts.getTweetCountsPerFrequency("hour","tweet3",13,4024)); 
	}

}
