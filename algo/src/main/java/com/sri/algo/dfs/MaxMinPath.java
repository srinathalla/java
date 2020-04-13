package com.sri.algo.dfs;

import java.util.PriorityQueue;
import java.util.Queue;

public class MaxMinPath {

	public int maximumMinimumPath(int[][] A) {

		int[] r = { 0, 0, -1, 1 };
		int[] c = { 1, -1, 0, 0 };
		Queue<int[]> pq = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);
		pq.add(new int[] { A[0][0], 0, 0 });
		int max = A[0][0];
		A[0][0] = -1;

		while (!pq.isEmpty()) {
			int[] p = pq.poll();
			max = Math.min(max, p[0]);

			if (p[1] == A.length - 1 && p[2] == A[0].length - 1) {
				break;
			}

			for (int i = 0; i < 4; i++) {

				int ar = r[i] + p[1];
				int ac = c[i] + p[2];

				if (ar >= 0 && ar < A.length && ac >= 0 && ac < A[0].length && A[ar][ac] >= 0) {

					pq.add(new int[] { A[ar][ac], ar, ac });
					A[ar][ac] = -1;
				}

			}

		}
		return max;
	}

	public static void main(String[] args) {

		MaxMinPath maxMinPath = new MaxMinPath();

		int[][] A = new int[][] { { 5, 4, 5 }, { 1, 2, 6 }, { 7, 4, 6 } };

		System.out.println(maxMinPath.maximumMinimumPath(A));

	}

}
