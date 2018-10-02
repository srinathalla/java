package com.sri.algo.hashing.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Design a class which receives a list of words in the constructor, and
 * implements a method that takes two words word1 and word2 and return the
 * shortest distance between these two words in the list. Your method will be
 * called repeatedly many times with different parameters.
 * 
 * Example: Assume that words = ["practice", "makes", "perfect", "coding",
 * "makes"].
 * 
 * Input: word1 = “coding”, word2 = “practice” Output: 3 Input: word1 = "makes",
 * word2 = "coding" Output: 1 Note: You may assume that word1 does not equal to
 * word2, and word1 and word2 are both in the list.
 * 
 * @author salla
 *
 */
public class ShortestWordDistance2 {

	Map<String, List<Integer>> wordToIndexMap = new HashMap<>();

	public ShortestWordDistance2(String[] words) {

		for (int i = 0; i < words.length; i++) {

			List<Integer> idxSet = wordToIndexMap.getOrDefault(words[i], new ArrayList<>());
			idxSet.add(i);
			wordToIndexMap.put(words[i], idxSet);
		}

	}

	/**
	 * T.C : O(n + m) where n and m are sizes of the frequency list ..
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int shortest(String word1, String word2) {

		List<Integer> word1Set = wordToIndexMap.get(word1);

		List<Integer> word2Set = wordToIndexMap.get(word2);
		int min = Integer.MAX_VALUE;

		int i = 0, j = 0;

		while (i < word1Set.size() && j < word2Set.size()) {
			min = Integer.min(min, Math.abs(word1Set.get(i) - word2Set.get(j)));
			if (word1Set.get(i) < word2Set.get(j)) {
				i++;
			} else {
				j++;
			}
		}

		return min;
	}

	public static void main(String[] args) {

		ShortestWordDistance2 sw = new ShortestWordDistance2(
				new String[] { "practice", "makes", "perfect", "coding", "makes" });

		System.out.println(sw.shortest("coding", "makes"));

	}

}
