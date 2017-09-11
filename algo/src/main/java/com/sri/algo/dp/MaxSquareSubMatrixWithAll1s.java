package com.sri.algo.dp;

public class MaxSquareSubMatrixWithAll1s {

	public static void maxSquareSubMatrix(int[][] matrix) {

		// S[i][j] represents size of the square sub-matrix with all 1s including M[i][j] 
		// where M[i][j] is the rightmost and bottommost entry in sub-matrix.
		int[][] s = new int[matrix.length][matrix[0].length];

		// Copy first row.
		for (int i = 0; i < matrix[0].length; i++) {
			s[0][i] = matrix[0][i];
		}

		// Copy first column.
		for (int i = 0; i < matrix.length; i++) {
			s[i][0] = matrix[i][0];
		}

		for (int i = 1; i < matrix.length; i++) {

			for (int j = 1; j < matrix[0].length; j++) {

				if (matrix[i][j] == 1) {
					s[i][j] = Integer.min(s[i - 1][j - 1],
							Integer.min(s[i][j - 1], s[i - 1][j])) + 1;
				}

				else {
					s[i][j] = 0;
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
		
		
		for (int i = max_i; i > max_i - max ; i--)
		{
		
			for (int j = max_j; j > max_j - max ; j--)
			{
				System.out.print(matrix[i][j] + " ");
			}
			
			System.out.println();
		}

	}
	
	public static void main(String[] args) {
		
		maxSquareSubMatrix(new int[][]{
				   {0, 1, 1, 0, 1}, 
                   {1, 1, 0, 1, 0}, 
                   {0, 1, 1, 1, 0},
                   {1, 1, 1, 1, 0},
                   {1, 1, 1, 1, 1},
                   {0, 0, 0, 0, 0}});
		
	}

}
