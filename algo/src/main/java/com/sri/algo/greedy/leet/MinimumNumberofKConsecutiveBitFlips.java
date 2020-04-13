package com.sri.algo.greedy.leet;

/**
 * In an array A containing only 0s and 1s, a K-bit flip consists of choosing a
 * (contiguous) subarray of length K and simultaneously changing every 0 in the
 * subarray to 1, and every 1 in the subarray to 0.
 * 
 * Return the minimum number of K-bit flips required so that there is no 0 in
 * the array. If it is not possible, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: A = [0,1,0], K = 1 Output: 2 Explanation: Flip A[0], then flip A[2].
 * Example 2:
 * 
 * Input: A = [1,1,0], K = 2 Output: -1 Explanation: No matter how we flip
 * subarrays of size 2, we can't make the array become [1,1,1].
 * 
 * @author srialla
 *
 */
public class MinimumNumberofKConsecutiveBitFlips {

	public int minKBitFlips(int[] A, int K) {
		int cur = 0, res = 0;

		for (int i = 0; i < A.length; i++) {
			if (i >= K && A[i-K] > 1) {
				A[i - K] -= 2;
				cur--;
			}

			if (cur % 2 == A[i]) {
				if (i + K > A.length) {
					return -1;
				}
				A[i] +=2;
				cur++;
				res++;
			}
		}

		return res;
	}

	public static void main(String[] args) {

		MinimumNumberofKConsecutiveBitFlips minimumNumberofKConsecutiveBitFlips = new MinimumNumberofKConsecutiveBitFlips();
		System.out.println(minimumNumberofKConsecutiveBitFlips.minKBitFlips(new int[] { 0, 0, 0 }, 1));

	}

}
