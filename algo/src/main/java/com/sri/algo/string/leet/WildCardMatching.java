package com.sri.algo.string.leet;


/**
 *  Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

	'?' Matches any single character.
	'*' Matches any sequence of characters (including the empty sequence).
	The matching should cover the entire input string (not partial).
 * @author salla
 *
 */
public class WildCardMatching {
	
	// T.C O(m + n)
	 public boolean isMatch(String str, String pattern) {
		 
		int p = 0, s = 0, starIdx = -1, match = -1;

		while (s < str.length()) {

			// increase both pointers
			if (p < pattern.length() && (pattern.charAt(p) == '?' || pattern.charAt(p) == str.charAt(s))) {
				p++;
				s++;
			}

			// increment only p
			else if (p < pattern.length() && pattern.charAt(p) == '*') {
				starIdx = p;
				match = s;
				p++;
			}

			// increment only s
			else if (starIdx != -1) {
				p = starIdx + 1;
				match++;
				s = match;
			}

			// return false
			else {
				return false;
			}

		}
		
		while(p < pattern.length() && pattern.charAt(p) == '*')
		{
			p++;
		}
		
		return p == pattern.length();

	}
	 
	 public static void main(String[] args) {
		 
		 WildCardMatching wildCardMatching = new WildCardMatching();
		 
		 System.out.println(
			 wildCardMatching.isMatch("aa", "a"));
		 System.out.println(
				 wildCardMatching.isMatch("aa", "*"));
		 System.out.println(
				 wildCardMatching.isMatch("adceb", "a*b"));
		
	}

}
