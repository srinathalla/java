package com.sri.algo.dp;

import java.util.HashSet;
import java.util.Set;

public class CoinChange {

	public static int countWaysToExchangeASum(int arr[], int m, int N,String path,Set<String> allPaths) {

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
		
		String denominationIncludePath = 
			path.isEmpty() ? 
				String.valueOf(arr[m - 1]): 
				path + "," + arr[m - 1];
        
		
		return 
			countWaysToExchangeASum(arr, m, N - arr[m - 1], denominationIncludePath, allPaths) + 
			countWaysToExchangeASum(arr, m - 1, N, path, allPaths);

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

	public static void main(String[] args) {

		Set<String> allPaths = new HashSet<>();
		System.out.println(countWaysToExchangeASum(new int[] { 1, 2, 3 }, 3, 5,"",allPaths));
		
		System.out.println(allPaths);

		System.out.println(coinChangeWithDP(new int[] { 1, 2, 3 }, 3, 5));
	}

}
