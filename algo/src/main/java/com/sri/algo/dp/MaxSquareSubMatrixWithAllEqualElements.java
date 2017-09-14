package com.sri.algo.dp;

public class MaxSquareSubMatrixWithAllEqualElements {

	/**
	 * This is a variation of MaxSquareSubMatrixWithAll1's.
	 * Time Complexity : O(m*n)
	 * Space Complexity : O(m*n)
	 * @param matrix
	 */
	public static void maxSquareSubMatrix(int[][] matrix) {

		// S[i][j] represents size of the square sub-matrix with all equal Elements
		// including M[i][j]
		// where M[i][j] is the rightmost and bottom most entry in sub-matrix.
		int[][] s = new int[matrix.length][matrix[0].length];

		// Set all first row values to 1.
		for (int i = 0; i < matrix[0].length; i++) {
			s[0][i] = 1;
		}

		// Set all first column values
		for (int i = 0; i < matrix.length; i++) {
			s[i][0] = 1;
		}

		for (int i = 1; i < matrix.length; i++) {

			for (int j = 1; j < matrix[0].length; j++) {

				if (matrix[i][j] == matrix[i - 1][j - 1] && matrix[i][j] == matrix[i - 1][j]
						&& matrix[i][j] == matrix[i][j - 1]) {
					s[i][j] = Integer.min(s[i - 1][j - 1],
							Integer.min(s[i][j - 1], s[i - 1][j])) + 1;
				}

				else {
					s[i][j] = 1;
				}
			}
		}

		int max = Integer.MIN_VALUE;
		int max_i = Integer.MIN_VALUE, max_j = Integer.MIN_VALUE;
		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix[0].length; j++) {
				if (s[i][j] > max) {
					max = s[i][j];
					max_i = i;
					max_j = j;
				}
			}
		}

		System.out.println("Max Square matrix length : " + max);
		for (int i = max_i; i > max_i - max; i--) {

			for (int j = max_j; j > max_j - max; j--) {
				System.out.print(matrix[i][j] + " ");
			}

			System.out.println();
		}

	}

	public static void main(String[] args) {

		maxSquareSubMatrix(new int[][] {
			{ 2, 3, 3 }, 
			{ 2, 3, 3 }, 
			{ 2, 2, 2 } });
		
		maxSquareSubMatrix(new int[][] {
			{9, 9, 9, 8},
            {9, 9, 9, 6},
            {9, 9, 9, 3},
            {2, 2, 2, 2}});
		
		maxSquareSubMatrix(new int[][] {
			{ 2, 3, 3, 4}, 
			{ 2, 3, 3, 3}, 
			{ 2, 2, 3 ,3} });
		
	}

	

}
