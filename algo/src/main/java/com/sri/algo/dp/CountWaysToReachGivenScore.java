package com.sri.algo.dp;

public class CountWaysToReachGivenScore {
	
	/**
	 * This is a variation of coin change problem.
	 * Time Complexity O(m*n)
	 * 
	 * i/p : 20
	 * o/p : 4
	 *         {3,3,3,3,3,5} ,{5,5,5,5},{10,10},{5,5,10}
	 * @param scores
	 * @param N
	 * @return
	 */
	public static int countWaysToReachGivenScore(int[] scores,int N)
	{
		return CoinChange.coinChangeWithDP(scores, scores.length, N);
	}
	
	public static int  countWaysWithDP(int n)
	{
	    // table[i] will store count of solutions for
	    // value i.
	    int[] table = new int[n+1];
	 
	    // Base case (If given value is 0)
	    table[0] = 1;
	    
	    for (int i =3; i<=n ; i++)
	    {
	    	 table[i] += table[i-3];
	    }
	    
	    for (int i =5; i<=n ; i++)
	    {
	    	 table[i] += table[i-5];
	    }
	    
	    for (int i =10; i<=n ;i++)
	    {
	    	 table[i] += table[i-10];
	    }
	 
	    return table[n];
	}
	
	/**
	 * Top down approach to count all possible ways to reach a score while 
	 * preserving order of scores.
	 * 
	 *  n : 20
	 *  o/p : 11
	 *          {10,10},
	 *          {5,5,5,5},
	 *          {10,5,5},
	 *          {5,10,5},
	 *          {5,5,10}, 
	 *          {3,3,3,3,3,5},
	 *          {5,3,3,3,3,3},
	 *          {3,5,3,3,3,3},
	 *          {3,3,5,3,3,3},
	 *          {3,3,3,5,3,3},
	 *          {3,3,3,3,5,3}
	 * 
	 * @param n
	 * @param cache
	 * @return
	 */
	public static int  countWaysWithOrder(int n,int[] cache)
	{
          if (n == 0)
          {
        	  return 1;
          }
          
          if (n < 0)
          {
        	  return 0;
          }
	 
          if (cache[n] == 0)
          {
        	  cache[n] =  countWaysWithOrder(n-5, cache) + 
        			      countWaysWithOrder(n-3, cache) + 
        			      countWaysWithOrder(n-10, cache);
          }
          
          return cache[n];      
	}
	
	
	
	public static void main(String[] args) 
	{
		
	/*	System.out.println(countWaysWithOrder(20,new int[21]));
		
		System.out.println(countWaysWithDP(20));*/
		
		System.out.println(countWaysWithOrder(13, new int[14]));
		
		System.out.println(countWaysWithDP(13));
	}

}
