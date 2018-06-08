package com.sri.algo.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * You are given a string, s, and a list of words, words, that are all of the
 * same length. Find all starting indices of substring(s) in s that is a
 * concatenation of each word in words exactly once and without any intervening
 * characters.
 * 
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * 
 * Output: [0,9]
 * 
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar"
 * respectively. The output order does not matter, returning [9,0] is fine too.
 * 
 * @author salla
 *
 */
public class SubStringwithConcatenationOfAllWords {

	/**
	 * Map based solution runs into TLE for bigger words array ..
	 * 
	 * @param s
	 * @param words
	 * @return
	 */
	public List<Integer> findSubstringTLE(String s, String[] words) {
		List<Integer> indices = new ArrayList<>();

		int n = s.length();

		Map<String, Integer> wordCountMap = new HashMap<>();
		Map<String, Integer> concatWordCountMap = new HashMap<>();
		int concatStrLen = 0;

		for (String word : words) {
			concatStrLen += word.length();

			if (!wordCountMap.containsKey(word)) {
				wordCountMap.put(word, 0);
				concatWordCountMap.put(word, 0);
			}

			wordCountMap.put(word, wordCountMap.get(word) + 1);
		}

		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = i; j < n; j++) {
				sb.append(s.charAt(j));

				if (concatWordCountMap.containsKey(sb.toString())) {
					int count = concatWordCountMap.get(sb.toString());
					concatWordCountMap.put(sb.toString(), count + 1);

					sb = new StringBuilder();
				}

				// look in the substring i..j when sub string length is equal to sum of length's
				// of all the words given ..
				if (j - i + 1 == concatStrLen) {
					if (isConcatString(wordCountMap, concatWordCountMap)) {
						indices.add(i);
					}

					for (String word : words) {
						concatWordCountMap.put(word, 0);
					}
					break;
				}
			}
		}

		return indices;
	}

	/**
	 * Map based solution..
	 * 
	 *  T.C : O(n * m) -> O(n)
	 *  
	 *  n is size of the given string ..
	 *  m is size of all the words combined ..
	 *  
	 * @param s
	 * @param words
	 * @return
	 */
	public List<Integer> findSubstring(String s, String[] words) {

		List<Integer> indices = new ArrayList<>();

		if (s == null || s.length() == 0) {
			return indices;
		}

		int n = s.length(), wCount = words.length, wSize = words[0].length();
		Map<String, Integer> originalWordToWordCountMap = new HashMap<>();

		for (String word : words) {
			originalWordToWordCountMap.put(word, originalWordToWordCountMap.getOrDefault(word, 0) + 1);
		}

		for (int i = 0; i < n - wCount * wSize + 1; i++) {

			int j = 0;
			Map<String, Integer> seenWordToWordCountMap = new HashMap<>();

			while (j < wCount) {
				String word = s.substring(i + j * wSize, i + (j + 1) * wSize);

				if (originalWordToWordCountMap.containsKey(word)) {
					seenWordToWordCountMap.put(word, seenWordToWordCountMap.getOrDefault(word, 0) + 1);

					if (seenWordToWordCountMap.get(word) > originalWordToWordCountMap.get(word)) {
						break;
					}
				} else {
					break;
				}
				j++;
			}

			if (j == wCount) {
				indices.add(i);
			}
		}

		return indices;

	}

	private boolean isConcatString(Map<String, Integer> wordCountMap, Map<String, Integer> concatWordCountMap) {

		for (Entry<String, Integer> entry : wordCountMap.entrySet()) {
			if (entry.getValue() != concatWordCountMap.get(entry.getKey())) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {

		SubStringwithConcatenationOfAllWords subStrConcat = new SubStringwithConcatenationOfAllWords();

		System.out.println(subStrConcat.findSubstring("barfoothefoobarman", new String[] { "foo", "bar" }));

	}

}
