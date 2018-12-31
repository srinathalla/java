package com.sri.algo.backtrack.leet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern2 {
	
	public boolean wordPatternMatch(String pattern, String str) {
	    Map<Character, String> map = new HashMap<>();
	    Set<String> set = new HashSet<>();
	    
	    return isMatch(str, 0, pattern, 0, map, set);
	  }
	  
	  boolean isMatch(String str, int i, String pat, int j, Map<Character, String> map, Set<String> set) {
		
		if (i == str.length() && j == pat.length()) {
			return true;
		}

		if (i == str.length() || j == pat.length()) {
			return false;
		}

		char ch = pat.charAt(j);

		if (map.containsKey(ch)) {
			String match = map.get(ch);

			if (!str.startsWith(match,i)) {
				return false;
			}

			return isMatch(str, i + match.length(), pat, j + 1, map, set);
		}
		
		for(int k=i; k < str.length(); k++)
		{
			String match = str.substring(i, k + 1);
			
			if (set.contains(match))
			{
				continue;
			}
			
			set.add(match);
			map.put(ch, match);
			
			if (isMatch(str, k + 1, pat, j + 1, map, set))
			{
				return true;
			}
			
			set.remove(match);
			map.remove(ch);
			
		}
		
		return false;
	  }
	  
	public static void main(String[] args) {
		
		
		WordPattern2 wp2 = new WordPattern2();
		/*
		System.out.println(
			wp2.wordPatternMatch("abab", "redblueredblue"));
		
		
		System.out.println(
				wp2.wordPatternMatch("aaaa","asdasdasdasd"));*/
		
		System.out.println(
				wp2.wordPatternMatch("ab","aa"));
		
	}

}
