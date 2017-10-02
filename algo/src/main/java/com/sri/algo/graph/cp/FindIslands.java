package com.sri.algo.graph.cp;

/**
 * A group of connected 1s forms an island now your task is to complete the
 * method findIslands which returns the no of islands present. The function
 * takes three arguments the first is the boolean matrix A and then the next two
 * arguments are N and M denoting the size of the matrix A .
 *
 * i/p : 1 1 0 0 0 1 1 0 1
 * 
 * o/p : 2
 *
 */
public class FindIslands {

	public static int findIslands(int[][] matrix, int N, int M) {

		boolean[][] visited = new boolean[N][M];

		int count = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matrix[i][j] == 1 && !visited[i][j]) {
					dfs(i, j, N, M, matrix, visited);
					count++;
				}
			}
		}

		return count;
	}

	public static void dfs(int i, int j, int N, int M, int[][] matrix, boolean[][] visited) {

		visited[i][j] = true;

		// current row
		if (j < N - 1 && !visited[i][j + 1] && matrix[i][j + 1] == 1) {
			dfs(i, j + 1, N, M, matrix, visited);
		}
		if (j > 0 && !visited[i][j - 1] && matrix[i][j - 1] == 1) {
			dfs(i, j - 1, N, M, matrix, visited);
		}

		// next row.
		if (i < N - 1 && !visited[i + 1][j] && matrix[i + 1][j] == 1) {
			dfs(i + 1, j, N, M, matrix, visited);
		}
		if (i < N - 1 && j < M - 1 && !visited[i + 1][j + 1] && matrix[i + 1][j + 1] == 1) {
			dfs(i + 1, j + 1, N, M, matrix, visited);
		}
		if (i < N - 1 && j > 0 && !visited[i + 1][j - 1] && matrix[i + 1][j - 1] == 1) {
			dfs(i + 1, j - 1, N, M, matrix, visited);
		}

		// prev row.
		if (i > 0 && !visited[i - 1][j] && matrix[i - 1][j] == 1) {
			dfs(i - 1, j, N, M, matrix, visited);
		}
		if (i > 0 && j > 0 && !visited[i - 1][j - 1] && matrix[i - 1][j - 1] == 1) {
			dfs(i - 1, j - 1, N, M, matrix, visited);
		}
		if (i > 0 && j < M - 1 && !visited[i - 1][j + 1] && matrix[i - 1][j + 1] == 1) {
			dfs(i - 1, j + 1, N, M, matrix, visited);
		}

	}

	public static void main(String[] args) {

		int[][] arr = new int[][] { { 1, 1, 0 }, { 0, 0, 1 }, { 1, 0, 1 } };

		System.out.println(findIslands(arr, 3, 3));
	}

}
