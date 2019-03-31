package com.sri.algo.array.leet.medium;

/**
 * You are given coins of different denominations and a total amount of money. 
 * Write a function to compute the number of combinations that make up that amount. 
 * You may assume that you have infinite number of each kind of coin.
 * 
 * Input: amount = 5, coins = [1, 2, 5]
	Output: 4
	Explanation: there are four ways to make up the amount:
	5=5
	5=2+2+1
	5=2+1+1+1
	5=1+1+1+1+1
 * @author salla
 *
 */
public class CoinChange {
	
	
	     public int change(int amount, int[] coins) 
	     {
	    	 int n = coins.length;    
		 	 
	    	 int[][] dp = new int[n + 1][amount + 1];   	 
	    	 dp[0][0] = 1;
	    	 
	    	 for (int i=1; i<= coins.length; i++)
	    	 {
	    		 dp[i][0] = 1; 
	    		 for (int j=1; j <= amount; j++)
		    	 {
	    			 dp[i][j] = dp[i-1][j] + // exluding the current coin
	    					 (j >= coins[i-1] ? dp[i][j- coins[i-1]] : 0); 
	    			 // including the current coint.
		    	 }
	    	 }
		 
		 
	        return dp[n][amount];
	    }
	     
	     public static void main(String[] args) {
	    	 
	    	 
	    	 CoinChange cc = new CoinChange();
	    	 
	    	 System.out.println(
    			 cc.change(5, new int[] {1, 2, 5}));
			
		}

}
