package com.sri.algo.array;

import java.util.Arrays;

public class NthSmallestElement {
	
	
	/**
	 * T.C : O(nlogn).
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public static int getNThSmallestBySort(int[] array,int k)
	{		
		Arrays.sort(array);	
		
		return array[k -1];		
	}
	
	public static int getNThSmallest(int[] array,int n)
	{	
		return partitionArray(array,0,array.length -1,n);		
	}
	
	private static int partitionArray(int array[],int low ,int high,int n)
	{
		int pivotElement = array[high];
		
		int pivotIndex = low - 1;
		if (low <= high)
		{
			for (int i = low ; i< high ; i++) 
			{		
				if (array[i] <= pivotElement)
				{
					pivotIndex++;
					
					int temp = array[i];
					array[i] = array[pivotIndex];
					array[pivotIndex] = temp;
					
				}	
			}
		}
		
		pivotIndex++;
		
		int temp = array[pivotIndex];
		array[pivotIndex] = pivotElement;
		array[high] = temp;
		
		if (pivotIndex == n -1)
		{
			return array[pivotIndex];
		}
		else if(pivotIndex > n -1)
		{
			return partitionArray(array, low, pivotIndex -1,n);
		}
		else
		{
			return partitionArray(array, pivotIndex + 1, high,n);
		}
	}
	
	
	public static void main(String[] args) {		
		
		System.out.println(getNThSmallest(new int[] {40,30,20,10,5},5));
		
		System.out.println(getNThSmallestBySort(new int[] {40,30,20,10,5},5));
	}

}
