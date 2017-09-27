package com.sri.algo.dp;

import java.util.Scanner;

public class MinSumPartition {
	
	/**
	 * Given an array, the task is to divide it into two sets S1 and 
	 * S2 such that the absolute difference between their sums is minimum.
	 * 
	 * 	
		i/p : {1 6 5 11}
		o/p : 1
		The array can be partitioned as {1, 6, 5} and {11}

		i/p : {36, 7, 46, 40}
		o/p : 23 
		
		 T.C : O(2^n)
		 as each node has two children.
	 * @param arr
	 * @return
	 */
	public static int minSum(int[] arr)
	{
		int sum = 0;
		
		for (int a :arr)
		{
			sum = sum + a;
		}
		
		return minSum(arr,arr.length,0,sum);
	}
	
	public static int minSum(int[] arr,int n,int pathSum, int totalSum)
	{
		// If we have reached last element.  Sum of one
	    // subset is pathSum, sum of other subset is
	    // totalSum-pathSum.  Return absolute difference
	    // of two sums.
		if (n == 0)
		{
			return Math.abs((totalSum - pathSum) - pathSum);
		}
		
		// Current element could be included/excluded as part of first sub set
		return Integer.min( 
			minSum(arr,n-1,pathSum,totalSum), // Exclude current element from first sub set. 
			minSum(arr,n-1,pathSum + arr[n-1],totalSum)); // Include current element in first sub set. 	
	}
	
	// Returns the minimum value of the difference of the two sets.
	public static int findMinWithDP(int arr[])
	{
		 int n = arr.length;
	    // Calculate sum of all elements
	    int sum = 0; 
	    for (int i = 0; i < n; i++)
	    {
	        sum += arr[i];
	    }
	 
	    // i : 0 to n
	    // j : 0 to sum/2. 
	    // table[i][j] indicates sum j is a possible subset sum from the elements
	    // present in array till i th index.
        boolean[][] table = new boolean[arr.length +1][sum/2 + 1];
		
		// Fill first column as true for all rows, 
        // if sum is zero a subset with {} exists.
		for (int i =0 ;i < table.length ; i++)
		{
			table[i][0] = true;
		}
		
		// Fill first row.i.e if no elements there 
		// can only be empty set. other than sum 0 all are false.
		for (int j =1 ;j < table[0].length  ; j++)
		{
			table[0][j] = false;
		}
		
		for (int i =1 ;i < table.length ; i++)
		{
			for (int j =1 ;j < table[0].length ; j++)
			{
				
				if (arr[i-1] <= j)
				{		
					// Include the current element in current subset/exclude it.
					// inclusion can be done only once so when included go back to prev row
					// check for sum j - arr[i-1] is possible.
					table[i][j] = table[i-1][j- arr[i-1]] || table[i-1][j]  ;
				}
				else
				{
					// If curr element is bigger than sum it has to be excluded.
					table[i][j] = table[i-1][j];
				}
			}
		}
	  
	    // Initialize difference of two sums. 
	    int diff = Integer.MAX_VALUE;
	     
	    // Find the largest j such that dp[n][j]
	    // is true where j loops from sum/2 t0 0
	    for (int j=sum/2; j>=0; j--)
	    {
	        // Find the 
	        if (table[n][j] == true)
	        {
	        	// A Subset with sum closer to sum/2 will give min difference
	        	// difference of sub sets is (sum -j) - j => sum -2j is the 
	        	// difference of both subsets
	            diff = sum-2*j;
	            break;
	        }
	    }
	    return diff;
	}
	
	public static void main(String[] args) {
		
		/*System.out.println(minSum(new int[] {1, 6, 5, 11}));
		
		System.out.println(minSum(new int[] {36 ,7 ,46, 40}));	
		
		System.out.println(findMinWithDP(new int[] {1, 6, 5, 11}));
		
		System.out.println(findMinWithDP(new int[] {36 ,7 ,46, 40}));	*/
		
		try(Scanner in = new Scanner(System.in))
		{
	        int testCount = in.nextInt();
	        
	        for (int i =0 ;i < testCount ; i++)
	        {
	        	int n = in.nextInt();
	        	int[] arr = new int[n];
	        	
	        	for (int j = 0 ;j < n ; j++)
	        	{
	        		arr[j] = in.nextInt();
	        	}
	        	
	    		System.out.println(findMinWithDP(arr));
	        }
		}
	}

}
