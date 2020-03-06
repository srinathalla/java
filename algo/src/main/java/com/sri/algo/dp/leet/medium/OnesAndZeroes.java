package com.sri.algo.dp.leet.medium;

import com.sri.algo.array.PrintArray;

public class OnesAndZeroes {

	public int findMaxForm(String[] strs, int m, int n) {

		int[][] memo = new int[m + 1][n + 1];

		for (String s : strs) {
			int ones = 0, zeroes = 0;
			for (char ch : s.toCharArray()) {
				if (ch == '1') {
					ones++;
				} else {
					zeroes++;
				}
			}
			for (int i = m; i >= zeroes; i--) {
				for (int j = n; j >= ones; j--) {
					memo[i][j] = Math.max(memo[i][j], memo[i - zeroes][j - ones] + 1);
				}
			}
		}

		return memo[m][n];
	}

	public static void main(String[] args) {
		OnesAndZeroes OnesAndZeroes = new OnesAndZeroes();
		String[] in = new String[] { "10", "0001", "111001", "1", "0" };
		int m = 5, n = 3;
		System.out.println(OnesAndZeroes.findMaxForm(in, m, n));

	}

}
