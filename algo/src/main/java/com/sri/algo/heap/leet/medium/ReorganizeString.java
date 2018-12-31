package com.sri.algo.heap.leet.medium;

import java.util.Map;
import java.util.TreeMap;

/**
 * Given a string S, check if the letters can be rearranged so that two
 * characters that are adjacent to each other are not the same.
 * 
 * If possible, output any possible result. If not possible, return the empty
 * string.
 * 
 * Example 1:
 * 
 * Input: S = "aab" Output: "aba" Example 2:
 * 
 * Input: S = "aaab" Output: "" Note:
 * 
 * S will consist of lowercase letters and have length in range [1, 500].
 * 
 * @author salla
 *
 */
public class ReorganizeString {

	public String reorganizeString(String S) {

		TreeMap<Character, Integer> map = new TreeMap<>();

		for (char ch : S.toCharArray()) {

			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		StringBuilder sb = new StringBuilder();

		char prev = ' ';
		while (!map.isEmpty()) {

			char curr = getMaxChar(map, sb, prev);

			if (curr == ' ') {
				return "";
			}
			sb.append(curr);
			map.put(curr, map.get(curr) - 1);

			if (map.get(curr) == 0) {
				map.remove(curr);
			}
			prev =curr;

		}

		return sb.toString();
	}

	private char getMaxChar(TreeMap<Character, Integer> map, StringBuilder sb, char ch) {
		Map.Entry<Character, Integer> maxEntry = null;

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getKey() != ch  && (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)) {
				maxEntry = entry;
			}
		}

		return maxEntry == null ? ' ' : maxEntry.getKey();
	}

	public static void main(String[] args) {

		ReorganizeString rs = new ReorganizeString();

		System.out.println(rs.reorganizeString("aab"));
		System.out.println(rs.reorganizeString("aaab"));

		System.out.println(rs.reorganizeString("vvvl0"));

	}

}
