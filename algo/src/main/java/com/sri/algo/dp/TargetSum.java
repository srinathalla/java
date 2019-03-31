package com.sri.algo.dp;

/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target,
 * S. Now you have 2 symbols + and -. For each integer, you should choose one
 * from + and - as its new symbol.
 * 
 * Find out how many ways to assign symbols to make sum of integers equal to
 * target S.
 * 
 * Example 1: Input: nums is [1, 1, 1, 1, 1], S is 3.
 * 
 * @author salla
 *
 */
public class TargetSum {

	int count;

	public int findTargetSumWays(int[] nums, int S) {

		targetSum(nums, 0, S);

		return count;

	}

	private void targetSum(int[] nums, int idx, int sum) {

		if (idx == nums.length) {

			if (sum == 0) {
				count++;
			}
		}

		else {
			targetSum(nums, idx + 1, sum - nums[idx]);
			targetSum(nums, idx + 1, sum + nums[idx]);
		}

	}

	public static void main(String[] args) {

		TargetSum ts = new TargetSum();

		int res = ts.findTargetSumWays(new int[] { 1, 1, 1, 1, 1 }, 3);

		System.out.println(res);

	}

}
