package com.sri.algo.graph;

/**
 * Given an integer matrix, find the length of the longest increasing path.
 * 
 * From each cell, you can either move to four directions: left, right, up or
 * down. You may NOT move diagonally or move outside of the boundary (i.e.
 * wrap-around is not allowed).
 * 
 * Example 1:
 * 
 * Input: nums = [ [9,9,4], [6,6,8], [2,1,1] ] Output: 4 Explanation: The
 * longest increasing path is [1, 2, 6, 9]. Example 2:
 * 
 * Input: nums = [ [3,4,5], [3,2,6], [2,2,1] ] Output: 4 Explanation: The
 * longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * 
 * @author salla
 *
 */
public class LongestIncreasingPath {

	private int maxPath = 0;

	/**
	 * T.C : O (n^4)
	 * 
	 * @param matrix
	 * @return
	 */
	public int longestIncreasingPath(int[][] matrix) {

		int n = matrix.length;
		
		if (n == 0) {
			return 0;
		}
		int m = matrix[0].length;
		boolean[][] visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				dfs(matrix, visited, i, j, n, m, 1);

			}
		}
		return maxPath;
	}

	private boolean isValid(int r, int c, int n, int m) {
		return r >= 0 && r < n && c >= 0 && c < m;
	}

	void dfs(int[][] matrix, boolean[][] visited, int r, int c, int n, int m, int currPath) {

		visited[r][c] = true;
		maxPath = Integer.max(maxPath, currPath);

		int[] rows = new int[] { 0, 0, -1, 1 };
		int[] cols = new int[] { 1, -1, 0, 0 };

		for (int i = 0; i < 4; i++) {

			int ajdr = r + rows[i];
			int ajdc = c + cols[i];

			if (isValid(ajdr, ajdc, n, m) && !visited[ajdr][ajdc] && matrix[ajdr][ajdc] > matrix[r][c]) {
				dfs(matrix, visited, ajdr, ajdc, n, m, currPath + 1);
			}
		}

		visited[r][c] = false;
	}

	public static void main(String[] args) {

		LongestIncreasingPath lip = new LongestIncreasingPath();

		/*int[][] matrix = new int[][] { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };

		System.out.println(lip.longestIncreasingPath(matrix));*/
		
		int[][] matrix1 = new int[][]  {{3,4,5},{3,2,6},{2,2,1}};
		
		System.out.println(lip.longestIncreasingPath(matrix1));

	}

}
