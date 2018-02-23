package com.sri.algo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CombinationSum {
	

	/**
	 * T.C => O(nlogn) + O(2^n);
	 * @param arr
	 * @param n
	 * @param sum
	 */
	public static void findAllCombinations(int[] arr,int n,int sum)
	{
		
		Arrays.sort(arr);	
		List<Integer> entries = new ArrayList<>();
		List<List<Integer>> allLists = new ArrayList<>();
		
		findAllCombinationsWithSum(arr,n,0,sum,entries,allLists);
		
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
	
	public static void findAllCombinationsWithSum(int[] arr,int n,int l,int sum,List<Integer> entries,
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
		findAllCombinationsWithSum(arr,n,l,sum -arr[l],entries,allLists);
		entries.remove(entries.size() -1);
		
		findAllCombinationsWithSum(arr,n,l + 1,sum,entries,allLists);
	
		
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) 
	{	
		List<List<Integer>> combinations = new ArrayList<>();
		
		List<Integer> path = new ArrayList<>();
		
		combinationSum(candidates, candidates.length -1, target,path, combinations);
		
		return combinations;    
    }
	
	private void combinationSum(int[] candidiates,int i, int target,List<Integer> path, List<List<Integer>> combinations)
	{
		
		if (target == 0)
		{
			List<Integer> cloned = new ArrayList<>();
			cloned.addAll(path);
			combinations.add(cloned);
			return;
		}
		
		if (i < 0 || target < 0)
		{
			return;
		}
		
		path.add(candidiates[i]);
		combinationSum(candidiates, i,target - candidiates[i],path,combinations);
		path.remove(path.size() -1);
		
		combinationSum(candidiates, i-1,target,path,combinations);
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		CombinationSum cs = new CombinationSum();
		List<List<Integer>> res = cs.combinationSum(new int[] {2, 3, 6, 7}, 7);
		System.out.println(res);
		
		/*try(Scanner in = new Scanner(System.in))
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
	        	
	        	findAllCombinations(arr1,n,k);
	        	System.out.println();
	    		
	        }
		}*/
}


}
