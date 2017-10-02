package com.sri.algo.dp;

/**
 * Given two strings ‘X’ and ‘Y’, find the length of the longest common
 * substring.
 * 
 * Input : X = "GeeksforGeeks", y = "GeeksQuiz" Output : 5 The longest common
 * substring is "Geeks" and is of length 5.
 * 
 *
 */
public class LongestCommonSubString {

	/**
	 * can be used to find the longest common substring in O(m*n) time. The idea is
	 * to find length of the longest common suffix for all substrings of both
	 * strings and store these lengths in a table.
	 * 
	 * @param X
	 * @param Y
	 * @param m
	 * @param n
	 * @return
	 */
	public static int lcs(char[] X, char[] Y, int n, int m) {

		int[][] table = new int[n + 1][m + 1];

		int max = Integer.MIN_VALUE;

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == 0 || j == 0) {
					table[i][j] = 0;
				} else if (X[i - 1] == Y[j - 1]) {
					table[i][j] = table[i - 1][j - 1] + 1;

					max = Integer.max(max, table[i][j]);
				} else {
					table[i][j] = 0;
				}
			}
		}

		if (max == Integer.MIN_VALUE) {
			max = 0;
		}

		return max;
	}

	public static void main(String[] args) {

		String x = "GeeksforGeeks";
		String y = "GeeksQuiz";

		System.out.println(lcs(x.toCharArray(), y.toCharArray(), x.length(), y.length()));
		
		 x = "ABCDGH";
		 y = "ACDGHR";

		System.out.println(lcs(x.toCharArray(), y.toCharArray(), x.length(), y.length()));

	}

}
