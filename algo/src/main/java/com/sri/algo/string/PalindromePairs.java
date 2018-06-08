package com.sri.algo.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Given a list of unique words, find all pairs of distinct indices (i, j) in
 * the given list, so that the concatenation of the two words, i.e. words[i] +
 * words[j] is a palindrome.
 * 
 * Example 1: Given words = ["bat", "tab", "cat"] Return [[0, 1], [1, 0]] The
 * palindromes are ["battab", "tabbat"]
 * 
 * Example 2: Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 * 
 * Return [[0,1], [1, 0], [3, 2], [2, 4]] The palindromes are ["dcbaabcd",
 * "abcddcba", "slls", "llssssll"].
 * 
 * @author salla
 *
 */
public class PalindromePairs {

	/**
	 * 
	 * T.C : O(n ^ 3)
	 * 
	 * Can we do better ?
	 * 
	 */
	public List<List<Integer>> palindromePairsNaive(String[] words) {

		List<List<Integer>> pairs = new ArrayList<>();
		int n = words.length;

		if (n == 0) {
			return pairs;
		}

		StringBuilder sb = new StringBuilder();
		List<Integer> pair = null;

		// Treat every word as a prefix and look for the suffix from the rest of the
		// words.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (i != j) {
					sb.append(words[i]).append(words[j]);
					if (isPalindrome(sb.toString())) {
						pair = new ArrayList<>();
						pair.add(i);
						pair.add(j);

						pairs.add(pair);
					}

					sb.setLength(0);
				}
			}
		}

		return pairs;

	}

	private boolean isPalindrome(String input) {
		int n = input.length();

		if (n <= 1) {
			return true;
		}

		int i = 0;
		int j = n - 1;

		while (i <= j) {
			if (input.charAt(i) != input.charAt(j)) {
				return false;
			}

			i++;
			j--;
		}

		return true;
	}

	/**
	 * T.C : O (n* T ^ 2)
	 * 
	 * Idea is to pick each word and check for the pair where the current word shall
	 * become a prefix/suffix.
	 * 
	 * @param words
	 * @return
	 */
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> pairs = new ArrayList<>();

		int n = words.length;

		if (n < 2) {
			return pairs;
		}

		Map<String, Integer> wordsToIndicesMap = new HashMap<>();

		for (int i = 0; i < n; i++) {
			wordsToIndicesMap.put(words[i], i);
		}

		for (int i = 0; i < n; i++) {
			int len = words[i].length();
			for (int j = 0; j <= len; j++) {
				String s1 = words[i].substring(0, j);
				String s2 = words[i].substring(j, len);

				if (isPalindrome(s1)) {
					String s2rev = new StringBuilder(s2).reverse().toString();

					if (wordsToIndicesMap.containsKey(s2rev) && wordsToIndicesMap.get(s2rev) != i) {
						List<Integer> pair = new ArrayList<>();
						pair.add(wordsToIndicesMap.get(s2rev));
						pair.add(i);

						pairs.add(pair);
					}
				}

				if (isPalindrome(s2)) {
					String s1rev = new StringBuilder(s1).reverse().toString();

					if (wordsToIndicesMap.containsKey(s1rev) && wordsToIndicesMap.get(s1rev) != i && !s2.isEmpty()) {
						List<Integer> pair = new ArrayList<>();
						pair.add(i);
						pair.add(wordsToIndicesMap.get(s1rev));

						pairs.add(pair);
					}
				}
			}
		}

		return pairs;
	}

	public static void main(String[] args) {

		PalindromePairs pp = new PalindromePairs();

		System.out.println(pp.palindromePairs(new String[] { "abcd", "dcba", "lls", "s", "sssll" }));

		// System.out.println(pp.palindromePairs(new String[] { "bat", "tab", "cat" }));

	}

}
