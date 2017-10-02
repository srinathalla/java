package com.sri.algo.dp.cp;

import java.util.Scanner;

/**
 *  Given two strings str1 and str2,
	find the shortest string that has both str1 and str2 as subsequences.
	
	Input:   str1 = "geek",  str2 = "eke"
	Output: "geeke"

	Input:   str1 = "AGGTAB",  str2 = "GXTXAYB"
	Output:  "AGXGTXAYB"
 * 
 *
 */
public class LongestCommonSuperSequence {

	/**
	 * T.C O (2 ^ min(m,n))
	 * 
	 * @param X
	 * @param Y
	 * @param m
	 * @param n
	 * @return
	 */
	public static int longestCommonSuperSequence(char[] X, char[] Y, int m, int n) {

		if (m == 0) {
			return n;
		}

		if (n == 0) {
			return m;
		}

		if (X[m - 1] == Y[n - 1]) {
			return 1 + longestCommonSuperSequence(X, Y, m - 1, n - 1);
		}

		return 1 + Integer.min(
			longestCommonSuperSequence(X, Y, m - 1, n), 
			longestCommonSuperSequence(X, Y, m, n - 1));
	}

	/**
	 * T.C : O(m*n)
	 * Auxillary Space : O(m*n)
	 * 
	 * @param X
	 * @param Y
	 * @param m
	 * @param n
	 * @return
	 */
	public static int lcsWithdp(char[] X, char[] Y, int m, int n) {

		int[][] table = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				
				if (i == 0) {
					table[i][j] = j;
				}

				else if (j == 0) {
					table[i][j] = i;
				}

				else if (X[i - 1] == Y[j - 1]) {
					table[i][j] = table[i - 1][j - 1] + 1;
				}

				else
				{
					table[i][j] = 1 + Integer.min(table[i][j - 1], table[i - 1][j]);
				}
			}
		}

		return table[m][n];
	}

	public static int longestCommonSuperSequence(char[] X, char[] Y, int m, int n, StringBuilder s) {
		if (m == 0) {
			for (int i = 0; i < n; i++) {
				s.append(Y[i]);
			}
			return n;
		}

		if (n == 0) {
			for (int i = 0; i < m; i++) {
				s.append(X[i]);
			}
			return m;
		}

		if (X[m - 1] == Y[n - 1]) {

			StringBuilder sbXY = new StringBuilder().append(X[m - 1]);
			int xyIncluded = longestCommonSuperSequence(X, Y, m - 1, n - 1, sbXY);

			s.insert(0, sbXY);
			return 1 + xyIncluded;
		}

		StringBuilder sbX = new StringBuilder().append(X[m - 1]);
		StringBuilder sbY = new StringBuilder().append(Y[n - 1]);
		int xIncludedPath = longestCommonSuperSequence(X, Y, m - 1, n, sbX);
		int yIncludedPath = longestCommonSuperSequence(X, Y, m, n - 1, sbY);

		if (xIncludedPath < yIncludedPath) {
			s.insert(0, sbX);
		} else {
			s.insert(0, sbY);
		}

		return 1 + Integer.min(xIncludedPath, yIncludedPath);
	}

	public static void main(String[] args) {

		/*System.out.println(longestCommonSuperSequence("AGGTAB".toCharArray(), "GXTXAYB".toCharArray(), 6, 7));

		System.out.println(lcsWithdp("AGGTAB".toCharArray(), "GXTXAYB".toCharArray(), 6, 7));
		*/
		try(Scanner in = new Scanner(System.in))
		{
	        int testCount = in.nextInt();
	        
	        for (int i =0 ;i < testCount ; i++)
	        {
	        
	        	String s = in.nextLine();
	        	while(s.isEmpty())
	        	{
	        		s = in.nextLine();
	        	}
	        	
	        	String s1 = s.split(" ")[0];
        		String s2 = s.split(" ")[1];
	        	
	    		System.out.println(lcsWithdp(
    				s1.toCharArray(), 
    				s2.toCharArray(),
				    s1.length(),
				    s2.length()));
	        }
		}

	}

}
