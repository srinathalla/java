package com.sri.algo.dp.leet.hard;

import com.sri.algo.array.PrintArray;

public class KInversePairs {
	
	Integer[][] memo = new Integer[1001][1001];
    public int kInversePairs(int n, int k) {
        if (n == 0)
            return 0;
        if (k == 0)
            return 1;
        if (memo[n][k] != null)
            return memo[n][k];
        int inv = 0;
        for (int i = 0; i <= Math.min(k, n - 1); i++)
            inv = (inv + kInversePairs(n - 1, k - i)) % 1000000007;
        memo[n][k] = inv;
        PrintArray.print2dArray(memo);
        return inv;
    }
    
	  public int kInversePairsDP(int n, int k) {
	        int[][] dp = new int[n + 1][k + 1];
	        for (int i = 1; i <= n; i++) {
	            for (int j = 0; j <= k; j++) {
	                if (j == 0)
	                    dp[i][j] = 1;
	                else {
	                    for (int p = 0; p <= Math.min(j, i - 1); p++)
	                    {
	                        dp[i][j] = (dp[i][j] + dp[i - 1][j - p]) % 1000000007;
	                        PrintArray.print2dArray(dp);             
	                    }
	                       
	                }
	            }
	        }
	        return dp[n][k];
	    }
	  
	  public static void main(String[] args) {
		  
		  KInversePairs kInversePairs = new KInversePairs();
		  System.out.println(
			  kInversePairs.kInversePairs(3, 1));
		
	}

}
