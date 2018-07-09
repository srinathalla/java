package com.sri.algo.string;

/**
 * Given two strings s1 and s2, write a function to return true if s2 contains
 * the permutation of s1. In other words, one of the first string's permutations
 * is the substring of the second string.
 * 
 * Example 1: Input:s1 = "ab" s2 = "eidbaooo" Output:True Explanation: s2
 * contains one permutation of s1 ("ba").
 * 
 * Example 2: Input:s1= "ab" s2 = "eidboaoo" Output: False Note: The input
 * strings only contain lower case letters. The length of both given strings is
 * in range [1, 10,000].
 * 
 * @author salla
 *
 */
public class PermutationInAString {

	public boolean checkInclusion(String s1, String s2) {

		int[] chars = new int[26];

		int k = s1.length();
		int n = s2.length();

		if (k > n) {
			return false;
		}
		
		if (k == 0)
		{
			return true;
		}

		for (int i = 0; i < k; i++) {
			chars[s1.charAt(i) - 'a']++;
			chars[s2.charAt(i) - 'a']--;
		}

		if (isAllZeroes(chars)) {
			return true;
		}

		for (int i = k; i < n; i++) {
			
			chars[s2.charAt(i) - 'a']--;
			chars[s2.charAt(i-k) - 'a']++;
			
			if (isAllZeroes(chars)) {
				return true;
			}
		}

		return false;

	}

	private boolean isAllZeroes(int[] arr) {

		for (int no : arr) {
			if (no != 0) {
				return false;
			}
		}

		return true;
	}
	
	public static void main(String[] args) {
		
		PermutationInAString  pis = new PermutationInAString();
		
		System.out.println(pis.checkInclusion("ab", "eidbaooo"));
		
		System.out.println(pis.checkInclusion("ab", "eidboaoo"));
		
	}

}
