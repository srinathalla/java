package com.sri.algo.dp;


/**
 * Given a string s and a string t, check if s is subsequence of t.

   You may assume that there is only lower case English letters in both s and t. t is potentially a 
   very long (length ~= 500,000) string, and s is a short string (<=100).

   A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

   Example 1:
   s = "abc", t = "ahbgdc"

   Return true.

   Example 2:
   s = "axc", t = "ahbgdc"

Return false.
 * @author salla
 *
 */
public class IsSubSequence {

	/**
	 * T.C : O(n*m). n : len of t m : len of s
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isSubsequenceWithDP(String s, String t) {

		int n = t.length(), m = s.length();

		if (n == 0 && m == 0) {
			return true;
		}

		boolean[][] table = new boolean[n + 1][m + 1];

		for (int i = 0; i <= n; i++) {
			table[i][0] = true;
		}

		for (int i = 1; i <= m; i++) {
			table[0][i] = false;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				table[i][j] = (t.charAt(i - 1) == s.charAt(j - 1)) ? table[i - 1][j - 1] : table[i - 1][j];
			}

			if (table[i][m]) {
				return true;
			}
		}

		return false;
	}

	/**
	 * T.C : O(n). 
	 *  n : len of t 
	 *  
	 *  two pointer based solution.
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isSubsequence(String s, String t) {

		int n = t.length(), m = s.length();

		if (n == 0 && m == 0) {
			return true;
		}
        
        if (m ==0)
        {
            return true;
        }
        
        if (n ==0)
        {
            return false;
        }

		int i = 0, j = 0;

		while (i < n) {

			while (i < n && t.charAt(i) != s.charAt(j)) {
				i++;
			}

			if (i == n)
			{
				return false;
			}
			
			i++;
			j++;

			if (j == m) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {

		IsSubSequence isSubSeq = new IsSubSequence();
/*
		System.out.println(isSubSeq.isSubsequence("abc", "ahbgdc"));

		System.out.println(isSubSeq.isSubsequence("axc", "ahbgdc"));
		*/
		System.out.println(isSubSeq.isSubsequence("b", "c"));

	}
}
