package com.sri.algo.backtrack;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Consider a rat placed at (0, 0) in a square matrix m[][] of order n and has
 * to reach the destination at (n-1, n-1). Your task is to complete the function
 * which returns a sorted array of strings denoting all the possible directions
 * which the rat can take to reach the destination at (n-1, n-1). The directions
 * in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right).
 * 
 * For example 1 0 0 0 1 1 0 1 1 1 0 0 0 1 1 1
 * 
 * For the above matrix the rat can reach the destination at (3, 3) from (0, 0)
 * by two paths ie DRDDRR and DDRDRR when printed in sorted order we get DDRDRR
 * DRDDRR.
 * 
 * 
 * Time Complexity : O(n^n).
 * 
 *
 *
 */
public class RatInaMaze {

	public static ArrayList<String> printPath(int[][] m, int n) {
		ArrayList<String> allPaths = new ArrayList<>();
		boolean[][] visited = new boolean[n][n];

		dfs(m, 0, 0, n, visited, new StringBuilder(), allPaths);

		Collections.sort(allPaths);

		return allPaths;

	}

	private static boolean isValid(int r, int c, int n, int m) {
		return r >= 0 && r < n && c >= 0 && c < m;
	}

	private static void dfs(int[][] table, int r, int c, int n, boolean[][] visited, StringBuilder path,
			ArrayList<String> allPaths) {

		visited[r][c] = true;

		if (r == n - 1 && c == n - 1) {
			allPaths.add(path.toString());
		}

		int[] row = new int[] { 0, 0, -1, 1 };
		int[] col = new int[] { 1, -1, 0, 0 };
		char[] direction = new char[] { 'R', 'L', 'U', 'D' };

		for (int i = 0; i < 4; i++) {
			int adjR = r + row[i];
			int adjC = c + col[i];

			if (isValid(adjR, adjC, n, n) && table[adjR][adjC] == 1 && !visited[adjR][adjC]) {
				dfs(table, adjR, adjC, n, visited, path.append(direction[i]), allPaths);
			}
		}

		// Back track to capture all paths.
		visited[r][c] = false;
		
		if (path.length() > 0)
		{
			path.deleteCharAt(path.length() - 1);
		}

	}

	public static void main(String[] args) {

		int[][] arr = new int[][] { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };

		System.out.println(printPath(arr, 4));
	}

}
