package com.sri.algo.dp.leet.medium;

import java.util.HashMap;

/**
 * Given an array A of integers, return the length of the longest arithmetic
 * subsequence in A.
 * 
 * Recall that a subsequence of A is a list A[i_1], A[i_2], ..., A[i_k] with 0
 * <= i_1 < i_2 < ... < i_k <= A.length - 1, and that a sequence B is arithmetic
 * if B[i+1] - B[i] are all the same value (for 0 <= i < B.length - 1).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [3,6,9,12] Output: 4 Explanation: The whole array is an arithmetic
 * sequence with steps of length = 3.
 * 
 * @author srialla
 *
 */
public class LongestArithmeticSequence {

	public int longestArithSeqLength(int[] A) {

		HashMap<Integer, Integer>[] dp = new HashMap[A.length];
		int res = 1;

		for (int i = 1; i < A.length; i++) {
			dp[i] = new HashMap<>();
			for (int j = 0; j < i; j++) {

				int d = A[i] - A[j];
				dp[i].put(d, dp[j].getOrDefault(d, 1) + 1);
				res = Math.max(res, dp[i].get(d));
			}
		}

		return res;
	}

}
