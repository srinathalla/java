package com.sri.algo.array;

import java.util.Scanner;

/**
 * Given an array A your task is to tell at which position the equilibrium first occurs in the array. 
 * Equilibrium position in an array is a position such that the sum of elements below it is equal to 
 * the sum of elements after it.
 * 
 * Example:
	Input:
	2
	1
	1
	5
	1 3 5 2 2
	
	Output:
	1
	3

 * @author salla
 *
 */
public class EquilibriumPoint {
	
	public static int getEquilibriumPt(int[] arr,int n)
	{
		
		
		int[] lSum = new int[n];
		int[] rSum = new int[n];
		
		lSum[0] = 0;
		rSum[n-1] = 0;
		
		for (int i=1;i<n;i++)
		{
			lSum[i] = lSum[i-1] + arr[i-1];
		}
		
		for (int i=n-2;i>=0;i--)
		{
			rSum[i] = rSum[i+1] + arr[i+1];
		}
		
		for(int i=0;i<n;i++)
		{
			
			if (lSum[i] == rSum[i])
			{
				return i + 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		
	/*	int[] arr = new int[]{1 ,3 ,5 ,2 ,2};
		System.out.println(getEquilibriumPt(arr,5));
		

		System.out.println(getEquilibriumPt(new int[] {1},1));*/
		
		try (Scanner in = new Scanner(System.in)) {
			int testCount = in.nextInt();

			for (int i = 0; i < testCount; i++) {
				int n = in.nextInt();
			
				int[] arr = new int[n];

				for (int j = 0; j < n; j++) {
					arr[j] = in.nextInt();
				}
				

				System.out.println(getEquilibriumPt(arr, n));

			}
		}
		
		
		
	}

}
