package com.sri.algo.string.leet;

import java.util.HashMap;
import java.util.Map;

/**
 * 	Given a string S, consider all duplicated substrings: (contiguous) substrings of S that 
 *  occur 2 or more times.  (The occurrences may overlap.)

	Return any duplicated substring that has the longest possible length.  (If S does not 
	have a duplicated substring, the answer is "".)
	
 * @author salla
 *
 */
public class LongestDuplicateSubStrings {
	
	
	public String longestDupSubstring(String S) {

		Map<String, Integer> map = new HashMap<>();

		String maxSubstring = "";
		int n = S.length();
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				String str = S.substring(i, j + 1);

				map.put(str, map.getOrDefault(str, 0) + 1);

				if (map.get(str) >= 2 && str.length() > maxSubstring.length()) {
					maxSubstring = str;
				}
			}
		}

		return maxSubstring;

	}
	
	public static void main(String[] args) {
		
		LongestDuplicateSubStrings longestDuplicateSubStrings = new LongestDuplicateSubStrings();
		
		System.out.println(
			longestDuplicateSubStrings.longestDupSubstring("banana"));
		System.out.println(
				longestDuplicateSubStrings.longestDupSubstring("abcd"));
	}

}
