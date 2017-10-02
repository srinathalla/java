package com.sri.algo.dp;

import java.util.Scanner;

public class LongestCommonSubSequence {

	/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
	public static int lcs(char[] X, char[] Y, int m, int n) 
	{
		
		if (m ==0 || n ==0)
		{
			return 0;
		}
		
		if (X[m -1] == Y [n-1])
		{
			return 1 + lcs(X,Y,m-1,n-1);
		}
		else
		{
			return Integer.max(lcs(X,Y,m-1,n),lcs(X,Y,m,n-1));
		}
		
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
	public static int lcsWithDP(char[] X, char[] Y, int m, int n) 
	{
		int[][] lcsMatrix = new int[m+1][n+1];
	
		
		for (int i=0 ;i <=m ;i ++)
		{
			for (int j =0 ;j <= n ;j ++)
			{
				
				if ( i== 0 || j ==0)
				{
					// When either of the string's are empty, lcs is 0.
					lcsMatrix[i][j] = 0;
				}	
				
				else if (X[i-1] == Y [j-1])
				{
					// if two chars X[i],Y[j] are equals lcs is 1 + lcs(i-1]j-1) i.e this value is already 
					// pre computed retrieve this value from table.
					lcsMatrix[i][j] = lcsMatrix[i -1][j -1] + 1;
				}
				else
				{
					// if two chars are not equal then lcs is max(lcs(i,j-1),lcs(i-1,j))
					// these values are already computed so retrie these values from table.
					lcsMatrix[i][j] =  
						Integer.max(
							lcsMatrix[i-1][j],
							lcsMatrix[i][j-1]);
				}
			}
		}
		
		 printLCS(lcsMatrix,X,Y);
		return lcsMatrix[m][n];
		
	}
	
	
	private static void printLCS(int[][] lcsMatrix ,char[] X, char[] Y)
	{
		int i = lcsMatrix.length - 1;
		int j = lcsMatrix[0].length -1;
		
		char[] lcs = new char[lcsMatrix[i][j]];
		
		int index = lcs.length -1;
		while (i > 0 && j > 0)
		{
			if (lcsMatrix[i][j] == lcsMatrix[i-1][j])
			{
				 i = i -1;
			}
			else if (lcsMatrix[i][j] == lcsMatrix[i][j-1])
			{
				j = j -1;
			}
			else
			{
				lcs[index] = X[i -1];
				index = index -1;
				i = i -1;
				j = j-1;
			}	
		}
		System.out.println(lcs);
	}

	public static void main(String[] args) {
		
		/*String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		System.out.println("Length of LCS is" + " " + lcsWithDP(X, Y, m, n));*/
		
		try(Scanner in = new Scanner(System.in))
		{
	        int testCount = in.nextInt();
	        
	        for (int i =0 ;i < testCount ; i++)
	        {
	        	int n1 = in.nextInt();
	        	int n2 = in.nextInt();
	        	String s1 = in.nextLine();
	        	while(s1.isEmpty())
	        	{
	        		s1 = in.nextLine();
	        	}
	        	String s2 = in.nextLine();
	        	while(s2.isEmpty())
	        	{
	        		s2 = in.nextLine();
	        	}
	        	
	    		System.out.println(lcsWithDP(s1.toCharArray(),s2.toCharArray(),n1,n2));
	        }
		}
	}
}
