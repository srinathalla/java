package com.sri.algo.dp.leet;

public class BuyAndSellStockWithAtmost2Transactions {
	
	 public int maxProfit(int[] prices) {
		 
		int len = prices.length;
		if (2 >= prices.length / 2) {
			return quickSolve(prices);
		}

		int[][] dp = new int[3][len];
		int tmpMax = 0;

		for (int i = 1; i <= 2; i++) {
			tmpMax = -prices[0];
			for (int j = 1; j < len; j++) {
				dp[i][j] = Integer.max(dp[i][j - 1], tmpMax + prices[j]);

				tmpMax = Integer.max(tmpMax, dp[i - 1][j - 1] - prices[j]);
			}
		}

		return dp[2][len - 1];
	        
	    }
	 
	 private int quickSolve(int[] prices)
	 {
		 int maxProfit = 0;
		 for (int i=0;i < prices.length -1; i++)
		 {
			 if (prices[i+ 1] > prices[i])
			 {
				 maxProfit += prices[i+ 1] - prices[i];
			 }
		 }
		 
		 return maxProfit;
	 }

}
