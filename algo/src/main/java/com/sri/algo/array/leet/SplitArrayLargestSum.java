package com.sri.algo.array.leet;

/**
 * Given an array which consists of non-negative integers and an integer m, you
 * can split the array into m non-empty continuous subarrays. Write an algorithm
 * to minimize the largest sum among these m subarrays.
 * 
 * Note: If n is the length of array, assume the following constraints are
 * satisfied:
 * 
 * 1 ≤ n ≤ 1000 1 ≤ m ≤ min(50, n)
 * 
 * Input: nums = [7,2,5,10,8] m = 2
 * 
 * Output: 18
 * 
 * Explanation: There are four ways to split nums into two subarrays. The best
 * way is to split it into [7,2,5] and [10,8], where the largest sum among the
 * two subarrays is only 18.
 * 
 * @author salla
 *
 */
public class SplitArrayLargestSum {

	private int ans;
	private int n, m;

	/**
	 * backtracking based approach
	 * 
	 * T.C O(n^m)..
	 * 
	 * @param nums
	 * @param i
	 * @param cntSubarrays
	 * @param curSum
	 * @param curMax
	 */
	private void dfs(int[] nums, int i, int cntSubarrays, int curSum, int curMax) {

		if (i == n) {
			if (cntSubarrays == m) {
				ans = Integer.min(ans, curMax);
			}
			return;
		}

		if (i > 0) {
			dfs(nums, i + 1, cntSubarrays, curSum + nums[i], Integer.max(curMax, curSum + nums[i]));
		}

		if (cntSubarrays < m) {
			dfs(nums, i + 1, cntSubarrays + 1, nums[i], Integer.max(curMax, nums[i]));
		}

	}

	public int splitArrayWithDfs(int[] nums, int M) {

		n = nums.length;
		m = M;
		ans = Integer.MAX_VALUE;

		dfs(nums, 0, 0, 0, 0);

		return ans;
	}

	public int splitArrayWithDP(int[] nums, int m) {
		int n = nums.length;
		int[][] f = new int[n + 1][m + 1];
		int[] sub = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				f[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < n; i++) {
			sub[i + 1] = sub[i] + nums[i];
		}
		f[0][0] = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				for (int k = 0; k < i; k++) {
					f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], sub[i] - sub[k]));

					System.out.println("f[" + i + "][" + j + "]" + f[i][j]);
				}
			}
		}
		return f[n][m];
	}

	/**
	 *
	 *
	 * Time complexity : O(n * log(sum of array)). The binary search costs O(log(sum
	 * of array)), where sum of array is the sum of elements in nums. For each
	 * computation of F(x), the time complexity is O(n)O(n) since we only need to go
	 * through the whole array.
	 * 
	 * Space complexity : O(n)O(n). Same as the Brute Force approach. We only need
	 * the space to store the array.
	 */
	public int splitArray(int[] nums, int m) {
		long l = 0;
		long r = 0;
		long ans = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {
			r += nums[i];

			if (l < nums[i]) {
				l = nums[i];
			}
		}

		while (l <= r) {
			long mid = (l + r) / 2;
			long sum = 0;
			int count = 1;

			for (int i = 0; i < nums.length; i++) {
				if (sum + nums[i] > mid) {
					count++;
					sum = nums[i];
				} else {
					sum += nums[i];
				}
			}

			if (count <= m) {
				ans = Long.min(ans, mid);
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		return (int) ans;
	}

	public static void main(String[] args) {

		SplitArrayLargestSum split = new SplitArrayLargestSum();

		 // System.out.println(split.splitArray(new int[] { 7, 2, 5, 10, 8 }, 2));
		
		System.out.println(split.splitArray(new int[] { 1,2,3}, 1));

	}

}
