package com.sri.algo.array.rotate;

import com.sri.algo.array.BinarySearch;

public class SearchElementInSortedRotatedArray 
{
	
	private static int searchElement(int[] arr,int x)
	{
		// pivot is the index of minimum element in sorted rotated array.
		int pivot = RotationCountInSortedRotatedArray.getRotationCount(arr, 0, arr.length -1);
		
		
		if (arr[pivot] == x)
		{
			return pivot;
		}
		
		// if given element lies in range of pivot to the maximum element
		else if (x <= arr[arr.length -1])
		{
			return BinarySearch.binarySearch(arr, x, pivot + 1, arr.length -1);
		}
		else
		{
			return BinarySearch.binarySearch(arr, x, 0, pivot -1);
		}
		
	}
	
	public static void main(String[] args) {
		
		
		System.out.println(searchElement(new int[] {4,5,1,2,3},1 ));
		
		System.out.println(searchElement(new int[] {4,5,1,2,3},2 ));

	    System.out.println(searchElement(new int[] {4,5,1,2,3},3 ));
	    
	    System.out.println(searchElement(new int[] {2,3,4,5,1},1 ));
	    System.out.println(searchElement(new int[] {4,5,1,2,3},5 ));

	}

}
