package com.sri.algo.backtrack;

import java.util.List;

public class WordLadder2 
{
	
	private static class TrieNode
	{
		TrieNode[] next = new TrieNode[26];
		String word;
	}
	
	/*public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) 
	{
		
		TrieNode root = buildTrie(wordList);
		
	   
        
    }*/
	
	private void fillLadders(String beginWord,String endWord, TrieNode root)
	{
		
	}
	
	
	private TrieNode buildTrie(List<String> wordList)
	{
		TrieNode root = new TrieNode();
		for (String word : wordList)
		{
			TrieNode current = root;
			for (char ch : word.toCharArray())
			{
				int index = ch - 'a';
				if(current.next[index] == null)
				{
					current.next[index] = new TrieNode();
				}
				
				current = current.next[index];
			}
			current.word = word;	
		}
		
		return root;
	}

}
