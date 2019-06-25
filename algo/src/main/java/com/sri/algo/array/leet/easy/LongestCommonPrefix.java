package com.sri.algo.array.leet.easy;

/**
 *  Write a function to find the longest common prefix string amongst an array of strings.
	If there is no common prefix, return an empty string "".
	
	Example 1:
	
	Input: ["flower","flow","flight"]
	Output: "fl"
	
 * @author salla
 *
 */
public class LongestCommonPrefix {
	
	
	public String longestCommonPrefix(String[] strs) {
		
		if (strs.length == 0)
		{
			return "";
		}

		String prev = strs[0];

		for (int i = 1; i < strs.length; i++) {
			String curr = strs[i];

			int j = 0;

			while (j < prev.length() && j < curr.length() && 
					prev.charAt(j) == curr.charAt(j)) {
				j++;
			}

			if (j == 0) {
				return "";
			}

			prev = prev.substring(0, j);
		}

		return prev;

	}
	
	public static void main(String[] args) {
		
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		
		System.out.println(
			lcp.longestCommonPrefix(new String[] {"flower","flow","flight"}));
		
	}

}
