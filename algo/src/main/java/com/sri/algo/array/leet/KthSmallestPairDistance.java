package com.sri.algo.array.leet;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an integer array, return the k-th smallest distance among all the
 * pairs. The distance of a pair (A, B) is defined as the absolute difference
 * between A and B.
 * 
 * Example 1: Input: nums = [1,3,1] k = 1 Output: 0 Explanation: Here are all
 * the pairs: (1,3) -> 2 (1,1) -> 0 (3,1) -> 2 Then the 1st smallest distance
 * pair is (1,1), and its distance is 0.
 * 
 * @author salla
 *
 */
public class KthSmallestPairDistance {

	/**
	 * will use a sliding window approach to count the number of pairs with distance <= guess.

       For every possible right, we maintain the loop invariant: left is the smallest value such
       that nums[right] - nums[left] <= guess. Then, the number of pairs with right as it's 
       right-most endpoint is right - left, and we add all of these up.
       
       
       O(NlogW + NlogN), where N is the length of nums, and W is equal to 
       nums[nums.length - 1] - nums[0], The logW factor comes from our binary search.
       
	 * @param nums
	 * @param k
	 * @return
	 */
	public int smallestDistancePair(int[] nums, int k) {

		int n = nums.length;

		Arrays.sort(nums);

		int l = 0, m, h = nums[n - 1] - nums[0];

		while (l < h) {
			m = l + (h - l) / 2;

			int j = 1, count = 0;
			for (int i = 0; i < n; i++) {
				while (j < n && nums[j] - nums[i] <= m) {
					j++;
				}
				
				count += (j-i-1);
			}

			System.out.println("l:" + l + " h:" + h + " count: " + count);
			if (count >= k) {
				h = m;
			} else {
				l = m + 1;
			}
		}

		return l;
	}


	public static void main(String[] args) {

		KthSmallestPairDistance kthSmallestPair = new KthSmallestPairDistance();

		// System.out.println(kthSmallestPair.smallestDistancePair(new int[] { 1, 3, 1
		// }, 1));

		// System.out.println(kthSmallestPair.smallestDistancePair(new int[] { 1, 6, 1 }, 3));

		System.out.println(kthSmallestPair.smallestDistancePair(new int[] { 62, 100, 4 }, 2));
		
		
	}

}
