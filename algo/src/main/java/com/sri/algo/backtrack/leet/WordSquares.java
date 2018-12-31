package com.sri.algo.backtrack.leet;

import java.util.ArrayList;
import java.util.List;

import com.sri.algo.trie.Trie;
import com.sri.algo.trie.TrieNode;

/**
 * 	Given a set of words (without duplicates), find all word squares you can build from them.

	A sequence of words forms a valid word square if the kth row and column read the exact same string, 
	where 0 ≤ k < max(numRows, numColumns).
	
	For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word 
	reads the same both horizontally and vertically.
	
	b a l l
	a r e a
	l e a d
	l a d y
	Note:
	There are at least 1 and at most 1000 words.
	All words will have the exact same length.
	Word length is at least 1 and at most 5.
	Each word contains only lowercase English alphabet a-z.
	Example 1:
	
	Input:
	["area","lead","wall","lady","ball"]
	
	Output:
	[
	  [ "wall",
	    "area",
	    "lead",
	    "lady"
	  ],
	  [ "ball",
	    "area",
	    "lead",
	    "lady"
	  ]
	]
	
	Explanation:
	The output consists of two word squares. The order of output does not matter (just the order
	of words in each word square matters).
	 * @author salla
 *
 */
public class WordSquares {
	
	class TrieNode {
        List<String> startWith;
        TrieNode[] children;

        TrieNode() {
            startWith = new ArrayList<>();
            children = new TrieNode[26];
        }
    }

    class Trie {
        TrieNode root;

        Trie(String[] words) {
          root = new TrieNode();
          
          for (String word: words)
          {
        	  TrieNode curr = root;
        	  for (char ch : word.toCharArray())
        	  {
        		 int idx = ch - 'a';  
        		 if(curr.children[idx] == null)
        		 {
        			 curr.children[idx] = new TrieNode();
        		 }
        		 curr.children[idx].startWith.add(word);
        		 curr = curr.children[idx];
        	  }
          }
        }

        List<String> findByPrefix(String prefix) {
            
        	List<String> ans = new ArrayList<>();
        	
        	TrieNode curr = root;
        	for (char ch : prefix.toCharArray())
        	{
        		int idx = ch - 'a';
        		if (curr.children[idx] == null)
        		{
        			return ans;
        		} 
        		curr = curr.children[idx];	
        	}
        	
        	ans.addAll(curr.startWith);
        	return ans;
        }
    }

    public List<List<String>> wordSquares(String[] words) {	
    	List<List<String>>  ans = new ArrayList<>();
    	
    	if(words == null || words[0].length() == 0)
    	{
    		return ans;
    	}
    	
    	List<String> ansBuilder = new ArrayList<>();
    	int len = words[0].length();
    	Trie trie = new Trie(words);
    	
    	for (String word : words)
    	{
    		ansBuilder.add(word);
    		search(len, trie, ans, ansBuilder);
    		ansBuilder.remove(ansBuilder.size() -1); 		
    	}	
    		
    	return ans; 
    }

    private void search(int len, Trie tr, List<List<String>> ans,
            List<String> ansBuilder) {
       
    	if (ansBuilder.size() == len)
    	{
    		ans.add(new ArrayList<>(ansBuilder));
    		return;
    	}
    	
    	StringBuilder pb = new StringBuilder();
    	int idx = ansBuilder.size();
    	for(String s : ansBuilder)
    	{
    		pb.append(s.charAt(idx));
    	}
    	
    	List<String> res = tr.findByPrefix(pb.toString());
    	
    	for (String s : res)
    	{
    		ansBuilder.add(s);
    		search(len, tr, ans, ansBuilder);
    		ansBuilder.remove(ansBuilder.size() -1);
    	}
    }
    
    public static void main(String[] args) {
    	
    	WordSquares wordSquares = new WordSquares();
    	
    	System.out.println(
			wordSquares.wordSquares(new String[] {"area","lead","wall","lady","ball"}));
		
	}

}
