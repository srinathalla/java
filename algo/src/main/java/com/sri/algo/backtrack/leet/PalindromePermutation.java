package com.sri.algo.backtrack.leet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Given a string s, return all the palindromic permutations (without duplicates) of it. 
 * Return an empty list if no palindromic permutation could be form.

	Example 1:
	
	Input: "aabb"
	Output: ["abba", "baab"]
	Example 2:
	
	Input: "abc"
	Output: []
 * @author salla
 *
 */
public class PalindromePermutation {
	
	Set<String> set = new HashSet<>();

	
	/**
	 * T.C O(n/2 + 1)! 
	 * 
	 * At most n/2! permutations needs to be generated in the worst case.
	 * Further, for each permutation generated, string.reverse() function will take n/4 time.
	 * 
	 * S.C O(n) The depth of recursion tree can go up to n/2 in the worst case.
	 * 
	 * @param s
	 * @return
	 */
	public List<String> generatePalindromes(String s) {
		int[] map = new int[128];
		char[] str = new char[s.length() / 2];

		if (!canPermutePalindrome(s, map)) {
			return new ArrayList<>();
		}

		char ch = 0;
		int k = 0;
		for (int i = 0; i < map.length; i++) {
			if (map[i] % 2 == 1) {
				ch = (char) i;
			}

			for (int j = 0; j < map[i] / 2; j++) {
				str[k++] = (char) i;
			}
		}

		permute(str, 0, ch);
		return new ArrayList<>(set);
	}

	public boolean canPermutePalindrome(String s, int[] map) {
		int count = 0;
		for (char ch : s.toCharArray()) {
			map[ch]++;

			if (map[ch] % 2 == 0) {
				count--;
			} else {
				count++;
			}
		}
		return count <= 1;
	}

	public void swap(char[] s, int i, int j) {
		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}

	void permute(char[] s, int l, char ch) {

		if (l == s.length) {
			String str = new String(s);
			set.add(str + (ch == 0 ? "" : ch) + new StringBuilder(str).reverse().toString());
		}

		for (int i = l; i < s.length; i++) {

			if (i == l || s[i] != s[l]) {
				swap(s, l, i);
				permute(s, l + 1, ch);
				swap(s, l, i);
			}
		}
	}

    public static void main(String[] args) {
    	
    	PalindromePermutation palindromePermutation = new PalindromePermutation();
    	
    	System.out.println(palindromePermutation.generatePalindromes("aabb"));
		
	}
}
