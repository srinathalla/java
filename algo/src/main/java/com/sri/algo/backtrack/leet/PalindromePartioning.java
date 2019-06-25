package com.sri.algo.backtrack.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * 	Given a string s, partition s such that every substring of the partition is a palindrome.
	
	Return all possible palindrome partitioning of s.
	
	Example:
	
	Input: "aab"
	Output:
	[
	  ["aa","b"],
	  ["a","a","b"]
	]
	
 * @author salla
 *
 */
public class PalindromePartioning {
	
	
	public List<List<String>> partition(String s) {

		List<List<String>> res = new ArrayList<>();

		List<String> curr = new ArrayList<>();
		partition(s, 0, res, curr);

		return res;

	}

	private void partition(String s, int pos, List<List<String>> res, List<String> curr) {
		if (pos == s.length()) {
			res.add(new ArrayList<>(curr));
			return;
		}

		for (int i = pos; i < s.length(); i++) {
			if (isPalindrome(s, pos, i)) {
				curr.add(s.substring(pos, i + 1));

				partition(s, i + 1, res, curr);
				curr.remove(curr.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String s, int start, int end) {
		int i = start, j = end;

		while (i < j) {
			if (s.charAt(i++) != s.charAt(j--)) {
				return false;
			}

		}

		return true;
	}
	
	
	public static void main(String[] args) {
		
		PalindromePartioning palindromePartioning = new PalindromePartioning();
		
		System.out.println(
			palindromePartioning.partition("aab"));
		
		
		
	}

}
