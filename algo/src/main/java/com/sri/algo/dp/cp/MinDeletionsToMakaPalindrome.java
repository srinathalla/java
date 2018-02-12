package com.sri.algo.dp.cp;


/**
 * Given a string of size ‘n’. The task is to remove or delete minimum number of characters
 * from the string so that the resultant string is palindrome.

   Note: The order of characters should be maintained.

	Examples:
	
	Input : aebcbda
	Output : 2
	Remove characters 'e' and 'd'
	Resultant string will be 'abcba'
	which is a palindromic string
	
	Input : geeksforgeeks
	Output : 8
	
 * @author salla
 *
 */
public class MinDeletionsToMakaPalindrome {
	
	
	public static int minDeletions(char[] input,int n)
	{	
		int lpss = longestPalindromeSubSequence(input,n);
			
		return n - lpss;	
	}
	
	
	private static int longestPalindromeSubSequence(char[] input,int n)
	{
		
		char[] reversedInput = new char[input.length];
		
		int j=0;
		for(int i= n-1; i>=0; i--)
		{
			reversedInput[j] = input[i];
			j++;
		}
		
		// longestCommonSubSequence(input,reversedInput, n-1, n-1);
		
		return longestCommonSubSequenceWithDP(input,reversedInput, n, n);
	}
	
	public static int longestCommonSubSequence(char[] input1, char[] input2,int n,int m)
	{
		
		if (n == 0 || m == 0)
		{
			return 0;
		}
		
		if (input1[n] == input2[m])
		{
			return 1 + longestCommonSubSequence(input1, input2, n-1, m-1);
		}
		
		return Integer.max(
				longestCommonSubSequence(input1, input2, n, m-1), 
				longestCommonSubSequence(input1, input2, n-1, m));
		
	}
	
	/**
	 * Time Complexity : O(n)(m);
	 * Auxillary Space : O(n)(m) 
	 * @param input1
	 * @param input2
	 * @param n
	 * @param m
	 * @return
	 */
	private static int longestCommonSubSequenceWithDP(char[] input1, char[] input2,int n,int m)
	{
		int[][] table = new int[n + 1][m + 1];
				
		for(int i =0 ;i <= n ;i++)
		{		
			for (int j=0; j<=m ; j++)
			{		
				if (i == 0 || j == 0)
				{
					table[i][j] = 0;
				}
				else if(input1[i -1] == input2[j-1])
				{
					table[i][j] = table[i - 1][j - 1] + 1;
				}
				else
				{
					table[i][j] = Integer.max(
						table[i][j-1], 
						table[i-1][j]);
				}
			}
		}
		
		return table[n][m];
		
	}
	
	public static void main(String[] args) {
		
		
		String input1 = "aebcbda";
		String input2 = "geeksforgeeks";
			
		System.out.println(MinDeletionsToMakaPalindrome.minDeletions(input1.toCharArray(), input1.length()));
		System.out.println(MinDeletionsToMakaPalindrome.minDeletions(input2.toCharArray(), input2.length()));
		
	}

}
