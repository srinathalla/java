package com.sri.algo.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SmallestWindowThatContainsAllchars {

	/**
	 *  i/p : "timetopractice","toc"
	 *  o/p : "toprac"
	 *  
	 *  i/p : "zoomlazapzo","oza"
	 *  o/p : "apzo"
	 *  
	 *  Time Complexity : O(n.m) n : len of bigger string, m : len of sub string.
	 *  Auxillary Space : O(m).
	 *  
	 *  
	 * @param input
	 * @param text
	 * @return
	 */
	public static String smallestWindow(String input, String text) {
		Map<Character, Integer> charToIndexMap = new HashMap<>();

		for (char ch : text.toCharArray()) {
			charToIndexMap.put(ch, Integer.MAX_VALUE);
		}

		int minLen = Integer.MAX_VALUE;
		int[] minMaxArr = null;

		for (int index = 0; index < input.length(); index++) {

			if (charToIndexMap.containsKey(input.charAt(index))) {
				charToIndexMap.put(input.charAt(index), index);
				int[] arr = getLength(charToIndexMap);
				
				if (arr[1] != Integer.MAX_VALUE && arr[1] - arr[0] < minLen)
				{
					minLen = arr[1] - arr[0];
					minMaxArr = arr;
				}	
			}	
		}
		
		return input.substring(minMaxArr[0], minMaxArr[1] + 1);
	}

	private static int[] getLength(Map<Character, Integer> charToIndexMap) {

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (Entry<Character, Integer> entry : charToIndexMap.entrySet()) {
			Integer val = entry.getValue();
			if (val == Integer.MAX_VALUE) {
				return new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE };
			}

			max = Integer.max(max, entry.getValue());
			min = Integer.min(min, entry.getValue());
		}

		return new int[] { min, max };
	}
	
	public static void main(String[] args) 
	{
		
		System.out.println(smallestWindow("timetopractice","toc"));
		
		System.out.println(smallestWindow("zoomlazapzo","oza"));
		
		System.out.println(smallestWindow("aabcbcdbca","abcd"));
	}

}
