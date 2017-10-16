package com.sri.algo.array;

import java.util.Scanner;

/**
 * A Tic-Tac-Toe board is given after some moves are played. Find out if the
 * given board is valid, i.e., is it possible to reach this board position after
 * some moves or not.
 * 
 * Note that every arbitrary filled grid of 9 spaces isn’t valid e.g. a grid
 * filled with 3 X and 6 O isn’t valid situation because each player needs to
 * take alternate turns.
 * 
 * X X O O O X => Valid X O X
 * 
 * O X X O X X => Not valid as both can win. O X O
 * 
 * 
 * 
 *
 */
public class TicTacToe {

	private static int[][] win = new int[][] { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 },
			{ 2, 5, 8 }, { 0, 4, 8 }, { 2, 4, 6 } };

	private static boolean isAWin(char[] board, char A) {
		for (int i = 0; i < 8; i++) {
			if (board[win[i][0]] == A && board[win[i][1]] == A && board[win[i][2]] == A) {
				return true;
			}
		}
		return false;
	}

	private static boolean isValid(char[] board) {
		int xCount = 0;
		int oCount = 0;

		for (char ch : board) {
			if (ch == 'X') {
				xCount++;
			}
			if (ch == 'O') {
				oCount++;
			}
		}

		if (xCount == oCount || xCount == oCount + 1) {
			if (isAWin(board, 'O')) {
				if (isAWin(board, 'X')) {
					return false;
				}
				return xCount == oCount;
			}

			else if (isAWin(board, 'X')) {
				return xCount - oCount == 1;
			}

			return true;
		}

		return false;
	}

	public static void main(String[] args) {

		// System.out.println(isValid(new char[] { 'X', 'X', 'O', 'O', 'O', 'X', 'X',
		// 'O', 'X' }));

		try (Scanner in = new Scanner(System.in)) {
			int testCount = in.nextInt();

			for (int k = 0; k < testCount; k++) {

				String bStr = in.nextLine();
				while (bStr.isEmpty()) {
					bStr = in.nextLine();
				}
				bStr.trim();
				String[] boardArr = bStr.split(" ");
				char[] board = new char[9];
				for (int i = 0; i < 9; i++) {
					board[i] = Character.toUpperCase(boardArr[i].charAt(0));
				}

				if (isValid(board)) {
					System.out.println("Valid");
				} else {
					System.out.println("Invalid");
				}
			}
		}
	}
}
