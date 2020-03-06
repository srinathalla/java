package com.sri.algo.string.leet;

import com.sri.algo.Solution;

/**
 * Given a palindromic string palindrome, replace exactly one character by any
 * lowercase English letter so that the string becomes the lexicographically
 * smallest possible string that isn't a palindrome.
 * 
 * After doing so, return the final string. If there is no way to do so, return
 * the empty string.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: palindrome = "abccba" Output: "aaccba" Example 2:
 * 
 * Input: palindrome = "a" Output: ""
 * 
 * @author srialla
 *
 */
public class BreakPalindrome {

	public String breakPalindrome(String palindrome) {

		int n = palindrome.length();
		if (palindrome.length() <= 1) {
			return "";
		}

		int idx = -1;
		// Traverse half the length to find a char which is not 'a' as this is a palidrome 
		for (int i = 0; i < palindrome.length() / 2; i++) {
			if (palindrome.charAt(i) != 'a') {
				idx = i;
				return palindrome.substring(0, idx) + 'a' + palindrome.substring(idx + 1);
			}
		}
	
		// Eg 1: aaa => aab and Eg 2 : aba => abb
		return palindrome.substring(0, n-1) + 'b';
	}

	public static void main(String[] args) {

		BreakPalindrome s = new BreakPalindrome();
		System.out.println(s.breakPalindrome("abccba"));
		System.out.println(s.breakPalindrome("aba"));

	}

}
