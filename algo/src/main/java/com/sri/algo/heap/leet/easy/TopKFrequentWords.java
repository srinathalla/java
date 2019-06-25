package com.sri.algo.heap.leet.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a non-empty list of words, return the k most frequent elements.
 * 
 * Your answer should be sorted by frequency from highest to lowest. If two
 * words have the same frequency, then the word with the lower alphabetical
 * order comes first.
 * 
 * Example 1: Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"] Explanation: "i" and "love" are the two most frequent
 * words. Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2: Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny",
 * "is", "is"], k = 4 Output: ["the", "is", "sunny", "day"] Explanation: "the",
 * "is", "sunny" and "day" are the four most frequent words, with the number of
 * occurrence being 4, 3, 2 and 1 respectively.
 * 
 * @author salla
 *
 */
public class TopKFrequentWords {

	/**
	 * T.C : O(nlogn)
	 * 
	 * this has to be done in O(nlogk)
	 * @param words
	 * @param k
	 * @return
	 */
	public List<String> topKFrequent(String[] words, int k) {

		Map<String, Integer> map = new HashMap<>();

		// O(n)
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		
		PriorityQueue<String> q = new PriorityQueue<>(
				(a, b) -> map.get(a) != map.get(b) ? map.get(b) - map.get(a) : a.compareTo(b));

		// O(nlogn)
		for (String word : map.keySet()) {

			q.add(word);
		}
		
		List<String> result = new ArrayList<>();
		while (k > 0)
		{
			result.add(q.poll()); // O(klogn)
			k--;
		}
		
		return result;
	}
	
	public List<String> topKFrequentInnlogk(String[] words, int k) 
	{
		Map<String, Integer> map = new HashMap<>();
		for (String word : words)
		{
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		
		PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> 
				map.get(a) != map.get(b) ? 
				(map.get(a) - map.get(b)) : 
				 b.compareTo(a));
		
		for (String word : map.keySet())
		{	
			
			pq.add(word);	
			
			if (pq.size() > k)
			{
				pq.poll();
			}
		}
		
		LinkedList<String> result = new LinkedList<>();
		while(!pq.isEmpty())
		{
			result.addFirst(pq.poll());
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
		
		System.out.println(
				topKFrequentWords.topKFrequent(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 2));
		
		
		System.out.println(
				topKFrequentWords.topKFrequentInnlogk(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 2));
		
	}

}
