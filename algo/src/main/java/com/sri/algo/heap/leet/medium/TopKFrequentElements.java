package com.sri.algo.heap.leet.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,1,2,2,3], k = 2 Output: [1,2] Example 2:
 * 
 * Input: nums = [1], k = 1 Output: [1] Note:
 * 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements. Your
 * algorithm's time complexity must be better than O(n log n), where n is the
 * array's size.
 * 
 * @author salla
 *
 */
public class TopKFrequentElements {

	/**
	 * O(nlogn) as we are sorting all the elements.
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public List<Integer> topKFrequentWithSorting(int[] nums, int k) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int no : nums) {
			map.put(no, map.getOrDefault(no, 0) + 1);
		}

		List<Integer> result = new ArrayList<>(map.keySet());

		Collections.sort(result, (a, b) -> map.get(a) != map.get(b) ? map.get(b) - map.get(a) : a - b);

		return result.subList(0, k);

	}

	/**
	 * T.C : O(n)
	 * S.C : O(n)
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public List<Integer> topKFrequent(int[] nums, int k) {

		List<Integer>[] buckets = new List[nums.length + 1];

		Map<Integer, Integer> map = new HashMap<>();

		for (int no : nums) {
			map.put(no, map.getOrDefault(no, 0) + 1);
		}

		List<Integer> result = new ArrayList<>();

		for (int key : map.keySet()) {
			int freq = map.get(key);

			if (buckets[freq] == null) {
				buckets[freq] = new ArrayList<>();
			}

			buckets[freq].add(key);
		}

		for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {

			if (buckets[i] != null) {
				result.addAll(buckets[i]);
			}
		}

		return result;
	}

	public static void main(String[] args) {

		TopKFrequentElements topKFrequentElements = new TopKFrequentElements();

		System.out.println(topKFrequentElements.topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2));

	}
}
