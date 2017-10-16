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
	
	private static boolean isValid(int i,int j,int N,int M)
	{
		return i >= 0 && i < N && j >=0 && j < M; 
	}

	public static void dfs(int i, int j, int N, int M, int[][] matrix, boolean[][] visited) {

		visited[i][j] = true;
		
        // all 8 moves possible.
		int[] row = new int[] {0, 0,-1,-1,-1, 1, 1, 1};
		int[] col = new int[]{-1, 1, 0, -1, 1, 0,-1, 1};
		
		for (int l=0 ;l < 8;l++)
		{
			int adjR = i + row[l];
			int adjC = j + col[l];
			
			if (isValid(adjR,adjC,N,M) && !visited[adjR][adjC] && matrix[adjR][adjC] == 1)
			{
				dfs(adjR, adjC, N, M, matrix, visited);
			}
		}

	}

	public static void main(String[] args) {

		int[][] arr = new int[][] { { 1, 1, 0 }, { 0, 0, 1 }, { 1, 0, 1 } };

		System.out.println(findIslands(arr, 3, 3));
	}

}
