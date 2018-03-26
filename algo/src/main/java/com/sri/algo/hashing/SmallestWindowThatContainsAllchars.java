package com.sri.algo.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SmallestWindowThatContainsAllchars {

	
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
		
		SmallestWindowThatContainsAllchars sm = new SmallestWindowThatContainsAllchars();
		
        System.out.println(sm.minWindow("timetopractice","toc"));
		
		System.out.println(sm.minWindow("zoomlazapzo","oza"));
		
		System.out.println(sm.minWindow("aabcbcdbca","abcd"));
	}

}
