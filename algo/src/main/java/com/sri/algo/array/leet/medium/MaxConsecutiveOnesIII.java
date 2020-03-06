package com.sri.algo.array.leet.medium;

/**
 * Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
 * 
 * Return the length of the longest (contiguous) subarray that contains only 1s.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2 Output: 6
 * 
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * 
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * 
 * @author srialla
 *
 */
public class MaxConsecutiveOnesIII {

	public int longestOnes(int[] A, int K) {

		int[] pos = new int[] { 0, 0 };

		int left = 0, right = 0;
		while (right < A.length) {
			if (A[right] == 0) {
				K--;
			}

			while (K < 0) {
				if (A[left] == 0) {
					K++;
				}
				left++;
			}

			if (right - left >= pos[1] - pos[0]) {
				pos[0] = left;
				pos[1] = right;
			}

			right++;
		}

		return pos[1] == 0 ? 0 : pos[1] - pos[0] + 1;
	}

	public static void main(String[] args) {

		MaxConsecutiveOnesIII maxConsecutiveOnesIII = new MaxConsecutiveOnesIII();
		// System.out.println(
		// maxConsecutiveOnesIII.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
		System.out.println(maxConsecutiveOnesIII.longestOnes(new int[] { 0, 0, 0, 1 }, 0));
		System.out.println(maxConsecutiveOnesIII.longestOnes(new int[] { 0, 0, 1, 0 }, 1));

	}

}
