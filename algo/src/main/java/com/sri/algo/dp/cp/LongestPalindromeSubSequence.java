package com.sri.algo.dp.cp;

/**
 * Given a String, find the longest palindromic subsequence
 * 
 * Input: 2 bbabcbcab abbaab Output: 7 4
 *
 *
 */
public class LongestPalindromeSubSequence {

	/**
	 * T.C : O(n*n) where n is length of string
	 * S.C : O(n*n)
	 * @param s
	 * @return
	 */
	public int longestPalindromeSubseq(String s) {

		int[][] dp = new int[s.length()][s.length()];
		
		for(int i=s.length()-1; i>=0;i--)
		{
			dp[i][i] = 1;
			for(int j=i + 1; j < s.length();j++)
			{
				
				if(s.charAt(i) == s.charAt(j))
				{
					dp[i][j] = dp[i+1][j-1] + 2;
				}
				else
				{
					dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
				}
			}
		}
		
		return dp[0][s.length()-1];

	}

	public int longestPalindromeSubseqTopDown(String s) {

		return helper(s, 0, s.length() - 1, new Integer[s.length()][s.length()]);

	}

	private int helper(String s, int i, int j, Integer[][] memo) {

		if (memo[i][j] != null) {
			return memo[i][j];
		}

		if (i > j) {
			return 0;
		}

		if (i == j) {
			return 1;
		}

		if (s.charAt(i) == s.charAt(j)) {
			memo[i][j] = helper(s, i + 1, j - 1, memo) + 2;
		} else {
			memo[i][j] = Math.max(helper(s, i, j - 1, memo), helper(s, i + 1, j, memo));
		}

		return memo[i][j];
	}

	/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
	/**
	 * Time Complexity = O(m*n) using bottom up approach.
	 * 
	 * @param X
	 * @param Y
	 * @param m
	 * @param n
	 * @return
	 */
	public static int lcsWithDP(char[] X, char[] Y, int m, int n) {
		int[][] lcsMatrix = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {

				if (i == 0 || j == 0) {
					// When either of the string's are empty, lcs is 0.
					lcsMatrix[i][j] = 0;
				}

				else if (X[i - 1] == Y[j - 1]) {
					// if two chars X[i],Y[j] are equals lcs is 1 + lcs(i-1]j-1) i.e this value is
					// already
					// pre computed retrieve this value from table.
					lcsMatrix[i][j] = lcsMatrix[i - 1][j - 1] + 1;
				} else {
					// if two chars are not equal then lcs is max(lcs(i,j-1),lcs(i-1,j))
					// these values are already computed so retrie these values from table.
					lcsMatrix[i][j] = Integer.max(lcsMatrix[i - 1][j], lcsMatrix[i][j - 1]);
				}
			}
		}

		return lcsMatrix[m][n];
	}

	public static void main(String[] args) {

		LongestPalindromeSubSequence lps = new LongestPalindromeSubSequence();
		System.out.println(lps.longestPalindromeSubseq("bbbab"));

	}

}
