package com.sri.algo.array.leet.medium;

import java.util.HashMap;
import java.util.Map;

/**
 *  Given a binary array, 
 *  find the maximum length of a contiguous subarray with equal number of 0 and 1.
 * 
 *  Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

	Example 1:
	Input: [0,1]
	Output: 2
	Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
	Example 2:
 * 
 * @author salla
 *
 */
public class ContigousArray {

	public int findMaxLength(int[] nums) {

		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);

		int count = 0, maxlen = 0;

		for (int i = 0; i < nums.length; i++) {
			count += nums[i] == 1 ? nums[i] : -1;

			if (map.containsKey(count)) {
				maxlen = Math.max(maxlen, i - map.get(count));
			} else {
				map.put(count, i);
			}
		}
		return maxlen;

	}
	 
	 public static void main(String[] args) {
		 
		 ContigousArray contigousArray = new ContigousArray();
		 
		 System.out.println(
			 contigousArray.findMaxLength(new int[] {0,1,0}));
		
	}

}
