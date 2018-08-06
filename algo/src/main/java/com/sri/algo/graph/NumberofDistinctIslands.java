package com.sri.algo.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's
 * (representing land) connected 4-directionally (horizontal or vertical.) You
 * may assume all four edges of the grid are surrounded by water.
 * 
 * Count the number of distinct islands. An island is considered to be the same
 * as another if they have the same shape, or have the same shape after rotation
 * (90, 180, or 270 degrees only) or reflection (left/right direction or up/down
 * direction).
 * 
 * Example 1: 11000 10000 00001 00011 Given the above grid map, return 1.
 * 
 * Notice that: 11 1 and 1 11 are considered same island shapes. Because if we
 * make a 180 degrees clockwise rotation on the first island, then two islands
 * will have the same shapes.
 * 
 * @author salla
 *
 */
public class NumberofDistinctIslands {

	public int numDistinctIslands(int[][] grid) {
		if (grid == null || grid.length < 1 || grid[0].length < 1)
			return 0;
		int m = grid.length, n = grid[0].length;
		Set<String> res = new HashSet<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				Set<String> set = new HashSet<>();
				if (grid[i][j] == 1) {
					dfs(grid, i, j, i, j, set);
					res.add(set.toString());
				}
			}
		}
		return res.size();
	}

	public void dfs(int[][] grid, int i, int j, int baseX, int baseY, Set<String> set) {
		int m = grid.length, n = grid[0].length;
		if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0)
			return;
		set.add((i - baseX) + "_" + (j - baseY));
		grid[i][j] = 0;
		dfs(grid, i + 1, j, baseX, baseY, set);
		dfs(grid, i - 1, j, baseX, baseY, set);
		dfs(grid, i, j - 1, baseX, baseY, set);
		dfs(grid, i, j + 1, baseX, baseY, set);
	}

	public static void main(String[] args) {

		NumberofDistinctIslands nod = new NumberofDistinctIslands();

		int[][] grid = new int[][] { { 1, 1, 0, 0, 0 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1 }, { 0, 0, 0, 1, 1 } };

		System.out.println(nod.numDistinctIslands(grid));

	}

}
