package com.sri.algo.dp.cp;

import com.sri.algo.dp.LongestCommonSubSequence;

/**
 * Given a string, find the minimum number of characters to be inserted to convert it to 
 * palindrome.
   
    For Example:
	ab: Number of insertions required is 1. bab or aba
	aa: Number of insertions required is 0. aa
	abcd: Number of insertions required is 3. dcbabcd
	
 * 
 *
 */
public class MinInsertionsToMakeAPalindrome {
	
	
	public static int minInsertions (String input)
	{
		
		char[] in1 = input.toCharArray();
		int n = in1.length;
		
		char[] reversedInput = new char[in1.length];
		
		int j=0;
		for(int i= n-1; i>=0; i--)
		{
			reversedInput[j] = in1[i];
			j++;
		}
		
		int lcs = LongestCommonSubSequence.lcsWithDP(in1, reversedInput, n, n);
		
		return n - lcs;
	}
	
	public static void main(String[] args) {
		
		System.out.println(minInsertions("ab"));
		System.out.println(minInsertions("aa"));
		System.out.println(minInsertions("abcd"));
		
	}

}
