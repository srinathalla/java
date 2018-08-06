package com.sri.algo.array;

/**
 * Given an array consisting of n integers, find the contiguous subarray whose
 * length is greater than or equal to k that has the maximum average value. And
 * you need to output the maximum average value.
 * 
 * Example 1: Input: [1,12,-5,-6,50,3], k = 4 Output: 12.75 Explanation: when
 * length is 5, maximum average value is 10.8, when length is 6, maximum average
 * value is 9.16667. Thus return 12.75.
 * 
 * @author salla
 *
 */
public class MaxAverageSubArray {

	/**
	 * T.C : O(n^2) Space complexity : O(1)O(1). Constant extra space is used.
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public double findMaxAverageNaive(int[] nums, int k) {

		int n = nums.length;

		if (n == 0) {
			return 0;
		}

		double max = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			int j = i;
			double sum = 0;

			while (j < n) {
				sum += nums[j];
				if (j - i + 1 >= k) {
					max = Math.max(max, sum * 1.0 / (j - i + 1));
				}
				j++;
			}
		}

		return max;
	}

	boolean check(int[] nums, int k, double x) // Check whether we can find a subarray whose average is bigger than x
	{
		int n = nums.length;

		double sum = 0, prev = 0;
		for (int i = 0; i < k; i++) {
			sum += nums[i] - x;
		}

		if (sum >= 0) {
			return true;
		}

		for (int i = k; i < n; i++) {

			sum += nums[i] - x;
			prev += nums[i - k] - x;

			if (prev < 0) {
				sum -= prev;
				prev = 0;
			}

			if (sum >= 0) {
				return true;
			}
		}

		return false;
	}

	/**
	 * T.C O(nlog(m)) where m is max - min
	 * 
	 * at each binary search in (max - min) range we traverse the entire array to
	 * see if there exists a mid value possible as average..
	 * 
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public double findMaxAverage(int[] nums, int k) {
		double l = Integer.MIN_VALUE, r = Integer.MAX_VALUE;

		while (r - l > 0.000005) {
			double mid = (l + r) * 0.5;

			if (check(nums, k, mid)) {
				l = mid;

				// if mid is possible as average check for higher average.
			} else {
				r = mid; // if mid is not possible as average check for lower average values.
			}
		}

		return r;
	}

	public static void main(String[] args) {

		MaxAverageSubArray maxAvg = new MaxAverageSubArray();

		System.out.println(maxAvg.findMaxAverage(new int[] { 1, 12, -5, -6, 50, 3 }, 4));

		/**
		 * System.out.println(maxAvg.findMaxAverage(new int[] {1,12,-5,-6,50,3}, 5));
		 * 
		 * System.out.println(maxAvg.findMaxAverage(new int[] {1,12,-5,-6,50,3}, 6));
		 */

		// System.out.println(maxAvg.findMaxAverageNaive(new int[] { -1 }, 1));

	}

}
