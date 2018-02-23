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
	

	/**
	 * Time Complexity O(n)
	 * At max we make two iterations O(2n).
	 * 
	 * 1) Move end pointer in s till we find all the characters of t.
	 * 2) Move start pointer towards end till we get a smallest window.
	 *    Repeat steps one and two till end pointer covers all characters of s.
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	 public String minWindow(String s, String t) {
	       
		 int[] chars = new int[256];
		 
		 // Set all char counter for each char present in s to zero
		 for (char ch  : s.toCharArray())
		 {
			  chars[ch] = 0;
		 }
		 
		 // Increment char counter for each char present in T.
		 for (char ch  : t.toCharArray())
		 {
			 chars[ch]++;
		 }
		 
		 int start =0,end=0,min = Integer.MAX_VALUE,min_start =0,counter = t.length();
		 
		while(end < s.length())
		{
		  
			char ch = s.charAt(end);
			
			// Decrement count value for each char, for characters present only in S and not T this will be -ve.
			chars[ch]--;
			if (chars[ch] >= 0)
			{
				// This condition is met only for chars present in T
				counter--;
			}
		
			// We reached a valid window.
			while (counter == 0)
			{
				if (min > end - start + 1)
				{
					// reset min value.
					min = end - start + 1;
					min_start = start;
				}
				
				char sch = s.charAt(start);
				chars[sch]++; // Increment count value of start character.
				
				// For each char present in T this will be > 0
				if(chars[sch] > 0)
				{
					counter++;
				}
				
				// Move start position.
				start++;	
			}
			
			// Move end position.
			end++;
		 
		}
		 
		 
		 return min == Integer.MAX_VALUE ? "" : s.substring(min_start, min_start + min);
	    }
	
	public static void main(String[] args) 
	{
		
		System.out.println(smallestWindow("timetopractice","toc"));
		
		System.out.println(smallestWindow("zoomlazapzo","oza"));
		
		System.out.println(smallestWindow("aabcbcdbca","abcd"));
		SmallestWindowThatContainsAllchars sm = new SmallestWindowThatContainsAllchars();
		
        System.out.println(sm.minWindow("timetopractice","toc"));
		
		System.out.println(sm.minWindow("zoomlazapzo","oza"));
		
		System.out.println(sm.minWindow("aabcbcdbca","abcd"));
	}

}
