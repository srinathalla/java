package com.sri.algo.hashing;

import java.util.HashSet;
import java.util.Set;

public class MinIndexedChar {
	
	/**
	 * Given a string str and another string patt. Find the character in patt that is present
	 * at the minimum index in str.If no character of patt is present in str then print
	 * ‘No character present’.
	 * 
	 * @param input
	 * @param text
	 * @return
	 */
	public static String minIndexedChar(String input, String text) 
	{		
		Set<Character> textCharsSet = new HashSet<>();
		
		for (char ch : text.toCharArray())
		{
			textCharsSet.add(ch);
		}
		
		for (char ch : input.toCharArray())
		{	
			if (textCharsSet.contains(ch))
			{
				return String.valueOf(ch);
			}
		}
		
		return "No character present";
	}
	
	public static void main(String[] args) {
		
		System.out.println(minIndexedChar("geeksforgeeks","set"));
		System.out.println(minIndexedChar("adcffaet","onkl"));
		
	}

}
