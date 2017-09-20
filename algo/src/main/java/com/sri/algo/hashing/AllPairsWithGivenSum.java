package com.sri.algo.hashing;

import java.util.HashSet;
import java.util.Set;

public class AllPairsWithGivenSum {
	
	/**
	 *  Time Complexity : O(n + m).
	 *  
	 *  Auxillary space : O(m).
	 *  
	 * @param arr1
	 * @param arr2
	 */
	public static void allPairs(int[] arr1, int[] arr2, int sum) {
		
		if (arr1.length == 0 || arr2.length == 0)
		{
			return;
		}
		
		Set<Integer> otherSet = new HashSet<>();
		for (int ele : arr2) 
		{
			otherSet.add(ele);	
		}
		
		System.out.println();
		 for (int ele : arr1) 
		 {
	     	 int other = sum - ele;
	     	   
	     	 if(otherSet.contains(other))
	     	 {
	     		System.out.print(ele + " " + other + ",");
	     	 }
		 }
		 
	}
	
	public static void main(String[] args) {
		

		allPairs(new int[] {4, 1, 2, 1, 1, 2}, new int[] {3, 6, 3, 3},7);
		
		allPairs(new int[] {5, 7, 4, 6}, new int[] {1, 2, 3, 8},6);
			
		
	}

}
