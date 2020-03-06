package com.sri.algo.string.leet;

import java.util.stream.IntStream;

/**
 * Consider the string s to be the infinite wraparound string of
 * "abcdefghijklmnopqrstuvwxyz", so s will look like this:
 * "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
 * 
 * Now we have another string p. Your job is to find out how many unique
 * non-empty substrings of p are present in s. In particular, your input is the
 * string p and you need to output the number of different non-empty substrings
 * of p in the string s.
 * 
 * Input: "cac" Output: 2 Explanation: There are two substrings "a", "c" of
 * string "cac" in the string s.
 * 
 * @author srialla
 *
 */
public class UniqueSubstringsInWraparoundString {

	public int findSubstringInWraproundString(String p) {

		int[] dp = new int[26];
		int maxLen = 0;

		for (int i = 0; i < p.length(); i++) {

			if ((i > 0 && p.charAt(i) - p.charAt(i - 1) == 1) || 
				(i < p.length() - 1 && p.charAt(i) - p.charAt(i + 1) == 25)) {
				maxLen++;
			} else {
				maxLen = 1;
			}

			int idx = p.charAt(i) - 'a';
			dp[idx] = Math.max(dp[idx], maxLen);
		}

		return IntStream.of(dp).sum();
	}

	public static void main(String[] args) {

		UniqueSubstringsInWraparoundString uniqueSubstringsInWraparoundString = new UniqueSubstringsInWraparoundString();
		System.out.println(
			uniqueSubstringsInWraparoundString.findSubstringInWraproundString("cac"));
	}

}
