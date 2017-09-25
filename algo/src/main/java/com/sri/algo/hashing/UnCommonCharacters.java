package com.sri.algo.hashing;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class UnCommonCharacters {
	
	/**
	 * Time Complexity : O(n+m).
	 * Auxillary Spacce : O(n+m).
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static String getUnCommonchars(String s1,String s2)
	{
		Set<Character> charsS1 = new HashSet<>();
		
		Set<Character> charsS2 = new HashSet<>();
		
		for (char ch : s1.toCharArray())
		{
			charsS1.add(ch);
		}
		
		for (char ch : s2.toCharArray())
		{
			charsS2.add(ch);
		}
		
		Iterator<Character> iter = charsS1.iterator();
		while (iter.hasNext())
		{
			Character ch = iter.next();
			if (charsS2.contains(ch))
			{
				charsS2.remove(ch);
				iter.remove();
			}
		}
		
		Set<Character> unCommonChars = new TreeSet<>();
		unCommonChars.addAll(charsS1);
		unCommonChars.addAll(charsS2);
		
		StringBuilder sb = new StringBuilder();
		
		for (Character ch : unCommonChars)
		{
			sb.append(ch);
		}
		
		return sb.toString();
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(getUnCommonchars("characters" , "alphabets"));
		
	}

}
