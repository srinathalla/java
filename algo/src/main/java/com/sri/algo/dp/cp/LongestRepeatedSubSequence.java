package com.sri.algo.dp.cp;

public class LongestRepeatedSubSequence {

	/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
	public static int lrs(char[] X, int m) {

		char[] Y = X;
		int n = m;
		int[][] table = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {

				if (i == 0 || j == 0) {
					table[i][j] = 0;
				} else if (X[i - 1] == Y[j - 1] && i != j) {
					table[i][j] = table[i - 1][j - 1] + 1;
				} else {
					table[i][j] = Integer.max(table[i][j - 1], table[i - 1][j]);
				}
			}
		}

		System.out.println(lprString(table, X, Y));
		return table[m][n];
	}

	public static String lprString(int[][] table, char[] X, char[] Y) {

		String s = "";
		int i = table.length - 1;
		int j = table[0].length - 1;

		while (i > 0 && j > 0) {

			if (table[i][j] != table[i - 1][j] && table[i][j] != table[i][j - 1]) {
				s = X[i - 1] + s;
				i--;
				j--;
			} else if (table[i][j] == table[i - 1][j]) {
				i--;
			} else if (table[i][j] == table[i][j - 1]) {
				j--;
			}
		}

		return s;
	}

	public static void main(String[] args) {

		String s1 = "AABEBCDD";

		char[] X = s1.toCharArray();
		int m = X.length;

		System.out.println("Length of LRS is" + " " + lrs(X, m));
		System.out.println("Length of LRS is" + " " + lrs("aab".toCharArray(), 3));

	}

}
