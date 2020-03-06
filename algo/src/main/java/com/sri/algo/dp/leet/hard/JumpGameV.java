package com.sri.algo.dp.leet.hard;

public class JumpGameV {

	public int maxJumps(int[] arr, int d) {

		int[] dp = new int[arr.length];

		int res = 1;
		for (int i = 0; i < arr.length; i++) {
			res = Math.max(res, dfs(i, d, arr, dp));
		}

		return res;

	}

	private int dfs(int i, int d, int[] arr, int[] dp) {

		if (dp[i] > 0) {
			return dp[i];
		}
		int res = 1;

		for (int j = i + 1; j <= Math.min(arr.length - 1, i + d) && arr[j] < arr[i]; j++) {
			res = Math.max(res, 1 + dfs(j, d, arr, dp));
		}
		for (int j = i - 1; j >= Math.max(0, i - d) && arr[j] < arr[i]; j--) {
			res = Math.max(res, 1 + dfs(j, d, arr, dp));
		}

		return res;

	}

	public static void main(String[] args) {

		JumpGameV jumpGameV = new JumpGameV();
		System.out.println(jumpGameV.maxJumps(new int[] { 6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12 }, 2));

	}
}