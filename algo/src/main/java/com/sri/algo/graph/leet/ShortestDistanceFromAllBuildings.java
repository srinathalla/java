package com.sri.algo.graph.leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 		You want to build a house on an empty land which reaches all 
 *      buildings in the shortest amount of distance. You can only move
 *      up, down, left and right. You are given a 2D grid of values 0, 1
 *      or 2, where:

		
		Each 0 marks an empty land which you can pass by freely.
		Each 1 marks a building which you cannot pass through.
		Each 2 marks an obstacle which you cannot pass through.
		
 * @author salla
 *
 */
public class ShortestDistanceFromAllBuildings {
	
	/**
	 *  
	 * @return
	 */
	public int shortestDistance(int[][] grid) {

		List<int[]> buildings = new ArrayList<>();

		int n = grid.length;
		int m = grid[0].length;
		int[][] dist = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					buildings.add(new int[] { i, j, 0 });
				}
				
				grid[i][j] = -grid[i][j];
			}
		}

		for (int i = 0; i < buildings.size(); i++) {
			bfs(grid, buildings.get(i), i, dist, n, m);
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (grid[i][j] == buildings.size() && dist[i][j] < min) {
					min = dist[i][j];
				}
			}
		}

		return min;
	}

	private void bfs(int[][] grid, int[] cell, int k, int[][] dist, int n, int m) {
		Queue<int[]> q = new LinkedList<>();
		q.add(cell);
		// grid[cell[0]][cell[1]] = k + 1;

		int[] rows = new int[] { 0, 0, -1, 1 };
		int[] cols = new int[] { 1, -1, 0, 0 };

		while (!q.isEmpty()) {
			int[] p = q.poll();

			dist[p[0]][p[1]] += p[2];

			for (int i = 0; i < 4; i++) {
				int adjR = p[0] + rows[i];
				int adjC = p[1] + cols[i];

				if (adjR >= 0 && adjR < n && adjC >= 0 && adjC < m && grid[adjR][adjC] == k) {
					q.add(new int[] { adjR, adjC, p[2] + 1 });
					grid[adjR][adjC] = k + 1;
				}
			}
		}

	}
	
	public static void main(String[] args) {
		
		
		ShortestDistanceFromAllBuildings shortest = new ShortestDistanceFromAllBuildings();
		
		int[][] grid = new int[][] {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
		System.out.println(
			shortest.shortestDistance(grid));
	}

}
