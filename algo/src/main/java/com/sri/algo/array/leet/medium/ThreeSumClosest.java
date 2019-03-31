package com.sri.algo.array.leet.medium;

import java.util.Arrays;

public class ThreeSumClosest {
	
	/**
	 * T.C : O(n ^ 2)
	 * @param nums
	 * @param target
	 * @return
	 */
	public int threeSumClosest(int[] nums, int target) {

		Arrays.sort(nums);

		int n = nums.length;

		int min_diff = Integer.MAX_VALUE;
		int csum = 0;

		for (int i = 0; i < n - 2; i++) {
			int j = i + 1;
			int k = n - 1;

			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];

				if (Math.abs(sum - target) < min_diff) {
					min_diff = Math.abs(sum - target);
					csum = sum;
				}

				if (sum <= target) {
					j++;
				} else {
					k--;
				}
			}
		}

		return csum;

	}
	

}
