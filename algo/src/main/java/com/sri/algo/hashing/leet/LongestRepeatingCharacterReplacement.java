package com.sri.algo.hashing.leet;

/**
 * Given a string s that consists of only uppercase English letters, you can
 * perform at most k operations on that string.
 * 
 * In one operation, you can choose any character of the string and change it to
 * any other uppercase English character.
 * 
 * Find the length of the longest sub-string containing all repeating letters
 * you can get after performing the above operations.
 * 
 * Note: Both the string's length and k will not exceed 104.
 * 
 * Example 1:
 * 
 * Input: s = "ABAB", k = 2
 * 
 * Output: 4
 * 
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * 
 * @author srialla
 *
 */
public class LongestRepeatingCharacterReplacement {

	public int characterReplacement(String s, int k) {
		int[] count = new int[26];
		int max = 0, maxLen = 0;
		int start = 0;
		for (int end = 0; end < s.length(); end++) {
			max = Math.max(max, ++count[s.charAt(end) - 'A']);

			while (end - start + 1 > max + k) {
				--count[s.charAt(start) - 'A'];
				start++;
			}
			maxLen = Math.max(maxLen, end - start + 1);
		}
		return maxLen;
	}

	public static void main(String[] args) {

		LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();

		System.out.println(longestRepeatingCharacterReplacement.characterReplacement("AABABBA", 1));

	}

}
