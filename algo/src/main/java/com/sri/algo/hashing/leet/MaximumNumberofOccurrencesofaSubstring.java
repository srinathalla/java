package com.sri.algo.hashing.leet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumNumberofOccurrencesofaSubstring {

	public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {

		Map<String, Integer> freq = new HashMap<>();
		for (int i = 0; i < s.length() - minSize + 1; i++) {
			String a = s.substring(i, i + minSize);
			freq.put(a, freq.getOrDefault(a, 0) + 1);
		}

		int max = 0;

		for (String k : freq.keySet()) {
			Set<Character> set = new HashSet<>();
			for (char c : k.toCharArray()) {
				set.add(c);
			}
			if (set.size() <= maxLetters) {
				max = Math.max(max, freq.get(k));
			}
		}

		return max;

	}

}
