package com.sri.algo.dp;

/**
 * Given a sequence of matrices, find the most efficient way to multiply these
 * matrices together. The problem is not actually to perform the
 * multiplications, but merely to decide in which order to perform the
 * multiplications.
 * 
 * For example, suppose A is a 10 × 30 matrix, B is a 30 × 5 matrix, and C is a
 * 5 × 60 matrix. Then,
 * 
 * (AB)C = (10×30×5) + (10×5×60) = 1500 + 3000 = 4500 operations A(BC) =
 * (30×5×60) + (10×30×60) = 9000 + 18000 = 27000 operations.
 * 
 * Input: p[] = {40, 20, 30, 10, 30} Output: 26000
 * 
 * multiplications are obtained by putting parenthesis in following way (A(BC))D
 * --> 20*30*10 + 40*20*10 + 40*10*30
 *
 */
public class MatrixChainMultiplication {

	static int matrixChainOrder(int p[], int l, int h) {
		System.out.println("l :" + l + " h:" + h);
		if (l == h) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int i = l; i < h; i++) {

			int count = matrixChainOrder(p, l, i) + matrixChainOrder(p, i + 1, h) + p[l - 1] * p[i] * p[h];

			min = Integer.min(min, count);
		}

		return min;
	}

	// Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
	static int matrixChainOrderWithDP(int p[], int n) {

		int table[][] = new int[n][n];
		int l, h, i, gap;

		// Multiplying a single matrix cost is zero.
		for (i = 0; i < n; i++) {
			table[i][i] = 0;
		}
       
		// Compute cost of matrices with gaps of 2,3..n-1.
		// fill the matrix based on recursion.
		for (gap = 2; gap < n; gap++) {
			
			// fill all the rows starting from 1 till n -gap +1 as he gap increases
			// number of rows to be filled decreases.
			for (l = 1; l < n - gap + 1; l++) {
				
				// compute h for given row.
				h = l + gap - 1;

				table[l][h] = Integer.MAX_VALUE;
				for (i = l; i < h; i++) {
					int res = table[l][i] + table[i + 1][h] + p[l - 1] * p[i] * p[h];
					if (res < table[l][h]) {
						table[l][h] = res;
					}

				}
			}
		}

		return table[1][n - 1];
	}

	public static void main(String args[]) {
		int arr[] = new int[] { 1, 2, 3, 4 };
		int n = arr.length;

		System.out.println("Minimum number of multiplications is " + matrixChainOrder(arr, 1, n - 1));

		System.out.println("Minimum number of multiplications is " + matrixChainOrderWithDP(arr, n));

	}

}
