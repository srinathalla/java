package com.sri.algo.hashing;

import java.util.HashSet;
import java.util.Set;

public class SwapTwoElementsToMakeSumOfTwoArraysSame {
	
	/**
	 *  Time Complexity : O(n + m).
	 *  
	 *  Auxillary space : O(m).
	 *  
	 * @param arr1
	 * @param arr2
	 */
	public static void swapPair(int[] arr1, int[] arr2) {
		
		if (arr1.length == 0 || arr2.length == 0)
		{
			return;
		}
		
		int sum1 = 0,sum2 =0 ;
	    for (int ele : arr1) 
		{
	    	sum1 = sum1 + ele;
		}
		
		Set<Integer> otherSet = new HashSet<>();
		for (int ele : arr2) 
		{
			otherSet.add(ele);	
			sum2 = sum2 + ele;
		}
		
		String pair = "";
		 for (int ele : arr1) 
		 {
	     	 int other = ele -   (sum1 - sum2)/2;
	     	   
	     	 if(otherSet.contains(other))
	     	 {
	     		pair = ele + " " + other;
	     	 }
		 }
		 
		 System.out.println(pair);
	}
	
	public static void main(String[] args) {
		

		swapPair(new int[] {4, 1, 2, 1, 1, 2}, new int[] {3, 6, 3, 3});
		
		swapPair(new int[] {5, 7, 4, 6}, new int[] {1, 2, 3, 8});
			
		
	}

}
