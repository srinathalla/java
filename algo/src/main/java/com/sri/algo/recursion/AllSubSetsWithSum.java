package com.sri.algo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AllSubSetsWithSum {
	
	/**
	 * T.C => O(nlogn) + O(2^n);
	 * @param arr
	 * @param n
	 * @param sum
	 */
	public static void findAllSubsetsWithSum(int[] arr,int n,int sum)
	{
		
		Arrays.sort(arr);	
		List<Integer> entries = new ArrayList<>();
		List<List<Integer>> allLists = new ArrayList<>();
		
		findAllSubsetsWithSum(arr,n,0,sum,entries,allLists);
		
		print(allLists);
		
		if (allLists.isEmpty())
		{
			System.out.print("Empty");
		}	
	}
	
	private static void print(List<List<Integer>> allLists)
	{
		String fullStr = "";
		for (List<Integer> set : allLists)
		{
			String s = "(";
			
			for (int i = 0 ;i < set.size() ; i++)
			{
				s = s + set.get(i);
				
				if (i +1 != set.size())
				{
					s = s + " ";
				}
			}
			
			 s = s + ")";
			 fullStr = fullStr + s;
		}
		
		System.out.print(fullStr);	
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
	
	public static void findAllSubsetsWithSum(int[] arr,int n,int l,int sum,List<Integer> entries,
		List<List<Integer>> allLists)
	{
			
		if(sum == 0)
		{
			addIfAbsent(allLists,entries);
			return;
		}
		
		if (sum < 0 || l >= n)
		{
			return;
		}
			
		entries.add(arr[l]);
		findAllSubsetsWithSum(arr,n,l +1,sum -arr[l],entries,allLists);
		entries.remove(entries.size() -1);
		
		findAllSubsetsWithSum(arr,n,l + 1,sum,entries,allLists);
		
	}
	
	public static void main(String[] args) {
		
		try(Scanner in = new Scanner(System.in))
		{
	        int testCount = in.nextInt();
	        
	        for (int i =0 ;i < testCount ; i++)
	        {
	        	int n = in.nextInt();
	        	
	        	int[] arr1 = new int[n];
	        	
	        	for (int j =0 ;j < n ; j++)
	 	        {
	        		arr1[j] = in.nextInt();
	 	        }	
	        	int k = in.nextInt();
	        	
	        	findAllSubsetsWithSum(arr1,n,k);
	        	System.out.println();
	    		
	        }
		}
}


}
