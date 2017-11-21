package com.sri.algo.graph.cp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Given an array of integers where each element represents the max number of
 * steps that can be made forward from that element. Write a function to return
 * the minimum number of jumps to reach the end of the array (starting from the
 * first element). If an element is 0, then cannot move through that element.
 * 
 * Input:

	1
	11
	1 3 5 8 9 2 6 7 6 8 9
	
	Output:
	3
	
	hops are 0->1,1->4,4->11.
	Using BFS we calculate shortest distance between starting and ending indices.
	
	Time Complexity is O(n) where n is the size of the array.
	Space Complexity is O(n) as we use queue.
	
	This can also be solved using dp as well.
 *
 */
public class MinJumpsToReachEnd {

	static class Cell {
		int v;
		int dist;

		public Cell(int v, int dist) {
			super();
			this.v = v;
			this.dist = dist;
		}
	}

	public static int minJumps(int[] arr, int N) {

		if (arr[0] == 0) {
			return -1;
		}
		boolean[] visited = new boolean[arr.length];

		Queue<Cell> queue = new LinkedList<>();
		queue.add(new Cell(0, 0));
		visited[0] = true;

		while (!queue.isEmpty()) {

			Cell cell = queue.poll();

			if (cell.v == N - 1) {
				return cell.dist;
			}

			for (int i = 1; i <= arr[cell.v]; i++) {
				int adj = cell.v + i;
				if (adj <= N - 1 && !visited[adj]) {
					visited[adj] = true;

					queue.add(new Cell(adj, cell.dist + 1));

				}
			}

		}

		return -1;
	}

	public static void main(String[] args) {
		/*
		 * int[] arr = new int[] { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		 * 
		 * System.out.println(minJumps(arr, 11));
		 */

		try (Scanner in = new Scanner(System.in)) {
			int testCount = in.nextInt();

			for (int i = 0; i < testCount; i++) {
				int n = in.nextInt();
				int[] arr = new int[n];
				for (int j = 0; j < n; j++) {
					arr[j] = in.nextInt();
				}
				System.out.print(minJumps(arr, n));
				System.out.println();

			}
		}

	}

}
