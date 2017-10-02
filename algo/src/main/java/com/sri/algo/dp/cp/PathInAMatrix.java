package com.sri.algo.dp.cp;

import java.util.Scanner;

public class PathInAMatrix {
	
		public static int longestPath(int[][] matrix,int m,int n)
		{	
		
			int[][] cache = new int[m][n];
			
			for (int i=0;i < m;i++ )
			{
				for (int j =0;j < n ;j++)
				{
					cache[i][j] = -1;
				}
			}
			
			for (int i=0;i < m;i++ )
			{
				for (int j =0;j < n ;j++)
				{
					if (cache[i][j] == -1)
					{
						longestPath(matrix,i,j,m,n,cache);
					}
				}
			}
			
			int max = Integer.MIN_VALUE;
			for (int i=0;i < m;i++ )
			{
				for (int j =0;j < n ;j++)
				{
					max =  Integer.max(max,cache[i][j]);
				}
			}
			
			return max;
		}
		
		private static boolean isInRange(int i,int j,int m,int n)
		{
			return i >= 0 && i < m && j>=0 && j< n;
		}
		
		public static int longestPath(int[][] matrix,int i,int j,int m,int n,int[][] cache)
		{
			  if (cache[i][j] == -1)
			  {
			
				Integer max = Integer.MIN_VALUE ;
				
				if (isInRange(i +1,j,m,n))
				{
					max = Integer.max(max ,longestPath(matrix,i +1,j,m,n,cache));
				}
				if (isInRange(i +1,j -1,m,n))
				{
					max = Integer.max(max ,longestPath(matrix,i+1,j -1,m,n,cache));
				}
					if (isInRange(i +1,j +1,m,n))
				{
					max = Integer.max(max ,longestPath(matrix,i+1,j+1,m,n,cache));
				}
				
			    cache[i][j] = max != Integer.MIN_VALUE  ? 
			        matrix[i][j] + max  : 
			        matrix[i][j];
				
			  }
				
			  return cache[i][j];	
		}
		
		public static void main(String[] args) {

			try(Scanner in = new Scanner(System.in))
			{
		        int testCount = in.nextInt();
		        
		        for (int k =0 ;k < testCount ; k++)
		        {
		            int n = in.nextInt();
		            int[][] matrix = new int[n][n];
		        	
		        	for (int i =0 ;i < n ; i++)
		            {
		                for (int j =0 ;j < n ; j++)
		                {
		        	            matrix[i][j] = in.nextInt();
		                }
		            }
		        	
		    		System.out.println(longestPath(matrix,n,n));
		        }
			}

		}

}
