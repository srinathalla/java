package com.sri.algo.dp.cp;

/**
 * The task is to count all the possible paths from top left to bottom right of a mXn matrix
   with the constraints that from each cell you can either move only to right or down.
 * 
 *
 */
public class CountAllPossiblePathsFromTopLeftToBottomRight {

	public static int count(int n, int m) {
		int[][] table = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == 0 || j == 0) {
					table[i][j] = 1;
				} else {
					table[i][j] = table[i][j - 1] + table[i - 1][j];
				}
			}
		}

		return table[n - 1][m - 1];
	}
	
	

	public static void main(String[] args) {

		System.out.println(count(32, 32));
	}

}
