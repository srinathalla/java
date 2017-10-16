package com.sri.algo.dp.cp;

import java.util.Scanner;

/**
 * Given a String, find the longest palindromic subsequence
 * 
 * Input: 2 bbabcbcab abbaab Output: 7 4
 *
 *
 */
public class LongestPalindromeSubSequence {

	/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
	/**
	 * Time Complexity = O(m*n) using bottom up approach.
	 * 
	 * @param X
	 * @param Y
	 * @param m
	 * @param n
	 * @return
	 */
	public static int lcsWithDP(char[] X, char[] Y, int m, int n) {
		int[][] lcsMatrix = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {

				if (i == 0 || j == 0) {
					// When either of the string's are empty, lcs is 0.
					lcsMatrix[i][j] = 0;
				}

				else if (X[i - 1] == Y[j - 1]) {
					// if two chars X[i],Y[j] are equals lcs is 1 + lcs(i-1]j-1) i.e this value is
					// already
					// pre computed retrieve this value from table.
					lcsMatrix[i][j] = lcsMatrix[i - 1][j - 1] + 1;
				} else {
					// if two chars are not equal then lcs is max(lcs(i,j-1),lcs(i-1,j))
					// these values are already computed so retrie these values from table.
					lcsMatrix[i][j] = Integer.max(lcsMatrix[i - 1][j], lcsMatrix[i][j - 1]);
				}
			}
		}

		return lcsMatrix[m][n];
	}

	public static void main(String[] args) {

		try (Scanner in = new Scanner(System.in)) {
			int testCount = in.nextInt();

			for (int i = 0; i < testCount; i++) {
				String s1 = in.nextLine();
				while (s1.isEmpty()) {
					s1 = in.nextLine();
				}
				s1.trim();
				int n1 = s1.length();
				char[] Y = new char[n1];

				int j = 0;
				for (int l = n1 - 1; l >= 0; l--) {
					Y[j] = s1.charAt(l);
					j++;
				}

				System.out.println(lcsWithDP(s1.toCharArray(), Y, n1, n1));
			}
		}
	}

}
