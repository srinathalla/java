package com.sri.algo.hashing;

import java.util.HashMap;
import java.util.Map;

public class FirstNoRepeatingKTimes {
	
	/**
	 *  Time Complexity : O(n).
	 *  
	 *  Auxillary space : O(n).
	 *  
	 * @param arr1
	 * @param arr2
	 */
	public static void firstRepeatingNoKTimes(int[] arr1, int k) {
		
		if (arr1.length == 0 || k == 0)
		{
			return;
		}
		
		Map<Integer,Integer> freq = new HashMap<>();
		for (int ele : arr1) 
		{		
			if (!freq.containsKey(Integer.valueOf(ele)))
			{
				freq.put(ele,0);
			}
			
			freq.put(ele, freq.get(ele) + 1);
		}
		
		for (int ele : arr1) 
		{
			if (freq.get(ele) == k)
			{
				System.out.println(ele);
				break;
			}
		}	
	}
	
	public static void main(String[] args) {
		

		firstRepeatingNoKTimes(new int[] {4, 1, 2, 1, 1, 2},3);
		
		firstRepeatingNoKTimes(new int[] {1 , 7, 4, 3, 4, 8, 7},2);
		
		
			
		
	}


}
