package com.sri.algo.dp;

public class LongestBitonicSequence {
	
	/**
	 * Longest sequence in array first increasing and later decreasing.
	 * 
	 * @param arr
	 * @return
	 */
	public static int longestBitonicSequence(int[] arr)
	{
		int[] lis = new int[arr.length];
		int[] lds = new int[arr.length];
		
		for (int i = 0; i <arr.length ;i++)
		{
			lis[i] = 1;
			lds[i] = 1;
		}
		
		for (int i = 1 ;i < arr.length ;i++)
		{
			for (int j = 0 ;j < i ;j++)
			{	
				if (arr[i] > arr[j])
				{
					lis[i] = Integer.max(lis[i], lis[j] + 1);
				}
			}			
		}
		
		for (int i = arr.length -2 ;i >=0 ;i--)
		{
			for (int j = arr.length - 1 ;j > i ;j--)
			{	
				if (arr[i] > arr[j])
				{
					lds[i] = Integer.max(lds[i], lds[j] + 1);
				}
			}		
		}
		
		int maxBitonicSeq = Integer.MIN_VALUE;
		for (int i =0 ; i < arr.length ; i++)
		{
			maxBitonicSeq = Integer.max(maxBitonicSeq , (lis[i] +  lds[i] -1));
		}
		
		return maxBitonicSeq;	
	}
	
	public static void main(String[] args) 
	{	
		System.out.println(longestBitonicSequence(new int[]{1, 11, 2, 10, 4, 5, 2, 1}));
	}

}
