package com.sri.algo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, add spaces in s to construct a sentence where each word is a
 * valid dictionary word. Return all such possible sentences.
 * 
 * Note:
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation. You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * 
 * Input: s = "catsanddog" wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output: [ "cats and dog", "cat sand dog" ]
 * 
 * @author salla
 *
 */
public class WordBreak2 {

	public List<String> wordBreakWithDFS(String s, List<String> wordDict) {

		List<String> wordList = new ArrayList<String>();
		if (s == null || s.isEmpty() || wordDict == null || wordDict.isEmpty()) {
			return wordList;
		}

		Set<String> wordSet = new HashSet<>();

		for (String word : wordDict) {
			wordSet.add(word);
		}

		wordBreak(s, wordSet, wordList, 0, 0, new StringBuilder());

		return wordList;

	}

	private void wordBreak(String s, Set<String> wordSet, List<String> wordList, int prevPos, int pos,
			StringBuilder str) {

		if (pos == s.length()) {
			return;
		}

		str.append(s.charAt(pos));

		if (wordSet.contains(s.substring(prevPos, pos + 1))) {

			if (pos + 1 == s.length()) {
				wordList.add(str.toString());
			} else {
				str.append(" ");
				wordBreak(s, wordSet, wordList, pos + 1, pos + 1, str);
				str.deleteCharAt(str.length() - 1);
			}
		}

		wordBreak(s, wordSet, wordList, prevPos, pos + 1, str);

		str.deleteCharAt(str.length() - 1);
	}

	public List<String> wordBreak(String s, List<String> wordDict) {

		List<String> wordList = new ArrayList<String>();
		if (s == null || s.isEmpty() || wordDict == null || wordDict.isEmpty()) {
			return wordList;
		}

		Set<String> wordSet = new HashSet<>();

		for (String word : wordDict) {
			wordSet.add(word);
		}

		return DFS(s, wordSet, new HashMap<String, List<String>>());
	}

	// DFS function returns an array including all substrings derived from s.
	List<String> DFS(String s, Set<String> wordDict, HashMap<String, List<String>> map) {

		if (map.containsKey(s)) {
			return map.get(s);
		}

		List<String> words = new ArrayList<>();
		if (s.isEmpty()) {
			words.add("");
			return words;
		}

		for (String word : wordDict) {
			if (s.startsWith(word)) {
				List<String> subList = DFS(s.substring(word.length()), wordDict, map);

				for (String entry : subList) {
					words.add(word + (entry.isEmpty() ? "" : " " + entry));
				}
			}
		}

		map.put(s, words);

		return words;
	}

	public static void main(String[] args) {

		WordBreak2 wb = new WordBreak2();

		System.out.println(
				wb.wordBreak("catsanddog", Arrays.asList(new String[] { "cat", "cats", "and", "sand", "dog" })));

		System.out.println(wb.wordBreak("pineapplepenapple",
				Arrays.asList(new String[] { "apple", "pen", "applepen", "pine", "pineapple" })));

		System.out.println(
				wb.wordBreak("catsandog", Arrays.asList(new String[] { "cats", "dog", "sand", "and", "cat" })));

	}

}
