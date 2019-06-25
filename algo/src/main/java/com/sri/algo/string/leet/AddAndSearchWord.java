package com.sri.algo.string.leet;

public class AddAndSearchWord {
	
	TrieNode root = new TrieNode();
	static class TrieNode
	{
		TrieNode[]  next = new TrieNode[26];
		String word = "";
	}
	
	 /** Adds a word into the data structure. */
    public void addWord(String word) {
    	
    	TrieNode curr = root;
    	for (char ch : word.toCharArray())
    	{	
    		if(curr.next[ch - 'a'] == null)
    		{
    			curr.next[ch - 'a'] = new TrieNode();
    		}	
    		curr = curr.next[ch - 'a'];
    	}
    	
    	curr.word = word;
        
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        
    	return search(word, 0, root);
    }
    
    private boolean search(String word, int idx,TrieNode curr)
    {
    	if(idx == word.length())
    	{
    		return curr.word != "";
    	}
    	
    	if (word.charAt(idx) != '.')
    	{
    		return curr.next[word.charAt(idx) - 'a'] != null && search(word, idx + 1, curr.next[word.charAt(idx) - 'a']);
    	}
    	else
    	{
    		
    		for (TrieNode node : curr.next)
    		{
    			if(node != null)
    			{
    				if(search(word, idx +1, node))
    				{
    					return true;
    				}
    			}
    		}
    	}
    	
    	
    	return false;
    	
    }
    
    public static void main(String[] args) {
    	
    	AddAndSearchWord addAndSearchWord  =new AddAndSearchWord();
    	
    	addAndSearchWord.addWord("bad");
    	addAndSearchWord.addWord("dad");
    	addAndSearchWord.addWord("mad");
    	
    	System.out.println(addAndSearchWord.search("pad"));
    	System.out.println(addAndSearchWord.search("bad"));
    	System.out.println(addAndSearchWord.search(".ad"));
    	System.out.println(addAndSearchWord.search("b.."));
		
	}

}
