package com.sri.algo.array;

/**
 * Given an unsorted array of non-negative integers, find a continuous sub-array which adds to a given number.

	Input:
	
	The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. 
	Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array 
	and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.
	
	Output:
	
	Corresponding to each test case, in a new line, print the starting and ending positions of first such 
	occuring subarray if sum equals to subarray, else print -1.
	
	Note: Position of 1st element of the array should be considered as 1.
	
	Expected Time Complexity: O(n)

	Constraints:
	1 ≤ T ≤ 100
	1 ≤ N ≤ 100
	1 ≤ an array element ≤ 200
	
	Example:
	
	Input:
	2
	5 12
	1 2 3 7 5
	10 15
	1 2 3 4 5 6 7 8 9 10
	
	Output:
	2 4
	1 5
 * @author salla
 *
 */
public class SubArrayWithSum {
	
	/**
	 *  Calculate sum of each Sub Array and check for the given sum.
	 *   
	 *  Time Complexity : O(n^2).
	 *  
	 * @param arr
	 * @param sum
	 */
	public static void longestContigSubArrayWithSum(int[] arr,int sum)
	{
		int n = arr.length;
		
		for (int i=0; i < n; i++)
		{
			int ssum = 0;
			for (int j=i; j <n; j++)
			{
				ssum =  ssum + arr[j];
				
				if (ssum == sum)
				{
					System.out.println((i + 1) + " " + (j +1));
					return;
					
				}
			}
		}	
	
		System.out.println(-1);
	}
	
	/**
	 * Time Complexity : O(n).
	 * 
	 * In worst case you traverse twice i.e T.C is 2*n.
	 * 
	 * @param arr
	 * @param sum
	 */
	public static void longestContigSubArrayWidSum(int[] arr,int sum)
	{
		int n = arr.length;
		
		int i =0;
		int j =i;
		
		int curr_sum = arr[j];
		while (j < n)
		{
			
			if (curr_sum == sum)
			{
				System.out.println((i + 1) + " " + (j +1));
				return;
			}
			
			else if (curr_sum > sum)
			{
				curr_sum = curr_sum - arr[i];
				i++;
			}
			else
			{   
				j++;
				curr_sum = curr_sum + arr[j];	
			}
		}
	
		System.out.println(-1);
	}
	
	public static void main(String[] args) 
	{
		longestContigSubArrayWithSum(new int[] {1 ,2 ,3 ,7 ,5} , 12);
		
		longestContigSubArrayWithSum(new int[] {1 ,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9 ,10} , 15);
		
		longestContigSubArrayWidSum(new int[] {1 ,2 ,3 ,7 ,5} , 12);
		
		longestContigSubArrayWidSum(new int[] {1 ,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9 ,10} , 15);
		
	}

}
