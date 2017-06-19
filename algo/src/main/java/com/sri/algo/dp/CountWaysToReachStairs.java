package com.sri.algo.dp;

public class CountWaysToReachStairs {
	
	
	public int countWays(int n)
	{
		int[] cache = new int[n];

	
		return countWays(n-1,cache) + countWays (n-2,cache) + countWays(n-3,cache);	
	}
	
	public int countWays(int n,int[] cache)
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

}
