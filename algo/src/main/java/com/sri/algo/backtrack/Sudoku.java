package com.sri.algo.backtrack;

import java.util.Scanner;

public class Sudoku {

	static class Position {
		int r;
		int c;
	}

	public static boolean solveSudoku(int[][] grid) {

		Position p = new Position();

		if (!hasEmptyCell(grid, p)) {
			return true;
		}

		for (int i = 1; i <= 9; i++) {

			if (isSafe(grid, p.r, p.c, i)) {
				grid[p.r][p.c] = i;

				if (solveSudoku(grid)) {
					return true;
				}

				// back track try different number.
				grid[p.r][p.c] = 0;
			}
		}

		return false;
	}

	private static boolean isSafe(int[][] grid, int r, int c, int no) {
		return !usedInRow(grid, r, no) && !usedInCol(grid, c, no) && !usedInBox(grid, r - r % 3, c - c % 3, no);

	}

	private static boolean hasEmptyCell(int[][] grid, Position p) {

		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {

				if (grid[row][col] == 0) {
					p.r = row;
					p.c = col;
					return true;
				}
			}
		}

		return false;
	}

	private static boolean usedInRow(int[][] grid, int row, int no) {

		for (int col = 0; col < grid[0].length; col++) {

			if (grid[row][col] == no) {
				return true;
			}
		}

		return false;
	}

	private static boolean usedInCol(int[][] grid, int col, int no) {

		for (int row = 0; row < grid.length; row++) {
			if (grid[row][col] == no) {
				return true;
			}
		}

		return false;
	}

	private static boolean usedInBox(int[][] grid, int rStart, int cStart, int no) {

		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (grid[rStart + row][cStart + col] == no) {
					return true;
				}
			}
		}
		return false;
	}

	private static void printMatrix(int[][] grid) {

		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {

				System.out.print(grid[row][col] + " ");
			}

			System.out.println();
		}
	}

	public static void main(String[] args) {

		// 0 means unassigned cells
		/*int[][] grid = new int[][] { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 8, 7, 0, 0, 0, 0, 3, 1 }, { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
				{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		if (solveSudoku(grid))
			printMatrix(grid);
		else
			System.out.println("No solution exists");*/
		
		try(Scanner in = new Scanner(System.in))
		{
	        int testCount = in.nextInt();
	        
	        for (int i =0 ;i < testCount ; i++)
	        {
	        	int[][] grid = new int[9][9];
	        	
	        	for (int r = 0 ;r < 9 ; r++)
	        	{
	        		for (int c = 0 ;c < 9 ; c++)
		        	{
	        			grid[r][c] = in.nextInt();
		        	}
	        	}
	        	
	        	if (solveSudoku(grid))
	    			printMatrix(grid);
	    		else
	    			System.out.println("No solution exists");
	        }
		}

	}

}
