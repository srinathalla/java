package com.sri.algo.hashing;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithZeroSum {

	/**
	 * Time Complexity O(n).
	 * Auxillary Space : O(n).
	 * 
	 * @param arr
	 * @return
	 */
	public static boolean hasSubArrayWithZeroSum(int[] arr) {
		Map<Integer, Integer> sumToIndexMap = new HashMap<>();

		int sum = 0;
		sumToIndexMap.put(0, -1);
		for (int index = 0; index < arr.length; index++) {
			
			if (arr[index] == 0)
			{
				return true;
			}
			
			sum = sum + arr[index];
			if (sumToIndexMap.containsKey(sum)) {
				return true;
			}

			sumToIndexMap.put(sum, index);
		}

		return false;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(hasSubArrayWithZeroSum(new int[] {-2,-3,-1,2,3,1}));
		
		System.out.println(hasSubArrayWithZeroSum(new int[] {4, 2, -3, 1, 6}));
		
		System.out.println(hasSubArrayWithZeroSum(new int[] {4, 2, 0, 1, 6}));
		
		System.out.println(hasSubArrayWithZeroSum(new int[] {-3, 2, 3, 1, 6}));
		
	}

}
