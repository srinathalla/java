package com.sri.algo.array.leet;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in
 * ascending order, find the kth smallest element in the matrix.
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth
 * distinct element.
 * 
 * Example:
 * 
 * matrix = [ [ 1, 5, 9], [10, 11, 13], [12, 13, 15] ], k = 8,
 * 
 * return 13. Note: You may assume k is always valid, 1 ≤ k ≤ n2.
 * 
 * @author salla
 *
 */
public class KthSmallestElementInSortedMatrix {

	/**
	 * build a min heap with elements in first column
	 * 
	 * idea is similar to merge n rows sorted
	 * 
	 * T.C O(nlogn) + O(klogn) => O(klogn) => O(n^2logn)
	 * 
	 * @param matrix
	 * @param k
	 * @return
	 */
	public int kthSmallestWithUsingMergeSortedRowsTechnique(int[][] matrix, int k) {

		int n = matrix.length;

		Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

		for (int i = 0; i < n; i++) {
			pq.add(new int[] { i, 0, matrix[i][0] });
		}

		for (int i = 0; i < k - 1; i++) {
			int[] p = pq.poll();

			if (++p[1] < n) {

				p[2] = matrix[p[0]][p[1]];
				pq.add(p);
			}
		}

		return pq.poll()[2];
	}

	
	/**
	 * Using range based binary search  we can solve this
	 * 
	 * T.C O(n^2log(max-min))
	 * @param matrix
	 * @param k
	 * @return
	 */
	public int kthSmallest(int[][] matrix, int k) {

		int n = matrix.length;
		int l = matrix[0][0], h = matrix[n - 1][n - 1];

		while (l < h) {

			int mid = (l + h) / 2;

			int j = n - 1, count = 0;
			;
			for (int i = 0; i < n; i++) {
				while (j >= 0 && matrix[i][j] > mid)
					j--;
				count += j + 1;
			}

			if (count < k) {
				l = mid + 1;
			} else {
				h = mid;
			}

		}

		return l;
	}

	public static void main(String[] args) {

		KthSmallestElementInSortedMatrix smallest = new KthSmallestElementInSortedMatrix();

		System.out.println(smallest.kthSmallest(new int[][] { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } }, 8));
	}

}
