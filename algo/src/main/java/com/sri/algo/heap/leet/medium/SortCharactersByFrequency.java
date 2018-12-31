package com.sri.algo.heap.leet.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string, sort it in decreasing order based on the frequency of
 * characters.
 * 
 * Example 1:
 * 
 * Input: "tree"
 * 
 * Output: "eert"
 * 
 * Explanation: 'e' appears twice while 'r' and 't' both appear once. So 'e'
 * must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 * 
 * Input: "cccaaa"
 * 
 * Output: "cccaaa"
 * 
 * Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid
 * answer. Note that "cacaca" is incorrect, as the same characters must be
 * together. Example 3:
 * 
 * Input: "Aabb"
 * 
 * Output: "bbAa"
 * 
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect. Note
 * that 'A' and 'a' are treated as two different characters.
 * 
 * @author salla
 *
 */
public class SortCharactersByFrequency {

	/**
	 * T.C O(nlogn).
	 * 
	 * @param s
	 * @return
	 */
	public String frequencySortUsingActualSort(String s) {

		Map<Integer, Integer> map = new HashMap<>();

		for (char no : s.toCharArray()) {
			map.put((int) no, map.getOrDefault((int) no, 0) + 1);
		}

		List<Integer> result = new ArrayList<>(map.keySet());

		Collections.sort(result, (a, b) -> map.get(a) != map.get(b) ? map.get(b) - map.get(a) : a - b);

		StringBuilder sb = new StringBuilder();
		for (int ascii : result) {
			int count = map.get(ascii);

			while (count-- > 0) {
				sb.append((char) ascii);
			}

		}

		return sb.toString();
	}

	public String frequencySort(String s) {

		List<Character>[] buckets = new List[s.length() + 1];

		Map<Character, Integer> map = new HashMap<>();

		for (char no : s.toCharArray()) {
			map.put(no, map.getOrDefault(no, 0) + 1);
		}

		for (Character key : map.keySet()) {
			int freq = map.get(key);

			if (buckets[freq] == null) {
				buckets[freq] = new ArrayList<>();
			}

			buckets[freq].add(key);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = buckets.length - 1; i >= 0; i--) {

			if (buckets[i] != null) {

				for (char ch : buckets[i]) {
					for (int count = 0; count < map.get(ch); count++) {
						sb.append(ch);
					}
				}
			}
		}

		return sb.toString();

	}

	public static void main(String[] args) {

		SortCharactersByFrequency sortCharactersByFrequency = new SortCharactersByFrequency();

		System.out.println(sortCharactersByFrequency.frequencySort("tree"));

	}

}
