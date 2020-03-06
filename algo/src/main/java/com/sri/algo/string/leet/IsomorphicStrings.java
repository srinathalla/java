package com.sri.algo.string.leet;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * Example 1:
 * 
 * Input: s = "egg", t = "add" Output: true
 * 
 * @author srialla
 *
 */
public class IsomorphicStrings {

	public boolean isIsomorphic(String s, String t) {

		if (s == null || t == null || s.length() != t.length()) {
			return false;
		}

		int[] smap = new int[256];
		int[] tmap = new int[256];

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (smap[ch] != tmap[ch]) {
				return false;
			}

			smap[ch] = i;
			tmap[ch] = i;
		}

		return true;

	}

	public static void main(String[] args) {

		IsomorphicStrings isomorphicStrings = new IsomorphicStrings();

		String s = "egg", t = "add";
		System.out.println(isomorphicStrings.isIsomorphic(s, t));

	}

}
