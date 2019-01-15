package com.sri.algo.hashing.leet;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums and a target value k, find the maximum length of a
 * subarray that sums to k. If there isn't one, return 0 instead.
 * 
 * Note: The sum of the entire nums array is guaranteed to fit within the 32-bit
 * signed integer range.
 * 
 * Example 1:
 * 
 * Input: nums = [1, -1, 5, -2, 3], k = 3 Output: 4 Explanation: The subarray
 * [1, -1, 5, -2] sums to 3 and is the longest. Example 2:
 * 
 * Input: nums = [-2, -1, 2, 1], k = 1 Output: 2 Explanation: The subarray [-1,
 * 2] sums to 1 and is the longest. Follow Up: Can you do it in O(n) time?
 * 
 * @author salla
 *
 */
public class MAxSizeSubArrayWhoseSumEqK {

	/**
	 * T.C : O(n*n)
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int maxSubArrayLenNaive(int[] nums, int k) {

		int max = 0;
		for (int i = 0; i < nums.length; i++) {

			int sum = 0;
			for (int j = i; j < nums.length; j++) {

				sum += nums[j];

				if (sum == k) {
					max = Integer.max(max, j - i + 1);
				}

			}
		}

		return max;

	}

	public int maxSubArrayLen(int[] nums, int k) {

		int max = 0, sum = 0;

		Map<Integer, Integer> sumMap = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {

			sum += nums[i];

			if (sum == k) {
				max = i + 1;
			}  if (sumMap.containsKey(sum - k)) {
				max = Integer.max(max, i - sumMap.get(sum - k));
			}

			if (!sumMap.containsKey(sum)) {
				sumMap.put(sum, i);
			}
			
			System.out.println(sumMap);

		}

		return max;
	}

	public static void main(String[] args) {

		MAxSizeSubArrayWhoseSumEqK max = new MAxSizeSubArrayWhoseSumEqK();

		System.out.println(max.maxSubArrayLen(new int[] { 1, -1, 5, -2, 3 }, 3));

		System.out.println(max.maxSubArrayLen(new int[] { -2, -1, 2, 1 }, 1));

		System.out.println(max.maxSubArrayLen(new int[] { -2, -1, 2, 1 }, 1));

	}

}
