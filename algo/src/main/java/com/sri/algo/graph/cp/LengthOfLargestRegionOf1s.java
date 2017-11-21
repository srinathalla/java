package com.sri.algo.graph.cp;


/**
 * Consider a matrix with rows and columns (n,m), where each cell contains 
 * either a ‘0’ or a ‘1’ and any cell containing a 1 is called a filled cell. 
 * Two cells are said to be connected if they are adjacent to each other horizontally, 
 * vertically, or diagonally .If one or more filled cells are connected, they form a region. 
 * Your task is to  find the length of the largest region.
 *
 *	Input : M[][5] = { 0 0 1 1 0
                   1 0 1 1 0
                   0 1 0 0 0
                   0 0 0 0 1 }
	Output : 6 
	Ex: in the following example, there are 2 regions one with length 1 and the other as 6.
	so largest region : 6
	
	Idea is to findIslands and keep track of island with highest 1's
 *
 */
public class LengthOfLargestRegionOf1s {

	private static class Counter {
		private int val = 0;
	}

	public static int findIslands(int[][] matrix, int N, int M) {

		boolean[][] visited = new boolean[N][M];

		int result = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matrix[i][j] == 1 && !visited[i][j]) {
					Counter c = new Counter();
					dfs(i, j, N, M, matrix, visited, c);

					result = Integer.max(result, c.val);

				}
			}
		}

		return result;
	}

	private static boolean isValid(int i, int j, int N, int M) {
		return i >= 0 && i < N && j >= 0 && j < M;
	}

	public static void dfs(int i, int j, int N, int M, int[][] matrix, boolean[][] visited, Counter c) {

		visited[i][j] = true;

		c.val = c.val + 1;

		// all 8 moves possible.
		int[] row = new int[] { 0, 0, -1, -1, -1, 1, 1, 1 };
		int[] col = new int[] { -1, 1, 0, -1, 1, 0, -1, 1 };

		for (int l = 0; l < 8; l++) {
			int adjR = i + row[l];
			int adjC = j + col[l];

			if (isValid(adjR, adjC, N, M) && !visited[adjR][adjC] && matrix[adjR][adjC] == 1) {
				dfs(adjR, adjC, N, M, matrix, visited,c);
			}
		}

	}

	public static void main(String[] args) {

		int[][] arr = new int[][] { { 1, 1, 0 }, { 0, 0, 1 }, { 1, 0, 1 } };

		System.out.println(findIslands(arr, 3, 3));
	}

}
