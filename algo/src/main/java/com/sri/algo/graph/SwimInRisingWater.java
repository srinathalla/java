package com.sri.algo.graph;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * On an N x N grid, each square grid[i][j] represents the elevation at that
 * point (i,j).
 * 
 * Now rain starts to fall. At time t, the depth of the water everywhere is t.
 * You can swim from a square to another 4-directionally adjacent square if and
 * only if the elevation of both squares individually are at most t. You can
 * swim infinite distance in zero time. Of course, you must stay within the
 * boundaries of the grid during your swim.
 * 
 * You start at the top left square (0, 0). What is the least time until you can
 * reach the bottom right square (N-1, N-1)?
 * 
 * @author salla
 *
 */
public class SwimInRisingWater {

	public int swimInWaterUsingPqAndSet(int[][] grid) {

		int N = grid.length;
		Set<Integer> seen = new HashSet<>();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((k1, k2) -> grid[k1 / N][k1 % N] - grid[k2 / N][k2 % N]);
		pq.offer(0);
		seen.add(0);
		int ans = 0;

		int[] dr = new int[] { 1, -1, 0, 0 };
		int[] dc = new int[] { 0, 0, 1, -1 };

		while (!pq.isEmpty()) {

			int k = pq.poll();
			System.out.println("popped :" + k);
			int r = k / N, c = k % N;
			ans = Math.max(ans, grid[r][c]);
			if (r == N - 1 && c == N - 1)
				return ans;

			for (int i = 0; i < 4; ++i) {
				int cr = r + dr[i], cc = c + dc[i];
				int ck = cr * N + cc;
				if (0 <= cr && cr < N && 0 <= cc && cc < N && !seen.contains(ck)) {
					pq.offer(ck);
					seen.add(ck);

					System.out.println("pushed :" + ck);
				}
			}
		}

		throw null;

	}

	private static class Point {
		int i;
		int j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}

	/**
	 * T.c : O (n^2)(log n^2) => n ^2(log )
	 * Space Complexity O(n*n).
	 * @param grid
	 * @return
	 */
	public int swimInWater(int[][] grid) {

		int N = grid.length;

		if (N == 1) {
			return 0;
		}

		boolean[][] seen = new boolean[N][N];

		PriorityQueue<Point> pq = new PriorityQueue<Point>((Point p1, Point p2) -> grid[p1.i][p1.j] - grid[p2.i][p2.j]);
		pq.offer(new Point(0, 0));
		seen[0][0] = true;

		int ans = Integer.MIN_VALUE;
		int[] dr = new int[] { 1, -1, 0, 0 };
		int[] dc = new int[] { 0, 0, 1, -1 };

		while (!pq.isEmpty()) {

			Point curr = pq.poll();
			ans = Math.max(ans, grid[curr.i][curr.j]);

			if (curr.i == N - 1 && curr.j == N - 1)
				return ans;

			for (int i = 0; i < 4; ++i) {

				int adjr = curr.i + dr[i];
				int adjc = curr.j + dc[i];

				if (0 <= adjr && adjr < N && 0 <= adjc && adjc < N && !seen[adjr][adjc]) {
					Point adjPoint = new Point(adjr, adjc);
					pq.offer(adjPoint);
					seen[adjr][adjc] = true;
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {

		SwimInRisingWater swim = new SwimInRisingWater();

		System.out.println(swim.swimInWater(new int[][] { { 0, 2 }, { 1, 3 } }));

		System.out.println(swim.swimInWater(new int[][] { { 0, 2, 3 }, { 1, 3, 4 }, { 3, 4, 5 } }));

	}

}
