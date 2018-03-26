package com.sri.algo.hashing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substrings without repeating characters
 * for “ABDEFGABEF” are “BDEFGA” and “DEFGAB”, with length 6.
 * 
 *
 */
public class LongestSubStringwithoutRepeatedChars {

	/**
	 * Set based solution.
	 * 
	 * T.C : O(n).
	 * 2 pass solution.
	 * 
	 * @param input
	 * @return
	 */
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
	
	/**
	 * Map based solution.
	 * 
	 * @param s
	 * @return
	 */
	 public static int lengthOfLongestSubstring(String s) 
	 {
	    if(s == null || s.isEmpty())
	    {
	    	return 0;
	    }
	    
		 Map<Character, Integer> chars = new HashMap<>();
		 int j =0;
		 
		 int len = Integer.MIN_VALUE;
		 
		 for (int i =0 ;i < s.length() ;i++  )
		 {
			 char ch = s.charAt(i);
			 
			 if(chars.containsKey(ch))
			 {
				 j = Integer.max(j, chars.get(ch) + 1);	 
			 }	 
			 chars.put(ch,i);	
			 len = Integer.max(len, i -j + 1);
		 }
		 
		 return len;	 
	 }
	 

		/**
		 * Array based solution.
		 * 
		 * @param s
		 * @return
		 */
		 public static int lengthOfLongestSubstringWithArray(String s) 
		 {
			    if (s == null || s.isEmpty())
			    {
			    	return 0;
			    }
			    
				 int[] chars = new int[256];
				 for (int i =0 ;i <= 255 ;i++)
				 {
					 chars[i] = -1;
				 }
				 int j =0;
				 
				 int len = Integer.MIN_VALUE;
				 
				 for (int i =0 ;i < s.length() ;i++  )
				 {
					 char ch = s.charAt(i);
					 int asciiVal = (int)ch;
					 
					 if(chars[asciiVal] != -1)
					 {
						 j = Integer.max(j, chars[asciiVal] + 1);	 
					 }	 
					 chars[asciiVal] = i;	
					 len = Integer.max(len, i -j + 1);
				 }
				 
				 return len;
		 }


	public static void main(String[] args) {

		System.out.println(longestSubString("geeksforgeeks"));
		System.out.println(longestSubString("qwertqwer"));
		
		System.out.println(lengthOfLongestSubstring("geeksforgeeks"));
		System.out.println(lengthOfLongestSubstring("qwertqwer"));
		
		System.out.println(lengthOfLongestSubstringWithArray("geeksforgeeks"));
		System.out.println(lengthOfLongestSubstringWithArray("qwertqwer"));
		
		/*try (Scanner in = new Scanner(System.in)) {
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
		}*/
	}

}
