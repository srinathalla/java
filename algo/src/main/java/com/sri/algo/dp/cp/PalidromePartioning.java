package com.sri.algo.dp.cp;


/**
 * Given a string, a partitioning of the string is a palindrome partitioning if every substring
 * of the partition is a palindrome. 
 * 
 * For example, “aba|b|bbabb|a|b|aba” is a palindrome 
 * partitioning of “ababbbabbababa”. 
 * Determine the fewest cuts needed for palindrome 
 * partitioning of a given string. For example, minimum 3 cuts are needed for “ababbbabbababa”. 
 * The three cuts are “a|babbbab|b|ababa”. If a string is palindrome, then minimum 0 cuts are needed. 
 * If a string of length n containing all different characters, then minimum n-1 cuts are needed.
 * 
 * @author salla
 *
 */
public class PalidromePartioning {
	
	/**
	 * Recursive solution. Time Complexity exponential.
	 * 
	 * @param input
	 * @param i
	 * @param j
	 * @return
	 */
	public static int minCuts(String input,int i,int j)
	{	
		if (i == j)
		{
			return 0;
		}
		
		if (isPalidrome(input,i,j))
		{
			return 0;
		}
		
		int minVal = Integer.MAX_VALUE;
		for (int k= i; k < j ;k++)
		{
			
			minVal = Integer.min(
					 minVal , 
					(minCuts(input,  i, k) + 1 +  minCuts(input,  k+1, j)));
		}
		
		return minVal;
	}
	
	
	/**
	 * Fill the table in bottom up manner.
	 * 
	 * 
	 * @param input
	 * @return
	 */
	private static int minCutsWithDP(String input)
	{
		int n = input.length();
		
		int[][] c = new int[n][n];
		boolean[][] p = new boolean[n][n];
		
		// Min cuts required for a string of length 1 is 0
		for (int i =0; i < n ; i++)
		{
			c[i][i] = 0;
			p[i][i] = true;
		}
		
		for (int l = 2 ;l <= n ; l++)
		{	
			for (int i = 0; i < n - l + 1 ;i++)
			{		
				int j = i + l -1; 
				
				if (l == 2)
				{	
					p[i][j] = input.charAt(i) == input.charAt(j);	
				}
				else
				{
					p[i][j] = input.charAt(i) == input.charAt(j) && p[i + 1][j -1];
				}
				
				
				if (p[i][j])
				{
					c[i][j] = 0;
				}
				else
				{
					c[i][j] = Integer.MAX_VALUE;			
					for (int k=i ;k <j;k++)
					{
						c[i][j] = Integer.min(
							c[i][j], (c[i][k] + 1 + c[k +1][j]));
					}
				}		
			}	
		}
		
		return c[0][n-1];
	}
	
	private static boolean isPalidrome(String s,int i,int j)
	{
		while(i != j)
		{
			if(s.charAt(i) != s.charAt(j))
			{
				return false;
			}
			
			i++;
			j--;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		String s = "ababbbabbababa";
		System.out.println(minCuts(s, 0, s.length() -1));	
		
		System.out.println(minCutsWithDP(s));
	}

}
