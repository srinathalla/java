package com.sri.algo.stack;

/**
 * Given a binary matrix, Your task is to complete the function maxArea which
 * the maximum size rectangle area in a binary-sub-matrix with all 1’s. The
 * function takes 3 arguments the first argument is the Matrix M[ ] [ ] and the
 * next two are two integers n and m which denotes the size of the matrix M.
 * Your function should return an integer denoting the area of the maximum
 * rectangle .
 * 
 *
 * 
 */
public class MaxRectangleWithAll1sInMatrix {

	public static int maxArea(int a[][], int m, int n) {

		int max = 0;

		// Copy first row as is.
		max = Integer.max(max, MaxRectangleArea.getMaxArea(a[0],n));
		

		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 1) {
					a[i][j] = a[i-1][j] + 1;
				} 
			}

			int area = MaxRectangleArea.getMaxArea(a[i], n);
			max = Integer.max(max, area);
		}

		return max;
	}

	public static void main(String[] args) {

		System.out
				.println(maxArea(new int[][] { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } }, 4, 4));
	}

}
