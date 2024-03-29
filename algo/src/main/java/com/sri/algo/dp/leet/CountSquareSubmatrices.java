package com.sri.algo.dp.leet;

/**
 * Given a m * n matrix of ones and zeros, return how many square submatrices
 * have all ones.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: matrix = [ [0,1,1,1], [1,1,1,1], [0,1,1,1] ] Output: 15 Explanation:
 * There are 10 squares of side 1. There are 4 squares of side 2. There is 1
 * square of side 3. Total number of squares = 10 + 4 + 1 = 15.
 * 
 * @author srialla
 *
 */
public class CountSquareSubmatrices {

	/**
	 * 
	 * matrix[i][j]  : No of squares with i,j as bottom right corner
	 * matrix[i][j]  : Also represents size of biggest square with i,j as bottom right corner
	 * 
	 * T.C: O(n*m) where n : rows,m : columns
	 * @param matrix
	 * @return
	 */
	public int countSquares(int[][] matrix) {
		int res = 0;
		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix[0].length; j++) {

				if (matrix[i][j] > 0 && i > 0 && j > 0) {
					matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
				}
				res += matrix[i][j];
			}
		}
		return res;
	}

	public static void main(String[] args) {

		CountSquareSubmatrices countSquareSubmatrices = new CountSquareSubmatrices();
	}

}
