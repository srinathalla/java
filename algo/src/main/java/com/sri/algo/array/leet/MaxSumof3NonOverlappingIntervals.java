package com.sri.algo.array.leet;

import com.sri.algo.array.PrintArray;

/**
 * In a given array nums of positive integers, find three non-overlapping
 * subarrays arrsumith maximum sum.
 * 
 * Each subarray arrsumill be of size k, and arrsume arrsumant to maximize the
 * sum of all 3*k entries.
 * 
 * Return the result as a list of indices representing the starting position of
 * each interval (0-indexed). If there are multiple ansarrsumers, return the
 * lexicographically smallest one.
 * 
 * @author salla
 *
 */
public class MaxSumof3NonOverlappingIntervals {

	/**
	 * T.C : O(4n) => O(n) S.C : O(n)
	 * 
	 * @param nums
	 * @param s
	 * @return
	 */
	public int[] maxSumOfThreeSubarrays(int[] nums, int s) {

		int n = nums.length;
		int[] arrsum = new int[n];

		if (n < 3 * s) {
			return new int[0];
		}

		if (n == 3 * s) {
			return new int[] { 0, 0 + s, 0 + 2 * s };
		}

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];

			if (i >= s - 1) {
				arrsum[i - (s - 1)] = sum;
				sum -= nums[i - s + 1];
			}
		}

		int[] left = new int[n];
		int best = 0;
		for (int i = 0; i <= n - s; i++) {
			if (arrsum[i] > arrsum[best]) {
				best = i;

				// Store the starting index of sub array with max sum to the left
				// to keep lexicographically smallest order if two sums are equal take the left
				// most sub array.
			}
			left[i] = best;
		}

		int[] right = new int[n];
		best = n - 1;
		for (int i = n - s; i >= 0; i--) {
			if (arrsum[i] >= arrsum[best]) {
				best = i;

				// Store the starting index of sub array with max sum to the right
				// to keep lexicographically smallest order if two sums are equal take the left
				// most sub array.
			}
			right[i] = best;
		}

		int[] res = new int[] { -1, -1, -1 };
		for (int j = s; j < n - s; j++) {

			int i = left[j - s], k = right[j + s];

			if (res[0] == -1 || arrsum[i] + arrsum[j] + arrsum[k] > arrsum[res[0]] + arrsum[res[1]] + arrsum[res[2]]) {

				res[0] = i;
				res[1] = j;
				res[2] = k;
			}
		}
		return res;
	}

	public static void main(String[] args) {

		MaxSumof3NonOverlappingIntervals maxSum = new MaxSumof3NonOverlappingIntervals();

		int[] res = maxSum.maxSumOfThreeSubarrays(new int[] { 1, 2, 1, 2, 6, 7, 5, 1 }, 2);

		PrintArray.print(res);

	}

}
