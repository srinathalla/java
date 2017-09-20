package com.sri.algo.hashing;

import java.util.HashMap;
import java.util.Map;

public class MaxSubArrayWithZeroSum {

	/**
	 * Time Complexity O(n). 
	 * Auxillary Space : O(n).
	 * 
	 * Map stores the 
	 * key : sum till current index, 
	 * value : index.
	 * 
	 * When we visit the same sum again, length of sub array is (index - map.get(sum));
	 * To get max traverse the complete array and update max value.
	 * 
	 * @param arr
	 * @return
	 */
	public static int maxSubArrayWithZeroSum(int[] arr) {
		Map<Integer, Integer> sumToIndexMap = new HashMap<>();

		int sum = 0;
		sumToIndexMap.put(0, -1);
		int max = Integer.MIN_VALUE;

		for (int index = 0; index < arr.length; index++) {

			if (arr[index] == 0) {
				max = Integer.max(max, 1);
			}

			sum = sum + arr[index];
			if (sumToIndexMap.containsKey(sum)) {

				int prevSumIndex = sumToIndexMap.get(sum);
				max = Integer.max(max, index - prevSumIndex);
			} else {
				sumToIndexMap.put(sum, index);
			}
		}

		return max;
	}

	public static void main(String[] args) {

		System.out.println(maxSubArrayWithZeroSum(new int[] { -2, -3, -1, 2, 3, 1 }));

		System.out.println(maxSubArrayWithZeroSum(new int[] { 4, 2, -3, 1, 6 }));

		System.out.println(maxSubArrayWithZeroSum(new int[] { 4, 2, 0, 1, 6 }));

		System.out.println(maxSubArrayWithZeroSum(new int[] { 15,  -2,  2,  -8,  1,  7,  10, 23}));
		
		System.out.println(maxSubArrayWithZeroSum(new int[] { -1, 1, -1, 1}));
	}

}
