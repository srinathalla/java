package com.sri.algo.dp;

import java.util.Set;

/**
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * 
 * Input: coins = [1, 2, 5], amount = 11 Output: 3
 * 
 * Explanation: 11 = 5 + 5 + 1
 * 
 * Input: coins = [2], amount = 3 Output: -1
 * 
 * @author salla
 *
 */
public class CoinChange {

	public static int countWaysToExchangeASum(int arr[], int m, int N, String path, Set<String> allPaths) {

		if (N == 0) {
			allPaths.add(path);
			return 1;
		}

		if (N < 0) {
			return 0;
		}

		if (m <= 0 && N >= 1) {
			return 0;
		}

		String denominationIncludePath = path.isEmpty() ? String.valueOf(arr[m - 1]) : path + "," + arr[m - 1];

		return countWaysToExchangeASum(arr, m, N - arr[m - 1], denominationIncludePath, allPaths)
				+ countWaysToExchangeASum(arr, m - 1, N, path, allPaths);

	}

	public static int coinChangeWithDP(int arr[], int m, int N) {

		int[][] table = new int[m][N + 1];

		for (int i = 0; i < m; i++) {
			table[i][0] = 1;
		}

		// In each step we are solving i,j
		// where i is current coin and j is the sum.
		for (int i = 0; i < m; i++) {

			for (int j = 1; j <= N; j++) {

				int denomination = arr[i];

				int x = 0;
				int y = 0;

				// Current denomination included in count.
				// To include a denomination its value has to be less than sum.
				if (denomination <= j) {
					x = table[i][j - denomination];
				}

				// Current denomination excluded count.
				if (i > 0) {
					y = table[i - 1][j];
				}

				table[i][j] = x + y;
			}
		}

		return table[m - 1][N];
	}

	/**
	 * bottom up approach.. T.C : O (n * m)
	 * Auxillary space : O(m)
	 * 
	 * where n : no of coins m: amount given for exchange .
	 * 
	 * @param coins
	 * @param amount
	 * @return
	 */
	public static int minCoinsChange(int[] coins, int amount) {

		int n = coins.length;
		int m = amount;

		if (m == 0) {
			return 0;
		}

		if (n == 0) {
			return -1;
		}

		int[] minCoins = new int[m + 1];

		for (int i = 0; i <= m; i++) {
			minCoins[i] = m + 1;
		}
		minCoins[0] = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= m; j++) {

				if (j >= coins[i]) {
					minCoins[j] = Integer.min(minCoins[j], 1 + minCoins[j - coins[i]]);
				}
			}
		}

		return minCoins[m] > m ? -1 : minCoins[m];
	}

	public static void main(String[] args) {

		/*
		 * Set<String> allPaths = new HashSet<>();
		 * System.out.println(countWaysToExchangeASum(new int[] { 1, 2, 3 }, 3, 5, "",
		 * allPaths));
		 * 
		 * System.out.println(allPaths);
		 * 
		 * System.out.println(coinChangeWithDP(new int[] { 1, 2, 3 }, 3, 5));
		 */

		System.out.println(minCoinsChange(new int[] { 1, 2, 3 }, 5));

		System.out.println(minCoinsChange(new int[] { 1, 2, 5 }, 11));

		System.out.println(minCoinsChange(new int[] { 2 }, 3));
	}

}
