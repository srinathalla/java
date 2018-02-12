package com.sri.algo.backtrack;

/**
 * You are given two strings a and b. Now your task is to print all longest
 * common sub-sequences in lexicographical order.
 * 
 * @author salla
 *
 */
public class PrintAllLcsSequences {

	public static void printAllLCS(String s1, String s2) {

		int[][] table = lcs(s1, s2, s1.length(), s2.length());

		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				System.out.print(table[i][j] + " ");

			}

			System.out.println();
		}

	}

	private static int[][] lcs(String s1, String s2, int n, int m) {
		int[][] table = new int[n + 1][m + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == 0 || j == 0) {
					table[i][j] = 0;
				}

				else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					table[i][j] = 1 + table[i - 1][j - 1];
				} else {
					table[i][j] = Integer.max(table[i][j - 1], table[i - 1][j]);
				}
			}
		}

		return table;
	}
	
	public static void main(String[] args) {
		
		
		printAllLCS("abaaa" , "baabaca");
	}

}
