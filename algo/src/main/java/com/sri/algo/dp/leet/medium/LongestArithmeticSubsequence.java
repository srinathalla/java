package com.sri.algo.dp.leet.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequence {

	public int longestSubsequence(int[] arr, int difference) {
		
		Map<Integer,Integer> map = new HashMap<>();
		
		int longest = 1;
		for(int no : arr)
		{
			map.put(no, map.getOrDefault(no - difference, 0) + 1);
			longest = Math.max(longest, map.get(no));
		}
		return longest;

	}

}
