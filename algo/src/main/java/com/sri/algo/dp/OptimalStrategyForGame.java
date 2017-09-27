package com.sri.algo.dp;

public class OptimalStrategyForGame {
	
	public static int optimalStrategyOfGame(int[] arr,int i,int j)
	{
		
		if (i == j)
		{
			return arr[i];
		}
		
		if (i+1 == j)
		{
			return Integer.max(arr[i],arr[j]);
		}
		
		return  Integer.max(
				arr[i] + Integer.min(
								optimalStrategyOfGame(arr,i+2, j), 
								optimalStrategyOfGame(arr,i+1, j-1)), 
				arr[j]  + Integer.min(
								optimalStrategyOfGame(arr, i+1, j-1),
								optimalStrategyOfGame(arr, i, j-2))) ;
	}
	
	public static int optimalStrategyWithDP(int[] arr, int n)
	{
	    // Create a table to subproblems solutions.	
		int[][] table = new int[n][n];
		int i,j,gap;
		
		// The below two with gap 0,1 were base cases for the recursive solution. 
		// All diagonal elements with gap 0.
		for (i=0; i<n; i++)
		{
			table[i][i] = arr[i];
		}
		
		// All diagonal elements with gap 1.
		for (i=0;i< n-1;i++)
		{
			table[i][i+1] = Integer.max(arr[i],arr[i+1]);
		}
		
		// Fill the table based on the formula.
		for (gap = 2; gap < n; gap++)
		{		
			for (i=0,j =gap; j < n;i++,j++)
			{
				int x = i + 2 <= j ? table[i+2][j] : 0;
				int y = i +1 <= j-1 ? table[i+1][j-1] : 0;
				int z = i <= j-2 ? table[i][j-2] : 0;
				
				table[i][j] =  Integer.max(
					arr[i] + Integer.min(x,y), 
					arr[j]  + Integer.min(y,z)) ;
			}
		}
	  
	    return table[0][n-1];
	}
	
	public static void main(String[] args) {
		
		
		System.out.println(optimalStrategyOfGame(new int[] {8, 15, 3, 7}, 0,3));
		
		System.out.println(optimalStrategyOfGame(new int[] {2, 2, 2, 2}, 0,3));
		
		System.out.println(optimalStrategyOfGame(new int[] {20, 30, 2, 2, 2, 10}, 0,5));
		
		System.out.println(optimalStrategyWithDP(new int[] {8, 15, 3, 7}, 4));
		

		System.out.println(optimalStrategyWithDP(new int[] {2, 2, 2, 2}, 4));
		
		System.out.println(optimalStrategyWithDP(new int[] {20, 30, 2, 2, 2, 10},6));
	}

}
