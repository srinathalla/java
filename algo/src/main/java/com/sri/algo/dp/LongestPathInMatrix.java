package com.sri.algo.dp;

/**
 * 
 * Given a n*n matrix where all numbers are distinct, 
 * find the maximum length path (starting from any cell) such that all cells along the 
 * path are in increasing order with a difference of 1.We can move in 4 directions from 
 * a given cell (i, j), i.e., we can move to (i+1, j) or (i, j+1) or (i-1, j) or (i, j-1) 
 * with the condition that the adjacent cells have a difference of 1.
 * 
 * Input:  mat[][] = {{1, 2, 9}
                   {5, 3, 8}
                   {4, 6, 7}}
   Output: 4
   The longest path is 6-7-8-9. 
   
   T.C : O(m*n)
   
   Auxillary Space : O(m*n)
 *
 */
public class LongestPathInMatrix {
	
	
	public static int longestPath(int[][] matrix,int m,int n)
	{		
		int[][] cache = new int[m][n];
		
		for (int i=0;i < m;i++ )
		{
			for (int j =0;j < n ;j++)
			{
				cache[i][j] = 1;
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int i=0;i < m;i++ )
		{
			for (int j =0;j < n ;j++)
			{
				if (cache[i][j] == -1)
				{
					longestPath(matrix,i,j,m,n,cache);	
				}
				
				max =  Integer.max(max,cache[i][j]);
			}
		}
		
		return max;
	}
	
	
	public static int longestPath(int[][] matrix,int i,int j,int m,int n,int[][] cache)
	{
		  if (cache[i][j] == -1)
		  {
			 cache[i][j] = 1;
			 
			 // Since all are distinct numbers two cells shall not have same number.
			if (j < n-1 && matrix[i][j +1] == 1 + matrix[i][j])
			{
				cache[i][j] =  1+ longestPath(matrix,i,j+1,m,n,cache);
			}
			else if (j > 0 && matrix[i][j - 1] == 1 + matrix[i][j])
			{
				cache[i][j] =  1 + longestPath(matrix,i,j-1,m,n,cache);
			}
			else if (i < m -1 && matrix[i +1][j] == 1 + matrix[i][j])
			{
				cache[i][j] =  1 + longestPath(matrix,i +1,j,m,n,cache);
			}
			else if (i > 0 && matrix[i -1][j] == 1 + matrix[i][j])
			{
				cache[i][j] = 1 + longestPath(matrix,i-1,j,m,n,cache);
			}
			
		  }
			
		  return cache[i][j];	
	}
	
	public static void main(String[] args) {
		
		System.out.println(longestPath( new int[][]{
											{1, 2, 9},
									        {5, 3, 8},
									        {4, 6, 7}} ,3,3));
		
	}

}
