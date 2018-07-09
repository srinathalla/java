package com.sri.algo.dp.cp;

import java.util.Arrays;

/**
 * In the computer world, use restricted resource you have to generate maximum
 * benefit is what we always want to pursue.
 * 
 * For now, suppose you are a dominator of m 0s and n 1s respectively. On the
 * other hand, there is an array with strings consisting of only 0s and 1s.
 * 
 * Now your task is to find the maximum number of strings that you can form with
 * given m 0s and n 1s. Each 0 and 1 can be used at most once.
 * 
 * Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3 Output: 4
 * 
 * 
 * @author salla
 *
 */
public class OnesAndZeroes {

	public int findMaxForm(String[] strs, int m, int n) {

		int[][] memo = new int[m + 1][n + 1];
		int numZeroes, numOnes;

		for (String s : strs) {
			numZeroes = numOnes = 0;
			// count number of zeroes and ones in current string
			for (char c : s.toCharArray()) {
				if (c == '0')
					numZeroes++;
				else if (c == '1')
					numOnes++;
			}

			// memo[i][j] = the max number of strings that can be formed with i 0's and j
			// 1's
			// from the first few strings up to the current string s
			// Catch: have to go from bottom right to top left
			// Why? If a cell in the memo is updated(because s is selected),
			// we should be adding 1 to memo[i][j] from the previous iteration (when we were
			// not considering s)
			// If we go from top left to bottom right, we would be using results from this
			// iteration => overcounting
			for (int i = m; i >= numZeroes; i--) {
				for (int j = n; j >= numOnes; j--) {
					memo[i][j] = Integer.max(memo[i][j], memo[i - numZeroes][j - numOnes] + 1);
				}
			}
		}
		return memo[m][n];

	}

	public static void main(String[] args) {

		OnesAndZeroes oz = new OnesAndZeroes();

		System.out.println(oz.findMaxForm(new String[] { "10", "0001", "111001", "1", "0" }, 5, 3));
		System.out.println(oz.findMaxForm(new String[] { "10", "0", "1" }, 1, 1));
		
		System.out.println(oz.findMaxForm(new String[] { "111","1000","1000","1000"}, 9, 3));
	}

}
