package com.sri.algo.array.leet.medium;

public class RangeSum {

	int[][] matrix;
	int[][] dp;

	public RangeSum(int[][] matrix) {
		this.matrix = matrix;
		this.dp = new int[matrix.length][matrix[0].length];

		for (int i = 0; i <= matrix.length; i++) {
			int sum = 0;
			for (int j = 0; j <= matrix.length; i++) {
				sum += matrix[i][j];
				dp[i][j] = sum;
			}
		}

	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int sum = 0;
		for (int i = row1; i <= row2; i++) {
			sum += dp[i][col2];
			if (col1 > 0) {
				sum -= dp[i][col1 - 1];
			}
		}
		return sum;

	}

}
