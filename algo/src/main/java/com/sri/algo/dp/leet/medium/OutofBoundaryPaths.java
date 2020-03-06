package com.sri.algo.dp.leet.medium;

/**
 * There is an m by n grid with a ball. Given the start coordinate (i,j) of the
 * ball, you can move the ball to adjacent cell or cross the grid boundary in
 * four directions (up, down, left, right). However, you can at most move N
 * times. Find out the number of paths to move the ball out of grid boundary.
 * The answer may be very large, return it after mod 109 + 7.
 * 
 * @author srialla
 *
 */
public class OutofBoundaryPaths {

	private static int M = 1000000007;

	public int findPaths(int m, int n, int N, int i, int j) {

		int[][][] memo = new int[m][n][N + 1];
		return findPaths(m, n, N, i, j, memo);

	}

	public int findPaths(int m, int n, int N, int i, int j, int[][][] memo) {

		if (i < 0 || i == m || j < 0 || j == n) {
			return 1;
		}

		if (N == 0) {
			return 0;
		}

		if (memo[i][j][N] > 0) {
			return memo[i][j][N];
		}

		memo[i][j][N] = findPaths(m, n, N - 1, i - 1, j) % M + findPaths(m, n, N - 1, i + 1, j) % M
				+ findPaths(m, n, N - 1, i, j - 1) % M + findPaths(m, n, N - 1, i, j + 1) % M;

		return memo[i][j][N];

	}

	public static void main(String[] args) {

		OutofBoundaryPaths outofBoundaryPaths = new OutofBoundaryPaths();
		System.out.println(
			outofBoundaryPaths.findPaths(2, 2, 2, 0, 0));

	}

}
