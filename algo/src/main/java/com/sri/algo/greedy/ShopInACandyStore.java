package com.sri.algo.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * In a candy store there are N different types of candies available  
 * and the prices of all the N different types of candies are provided to you.You are now provided with 
 * an attractive offer.You can buy a single candy from the store and get atmost K other candies
 * ( all are different types ) for free. Now you have to answer two questions. Firstly,
 * you have to tell what is the minimum amount of money you have to spend to buy all the N different candies.
 * Secondly, you have to tell what is the maximum amount of money you have to spend to buy all the N 
 * different candies.In both the cases you must utilize the offer i.e. you buy one candy and 
 * get K other candies for free.
 * 
 * 
 *  Input    
	 1
	 4  2
	 3 2 1 4

	Output 
	 3 7
	 
	 T.C : O(nlogn).
 *
 */
public class ShopInACandyStore {

	public static void shopItems(int[] prices, int k) {

		int min = 0, max = 0, l;

		// Sort prices
		Arrays.sort(prices);

		int i = 0, j = prices.length - 1;

		while (i <= j) {
			
			// Min Prices are available at the start of the array to 
            // pay minimum price to the vendor we need to pick items from start of the array.
			min = min + prices[i]; 
			i++;

			l = k;
			while (l > 0 && i <= j) { 
				// For every item bought k items are given as free. pick k items with maximum 
				// prices as free in order to pay minimum amount to the vendor.
				j--;
				l--;
			}
		}

		i = 0; j = prices.length - 1;
		while (i <= j) {
			// Max Prices are available at the end of the array to 
            // pay max price to vendor we need to pick items from end of the array.
			max = max + prices[j];
			j--;

			l = k;
			while (l > 0 && i <= j) {
				// For every item bought k items are given as free pick k items with minimum 
				// prices as free in order to pay max amount to the vendor.
				i++;  
				l--;
			}
		}
		
		System.out.println(min + " " + max);

	}
	
	public static void main(String[] args) {
		
		// shopItems(new int[] {3 ,2 ,1 ,4} , 2);
		
		try(Scanner in = new Scanner(System.in))
		{
	        int testCount = in.nextInt();
	        
	        for (int i =0 ;i < testCount ; i++)
	        {
	        	int n = in.nextInt();
	        	int k = in.nextInt();
	        	
	        	int[] arr = new int[n];	
	        	for (int j = 0 ;j < n ; j++)
	        	{
	        		arr[j] = in.nextInt();
	        	}
	        	     	
	        	shopItems(arr,k);
	        }
		}	
		
	}

}
