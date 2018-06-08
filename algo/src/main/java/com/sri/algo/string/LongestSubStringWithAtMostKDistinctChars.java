package com.sri.algo.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring T that contains at
 * most k distinct characters.
 * 
 * For example, Given s = “eceba” and k = 2,
 * 
 * T is "ece" which its length is 3.
 * 
 * 
 * @author salla
 *
 */
public class LongestSubStringWithAtMostKDistinctChars {

	/**
	 * Naive approach. T.C : O(n^3). At each sub string search for max len.
	 * 
	 * @param s
	 * @param k
	 * @return
	 */
	public int lengthOfLongestSubstringKDistinctNaive(String s, int k) {

		int len = Integer.MIN_VALUE;
		int n = s.length();

		if (n == 0) {
			return 0;
		}

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				len = Integer.max(len, getMaxLen(s.substring(i, j + 1), k));
			}
		}

		return len;
	}

	private int getMaxLen(String s, int k) {
		Set<Character> chars = new HashSet<>();
		int len = 0;
		for (char ch : s.toCharArray()) {
			chars.add(ch);

			if (chars.size() > k) {
				break;
			}
			len++;
		}

		return len;
	}

	/**
	 * Map based O(n) solution.
	 * 
	 * Using two pointers we maintain a sliding window of size k distinct
	 * characters.
	 * 
	 * @param s
	 * @param k
	 * @return
	 */
	public int lengthOfLongestSubstringKDistinctWithMap(String s, int k) {
		int n = s.length();

		if (n == 0 || k == 0) {
			return 0;
		}

		Map<Character, Integer> charsCounter = new HashMap<>();

		int j = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);

			if (!charsCounter.containsKey(ch)) {
				charsCounter.put(ch, 0);
			}

			charsCounter.put(ch, charsCounter.get(ch) + 1);

			while (charsCounter.size() > k) {
				charsCounter.put(s.charAt(j), charsCounter.get(s.charAt(j)) - 1);

				if (charsCounter.get(s.charAt(j)) == 0) {
					charsCounter.remove(s.charAt(j));
				}
				j++;
			}

			max = Integer.max(max, i - j + 1);
		}

		return max;
	}

	/**
	 * Array based O(n) solution faster than map based.
	 * 
	 * Using two pointers we maintain a sliding window of size k distinct
	 * characters.
	 * 
	 * @param s
	 * @param k
	 * @return
	 */
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int n = s.length();

		if (n == 0 || k == 0) {
			return 0;
		}

		int[] charsCounter = new int[256];

		int j = 0;
		int max = Integer.MIN_VALUE;
		int count = 0;
		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);

			if (charsCounter[ch]++ == 0) {
				count++; // Unique chars counter.
			}

			// Keep the window to size k.
			if (count > k) {

				
				// Move slow pointer to a position where position - 1 count becomes zero.
				while (--charsCounter[s.charAt(j++)] != 0);

				count--; // // Remove one distinct char from sliding window. i.e count is reduced only when a character count becomes zero.
			}

			max = Integer.max(max, i - j + 1);
		}

		return max;

	}

	public static void main(String[] args) {

		LongestSubStringWithAtMostKDistinctChars lenOfSubStr = new LongestSubStringWithAtMostKDistinctChars();

		// System.out.println(lenOfSubStr.lengthOfLongestSubstringKDistinct("eceba",
		// 2));

		System.out.println(lenOfSubStr.lengthOfLongestSubstringKDistinct("abaccc", 2));

	}

}
