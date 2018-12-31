package com.sri.algo.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string s, return all the palindromic permutations (without
 * duplicates) of it. Return an empty list if no palindromic permutation could
 * be form.
 * 
 * Example 1:
 * 
 * Input: "aabb" Output: ["abba", "baab"] Example 2:
 * 
 * Input: "abc" Output: []
 * 
 * @author salla
 *
 */
public class PalindromePermutation2 {

	public List<String> generatePalindromes(String s) {

		int[] map = new int[128];

		for (char ch : s.toCharArray()) {
			map[ch]++;
		}

		int count = 0;
		for (int ch : map) {
			count += map[ch] % 2;
		}

		Set<String> result = new HashSet<>();
		if (count > 1) {
			return new ArrayList<>();
		}

		permutate(s.toCharArray(), 0, s.length() - 1, result);

		return new ArrayList<>(result);

	}

	private void permutate(char[] chars, int l, int h, Set<String> result) {
		if (l >= h) {

			if (isPalidrome(chars)) {
				result.add(new String(chars));
			}
			return;
		}

		for (int i = l; i <= h; i++) {

			char ch = chars[l];
			chars[l] = chars[i];
			chars[i] = ch;

			permutate(chars, l + 1, h, result);
			ch = chars[l];
			chars[l] = chars[i];
			chars[i] = ch;
		}

	}

	private boolean isPalidrome(char[] str) {
		int i = 0, j = str.length - 1;

		while (i <= j && str[i] == str[j]) {
			i++;
			j--;
		}

		return i >= j;
	}
	
	public static void main(String[] args) {
		
		PalindromePermutation2 pp = new PalindromePermutation2();
		
		
		//System.out.println(pp.generatePalindromes("aabb"));
		// System.out.println(pp.generatePalindromes("abc"));
		
		System.out.println(pp.generatePalindromes("aaa"));
		
	}

}
