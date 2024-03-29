package com.sri.algo.dp.leet;

/**
 * 
 * Given a square array of integers A, we want the minimum sum of a falling path
 * through A.
 * 
 * A falling path starts at any element in the first row, and chooses one
 * element from each row. The next row's choice must be in a column that is
 * different from the previous row's column by at most one.
 * 
 * Example 1:

	Input: [[1,2,3],[4,5,6],[7,8,9]]
	Output: 12
	Explanation: 
	The possible falling paths are:
	
	[1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
	[2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
	[3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
	The falling path with the smallest sum is [1,4,7], so the answer is 12.
 * 
 * @author srialla
 *
 */
public class MinFallingPathSum {

	/**
	 * * T.C : O(n*m) where is no fo rows, m is no of columns.
	 * 
	 * Idea is to transform existing array into dp array
	 * 
	 * A[i][j] will store the sum of min falling path ending at i,j.
	 * '
	 * 
	 * 
	 * @param A
	 * @return
	 */
	public int minFallingPathSum(int[][] A) {

		for (int i = 1; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {

				int best = A[i - 1][j];
				if (j + 1 < A.length) {
					best = Math.min(best, A[i - 1][j + 1]);
				}
				if (j > 0) {
					best = Math.min(best, A[i - 1][j - 1]);
				}
				A[i][j] += best;
			}
		}

		int min = Integer.MAX_VALUE;

		for (int no : A[A.length - 1]) {
			min = Math.min(min, no);
		}
		return min;
	}

	public static void main(String[] args) {
		
		int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
		
		MinFallingPathSum minFallingPathSum = new MinFallingPathSum();
		
		System.out.println(minFallingPathSum.minFallingPathSum(A));
	}
}
