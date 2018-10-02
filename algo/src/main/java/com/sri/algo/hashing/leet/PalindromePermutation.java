package com.sri.algo.hashing.leet;

/**
 * Given a string, determine if a permutation of the string could form a
 * palindrome.
 * 
 * Example 1:
 * 
 * Input: "code" Output: false Example 2:
 * 
 * Input: "aab" Output: true Example 3:
 * 
 * Input: "carerac" Output: true
 * 
 * @author salla
 *
 */
public class PalindromePermutation {

	/**
	 * T.C O(n) where n is length of String
	 * 
	 * @param s
	 * @return
	 */
	public boolean canPermutePalindrome(String s) {

		int[] map = new int[128];

		for (char ch : s.toCharArray()) {
			map[ch]++;
		}

		int count = 0;

		for (int i = 0; i < map.length && count <= 1; i++) {
			count += map[i] % 2;
		}

		return count <= 1;
	}
	
	public static void main(String[] args) {
		
		PalindromePermutation pp = new PalindromePermutation();
		
		System.out.println(pp.canPermutePalindrome("carerac"));
		
		System.out.println(pp.canPermutePalindrome("abc"));
		
		System.out.println(pp.canPermutePalindrome("aab"));
		
		
	}

}
