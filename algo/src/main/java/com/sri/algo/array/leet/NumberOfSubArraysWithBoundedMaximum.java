package com.sri.algo.array.leet;

/**
 * We are given an array A of positive integers, and two positive integers L and
 * R (L <= R).
 * 
 * Return the number of (contiguous, non-empty) subarrays such that the value of
 * the maximum array element in that subarray is at least L and at most R.
 * 
 * Example : Input: A = [2, 1, 4, 3] L = 2 R = 3 Output: 3 Explanation: There
 * are three subarrays that meet the requirements: [2], [2, 1], [3].
 * 
 * Note:
 * 
 * L, R and A[i] will be an integer in the range [0, 10^9]. The length of A will
 * be in the range of [1, 50000].
 * 
 * 
 * @author salla
 *
 */
public class NumberOfSubArraysWithBoundedMaximum {

	/**
	 * T.C : O(n)
	 * 
	 * single pass solution.
	 * 
	 * 
	 * @param A
	 * @param L
	 * @param R
	 * @return
	 */
	public int numSubarrayBoundedMax(int[] A, int L, int R) {
		int sum = 0;

		int l = -1, r = -1;
		for (int i = 0; i < A.length; i++) {

			// we need to reset both left and right pointers when current number exceeds upper bound
			// as no sub array can end here.
			if (A[i] > R) {
				l = i;
				r = i;
			} else if (A[i] >= L) {
				
				//  when an element falls in the boundary range just reset right pointer.
				//  as this can be included in all the sub arrays possible till now.
				r = i;
			}

			sum += r - l;
		}

		return sum;
	}

	public static void main(String[] args) {

		NumberOfSubArraysWithBoundedMaximum noOfSubArr = new NumberOfSubArraysWithBoundedMaximum();

		System.out.println(noOfSubArr.numSubarrayBoundedMax(new int[] { 2, 1, 4, 3 }, 2, 3));

	}

}
