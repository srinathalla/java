package com.sri.algo.dp.leet.hard;

/**
 * Given an input string (s) and a pattern (p), implement regular expression
 * matching with support for '.' and '*'.
 * 
 * '.' Matches any single character. '*' Matches zero or more of the preceding
 * element. The matching should cover the entire input string (not partial).
 * 
 * Note:
 * 
 * s could be empty and contains only lowercase letters a-z. p could be empty
 * and contains only lowercase letters a-z, and characters like . or *. Example
 * 1:
 * 
 * Input: s = "aa" p = "a" Output: false Explanation: "a" does not match the
 * entire string "aa".
 * eibccckrhcgucrgnrtevkicbcrfejcgcktrlchvunvlg
 * 
 * @author srialla
 *
 */
public class RegularExpressionMatching {

	public boolean isMatch(String s, String p) {

		int n = s.length();
		int m = p.length();
		boolean[][] dp = new boolean[n + 1][m + 1];
		dp[0][0] = true;

		for (int i = 1; i <= m; i++) {
			if (p.charAt(i - 1) == '*') {
				dp[0][i] = dp[0][i - 2];
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {

				if (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];

				} else if (p.charAt(j - 1) == '*') {

					dp[i][j] = dp[i][j - 2];
					if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
						dp[i][j] = dp[i][j] | dp[i - 1][j];
					}
				}

				else {
					dp[i][j] = false;
				}
			}
		}

		return dp[n][m];
	}

	public static void main(String[] args) {

		RegularExpressionMatching rem = new RegularExpressionMatching();
		System.out.println(rem.isMatch("aa", "a*"));

	}

}
