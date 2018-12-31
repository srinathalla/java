package com.sri.algo.backtrack.leet;

import java.util.Arrays;

public class NQueens2 {

	int count = 0;

	public int totalNQueens(int n) {

		solveNQueens(n);

		return count;

	}

	public void solveNQueens(int n) {

		char[][] grid = new char[n][n];

		for (char[] row : grid) {
			Arrays.fill(row, '.');
		}

		placeQueens(0, grid);

	}

	private boolean isValidCell(int r, int c, char[][] grid) {

		for (int j = 0; j < c; j++) {
			if (grid[r][j] == 'Q') {
				return false;
			}
		}

		int i = r - 1, j = c - 1;
		while (i >= 0 && j >= 0) {

			if (grid[i][j] == 'Q') {
				return false;
			}

			i--;
			j--;

		}

		i = r + 1;
		j = c - 1;
		while (i < grid.length && j >= 0) {

			if (grid[i][j] == 'Q') {
				return false;
			}

			i++;
			j--;

		}

		return true;
	}

	private void placeQueens(int j, char[][] grid) {

		if (j == grid[0].length) {

			count++;
			return;
		}

		for (int i = 0; i < grid.length; i++) {
			if (isValidCell(i, j, grid)) {
				grid[i][j] = 'Q';
				placeQueens(j + 1, grid);
				grid[i][j] = '.'; // back track.
			}
		}
	}
}
