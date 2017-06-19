package com.sri.algo.array;

import java.util.Scanner;

public class MaxSumContigousSubArray {
	
	
	
	public long applyKadaneAlogrithm(int[] array)
	{
		long max_ending_here = Integer.MIN_VALUE;
		long max_so_far = Integer.MIN_VALUE;;		
		
		for (int index = 0; index < array.length ; index++)
		{	
			 max_ending_here = Long.max(array[index], max_ending_here + array[index]);
			
			 max_so_far = Long.max(max_so_far, max_ending_here);		
		}
		
		return max_so_far;
	}

	public static void main(String[] args) 
	{
		/*
		 * Sample Test Case.
		 *  2
		    3
			1 2 3
			4
		   -1 -2 -3 -4
		 */
		
		MaxSumContigousSubArray  maxSumContigousSubArray = new MaxSumContigousSubArray();
		try (Scanner in = new Scanner(System.in))
		{
			
			int tests = in.nextInt();

			for (int test = 0; test < tests; test++) 
			{
			    int n = in.nextInt();
			    
			    int arr[] = new int[n];
			    for (int i =0 ; i < n; i++)
			    {
			    	arr[i] = in.nextInt();
			    }
				long maxSum = maxSumContigousSubArray.applyKadaneAlogrithm(arr);
				System.out.println(maxSum);
			}
		}
		
	}
}
