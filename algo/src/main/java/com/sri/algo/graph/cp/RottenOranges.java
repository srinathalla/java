package com.sri.algo.graph.cp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Given a matrix of dimension r*c where each cell in the matrix can have values
 * 0, 1 or 2 which has the following meaning
 * @author KH2024
 *
 */
public class RottenOranges {

	private static class Pair {
		int r;
		int c;
		int dist = 0;

		public Pair(int r, int c, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

	}

	private static boolean isValid(int i, int j, int N, int M) {
		return i >= 0 && i < N && j >= 0 && j < M;
	}

	/**
	 * Idea is to run BFS from all cells with rotten oranges
	 * and update the time taken. 
	 * 
	 * @param n
	 * @param m
	 * @param s1
	 * @param s2
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int minTimeTakenToRotAllOranges(int[][] matrix, int n, int m) {

		int[][] timeTaken = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (matrix[i][j] == 1) {
					timeTaken[i][j] = Integer.MAX_VALUE;
				} else {
					timeTaken[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (matrix[i][j] == 2) {
					bfs(new Pair(i, j, 0), matrix, n, m, new boolean[n][m], timeTaken);
				}
			}
		}

		int minTime = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (matrix[i][j] == 1) {

					if (timeTaken[i][j] == Integer.MAX_VALUE) {
						return -1;
					}
					minTime = Integer.max(minTime, timeTaken[i][j]);
				}
			}
		}

		return minTime;
	}

	private static void bfs(Pair pair, int[][] matrix, int n, int m, boolean[][] visited, int[][] timeTaken) {

		Queue<Pair> queue = new LinkedList<>();

		queue.add(pair);

		int[] row = new int[] { 0, 0, -1, 1 };
		int[] col = new int[] { -1, 1, 0, 0 };

		while (!queue.isEmpty()) {
			Pair curr = queue.poll();
			visited[curr.r][curr.c] = true;

			if (timeTaken[curr.r][curr.c] > curr.dist) {
				timeTaken[curr.r][curr.c] = curr.dist;
			}

			for (int l = 0; l < 4; l++) {
				int adjR = curr.r + row[l];
				int adjC = curr.c + col[l];
				if (isValid(adjR, adjC, n, m) && !visited[adjR][adjC] && matrix[adjR][adjC] == 1) {
					queue.add(new Pair(adjR, adjC, curr.dist + 1));
				}
			}
		}
	}

	public static void main(String[] args) {

		try (Scanner in = new Scanner(System.in)) {
			int testCount = in.nextInt();

			for (int i = 0; i < testCount; i++) {
				int N = in.nextInt();
				int M = in.nextInt();

				int[][] oranges = new int[N][M];
				for (int l = 0; l < N; l++) {
					for (int m = 0; m < M; m++) {
						oranges[l][m] = in.nextInt();
					}
				}

				System.out.print(minTimeTakenToRotAllOranges(oranges, N, M));
				System.out.println();

			}
		}
	}

}
