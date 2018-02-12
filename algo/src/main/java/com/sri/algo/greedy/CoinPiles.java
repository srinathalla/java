package com.sri.algo.greedy;

import java.util.Scanner;

/**
 * 
 * 
There are N piles of coins each containing  Ai (1<=i<=N) coins. 
Now, you have to adjust the number of coins in each pile such that for any two pile, if a be the number
 of coins in first pile and b is the number of coins in second pile then |a-b|<=K.
In order to do that you can remove coins from different piles to decrease the number of coins in 
those piles but you cannot increase the number of coins in a pile by adding more coins. Now, 
given a value of N and K, along with the sizes of the N different piles you have to tell the minimum
number of coins to be removed in order to satisfy the given condition.

Note: You can also remove a pile by removing all the coins of that pile.
 * @author salla
 *
 */
public class CoinPiles {
	
	public static int minCoins(int[] coins,int k)
	{
		int minVal = Integer.MAX_VALUE;
		int minCoins = 0;
		for (int no : coins)
		{
			
			minVal = Integer.min(minVal, no); 
		}
		
		for (int no : coins)
		{
			if (no > minVal + k)
			{
				minCoins = minCoins + no - (minVal + k);
			}
		}
		
		return minCoins;
		
	}
	
	public static void main(String[] args) 
	{
		
	/*	System.out.println(minCoins(new int[] {2 ,2 ,2 ,2},0));
		System.out.println(minCoins(new int[] {1, 2 ,5,1 ,1 ,1},3));
		System.out.println(minCoins(new int[] {1, 5 ,1,2,5,1},3));*/
		
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
	        	
	        	System.out.print(minCoins(arr,k));
	        	 System.out.println();
	        }
	       
		}
		
	/*	42 468
		335 501 170 725 479 359 963 465 706 146 282 828 962 492 996 943 828 437 392 605 903 154 293 383 422 717 719 896 448 727 772 539 870 913 668 300 36 895 704 812 323 334 

		Its Correct output is:
		2337

		And Your Code's Output is:
		6603
*/
	}

}
