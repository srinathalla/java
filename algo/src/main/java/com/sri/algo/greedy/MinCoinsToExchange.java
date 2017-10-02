package com.sri.algo.greedy;

import java.util.Scanner;

public class MinCoinsToExchange {

	public static int minCoins(int val) {
		int[] denom = new int[] { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
		String str = "";
		int count = 0;

		int i = denom.length - 1;
		while (denom[i] > val) {
			i--;
		}

		while (val > 0) {
			if (val >= denom[i]) {
				val = val - denom[i];
				
				count++;
				
				str = str.isEmpty() ? String.valueOf(denom[i])
						: str + " " + String.valueOf(denom[i]);
			} else {
				i--;
			}
		}
		System.out.println(str);

		return count;
	}

	public static void main(String[] args) {

		// System.out.println(minCoins(93));
		
		try(Scanner in = new Scanner(System.in))
		{
	        int testCount = in.nextInt();
	        
	        for (int i =0 ;i < testCount ; i++)
	        {
	        	int n = in.nextInt();
	        	
	       
	        	minCoins(n);
	        }
		}

	}

}
