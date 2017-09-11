package com.sri.algo.dp;

import java.util.HashSet;
import java.util.Set;

public class MinCoinsToExchangeASum {

	public static int minCoinsUsingCoinChangeProblem(int arr[], int m, int N) {

		Set<String> allPaths = new HashSet<>();

		CoinChange.countWaysToExchangeASum(arr, m, N, "", allPaths);

		int min = Integer.MAX_VALUE;
		String minCoins = null;
		for (String path : allPaths) {
			String[] exchangedCoins = path.split(",");

			if (exchangedCoins.length < min) {
				min = exchangedCoins.length;
				minCoins = path;
			}
		}

		System.out.println("Exchange Coins : " + minCoins);
		return min;

	}

	/**
	 * m is size of coins array (number of different coins)
	 * 
	 * @param coins
	 * @param m
	 * @param V
	 * @return
	 */
	public static int minCoins(int coins[], int m, int V) {
		if (V == 0) {
			return 0;
		}
		int res = Integer.MAX_VALUE;

		for (int i = 0; i < m; i++) {
			if (coins[i] <= V) {
				int coinsCnt = minCoins(coins, m, V - coins[i]);
				if (coinsCnt != Integer.MAX_VALUE && coinsCnt + 1 < res) {
					res = coinsCnt + 1;
				}
			}
		}

		return res;
	}

	/**
	 * m is size of coins array (number of different coins)
	 * 
	 * @param coins
	 * @param m
	 * @param V
	 * @return
	 */
	public static int minCoinswithDP(int coins[], int m, int V) {
		int[] table = new int[V + 1];
		table[0] = 0;

		for (int i = 1; i <= V; i++) {
			for (int j = 0; j < m; j++) {
				if (coins[j] < i) {
					table[i] = Integer.min(table[i], table[i - coins[j]] + 1);
				}
			}
		}
		return table[V];
	}

	public static void printArray(int[] arr) {
		System.out.print("coins : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();

	}

	public static void main(String[] args) {

		System.out.println(
				"Min Coins using coins path : " + minCoinsUsingCoinChangeProblem(new int[] { 9, 6, 5, 1 }, 4, 11));

		System.out.println("Min Coins using recursion : " + minCoins(new int[] { 9, 6, 5, 1 }, 4, 11));

		System.out.println("Min Coins using dp : " + minCoins(new int[] { 9, 6, 5, 1 }, 4, 11));

	}

}
