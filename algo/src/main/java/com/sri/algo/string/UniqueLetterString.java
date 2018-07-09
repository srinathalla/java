package com.sri.algo.string;

import java.util.Arrays;

import com.sri.algo.array.PrintArray;

/**
 * A character is unique in string S if it occurs exactly once in it.
 * 
 * For example, in string S = "LETTER", the only unique characters are "L" and
 * "R".
 * 
 * Let's define UNIQ(S) as the number of unique characters in string S.
 * 
 * For example, UNIQ("LETTER") = 2.
 * 
 * Given a string S with only uppercases, calculate the sum of UNIQ(substring)
 * over all non-empty substrings of S.
 * 
 * If there are two or more equal substrings at different positions in S, we
 * consider them different.
 * 
 * Since the answer can be very large, retrun the answer modulo 10 ^ 9 + 7.
 * 
 * @author salla
 *
 */
public class UniqueLetterString {

	/**
	 * Naive approach
	 * 
	 * T.C : O (n ^ 2 * 26)
	 * 
	 * @param s
	 * @return
	 */
	public int uniqueLetterStringNaive(String s) {

		int n = s.length();

		if (n < 2) {
			return n;
		}

		int[] chars;
		int count = 0;

		for (int i = 0; i < n; i++) {

			chars = new int[26];
			for (int j = i; j < n; j++) {

				int ch = s.charAt(j) - 'A';
				chars[ch]++;

				count += countUniqueChars(chars);

				// count = count % (10 ^ 9 + 7);
			}
		}

		return count;
	}

	private int countUniqueChars(int[] charsCount) {
		int count = 0;

		for (int no : charsCount) {
			if (no == 1) {
				count++;
			}
		}

		return count;
	}

	public int uniqueLetterString(String S) {
		int[][] index = new int[26][2];
		for (int i = 0; i < 26; ++i) {
			Arrays.fill(index[i], -1);
		}

		int res = 0, N = S.length(), mod = (int) Math.pow(10, 9) + 7;
		for (int i = 0; i < N; ++i) {
			int c = S.charAt(i) - 'A';
			res = (res + (i - index[c][1]) * (index[c][1] - index[c][0]) % mod) % mod;

			System.out.println(res);
			index[c] = new int[] { index[c][1], i };
		}
		for (int c = 0; c < 26; ++c)
			res = (res + (N - index[c][1]) * (index[c][1] - index[c][0]) % mod) % mod;
		return res;
	}

	public int uniqueLetterStringWithDP(String S) {

		int res = 0;

		int n = S.length();

		if (n < 2) {
			return n;
		}

		int[] contribution = new int[26];
		int[] lastSeen = new int[26];

		int cur = 0;

		for (int i = 0; i < n; i++) {
			int pos = S.charAt(i) - 'A';
			cur -= contribution[pos];

			contribution[pos] = (i - (lastSeen[pos] - 1));
			cur += contribution[pos];
			
			lastSeen[pos] = i + 1;
			
			res += cur;

		}

		return res;
	}

	public static void main(String[] args) {
		UniqueLetterString uls = new UniqueLetterString();

		/*
		 * System.out.println(uls.uniqueLetterString("ABC"));
		 * 
		 * System.out.println(uls.uniqueLetterString("ABA"));
		 */
		System.out.println(uls.uniqueLetterStringWithDP("ABABABAB"));

	}

}
