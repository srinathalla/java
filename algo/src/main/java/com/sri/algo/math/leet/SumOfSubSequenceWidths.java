package com.sri.algo.math.leet;

import java.util.Arrays;

/**
 * Given an array of integers A, consider all non-empty subsequences of A.
 * 
 * For any sequence S, let the width of S be the difference between the maximum
 * and minimum element of S.
 * 
 * Return the sum of the widths of all subsequences of A.
 * 
 * As the answer may be very large, return the answer modulo 10^9 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [2,1,3] Output: 6 Explanation: Subsequences are [1], [2], [3], [2,1],
 * [2,3], [1,3], [2,1,3]. The corresponding widths are 0, 0, 0, 1, 1, 2, 2. The
 * sum of these widths is 6.
 * 
 * @author salla
 *
 */
public class SumOfSubSequenceWidths {

	public int sumSubseqWidths(int[] A) {
		int MOD = 1_000_000_007;
		int n = A.length;
		long ans = 0;
		
		Arrays.sort(A);

		long[] pow2 = new long[n];
		pow2[0] = 1;

		for (int i = 1; i < n; i++) {
			pow2[i] = (pow2[i - 1] * 2) % MOD;
		}

		for (int i = 0; i < n; i++) {

			ans = (ans + (pow2[i] - pow2[n - i - 1]) * A[i]) % MOD;
		}

		return (int) ans;
	}

	public static void main(String[] args) {

		SumOfSubSequenceWidths ss = new SumOfSubSequenceWidths();

		System.out.println(ss.sumSubseqWidths(new int[] { 2, 1, 3 }));

	}

}
