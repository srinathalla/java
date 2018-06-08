package com.sri.algo.backtrack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * Only one letter can be changed at a time. Each transformed word must exist in
 * the word list. Note that beginWord is not a transformed word. For example,
 * 
 * Given: beginWord = "hit" endWord = "cog" wordList =
 * ["hot","dot","dog","lot","log","cog"]
 * 
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * @author salla
 *
 */
public class WordLadder {

	/**
	 * Idea is to use bfs.
	 * 
	 * 
	 * 
	 * T.C is (26*n*L) => O(n*L)
	 * n : dictionary size.
	 * L is length of each word.
	 * 
	 * ToDO : Need to try two way BFS approach.
	 *
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
	public int ladderLength(String beginWord, String endWord, List<String> wordList) 
	{
		Set<String> dict = new HashSet<>(wordList);
		Set<String> visited = new HashSet<>();
		
		visited.add(beginWord);
	    Queue<String> q = new LinkedList<>();
	    q.add(beginWord);
	    
	    int level = 1;
	    while (!q.isEmpty())
	    {
	    	// Process nodes at each level of the tree.
	    	for (int nC = q.size(); nC > 0; nC--)
	    	{
		    	String w = q.poll(); 	
		    	if (w.equals(endWord))
		    	{
		    		return level;
		    	}
		    	
		    	char[] chars = w.toCharArray();
		    	
		    	// Each character of the word is replaced by 26 lower case chars(i.e a..... z).
		    	for (int i = 0; i < w.length() ;i ++)
		    	{
		    		// Store original character.
		    		char orig = chars[i];
		    		for (char ch = 'a'; ch <= 'z'; ch++)
		    		{
		    			chars[i] = ch;
		    			String adjW = String.valueOf(chars);
		    			
		    			System.out.println(adjW + " q :" + q);
		    			
		    			if (dict.contains(adjW) && !visited.contains(adjW))
		    			{
		    				visited.add(adjW); // This to ensure each word in dictionary is processed only once.
		    				q.offer(adjW); // Add only adjacent words present in dictionary.
		    			}
		    		}
		    		
		    		// Replace original character back in its position.
		    		chars[i] = orig;
		    	}
	    	}	
	    	// Move to next level
	    	level++;
	    }
	
		return 0;
	}
	
	public static void main(String[] args) 
	{
		
		WordLadder wl = new WordLadder();
		
		System.out.println(
			wl.ladderLength("hit", "cog", 
				Arrays.asList(new String[] { "hot","dot","dog","lot","log","cog"})));
	}

}
