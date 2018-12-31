package com.sri.algo.heap.leet.hard;

import java.util.PriorityQueue;

public class TrapRainWater2 {

	private static class Cell {
		int row;
		int col;
		int height;

		public Cell(int row, int col, int height) {
			this.row = row;
			this.col = col;
			this.height = height;
		}
	}

	/**
	 * Idea is to pick the smallest cell from the boundary  and compute water that can be stored in
	 * all the adjacent cells.
	 * 
	 * T.C  : O(n)
	 * 
	 * @param heights
	 * @return
	 */
	public int trapRainWater(int[][] heights) {
		if (heights == null || heights.length == 0 || heights[0].length == 0)
			return 0;

		int m = heights.length;
		int n = heights[0].length;

		boolean[][] visited = new boolean[m][n];
		PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.height - b.height);

		int max = 0;

		for (int i = 0; i < m; i++) {
			visited[i][0] = true;
			visited[i][n - 1] = true;

			pq.offer(new Cell(i, 0, heights[i][0]));

			pq.offer(new Cell(i, n - 1, heights[i][n - 1]));
		}

		for (int i = 0; i < n; i++) {
			visited[0][i] = true;
			visited[m - 1][i] = true;

			pq.offer(new Cell(0, i, heights[0][i]));

			pq.offer(new Cell(m - 1, i, heights[m - 1][i]));
		}

		int[][] cells = new int[][] { {0,1} , {0,-1}, { -1,0},{ 1,0 }};
	

		while (!pq.isEmpty()) {
			Cell cell = pq.poll();

			for (int[] aCell : cells) {
				int adjr = cell.row + aCell[0];
				int adjc = cell.col + aCell[1];

				if (adjr >= 0 && adjr < m && adjc >= 0 && adjc < n && !visited[adjr][adjc]) {
					visited[adjr][adjc] = true;
					max += Math.max(0, cell.height - heights[adjr][adjc]);
					pq.offer(new Cell(adjr, adjc, Math.max(cell.height, heights[adjr][adjc])));
					
				}
			}
		}

		return max;
	}

	public static void main(String[] args) {

		TrapRainWater2 trapRainWater2 = new TrapRainWater2();

		int[][] heights = new int[][] { { 1, 4, 3, 1, 3, 2 }, { 3, 2, 1, 3, 2, 4 }, { 2, 3, 3, 2, 3, 1 } };

		System.out.println(trapRainWater2.trapRainWater(heights));

	}

}
