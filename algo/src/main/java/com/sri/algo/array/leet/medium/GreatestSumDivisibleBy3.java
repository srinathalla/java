package com.sri.algo.array.leet.medium;

import com.sri.algo.array.PrintArray;

/**
 * Given an array nums of integers, we need to find the maximum possible sum of elements of the array such that it is divisible by three.

 

Example 1:

Input: nums = [3,6,5,1,8]
Output: 18
Explanation: Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).
 * @author srialla
 *
 */
public class GreatestSumDivisibleBy3 {
	public int maxSumDivThree(int[] A) {

		int[] dp = { 0, Integer.MIN_VALUE, Integer.MIN_VALUE };
		for (int a : A) {
			int[] dp2 = new int[3];
			for (int i = 0; i < 3; i++) {
				dp2[(i + a) % 3] = Math.max(dp[(i + a) % 3], dp[i] + a);
				PrintArray.print(dp2);
			}
			dp = dp2;
		}
		return dp[0];
	}

	public static void main(String[] args) {

		GreatestSumDivisibleBy3 greatestSumDivisibleBy3 = new GreatestSumDivisibleBy3();
		System.out.println(greatestSumDivisibleBy3.maxSumDivThree(new int[] { 3, 6, 5, 1, 8 }));

	}

}
