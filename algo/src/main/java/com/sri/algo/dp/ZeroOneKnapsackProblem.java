package com.sri.algo.dp;

public class ZeroOneKnapsackProblem {
	
	
	public static int knapsack(int val[], int w[],int wt,int n)
	{
		
		if (wt == 0 || n == 0)
		{
			return 0;
		}
		
		// If item's weight is greater than knapsack's capacity 
		// item is excluded.
		if (w[n-1] > wt)
		{
			return knapsack(val, w, wt, n-1);
		}
		
		// Item can either be included or excluded.
		return Integer.max(
			val[n-1] + knapsack(val,w, wt - w[n-1],n-1),
			knapsack(val,w, wt,n-1));
	}
	
	public static int knapsackWithDP(int val[], int wt[],int W,int n)
	{
		
		// Matrix of size n+1, W+1.
		int[][] matrix = new int[n+1][W+1];
		
		
		// For each item fill all combinations of knapsack capacity allowed.
		// At each step We are solving i,w.
		for (int i =0 ;i <= n ;i ++)
		{		
			// 
			for (int w = 0; w <= W ;w ++)
			{
				
				 if (i ==0 || w == 0)
				 {
					 // If items or knapsack capacity is 0 value is 0.
					 matrix[i][w] = 0;
				 }
				 
				 
				 else if (wt[i -1] <= w)
				 {
					 // If current item's weight is less than current weight than two choices are possible
					 //  include/exclude the item to get max value.
					 matrix[i][w] = 
						 Integer.max(
							 val[i-1] + matrix[i-1][w- wt[i -1]],
							 matrix[i-1][w]);
			     }
				 else
				 {
					 // If items weight is greater than current weight, this item is excluded  
					 // i.e max value till here is the value obtained from rest of the items.
					 matrix[i][w] = matrix[i-1][w];
				 }
			}
		}
		
		
		return matrix[n][W];
	}
	
	public static void main(String[] args) {
		
		int val[] = {60, 100, 120};
	    int wt[] = {1, 2, 3};
	    int  W = 5;
	    System.out.println(knapsackWithDP(val, wt, W, val.length));
		
	}

}
