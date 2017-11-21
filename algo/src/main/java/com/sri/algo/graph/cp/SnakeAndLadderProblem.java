package com.sri.algo.graph.cp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Is solved using BFS.
 * Time Complexity O(N) where N is number of cells in the board.
 * 
 * 
 * @author salla
 *
 */
public class SnakeAndLadderProblem {

	static class Cell {
		int v;
		int dist;

		public Cell(int v, int dist) {
			super();
			this.v = v;
			this.dist = dist;
		}
	}

	public static int minDice(int[] board, int N) {
		boolean[] visited = new boolean[board.length];

		Queue<Cell> queue = new LinkedList<>();
		queue.add(new Cell(0, 0));
		visited[0] = true;

		while (!queue.isEmpty()) {

			Cell cell = queue.poll();

			if (cell.v == N - 1) {
				return cell.dist;
			}

			for (int i = 1; i <= 6; i++) {
				int adj = cell.v + i;
				if (adj <= N - 1 && !visited[adj]) {
					visited[adj] = true;
					if (board[adj] == 0) {
						queue.add(new Cell(adj, cell.dist + 1));
					} else {
						queue.add(new Cell(board[adj], cell.dist + 1));
					}
				}
			}

		}

		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) {

		/*
		 * int[] board = new int[30];
		 * 
		 * board[10] = 25; board[2] = 21; board[4] = 7; board[19] = 28; board[26] = 1;
		 * board[21] = 8;
		 * 
		 * System.out.println(minDice(board,30));
		 */

		try (Scanner in = new Scanner(System.in)) {
			int testCount = in.nextInt();

			for (int i = 0; i < testCount; i++) {
				int n = in.nextInt();
				int[] board = new int[30];
				for (int j = 0; j < n; j++) {
					board[in.nextInt() - 1] = in.nextInt() - 1;
				}
				System.out.print(minDice(board, 30));
				System.out.println();

			}
		}

	}

}
