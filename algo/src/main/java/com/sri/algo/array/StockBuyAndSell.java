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
	
	public static void main(String[] args) {
		
		StockBuyAndSell stock = new StockBuyAndSell();
        
        // stock prices on consecutive days
        int price[] = {100, 180, 260, 310, 40, 535, 695};
  
 
        // fucntion call
        stock.buyAndSell(price);
	}

}
