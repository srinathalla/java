package com.sri.algo.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of non-negative numbers and a target integer k, write a function
 * to check if the array has a continuous subarray of size at least 2 that sums
 * up to the multiple of k, that is, sums up to n*k where n is also an integer.
 * 
 * Example 1: Input: [23, 2, 4, 6, 7], k=6 Output: True Explanation: Because [2,
 * 4] is a continuous subarray of size 2 and sums up to 6.
 * 
 * @author salla
 *
 */
public class ContinousSubArraySum {

	/**
	 * brute force approach
	 * 
	 * get all sub arrays and check its sum is multiple of 6.
	 * 
	 * T.C : O(n * n)
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public boolean checkSubarraySumBruteForce(int[] nums, int k) {

		int n = nums.length;

		if (n == 1) {
			return false;
		}

		if (k == 0) {

			for (int i = 1; i < n; i++) {

				if (nums[i] == 0 && nums[i - 1] == 0) {
					return true;
				}
			}
			return false;
		}

		for (int i = 0; i < n; i++) {
			int sum = nums[i];
			for (int j = i + 1; j < n; j++) {
				sum = sum + nums[j];

				if (sum % k == 0) {
					return true;
				}

			}
		}

		return false;

	}

	/**kmk,l, 
	 * T.C : O(n)
	 * single pass map based solution.
	 * 
	 * we keep sum % k,i in map if same sum is seen again at j, then sub array (i, j) is a multiple of k ..
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public boolean checkSubarraySum(int[] nums, int k) {
		int n = nums.length;

		if (n == 1) {
			return false;
		}

		Map<Integer, Integer> numsMap = new HashMap<>();

		int sum = 0;
		numsMap.put(sum, -1);

		for (int i = 0; i < n; i++) {
			sum += nums[i];

			if (k > 0) {
				sum = sum % k;
			}

			if (numsMap.containsKey(sum)) {
				if (i - numsMap.get(sum) > 1)
					return true;
			} else {
				numsMap.put(sum, i);
			}
		}

		return false;
	}

	public static void main(String[] args) {

		ContinousSubArraySum css = new ContinousSubArraySum();

		System.out.println(css.checkSubarraySum(new int[] { 23, 2, 4, 6, 7 }, 6));

		System.out.println(css.checkSubarraySum(new int[] { 23, 2, 4, 6, 7 }, 0));

		System.out.println(css.checkSubarraySum(new int[] { 0, 0 }, 0));
	}

}
