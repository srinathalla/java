package com.sri.algo.array;

public class BinarySearch {
	
	public static int binarySearch(int[] arr,int x,int l, int h)
	{
		if (l <= h)
		{
			int mid = l + (h-l)/2;
			
			if (arr[mid] == x)
			{
				return mid;
			}
			
			else if  (x > arr[mid])
			{
				return binarySearch(arr,x, mid + 1, h);
			}
			else
			{
				return binarySearch(arr,x, l, mid -1);
			}		
		}
		
		return -1;	
	}

}
