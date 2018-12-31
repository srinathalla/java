package com.sri.algo.backtrack.leet;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * A sudoku solution must satisfy all of the following rules:
 * 
 * Each of the digits 1-9 must occur exactly once in each row. Each of the
 * digits 1-9 must occur exactly once in each column. Each of the the digits 1-9
 * must occur exactly once in each of the 9 3x3 sub-boxes of the grid. Empty
 * cells are indicated by the character '.'.
 * 
 * 
 * A sudoku puzzle...
 * 
 * 
 * ...and its solution numbers marked in red.
 * 
 * Note:
 * 
 * The given board contain only digits 1-9 and the character '.'. You may assume
 * that the given Sudoku puzzle will have a single unique solution. The given
 * board size is always 9x9.
 * 
 * @author salla
 *
 */
public class SudokuSolver {

	public void solveSudoku(char[][] board) {

		placeNumbers(board,0,0);

	}

	private boolean isValid(char[][] board, int r, int c, int no) {

		for (int j = 0; j < 9; j++) {
			if (board[r][j] != '.' && Character.getNumericValue(board[r][j]) == no) {
				return false;
			}
		}

		for (int j = 0; j < 9; j++) {
			if (board[j][c] != '.' && Character.getNumericValue(board[j][c]) == no) {
				return false;
			}
		}

		int rS = r - (r % 3);
		int cS = c - (c % 3);

		for (int i = rS; i < rS + 3; i++) {
			for (int j = cS; j < cS + 3; j++) {

				if (board[i][j] != '.' && Character.getNumericValue(board[i][j]) == no) {
					return false;
				}

			}
		}
		return true;
	}

	private boolean placeNumbers(char[][] board,int rS,int cS) {

		int r = -1, c = -1;

		for (int i = rS; i < board.length; i++) {

			for (int j = cS; j < board[0].length; j++) {

				if (board[i][j] == '.') {
					r = i;
					c = j;
					break;
				}
			}
		}

		if (r == -1 && c == -1) {
			return true;
		}

		for (int no = 1; no <= 9; no++) {

			if (isValid(board, r, c, no)) {
				board[r][c] = (char) (48 + no);

				if (placeNumbers(board,r,c)) {
					return true;
				}
				board[r][c] = '.'; // backtrack;

			}
		}

		return false;

	}

	public static void main(String[] args) {

		int[][] grid = new int[][] { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 8, 7, 0, 0, 0, 0, 3, 1 }, { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
				{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		char[][] cgrid = new char[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				cgrid[i][j] = grid[i][j] == 0 ? '.' : (char) (48 + grid[i][j]);
			}
		}

		SudokuSolver sudokuSolver = new SudokuSolver();

		sudokuSolver.solveSudoku(cgrid);
		System.out.println(cgrid);

	}

}
