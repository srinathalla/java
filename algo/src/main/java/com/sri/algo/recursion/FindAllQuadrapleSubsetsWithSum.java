package com.sri.algo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Given an array A of size N, find all combination of four elements in the array 
 * whose sum is equal to a given value K. For example, if the given array is
 * {10, 2, 3, 4, 5, 9, 7, 8} and K = 23, one of the quadruple is “3 5 7 8” (3 + 5 + 7 + 8 = 23).
 *
 */
public class FindAllQuadrapleSubsetsWithSum {
	
	/**
	 * T.C => O(nlogn) + O(2^n);
	 * @param arr
	 * @param n
	 * @param sum
	 */
	public static void findAllQuadraples(int[] arr,int n,int sum)
	{
		
		Arrays.sort(arr);	
		List<Integer> entries = new ArrayList<>();
		List<List<Integer>> allLists = new ArrayList<>();
		
		findAllQuadraples(arr,n,0,sum,entries,allLists);
		
		for (List<Integer> entry : allLists)
		{
			printPathEntries(entry);
		}
		
		if (allLists.isEmpty())
		{
			System.out.println(-1);
		}	
	}
	
	private static void addIfAbsent(List<List<Integer>> allLists,List<Integer> newEntry)
	{	
		if (!allLists.contains(newEntry))
		{
			List<Integer> cloned = new ArrayList<>();
			cloned.addAll(newEntry);
			allLists.add(cloned);
		}
	}
	
	private static void printPathEntries(List<Integer> entries)
	{
		for (int no : entries)
		{
			System.out.print(no + " ");
		}
		System.out.print("$");
	}
	
	public static void findAllQuadraples(int[] arr,int n,int l,int sum,List<Integer> entries,
		List<List<Integer>> allLists)
	{
		
		if (entries.size() > 4)
		{
			return;
		}	
		if(sum == 0 && entries.size() == 4)
		{
			addIfAbsent(allLists,entries);
			return;
		}
		
		if (sum < 0 || l >= n)
		{
			return;
		}
			
		entries.add(arr[l]);
		findAllQuadraples(arr,n,l +1,sum -arr[l],entries,allLists);
		entries.remove(entries.size() -1);
		
		findAllQuadraples(arr,n,l + 1,sum,entries,allLists);
		
	}
	
	public static void main(String[] args) {
		
		try(Scanner in = new Scanner(System.in))
		{
	        int testCount = in.nextInt();
	        
	        for (int i =0 ;i < testCount ; i++)
	        {
	        	int n = in.nextInt();
	        	int k = in.nextInt();
	        	int[] arr1 = new int[n];
	        	
	        	for (int j =0 ;j < n ; j++)
	 	        {
	        		arr1[j] = in.nextInt();
	 	        }	
	        	
	    		findAllQuadraples(arr1,n,k);
	    		
	        }
		}
}

}
