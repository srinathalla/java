package com.sri.algo.string.leet;


/**
 *  Given a string, your task is to count how many palindromic substrings in this string.

	The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
	
	Example 1:
	Input: "abc"
	Output: 3
	Explanation: Three palindromic strings: "a", "b", "c".
	
	Example 2:
	Input: "aaa"
	Output: 6
	Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
	
 * @author salla
 *
 */
public class PalindromeSubStrings {
	
	
	/**
	 * Idea is to expand around centre.
	 * 
	 * for a string aaa ->  
	 * 
	 * we check all the substrings with centers as the given positions and try 
	 * to expand around.
	 * 
	 * (0,0), (0,1), (1,1), (1,2), (2,2), (2,3)
	 * 
	 * T.C : O(n*n).
	 * 
	 * @param s
	 * @return
	 */
	public int countSubstrings(String s) {

		int n = s.length();
		int count = 0;
		for (int i = 0; i < 2 * n - 1; i++) {
			int l = i / 2;
			int r = l + i % 2;

			while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
				count++;
				l--;
				r++;
			}
		}

		return count;

	}

	 public static void main(String[] args) {
		 
		 PalindromeSubStrings ps = new PalindromeSubStrings();
		 
		 System.out.println(
		 ps.countSubstrings("aaa"));
		
	}

}
