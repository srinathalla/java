package com.sri.algo.string.leet;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning
 * it to two non-empty substrings recursively.

	Below is one possible representation of s1 = "great":
	
	    great
	   /    \
	  gr    eat
	 / \    /  \
	g   r  e   at
	           / \
	          a   t
	          
   To scramble the string, we may choose any non-leaf node and swap its two children.

    For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
	
	    rgeat
	   /    \
	  rg    eat
	 / \    /  \
	r   g  e   at
	           / \
	          a   t
 * @author salla
 *
 */
public class ScrambledString {
	
	public boolean isScramble(String s1, String s2) {
		
		  if(s1==s2)
	            return true;
	            
	        int len = s1.length();
	        int[] count = new int[26];
	        
	        for(int i=0; i < len; i++)
	        {
	            count[s1.charAt(i) - 'a']++;
	            count[s2.charAt(i) - 'a']--;
	        }
	        
	        for(int i=0; i<26; i++)
	        {
	            if(count[i]!=0)
	            {
	                return false;
	            }
	        }
	        
	        for(int i=1; i<=len-1; i++)
	        {
	            if( isScramble(s1.substring(0,i), s2.substring(0,i)) && 
	            		isScramble(s1.substring(i), s2.substring(i)))
	            {
	                return true;
	            }
	            if( isScramble(s1.substring(0,i), s2.substring(len-i)) && 
	            		isScramble(s1.substring(i), s2.substring(0,len-i)))
	            {
	                return true;
	            }
	        }
	        return false;

	}
	
	public static void main(String[] args) {
		
		ScrambledString scrambledString = new ScrambledString();
		
		System.out.println(
			scrambledString.isScramble("great", "rgeat"));
		
	}

}
