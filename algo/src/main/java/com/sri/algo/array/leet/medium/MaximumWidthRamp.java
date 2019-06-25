package com.sri.algo.array.leet.medium;

import java.util.Arrays;

/**
 * Given an array A of integers, a ramp is a tuple (i, j) for which i < j and A[i] <= A[j].  
 * The width of such a ramp is j - i.

   Find the maximum width of a ramp in A.  If one doesn't exist, return 0.
 * @author salla
 *
 */
public class MaximumWidthRamp {
	
	/**
	 * T.C : O(nlogn)
	 * @param A
	 * @return
	 */
	public int maxWidthRamp(int[] A) {

		   int n = A.length;
		   
		   Integer[] B = new Integer[n];
		   for (int i=0; i <n; i++)
		   {
			   B[i] = i;
		   }
		   
		   Arrays.sort(B, (i, j) -> A[i] - A[j]);
		   
		   int m = n,max = 0;
		   
		   for (int i : B)
		   {
			   max = Math.max(max, i - m);
			   m = Math.min(m, i);
		   }
		   
		   return max;

	}
	
	public static void main(String[] args) {
		
		MaximumWidthRamp maximumWidthRamp = new 
				MaximumWidthRamp();
		
		System.out.println(
			maximumWidthRamp.maxWidthRamp(new int[] {6,0,8,2,1,5}));
		
		System.out.println(
				maximumWidthRamp.maxWidthRamp(new int[] {9,8,1,0,1,9,4,0,4,1}));
		
	}

}
