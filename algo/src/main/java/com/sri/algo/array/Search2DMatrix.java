package com.sri.algo.array;

/**
 * 	Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

	Integers in each row are sorted in ascending from left to right.
	Integers in each column are sorted in ascending from top to bottom.
	For example,

	Consider the following matrix:
	
	[
	  [1,   4,  7, 11, 15],
	  [2,   5,  8, 12, 19],
	  [3,   6,  9, 16, 22],
	  [10, 13, 14, 17, 24],
	  [18, 21, 23, 26, 30]
	]
	
	Given target = 5, return true.

	Given target = 20, return false.


 * @author salla
 *
 */
public class Search2DMatrix 
{

	/**
	 * Simple scan the matrix.
	 * T.C : O(n*m).
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix(int[][] matrix, int target)
	{
		int n = matrix.length;
		int m = matrix[0].length;
		
		for (int i =0 ;i < n;i++)
		{
			for (int j =0 ;j < m;j++)
			{
					
				if (matrix[i][j] == target)
				{
					return true;
				}
			}
		}
		
		return false;
    }
	
	/**
	 * Apply binary search on each row.
	 * T.C:  O(n * logm).
	 * 
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrixWithBinSearch(int[][] matrix, int target)
	{
		int n = matrix.length;
		int m = matrix[0].length;
		
		for (int i =0 ;i < n;i++)
		{
			if(binarySearch(matrix, 0, m-1, i, target))
			{
				return true;
			}
		}
		
		return false;
    }
	
	private boolean binarySearch(int[][] m, int low,int high,int r,int target)
	{
		if(low <= high)
		{
			
			int mid = (low + high)/2;
			
			if (m[r][mid] == target)
			{
				return true;
			}
			
			if (m[r][mid] > target)
			{
				return binarySearch(m, low,mid-1,r,target);
			}
			else
			{
				return binarySearch(m, mid + 1,high,r,target);
			}
			
		}
		
		return false;	
	}
	
	
	/**
	 * Start from top right and eliminate either a row/col based on the target element. 
	 * 
	 * 
	 * T.C : O(n) + O(m).
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	
	public boolean searchMatrixStartinfTopRight(int[][] matrix, int target) 
	{
		int n = matrix.length;
		
		if(n == 0)
		{
			return false;
		}
		
		int m = matrix[0].length;
		
		int r = 0,c = m-1;
		
		while(r < n && c >= 0)
		{
			
			if (matrix[r][c] == target)
			{
				return true;
			}
			else if (matrix[r][c] > target)
			{
				 c--; // Entire column can be skipped as all the target element is smaller than the smallest element of the column.
			}
			else
			{
				r++; // Since target element is bigger than biggest element of the row, entire row can be skipped.
				     
			}
		}
		
		return false;
    }
	
	public boolean searchMatrixStartingBottomLeft(int[][] matrix, int target) 
	{
		int n = matrix.length;
		
		if(n == 0)
		{
			return false;
		}
		
		int m = matrix[0].length;
		
		int r = n-1,c = 0;
		
		while(r >=0 && c < m)
		{
			
			if (matrix[r][c] == target)
			{
				return true;
			}
			else if (matrix[r][c] > target)
			{
				 r--; // Entire column can be skipped as all the target element is smaller than the smallest element of the column.
			}
			else
			{
				c++; // Since target element is bigger than biggest element of the row, entire row can be skipped.
				     
			}
		}
		
		return false;
    }
	
	
	
	public static void main(String[] args) {
		
		
		int[][] matrix = 
		{
		  {1,   4,  7, 11, 15},
		  {2,   5,  8, 12, 19},
		  {3,   6,  9, 16, 22},
		  {10, 13, 14, 17, 24},
		  {18, 21, 23, 26, 30}
		};
		
		Search2DMatrix sm = new Search2DMatrix();
		
		System.out.println(sm.searchMatrix(matrix, 5));
		System.out.println(sm.searchMatrix(matrix, 21));
		System.out.println(sm.searchMatrix(matrix, 20));
		
		System.out.println(sm.searchMatrixWithBinSearch(matrix, 5));
		System.out.println(sm.searchMatrixWithBinSearch(matrix, 21));
		System.out.println(sm.searchMatrixWithBinSearch(matrix, 20));
		
		System.out.println(sm.searchMatrixStartingBottomLeft(matrix, 5));
		System.out.println(sm.searchMatrixStartingBottomLeft(matrix, 21));
		System.out.println(sm.searchMatrixStartingBottomLeft(matrix, 20));

	}

}
