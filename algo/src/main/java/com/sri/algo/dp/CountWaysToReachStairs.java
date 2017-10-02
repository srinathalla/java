package com.sri.algo.dp;

import java.util.Scanner;

public class CountWaysToReachStairs {
	
	
	public static int countWays(int n)
	{
		int[] cache = new int[n];

	
		return countWays(n-1,cache) + countWays (n-2,cache) + countWays(n-3,cache);	
	}
	
	public static int countWays(int n,int[] cache)
	{
		if (n < 0)
		{
			return 0;
		}
		else if (n == 0)
		{
			return 1;
		}
		else if (cache[n] == 0)
		{
			cache[n] = countWays(n-1,cache) + countWays (n-2,cache) + countWays(n-3,cache);	
			
		}
		
		return cache[n];
	}
	
	public static void main(String[] args) {
		
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
