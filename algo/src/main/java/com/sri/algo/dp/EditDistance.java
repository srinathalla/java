package com.sri.algo.dp;

import java.util.Scanner;

/**
 * Given two strings str1 and str2 and below operations that can performed on str1.
 *  Find minimum number of edits (operations) required to convert ‘str1′ into ‘str2′.
		Insert
		Remove
		Replace
 *
 *
 */
public class EditDistance {
	/**
	 * 
	 * @param X
	 * @param Y
	 * @param m
	 * @param n
	 * @return
	 */
	public static int distance(char[] X, char[] Y, int m, int n) 
	{
		int lcs = LongestCommonSubSequence.lcsWithDP(X, Y, m, n);
		
		return m > n ? m - lcs : n- lcs;
	}
	
	 public int minDistance(String word1, String word2) {
		 
		 int n = word1.length();
		 int m = word2.length();
		 
		 if (n * m == 0) // if either of the strings are zero.
		 {
			 return n + m;
		 }
		 
		 int[][] dist = new int[n+1][m+1];
		 
		 for(int i=0;i <= n; i++)
		 {
			 dist[i][0] = i;
		 }
		 
		 for(int j=0;j <= m; j++)
		 {
			 dist[0][j] = j;
		 }
		 
		 for (int i=1;i <= n; i++)
		 {
			 for (int j=1; j<= m;j++)
			 {
				 
				 if (word1.charAt(i-1) == word2.charAt(j-1))
				 {
					 dist[i][j] = 1 + Math.min(Math.min(dist[i-1][j], dist[i][j-1]),dist[i-1][j-1]-1);
				 }
				 else
				 {
					 dist[i][j] = 1 + Math.min(Math.min(dist[i-1][j], dist[i][j-1]),dist[i-1][j-1]);
				 }
			 }
		 }
		 
		 return dist[n][m];
	        
	    }
	
	public static void main(String[] args) {
		
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		// System.out.println("Length of LCS is" + " " + lcsWithDP(X, Y, m, n));
		
		EditDistance editDistance = new EditDistance();
		System.out.println(
			editDistance.minDistance("horse", "ros"));
		
		try(Scanner in = new Scanner(System.in))
		{
	        int testCount = in.nextInt();
	        
	        for (int i =0 ;i < testCount ; i++)
	        {
	        	int n1 = in.nextInt();
	        	int n2 = in.nextInt();
	        	String s = in.nextLine();
	        	while(s.isEmpty())
	        	{
	        		s = in.nextLine();
	        	}
	        
	        	
	    		System.out.println(distance(s.split(" ")[0].toCharArray(),s.split(" ")[1].toCharArray(),n1,n2));
	        }
		}
	}

}
