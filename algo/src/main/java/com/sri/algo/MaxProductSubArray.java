package com.sri.algo;

public class MaxProductSubArray {
	
	
	public static int maxProduct(int[] arr)
	{
		if (arr.length == 1)
		{
			return arr[0];
		}
		
		int max_global = Integer.MIN_VALUE;
		int max_till_here = arr[0];
		// int min_till_here = 
		
		
		for (int i =1; i < arr.length; i++)
		{
			max_till_here = Integer.max(max_till_here * arr[i], arr[i]);
			
			max_global = Integer.max(max_global, max_till_here);
		}
		
		return max_global;
		
	}
	
	public static void main(String[] args)
	{
		
		System.out.println(maxProduct(new int[] {6, -3, -10, 0, 2}));
		
		System.out.println(maxProduct(new int[] {-1, -3, -10, 0, 60}));
		
		System.out.println(maxProduct(new int[] {-2, -3, 0, -2, -40}));
	}

}
