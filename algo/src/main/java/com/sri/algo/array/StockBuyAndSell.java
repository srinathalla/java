package com.sri.algo.array;

import java.util.ArrayList;
import java.util.List;

public class StockBuyAndSell {
	
	static class Interval
	{
		int buy;
		int sell;
	}
	
	public void buyAndSell(int prices[])
	{
		List<Interval> intervals = new ArrayList<>();
		
		int i = 0;
		while (i < prices.length -1)
		{
			while ( i < prices.length - 1 && prices[i] >= prices[i + 1])
			{
				i++;
			}
			
			if (i == prices.length - 1)
			{
				return;
			}
			
			Interval interval = new Interval();
			interval.buy = i++;
			
			while ( i < prices.length && prices[i] >= prices[i-1])
			{
				i ++;
			}
			
			interval.sell = i -1;
			
			intervals.add(interval);
		}
		
		
		if (intervals.size() == 0)
		{
			System.out.println("No Profit.");
		}
		
		else
		{
			for (Interval interval : intervals)
			{
				System.out.println("Buy on :" + interval.buy  + " Sell on :" + interval.sell);
			}
		}
		
	}
	
	/**
	 * Time Complexity O(n).
	 * 
	 * @param prices
	 * @return
	 */
	public  int maxProfit(int [] prices)
	{
		if(prices.length <= 1)
		{
			return 0;
		}
		
	   int maxProfit2 = 0;
	   int maxProfit1 = 0;
	   int lowestBuyPrice2 = Integer.MAX_VALUE;
	   int lowestBuyPrice1 = Integer.MAX_VALUE;
	   
	   for (int p: prices)
	   {
		   maxProfit2 = Integer.max(maxProfit2, p - lowestBuyPrice2);
		   lowestBuyPrice2 = Integer.min(lowestBuyPrice2, p - maxProfit1);
		   maxProfit1 = Integer.max(maxProfit1, p - lowestBuyPrice1);
		   lowestBuyPrice1 = Integer.min(lowestBuyPrice1, p);
	   }
	   
	   return maxProfit2;
	   
	}
	
	public static void main(String[] args) {
		
		StockBuyAndSell stock = new StockBuyAndSell();
        
        // stock prices on consecutive days
        int price[] = {100, 180, 260, 310, 40, 535, 695};
  
 
        // fucntion call
        // stock.buyAndSell(price);
        
        System.out.println(stock.maxProfit(price));
        
        // stock prices on consecutive days
        int price1[] = {100, 180, 260, 310, 40, 535, 695,30,800};   
        System.out.println(stock.maxProfit(price1));
        
        
        // stock prices on consecutive days
        int price2[] = {400,300,200,100};  
        System.out.println(stock.maxProfit(price2));
        
        // stock prices on consecutive days
        int price3[] = {400,300,100,400};  
        System.out.println(stock.maxProfit(price3));
        
        
        
	}

}
