package com.sri.algo.dp.cp;

/**
 * 
 *  Given a string s, find the longest palindromic substring in s. 
 *  You may assume that the maximum length of s is 1000.

	Example:
	
	Input: "babad"
	Output: "bab"
	Note: "aba" is also a valid answer.
	 
	Example:
	Input: "cbbd"
	Output: "bb"
	
	Time Complexity : O(n*n).
 *
 */
public class LongestPalindromeInAString {
	
	private int startPostion;
	private int maxLen = Integer.MIN_VALUE;
	
	public String longestPalindrome(String s)
	{
	     int n = s.length();
	     if(n < 2)
	     {
	    	 return s;
	     }
	     
		 for(int i=0 ;i < n-1;i++)
		 {
			 extendPalindrome(s,i,i); // Look for odd length palindrome with i as centre.
			 extendPalindrome(s,i,i + 1); // Look for even length palindrome with i as centre.
		 }
		 
		 return s.substring(startPostion, startPostion + maxLen);
		 
	 }
	 
	 private void extendPalindrome(String s,int l,int h)
	 {
		 
		 while(l>=0 && h < s.length() && s.charAt(l) == s.charAt(h))
		 {
			 l--;
			 h++;
		 }
		 
		 if (maxLen < h - l -1)
		 {
			 maxLen = h - (l + 1);
			 startPostion = l + 1;	 
		 }
		 
	 }
	 
	
	public static void main(String[] args) {
		
		LongestPalindromeInAString lp = new LongestPalindromeInAString();
		
		System.out.println(lp.longestPalindrome("aaaabbaa"));
		
	}

}
