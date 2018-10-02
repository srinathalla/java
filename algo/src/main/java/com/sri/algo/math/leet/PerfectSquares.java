package com.sri.algo.math.leet;

import java.util.Arrays;

/**
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * Example 1:
 * 
 * Input: n = 12 Output: 3 Explanation: 12 = 4 + 4 + 4. Example 2:
 * 
 * Input: n = 13 Output: 2 Explanation: 13 = 4 + 9.
 * 
 * @author salla
 *
 */
public class PerfectSquares {

	/**
	 * memory limit exceeded ..
	 * 
	 * @param n
	 * @return
	 */
	public int numSquaresWithTwoLoops(int n) {

		if (n <= 2) {
			return n;
		}

		int[] dp = new int[n + 1];

		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j * j <= i; j++) {

				dp[i] = Integer.min(dp[i], 1 + dp[i - j * j]);
			}
		}

		return dp[n];
	}

	public int numSquares(int n) {
		if (n <= 2) {
			return n;
		}

		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 1; i < n + 1; i++) {
			int j = 1;

			int min = Integer.MAX_VALUE;
			while (i - j * j >= 0) {
				min = Integer.min(min, dp[i - j * j] + 1);
				j++;
			}
			dp[i] = min;
		}

		return dp[n];
	}

	public static void main(String[] args) {

		PerfectSquares p = new PerfectSquares();

		System.out.println(p.numSquares(12));
		System.out.println(p.numSquaresWithTwoLoops(12));
	}

}
