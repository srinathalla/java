package com.sri.algo.hashing;

import java.util.ArrayList;
import java.util.List;

/**
 * A string S of lowercase letters is given. We want to partition this string into as many parts 
 * as possible so that each letter appears in at most one part, and return a list of integers 
 * representing the size of these parts.

   Example 1:
   Input: S = "ababcbacadefegdehijhklij"
   Output: [9,7,8]
	
   Explanation:
   The partition is "ababcbaca", "defegde", "hijhklij".
   This is a partition so that each letter appears in at most one part.
   A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
	
   Note:
   S will have length in range [1, 500].
   S will consist of lowercase letters ('a' to 'z') only.
 * @author salla
 *
 */
public class PartitionLabels 
{
	
	
	/**
	 * Two pass solution.
	 * 
	 * 1) Store the last index of each character.
	 * 2) Check all the characters of the current sub string lie in the range of the current char 
	 * if so add the current sub string length to the list. and move first pointer to i + 1;
	 * 
	 * .T.C : O(2*n)
	 * 
	 * @param s
	 * @return
	 */
	    public List<Integer> partitionLabels(String s) 
	    {
	    	List<Integer> partionLen = new ArrayList<>();
	    	int[] charPos = new int[26];
	    	
	    	int n = s.length();	
	    	if (n == 0)
	    	{
	    		return partionLen;
	    	}
	    	
	    	for (int i = 0 ;i< n ;i++)
	    	{
	    		char ch = s.charAt(i);
	    		charPos[ch - 'a'] = i; // Store last Index of each character.
	    	}
	    	
	    	int last = 0, first = 0;
	    	for (int i = 0 ;i< n ;i++)
	    	{
	    		char ch = s.charAt(i);
	    		last = Integer.max(last, charPos[ch - 'a']);
	    		
	    		if (last == i)
	    		{
	    			partionLen.add(last - first + 1);
	    			first = i + 1;
	    		}
	    	}
	    	
	    	return partionLen; 
	    }
	 
	
	/**
	 * Two pass solution.
	 * 
	 * T.C O(2*n) where n is the length of String.
	 * 
	 * Idea here is same as above but we traverse from back to front and store the 
	 * first index of each char.
	 * 
	 * @param s
	 * @return
	 */
    public List<Integer> partitionLabelsByStoringStartIndex(String s) 
    {
    	List<Integer> partionLen = new ArrayList<>();
    	int[] charPos = new int[26];
    	
    	int n = s.length();
    	if (n == 0)
    	{
    		return partionLen;
    	}
    	
    	for (int i = n-1 ;i >= 0;i--)
    	{
    		char ch = s.charAt(i);
    		charPos[ch - 'a'] = i; // Store first Index of each character.
    	}
    	
    	int last = n-1, first = n-1;
    	for (int i = n-1 ;i >= 0;i--)
    	{
    		char ch = s.charAt(i);	
    		first = Integer.min(first, charPos[ch - 'a']);
    		
    		if (first == i)
    		{
    			partionLen.add(0,last - first + 1);
    			last = i -1;
    		}
    	}
    	
    	return partionLen;  
    }

    
    public static void main(String[] args)
    {	
    	String S = "ababcbacadefegdehijhklij";
    	PartitionLabels pl = new PartitionLabels();
    	
    	System.out.println(pl.partitionLabels(S));
	}
}
