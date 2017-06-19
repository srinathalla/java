package com.sri.algo.array;

public class MagicIndex {
	
	
	/**
	 * Given a sorted array magic index is defined as array[index] = index.
	 * elements are not repeated.
	 * 
	 * @param array
	 * @param low
	 * @param high
	 * @return
	 */
	public static int getMagicIndex(int[] array,int low,int high) 
	{
		
		if (low <= high)
		{		
			int mid = (high + low)/2;
			
			if (array[mid] == mid)
			{
				return mid;
			}
			else if (array[mid] < mid)
			{
				return  getMagicIndex(array, mid + 1,high);
			}
			else
			{
				return  getMagicIndex(array, low,mid -1);
			}
		}
		
		return -1;
	}
	
	/**
	 * Given a sorted array magic index is defined as array[index] = index.
	 * Here elements can be repeated.
	 * 
	 * @param array
	 * @param low
	 * @param high
	 * @return
	 */
	public static int getMagicIndexInArrayWithRepeatedElements(int[] array,int low,int high) 
	{
		
		if (low <= high)
		{		
			int mid = (high + low)/2;		
			if (array[mid] == mid)
			{
				return mid;
			}
			
			// When elements are repeated we need to traverse 
			// both left and right portions of array but some of the elements 
			// can be ignored.
				
			int leftIndex = Math.min(mid-1, array[mid]);	
			int left = getMagicIndexInArrayWithRepeatedElements(array, low,leftIndex);
			
			if (left >= 0)
			{
				return left;
			}
			
			int rightIndex = Math.max(mid+1, array[mid]);
			int right = getMagicIndexInArrayWithRepeatedElements(array, rightIndex,high);
			
			if (right >= 0)
			{
				return right;
			}
			
		}
		
		return -1;
	}
	
	
	public static void main(String[] args) {
		
		// int[] array = new int[] {-1,0,1,3};
		//System.out.println(getMagicIndex(array,0,array.length -1));
		
		int[] array1 = new int[] {-1,0,1,3};
		System.out.println(getMagicIndexInArrayWithRepeatedElements(array1,0,array1.length -1));
		
	}

}
