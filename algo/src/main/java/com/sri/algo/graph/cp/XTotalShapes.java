package com.sri.algo.graph.cp;

/**
 * Given N * M string array of O's and X's Return the number of 'X' total
 * shapes. 'X' shape consists of one or more adjacent X's (diagonals not
 * included).
 * 
 * Example (1):
 * 
 * OOOXOOO OXXXXXO OXOOOXO
 * 
 * answer is 1 , shapes are : X X X X X X X
 * 
 *
 */
public class XTotalShapes {

	public static int getXTotalShapes(char[][] input, int N, int M) {

		boolean[][] visited = new boolean[N][M];
		int count = 0;

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < M; j++) {

				if (!visited[i][j] && input[i][j] == 'X') {
					count++;
					dfs(input, i, j, N, M, visited);
				}
			}
		}

		return count;

	}

	public static boolean isValid(int i, int j, int N, int M) {
		return i >= 0 && i < N && j >= 0 && j < M;
	}

	public static void dfs(char[][] input, int r, int c, int N, int M, boolean[][] visited) {

		visited[r][c] = true;

		int[] rIndex = new int[] { 0, 0, -1, 1 };

		int[] cIndex = new int[] { 1, -1, 0, 0 };

		for (int i = 0; i < 4; i++) {
			int adjR = r + rIndex[i];
			int adjC = c + cIndex[i];

			if (isValid(adjR, adjC, N, M) && input[adjR][adjC] == 'X' && !visited[adjR][adjC]) {
				dfs(input, adjR, adjC, N, M, visited);
			}
		}

	}

	public static void main(String[] args) {

		char[][] arr = new char[][] { { 'X', 'X', 'X' }, { 'O', 'O', 'O' }, { 'X', 'X', 'X' } };
		
		System.out.println(getXTotalShapes(arr,3,3));

	}

}
