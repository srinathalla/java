package com.sri.algo.dp;

import java.util.Scanner;

public class CountWaysToReachNthStairIwthoutOrder {
	
	/**
	 * There are n stairs, a person standing at the bottom wants to reach the top. 
	 * The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, 
	 * the person can reach the top (order does not matter). 
	 * Order does not matter means for n=4 {1 2 1},{2 1 1},{1 1 2} are considered same.
	 * 
	 * i/p 4
	 * o/p 3 => {1,1,1,1},{1,2,1},{2,2}
	 * 
	 * T.C O(n) we loop 2 times.
	 * Auxillary space : O(n)
	 * 
	 * @return
	 */
	public static int countWays(int n)
	{
		int[] table = new int[n+1];
		
		// Base case bottom up approach.
		table[0] = 1;
				
		for (int i = 1;i <=n ;i++)
		{
			table[i] += table[i-1];
		}
		
		for (int i = 2;i <=n ;i++)
		{
			table[i] += table[i-2];
		}
		
		return table[n];
	}
	
	public static void main(String[] args) {
		
		//System.out.println(countWays(4));
		
		try(Scanner in = new Scanner(System.in))
		{
	        int testCount = in.nextInt();
	        
	        for (int i =0 ;i < testCount ; i++)
	        {
	        	int n = in.nextInt();
	        	
	    		System.out.println(countWays(n));
	        }
		}
	}

}
