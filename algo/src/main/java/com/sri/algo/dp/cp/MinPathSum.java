package com.sri.algo.dp.cp;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Example:
 * 
 * Input: [ [1,3,1], [1,5,1], [4,2,1] ] Output: 7 Explanation: Because the path
 * 1→3→1→1→1 minimizes the sum.
 * 
 * 
 *
 */
public class MinPathSum {

	public int minPathSum(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;

		if (n == 0) {
			return 0;
		}

		int[][] pathSum = new int[n][m];

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += grid[i][0];
			pathSum[i][0] = sum;
		}

		sum = 0;
		for (int i = 0; i < m; i++) {
			sum += grid[0][i];
			pathSum[0][i] = sum;
		}

		for (int i = 1; i < n; i++) {

			for (int j = 1; j < m; j++) {
				pathSum[i][j] = Integer.min(pathSum[i - 1][j], pathSum[i][j - 1]) + grid[i][j];
			}
		}

		return pathSum[n-1][m-1];
	}
	
	public static void main(String[] args) {
		
		MinPathSum mps = new MinPathSum();
		
		int[][] grid = new int[][] { {1,3,1}, {1,5,1}, {4,2,1} };
		
		System.out.println(mps.minPathSum(grid));
		
	}

}
