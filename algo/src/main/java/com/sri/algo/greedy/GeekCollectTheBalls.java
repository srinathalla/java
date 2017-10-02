package com.sri.algo.greedy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;


public class GeekCollectTheBalls {
	
	
	public static void collectMaxBalls(int[] b1, int[] b2) 
	{
		Set<Integer> bucketSizesSet = new HashSet<>();
		for (int size : b2)
		{
			bucketSizesSet.add(size);
		}
		
		Queue<Integer> commonBucketCounts = new LinkedList<>();
		for (int size : b1)
		{
			if (bucketSizesSet.contains(size))
			{
				commonBucketCounts.add(size);
			}
		}	
		
		int i = 0,j=0;
		long maxSum = 0,sum1,sum2;
		
		while ( i< b1.length || j < b2.length)
		{
			int matchedBucketCount = commonBucketCounts.isEmpty() ?	
				Integer.MAX_VALUE : 
				commonBucketCounts.poll();
			
			sum1 = 0;
			while(i < b1.length && b1[i] != matchedBucketCount)
			{
				sum1 = sum1 + b1[i];
				i++;
			}
			
			sum2 = 0;
			while(j < b2.length && b2[j] != matchedBucketCount)
			{
				sum2 = sum2 + b2[j];
				j++;
			}
			
			maxSum = maxSum + Long.max(sum1, sum2);
		}
		
		System.out.println(maxSum);
	}
	
	public static void main(String[] args) {
		
		/*collectMaxBalls(new int[] {1 ,4 ,5 ,6 ,8},new int[] {
				2 ,3, 4, 6, 9});*/
		
		try(Scanner in = new Scanner(System.in))
		{
	        int testCount = in.nextInt();
	        
	        for (int i =0 ;i < testCount ; i++)
	        {
	        	int n = in.nextInt();
	        	int m = in.nextInt();
	        	int[] arr = new int[n];
	        	
	        	for (int j = 0 ;j < n ; j++)
	        	{
	        		arr[j] = in.nextInt();
	        	}
	        	
	        	int[] arr1 = new int[m];
	        	
	        	for (int j = 0 ;j < m ; j++)
	        	{
	        		arr1[j] = in.nextInt();
	        	}
	        	
	    		collectMaxBalls(arr,arr1);
	        }
		}
		
	}

}
