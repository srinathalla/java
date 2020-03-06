package com.sri.algo.greedy.leet;

import java.util.Arrays;

import com.sri.algo.array.PrintArray;

public class MinTapsToWaterGarden {

	public int minTaps(int n, int[] A) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, n + 2);
		dp[0] = 0;

		for (int i = 0; i <= n; i++) {
			for (int j = Math.max(0, i - A[i]); j <= Math.min(n, i + A[i]); j++) {

				dp[j] = Math.min(dp[j], dp[Math.max(0, i - A[i])] + 1);

			}
		}

		return dp[n] == n + 2 ? -1 : dp[n];
	}

	public static void main(String[] args) {

		int n = 5;
		int[] A = new int[] { 3, 4, 1, 1, 0, 0 };

		MinTapsToWaterGarden minTapsToWaterGarden = new MinTapsToWaterGarden();

		System.out.println(minTapsToWaterGarden.minTaps(5, A));

	}

}
