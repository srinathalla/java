package com.sri.algo.string;

public class LongestPalidromeInString {
	
	public static int longestPalindrome(String str)
	{
		char[] reverseStr = new char[str.length()];
		
		int i = str.length() -1;
		int index = 0;
		while(i >=0 )
		{
			reverseStr[index] = str.charAt(i);
			i--;
			index++;
		}
		
		return 
			LongestCommonSubString.getLongestCommonSubStr(str, String.valueOf(reverseStr));
	}
	
	public static void main(String[] args) {
		
		System.out.println(longestPalindrome("forgeeksskeegfor"));
		
	}

}
