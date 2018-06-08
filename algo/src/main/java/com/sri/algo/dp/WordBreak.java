package com.sri.algo.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words. 
 * You may assume the dictionary does not contain duplicate words.

   For example, given
	s = "leetcode",
	dict = ["leet", "code"].

	Return true because "leetcode" can be segmented as "leet code".
 * @author salla
 *
 */
public class WordBreak {
	
	/**
	 * Recursive approach.
	 * Will exceed time limit.
	 * 
	 * @param s
	 * @param wordDict
	 * @return
	 */
	 public boolean wordBreakWithRecursion(String s, List<String> wordDict)
	 {   
		 if (s== null || s.length() == 0)
		 {
			 return false;
		 }
		 
		 Set<String> dict = new HashSet<>(wordDict);
		 return wordBreak(s,0,dict); 
	 }
	 
	 private boolean wordBreak(String s,int l, Set<String> dict)
	 {
		 if (l < s.length())
		 { 
			 if (dict.contains(s.substring(l)))
			 {
				 return true;
			 }
		
			 for (int i = l; i < s.length() -1;i++)
			 {
				 if (dict.contains(s.substring(l, i + 1)) && wordBreak(s,i +1,dict))
				 {
					 return true;
				 }
			 }
		 }
		 return false;
	 }
	 
	 /**
	  * DP Appraoch.
	  * Bottom Up solution.
	  * 
	  * T.C : O(n * n).
	  * 
	  * @param s
	  * @param wordDict
	  * @return
	  */
	 public boolean wordBreak(String s, List<String> wordDict)
	 {   
		 int n = s.length();
		 boolean[] res = new boolean[n + 1];
		 res[0] = true;
		 
		 Set<String> dict = new HashSet<>(wordDict);
		 
		 for (int i=1; i<=n; i++)
		 {
			 
			 for (int j=0;j < i;j++)
			 {
				 
				 if(res[j] && dict.contains(s.substring(j,i)))
				 {
					 res[i] = true;
					 break;
				 }
			 }
		 }
		 
	    return res[n];
	 }
	 
	 public static void main(String[] args) 
	 {
		 
		 WordBreak wb = new WordBreak();
		 
		 System.out.println(
			 wb.wordBreak(
					 "leetcode", 
					  Arrays.asList(new String[] {"leet", "code"})));
		 
		 System.out.println(
				 wb.wordBreak(
						 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", 
						  Arrays.asList(new String[] 
							  {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"})));
		
	}

}
