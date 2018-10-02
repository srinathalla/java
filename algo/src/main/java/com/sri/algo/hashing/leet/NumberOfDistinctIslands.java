package com.sri.algo.hashing.leet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's
 * (representing land) connected 4-directionally (horizontal or vertical.) You
 * may assume all four edges of the grid are surrounded by water.
 * 
 * Count the number of distinct islands. An island is considered to be the same
 * as another if and only if one island can be translated (and not rotated or
 * reflected) to equal the other.
 * 
 * Example 1: 11000 11000 00011 00011 Given the above grid map, return 1.
 * Example 2: 11011 10000 00001 11011 Given the above grid map, return 3.
 * 
 * Notice that: 11 1 and 1 11 are considered different island shapes, because we
 * do not consider reflection / rotation. Note: The length of each dimension in
 * the given grid does not exceed 50.
 * 
 * @author salla
 *
 */
public class NumberOfDistinctIslands {

	private Set<Integer> shape;
	private int[][] grid;
	private boolean[][] seen;
	private List<Integer> lshape;

	public int numDistinctIslands1(int[][] grid) {

		this.grid = grid;
		this.seen = new boolean[grid.length][grid[0].length];

		Set<Set<Integer>> shapes = new HashSet<>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {

				shape = new HashSet<>();

				dfs1(i, j, i, j);

				if (!shape.isEmpty()) {
					shapes.add(shape);
				}

			}
		}

		return shapes.size();
	}

	private void dfs1(int r, int c, int r0, int c0) {

		if (r < grid.length && r >= 0 && c >= 0 && c < grid[0].length //
				&& grid[r][c] == 1 && !seen[r][c]) {

			seen[r][c] = true;

			shape.add((r - r0) * 2 * grid[0].length + c - c0);

			dfs1(r, c + 1, r0, c0);
			dfs1(r, c - 1, r0, c0);
			dfs1(r - 1, c, r0, c0);
			dfs1(r + 1, c, r0, c0);
		}

	}

	public int numDistinctIslands(int[][] grid) {

		this.grid = grid;
		this.seen = new boolean[grid.length][grid[0].length];

		Set<List<Integer>> shapes = new LinkedHashSet<>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {

				lshape = new ArrayList<>();

				dfs(i, j, 0);

				if (!lshape.isEmpty()) {
					System.out.println("i :" + i + "j: " + j + lshape);
					shapes.add(lshape);
				}

			}
		}
		System.out.println(shapes);
		return shapes.size();
	}

	private void dfs(int r, int c, int di) {

		if (r < grid.length && r >= 0 && c >= 0 && c < grid[0].length //
				&& grid[r][c] == 1 && !seen[r][c]) {

			seen[r][c] = true;

			lshape.add(di);

			dfs(r, c + 1, 1);
			dfs(r, c - 1, 2);
			dfs(r + 1, c, 3);
			dfs(r - 1, c, 4);

			lshape.add(0);
		}

	}

	public static void main(String[] args) {

		NumberOfDistinctIslands nd = new NumberOfDistinctIslands();

		/*
		 * System.out.println(nd.numDistinctIslands(new int[][] { { 1, 1, 0, 0, 0 }, //
		 * { 1, 1, 0, 0, 0 }, // { 0, 0, 0, 1, 1 }, // { 0, 0, 0, 1, 1 } // }));
		 * 
		 * System.out.println(nd.numDistinctIslands(new int[][] { { 1, 1, 0, 1, 1 }, //
		 * { 1, 0, 0, 0, 0 }, // { 0, 0, 0, 0, 1 }, // { 1, 1, 0, 1, 1 } // }));
		 */

		/*
		 * System.out.println(nd.numDistinctIslands(new int[][] { { 1, 1, 1, 1 }, { 1,
		 * 0, 1, 0 }, // { 0, 0, 0, 0 }, // { 0, 1, 1, 1 }, // { 1, 1, 0, 1 } }));
		 */

		System.out.println(nd.numDistinctIslands(new int[][] {
				{ 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1,
						0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0 },
				{ 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0,
						0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0,
						1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0 },
				{ 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1,
						0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1 } }));

	}
}
