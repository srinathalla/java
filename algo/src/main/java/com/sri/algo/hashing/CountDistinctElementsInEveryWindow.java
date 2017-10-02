package com.sri.algo.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Given an array A[] of size n and an integer k, your task is to 
 * complete the function countDistinct which prints the count of 
 * distinct numbers in all windows of size k in the array A[].
 * 
 * Input:  A[] = {1, 2, 1, 3, 4, 2, 3};
            k = 4
   Output:  3 4 4 3
 * 
 *
 */
public class CountDistinctElementsInEveryWindow {
	
	public static void countDistinctElements(int[] arr,int k)
	{
		
		Map<Integer,Integer> eleMap = new HashMap<>();
		
		int j =0;
		for (int i = 0;i<arr.length ;i++)
		{	
			if(!eleMap.containsKey(arr[i]))
			{
				eleMap.put(arr[i], 0);
			}
			
			eleMap.put(arr[i], eleMap.get(arr[i]) + 1);
			j++;
			if(j == k)
			{
				System.out.print(eleMap.size() + " ");		
				int currWindStrtEleCount = eleMap.get(arr[i - k +1]);	
				if (currWindStrtEleCount == 1)
				{
					eleMap.remove(arr[i - k +1]);
				}
				else
				{
					eleMap.put(arr[i - k +1],currWindStrtEleCount -1);
				}	
				j--;
			}	
		}
		
	}
	public static void main(String[] args) {
		
		// countDistinctElements(new int[] {1, 2, 1, 3, 4, 2, 3},4);
		

		try(Scanner in = new Scanner(System.in))
		{
	        int testCount = in.nextInt();
	        
	        for (int i =0 ;i < testCount ; i++)
	        {
	        	int n1 = in.nextInt();
	        	int k = in.nextInt();
	        	int[] arr1 = new int[n1];
	        	
	        	for (int j =0 ;j < n1 ; j++)
	 	        {
	        		arr1[j] = in.nextInt();
	 	        }
	        	
	        	
	        	
	    		countDistinctElements(arr1,k);
	        }
		}
		
	}

}
