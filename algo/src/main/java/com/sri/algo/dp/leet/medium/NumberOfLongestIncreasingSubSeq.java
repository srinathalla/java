package com.sri.algo.dp.leet.medium;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubSeq {

	public int findNumberOfLIS(int[] nums) {

		int[] dp = new int[nums.length];
		int[] counts = new int[nums.length];
		Arrays.fill(dp, 1);
		Arrays.fill(counts, 1);

		int max = 1;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					if (dp[j] >= dp[i]) {
						dp[i] = dp[j] + 1;
						counts[i] = counts[j];
					} else if (dp[i] == dp[j] + 1) {
						counts[i] += counts[j];
					}
				}
			}
			max = Math.max(max, dp[i]);
		}

		int count = 0;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] == max) {
				count += counts[i];
			}
		}
		return count;

	}

	public static void main(String[] args) {

		NumberOfLongestIncreasingSubSeq numberOfLongestIncreasingSubSeq = new NumberOfLongestIncreasingSubSeq();
		System.out.println(numberOfLongestIncreasingSubSeq.findNumberOfLIS(new int[] { 1, 3, 5, 4, 7 }));
	}

}
