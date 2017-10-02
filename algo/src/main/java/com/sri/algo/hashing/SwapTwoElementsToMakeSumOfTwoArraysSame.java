package com.sri.algo.hashing;

import java.util.HashSet;
import java.util.Scanner;
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
	public static int swapPair(int[] arr1, int[] arr2) {
		
		if (arr1.length == 0 || arr2.length == 0)
		{
			return -1;
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
	     		return 1;
	     	 }
		 }
		 
		 System.out.println(pair);
		 return -1;
	}
	
	public static void main(String[] args) {
		

		swapPair(new int[] {4, 1, 2, 1, 1, 2}, new int[] {3, 6, 3, 3});
		
		swapPair(new int[] {5, 7, 4, 6}, new int[] {1, 2, 3, 8});
		

		try(Scanner in = new Scanner(System.in))
		{
	        int testCount = in.nextInt();
	        
	        for (int i =0 ;i < testCount ; i++)
	        {
	        	int n1 = in.nextInt();
	        	int n2 = in.nextInt();
	        	int[] arr1 = new int[n1];
	        	
	        	for (int j =0 ;j < n1 ; j++)
	 	        {
	        		arr1[j] = in.nextInt();
	 	        }
	        	
	        	int[] arr2 = new int[n2];
	        	
	        	for (int j =0 ;j < n2 ; j++)
	 	        {
	        		arr2[j] = in.nextInt();
	 	        }
	        	
	        	
	    		System.out.println(swapPair(arr1,arr2));
	        }
		}
	}

}
