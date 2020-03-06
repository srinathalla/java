package com.sri.algo.dp.leet.hard;

import java.util.Arrays;

import com.sri.algo.array.PrintArray;

/**
 * Given an integer array arr, in one move you can select a palindromic subarray
 * arr[i], arr[i+1], ..., arr[j] where i <= j, and remove that subarray from the
 * given array. Note that after removing a subarray, the elements on the left
 * and on the right of that subarray move to fill the gap left by the removal.
 * 
 * Return the minimum number of moves needed to remove all numbers from the
 * array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [1,2] Output: 2
 * 
 * @author srialla
 *
 */
public class PalindromeRemoval {

	public int minimumMoves(int[] arr) {

		int[][] dp = new int[arr.length][arr.length];
		for (int[] a : dp) {
			Arrays.fill(a, arr.length);
		}

		for (int i = 0; i < arr.length; i++) {
			dp[i][i] = 1;
		}
		for (int i = 0; i < arr.length - 1; i++) {
			dp[i][i + 1] = arr[i] == arr[i + 1] ? 1 : 2;
		}

		for (int l = 3; l <= arr.length; l++) {
			for (int left = 0, right = left + l - 1; right < arr.length; left++, right++) {

				if (arr[left] == arr[right]) {
					dp[left][right] = dp[left + 1][right - 1];

				}

				else {
					for (int mid = left; mid < right; mid++) {
						dp[left][right] = Math.min(dp[left][right], dp[left][mid] + dp[mid + 1][right]);

					}
				}
			}
		}

		return dp[0][arr.length - 1];
	}


	public static void main(String[] args) {

		PalindromeRemoval palindromeRemoval = new PalindromeRemoval();

		int[] arr = new int[] { 1, 3, 4, 1, 5 };
		int[] arr1 = new int[] {16,13,13,10,12};

		System.out.println(palindromeRemoval.minimumMoves(arr1));

	}

}
