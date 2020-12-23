package com.sri.algo.string.leet;

import java.util.Arrays;

public class StringsAreClose {

	public boolean closeStrings(String word1, String word2) {

		int[] w1 = new int[26];
		int[] w2 = new int[26];
		int[] w1u = new int[26];
		int[] w2u = new int[26];

		for (char c : word1.toCharArray()) {
			w1[c - 'a']++;
			w1u[c - 'a'] = 1;
		}

		for (char c : word2.toCharArray()) {
			w2[c - 'a']++;
			w2u[c - 'a'] = 1;
		}

		Arrays.sort(w1);
		Arrays.sort(w2);
		Arrays.sort(w1u);
		Arrays.sort(w2u);
		
		return Arrays.equals(w1, w2) && Arrays.equals(w1, w2);

	}

	public static void main(String[] args) {
		
		
		StringsAreClose src = new StringsAreClose();
		
		System.out.println(
				src.closeStrings("abc", "bca"));

	}

}
