package com.sri.algo.array;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than the last integer of the previous row. For example,
 * 
 * Consider the following matrix:
 * 
 * [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ]
 * 
 * Given target = 3, return true.
 * 
 * @author salla
 *
 */
public class Search2DMatrix2 {

	/**
	 * T.c : O(n) + O(m).
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		int r = 0;
		int n = matrix.length;

		if (n == 0) {
			return false;
		}

		int m = matrix[0].length;

		while (r < n)
		{
			if (matrix[r][m - 1] == target) {
				return true;
			}
			
			else if (matrix[r][m - 1] > target) 
			{
				for (int j = 0; j < m; j++) 
				{
					if (matrix[r][j] == target)
					{
						return true;
					}
				}
				return false;
			} 
			else
			{
				r++;
			}
		}

		return false;

	}
	
	/**
	 * Treat the matrix like a sorted array and apply binary search.
	 * 
	 * T.C O(log n*m).
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrixWithBinarySearch(int[][] matrix, int target) {

		int n = matrix.length;

		if (n == 0) {
			return false;
		}

		int m = matrix[0].length;
		
		int low = 0;
		int high = n * m -1;

		while (low <= high)
		{
			int mid = (low + high)/2;
			
			if (matrix[mid / m][mid % m] == target) {
				return true;
			}
			
			else if (matrix[mid/m][mid % m] > target) 
			{
				high = mid -1;
			} 
			else
			{
				low = mid + 1;
			}
		}

		return false;

	}
	
	public static void main(String[] args) 
	{
		int[][] matrix = 
			{
				  {1,   3,  5,  7},
				  {10, 11, 16, 20},
				  {23, 30, 34, 50}
			};
			
			Search2DMatrix2 sm = new Search2DMatrix2();
			
			System.out.println(sm.searchMatrix(matrix, 5));
			System.out.println(sm.searchMatrix(matrix, 21));
			System.out.println(sm.searchMatrix(matrix, 20));
			
			System.out.println(sm.searchMatrixWithBinarySearch(matrix, 5));
			System.out.println(sm.searchMatrixWithBinarySearch(matrix, 21));
			System.out.println(sm.searchMatrixWithBinarySearch(matrix, 20));
	}

}
