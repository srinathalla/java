package com.sri.algo.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * You are given N pairs of numbers. In every pair, the first number is always 
 * smaller than the second number. A pair (c, d) can follow another pair (a, b) if b < c. 
 * Chain of pairs can be formed in this fashion. Your task is to complete the function maxChainLen
 * which returns an integer denoting the longest chain which can be formed from a given set of pairs. 
 * 
 * This problem is similar to activity selection problem.
 * 
 * Input
	2
	5
	5  24 39 60 15 28 27 40 50 90
	2
	5 10 1 11 

	Output
	3
	1
 *
 */
public class MaxLenChain {
	
	static class Chain
	{
		int start;
		int end;
		
		Chain(int start , int end)
		{
			this.start = start;
			this.end = end;
		}
	}
	
	/**
	 * Time Complexity : O(nlogn)
	 * Auxillary space : O(n).
	 * 
	 * Sorting activities takes O(nlogn),
	 * Activity array takes O(n) space for n activity objects.
	 * 
	 
	 * @param start
	 * @param end
	 * @return
	 */
	public static int maxLen(Chain[] chains)
	{
		 
		 
		 // Sort activities by their end times in ascending order.
		 // i.e smallest end time as the first and biggest end time
		 // as the last.
		 Arrays.sort(chains, new Comparator<Chain>() {

			@Override
			public int compare(Chain o1, Chain o2) {
				
				return o1.end -o2.end;
			}
		});
		 
		 Chain prevChain = chains[0];
		 int count  = 1;
		 
		 for (int  index = 1; index < chains.length ;index++)
		 {
			 
			 if (chains[index].start > prevChain.end)
			 {
				 count++;
				 prevChain = chains[index];
			 }
		 }
			 
		 return count;	
	}
	
	public static void main(String[] args) {
		
		/*System.out.println(countMaxActivities(new int[] {1, 3, 0, 5, 8, 5},
				new int[] {2 ,4 ,6,7,9, 9}));*/
		
		try(Scanner in = new Scanner(System.in))
		{
	        int testCount = in.nextInt();
	        
	        for (int i =0 ;i < testCount ; i++)
	        {
	        	int n = in.nextInt();
	        	
	        	Chain[] chains = new Chain[n];
	        	
	        	for (int j = 0 ;j < n ; j++)
	        	{
	        		int start = in.nextInt();
	        		int end = in.nextInt();
	        		
	        		Chain c = new Chain(start, end);
	        		chains[j] = c;
	        	}  	
	        	
	    		System.out.println(maxLen(chains));
	        }
		}
		
	}

}
