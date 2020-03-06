package com.sri.algo.dp.leet.hard;

import com.sri.algo.array.PrintArray;

/**
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a
 * number on it represented by array nums. You are asked to burst all the
 * balloons. If the you burst balloon i you will get nums[left] * nums[i] *
 * nums[right] coins. Here left and right are adjacent indices of i. After the
 * burst, the left and right then becomes adjacent.
 * 
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * 
 * Note:
 * 
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can
 * not burst them. 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100 Example:
 * 
 * Input: [3,1,5,8] Output: 167 Explanation: nums = [3,1,5,8] --> [3,5,8] -->
 * [3,8] --> [8] --> [] coins = 3*1*5 + 3*5*8 + 1*3*8 + 1*8*1 = 167
 * 
 * @author srialla
 *
 */
public class BurstBalloons {

	public int maxCoins(int[] nums) {

		int n = nums.length;
		int len = n + 2;
		int[] a = new int[len];
		System.arraycopy(nums, 0, a, 1, n);
		a[0] = 1;
		a[len - 1] = 1;
		int[][] dp = new int[len][len];

		for (int gap = 2; gap < len; gap++) {
			for (int left = 0, right = left + gap; right < len; left++, right++) {
				int cur = 0;
				for (int i = left + 1; i < right; i++) {
					cur = Math.max(cur, dp[left][i] + dp[i][right] + a[left] * a[i] * a[right]);
					PrintArray.print2dArray(dp);
				}
				dp[left][right] = cur;
				PrintArray.print2dArray(dp);
			}
		}

		return dp[0][len - 1];
	}

	public int maxCoinsTopDown(int[] nums) {

		int n = nums.length;
		int len = n + 2;
		int[] a = new int[len];
		System.arraycopy(nums, 0, a, 1, n);
		a[0] = 1;
		a[len - 1] = 1;
		int[][] memo = new int[len][len];
		return maxCoinsTopDown(a, 0, len-1, memo);
	}

	private int maxCoinsTopDown(int[] nums, int left, int right, int[][] memo) {
		if (left + 1 == right) {
			return 0;
		}

		if (memo[left][right] > 0) {
			return memo[left][right];
		}

		int curr = 0;
		for (int mid = left + 1; mid < right; mid++) {

			curr = Math.max(curr, nums[left] * nums[right] * nums[mid] + maxCoinsTopDown(nums, left, mid, memo)
					+ maxCoinsTopDown(nums, mid, right, memo));

		}

		memo[left][right] = curr;
		return memo[left][right];
	}

	public static void main(String[] args) {

		BurstBalloons burstBallons = new BurstBalloons();
		System.out.println(burstBallons.maxCoins(new int[] { 3, 3 }));
		System.out.println(burstBallons.maxCoinsTopDown(new int[] { 3, 3 }));

	}

}
