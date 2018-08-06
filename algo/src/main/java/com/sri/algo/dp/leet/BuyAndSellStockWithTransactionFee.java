package com.sri.algo.dp.leet;

/**
 * Your are given an array of integers prices, for which the i-th element is the
 * price of a given stock on day i; and a non-negative integer fee representing
 * a transaction fee.
 * 
 * You may complete as many transactions as you like, but you need to pay the
 * transaction fee for each transaction. You may not buy more than 1 share of a
 * stock at a time (ie. you must sell the stock share before you buy again.)
 * 
 * Return the maximum profit you can make.
 * 
 * Example 1: Input: prices = [1, 3, 2, 8, 4, 9], fee = 2 Output: 8 Explanation:
 * The maximum profit can be achieved by: Buying at prices[0] = 1 Selling at
 * prices[3] = 8 Buying at prices[4] = 4 Selling at prices[5] = 9 The total
 * profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 
 * @author salla
 *
 */
public class BuyAndSellStockWithTransactionFee {

	
	/**
	 * Time Complexity: O(N), where N is the number of prices.

       Space Complexity: O(1), the space used by cash and hold.
	 * @param prices
	 * @param fee
	 * @return
	 */
	public int maxProfit(int[] prices, int fee) {

		int n = prices.length;

		if (n <= 1) {
			return 0;
		}
		
	
		int cash = 0, hold = -prices[0];
		
		for (int i=1; i< n; i++)
		{
			System.out.println("cash :" + cash);
			System.out.println("hold :" + hold);
			cash = Integer.max(cash, hold + prices[i] - fee);
			hold = Integer.max(hold, cash - prices[i]);
		}

		return cash;
	}
	
	public static void main(String[] args) {
		
		BuyAndSellStockWithTransactionFee buySell = new BuyAndSellStockWithTransactionFee();
		
		System.out.println(buySell.maxProfit(new int[] {1, 3, 2, 8, 4, 9}, 2));
		
	}

}
