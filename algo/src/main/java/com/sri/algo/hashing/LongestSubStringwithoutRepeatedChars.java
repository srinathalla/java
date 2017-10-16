package com.sri.algo.hashing;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substrings without repeating characters
 * for “ABDEFGABEF” are “BDEFGA” and “DEFGAB”, with length 6.
 * 
 *
 */
public class LongestSubStringwithoutRepeatedChars {

	public static int longestSubString(String input) {

		Set<Character> charSet = new LinkedHashSet<>();

		int len = 1;

		int i = 0;
		while (i < input.length()) {

			char ch = input.charAt(i);
			if (charSet.contains(ch)) {
				Iterator<Character> iter = charSet.iterator();
				while (iter.hasNext()) {
					if (iter.next() == ch) {
						iter.remove();
						break;
					} else {
						iter.remove();
					}
				}
			}
			charSet.add(ch);
			len = Integer.max(len, charSet.size());

			i++;
		}

		return len;
	}

	public static void main(String[] args) {

	/*	System.out.println(longestSubString("geeksforgeeks"));
		System.out.println(longestSubString("qwertqwer"));*/
		
		try (Scanner in = new Scanner(System.in)) {
			int testCount = in.nextInt();

			for (int i = 0; i < testCount; i++) {
			
				String s = in.nextLine();
				while (s.isEmpty()) {
					s = in.nextLine();
				}
				s.trim();
				
				System.out.print(longestSubString(s));

				System.out.println();

			}
		}
	}

}
