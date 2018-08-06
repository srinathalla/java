package com.sri.algo.dp.leet;

import java.util.Arrays;

/**
 * In a N x N grid representing a field of cherries, each cell is one of three
 * possible integers.
 * 
 * 0 means the cell is empty, so you can pass through; 1 means the cell contains
 * a cherry, that you can pick up and pass through; -1 means the cell contains a
 * thorn that blocks your way. Your task is to collect maximum number of
 * cherries possible by following the rules below:
 * 
 * Starting at the position (0, 0) and reaching (N-1, N-1) by moving right or
 * down through valid path cells (cells with value 0 or 1); After reaching (N-1,
 * N-1), returning to (0, 0) by moving left or up through valid path cells; When
 * passing through a path cell containing a cherry, you pick it up and the cell
 * becomes an empty cell (0); If there is no valid path between (0, 0) and (N-1,
 * N-1), then no cherries can be collected. Example 1: Input: grid = [[0, 1,
 * -1], [1, 0, -1], [1, 1, 1]]
 * 
 * Output: 5
 * 
 * Explanation: The player started at (0, 0) and went down, down, right right to
 * reach (2, 2). 4 cherries were picked up during this single trip, and the
 * matrix becomes [[0,1,-1],[0,0,-1],[0,0,0]]. Then, the player went left, up,
 * up, left to return home, picking up one more cherry. The total number of
 * cherries picked up is 5, and this is the maximum possible. Note:
 * 
 * grid is an N by N 2D array, with 1 <= N <= 50. Each grid[i][j] is an integer
 * in the set {-1, 0, 1}. It is guaranteed that grid[0][0] and grid[N-1][N-1]
 * are not -1.
 * 
 * @author salla
 *
 */
public class CherryPickup {

	private int max_cherries = 0;

	/**
	 * T.C is exponential.As we visit same cells many times.
	 * 
	 * @param grid
	 * @return
	 */
	public int cherryPickupUsingRecursion(int[][] grid) {
		int n = grid.length;

		if (n == 0) {
			return 0;
		}

		dfsDown(grid, 0, 0, 0, n);

		return max_cherries;
	}

	public void dfsDown(int[][] grid, int i, int j, int count, int n) {

		int gridVal = grid[i][j];

		if (grid[i][j] == 1) {
			count++;
			grid[i][j] = 0;
		}

		if (i == n - 1 && j == n - 1) {

			dfsUp(grid, i, j, count, n);
			grid[i][j] = gridVal;
			return;
		}

		if (i + 1 < n && grid[i + 1][j] != -1) {
			dfsDown(grid, i + 1, j, count, n);
		}
		if (j + 1 < n && grid[i][j + 1] != -1) {
			dfsDown(grid, i, j + 1, count, n);
		}

		grid[i][j] = gridVal;

	}

	public void dfsUp(int[][] grid, int i, int j, int count, int n) {

		int gridVal = grid[i][j];

		if (grid[i][j] == 1) {
			count++;
			grid[i][j] = 0;
		}

		if (i == 0 && j == 0) {
			max_cherries = Integer.max(max_cherries, count);
			return;
		}

		if (i > 0 && grid[i - 1][j] != -1) {
			dfsUp(grid, i - 1, j, count, n);
		}
		if (j > 0 && grid[i][j - 1] != -1) {
			dfsUp(grid, i, j - 1, count, n);
		}

		grid[i][j] = gridVal;

	}

	public int cherryPickup(int[][] grid) {
		int ans = 0;

		int[][] bestPath = bestPath(grid);

		if (bestPath == null) {
			return 0;
		}

		for (int[] path : bestPath) {
			ans += grid[path[0]][path[1]];
			grid[path[0]][path[1]] = 0;

		}

		for (int[] path : bestPath(grid)) {
			ans += grid[path[0]][path[1]];
		}

		return ans;
	}

	public int[][] bestPath(int[][] grid) {
		int n = grid.length;

		int[][] ans = new int[(2 * n) - 1][2];
		int[][] dp = new int[n][n];

		for (int[] row : dp) {
			Arrays.fill(row, Integer.MIN_VALUE);
		}

		dp[n - 1][n - 1] = grid[n - 1][n - 1];

		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {

				if (grid[i][j] != -1 && (i != n - 1 || j != n - 1)) {
					dp[i][j] = Integer.max(i + 1 < n ? dp[i + 1][j] : Integer.MIN_VALUE,
							j + 1 < n ? dp[i][j + 1] : Integer.MIN_VALUE);
					dp[i][j] += grid[i][j];
				}
			}
		}

		if (dp[0][0] < 0) {
			return null;
		}

		int i = 0, j = 0, t = 0;

		while (i != n - 1 || j != n - 1) {
			if (j == n - 1 || (i + 1 < n && dp[i + 1][j] >= dp[i][j + 1])) {
				i++;
			} else {
				j++;
			}

			ans[t][0] = i;
			ans[t][1] = j;
			t++;
		}
		return ans;
	}

	public static void main(String[] args) {
		CherryPickup cp = new CherryPickup();

		/* int[][] arr = new int[][] { { 0, 1, -1 }, { 1, 0, -1 }, { 1, 1, 1 } }; */

		int[][] arr = new int[][] { { 1, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 1 },
				{ 1, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1, 1, 1 } };

		System.out.println(cp.cherryPickup(arr));

	}

}
