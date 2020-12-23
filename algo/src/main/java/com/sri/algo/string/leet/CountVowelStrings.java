package com.sri.algo.string.leet;

import java.util.stream.IntStream;

public class CountVowelStrings {

	public int countVowelStrings(int n) {

		int[] c = new int[] { 1, 1, 1, 1, 1 };

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < 5; j++) {
				c[j] += c[j - 1];
			}
		}

		return IntStream.of(c).sum();

	}

}
