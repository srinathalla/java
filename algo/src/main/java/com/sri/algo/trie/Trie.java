package com.sri.algo.trie;


/**
 * Trie is an efficient information reTrieval data structure. 
 * Using Trie, search complexities can be brought to optimal limit (key length). 
 * If we store keys in binary search tree, a well balanced BST will need time 
 * proportional to M * log N, where M is maximum string length and N is number of 
 * keys in tree.Using Trie, we can search the key in O(M) time. 
 *
 *
 */
public class Trie {

	private TrieNode root = null;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String input) {
		int len = input.length();

		TrieNode curr = root;
		for (int level = 0; level < len; level++) {
			
			int index = input.charAt(level) - 'a';		
			if (curr.getChildren()[index] == null)
			{
				curr.getChildren()[index] = new TrieNode();
			}		
			curr = curr.getChildren()[index];
		}
		
		curr.setEnd(true);
	}
	
	public boolean search(String input) 
	{
		int len = input.length();

		TrieNode curr = root;
		for (int level = 0; level < len; level++) {
			
			int index = input.charAt(level) - 'a';		
			if (curr.getChildren()[index] == null)
			{
				return false ;
			}
			
			curr = curr.getChildren()[index];
		}
		
		return curr.isEnd();
	}
	
	public static void main(String[] args) {
		
		Trie trie = new Trie();
		
		
		trie.insert("raman");
		trie.insert("raj");
		trie.insert("raghu");
		trie.insert("sri");
		
		System.out.println(trie.search("raj"));
		System.out.println(trie.search("raghu"));
		System.out.println(trie.search("sri"));
		System.out.println(trie.search("srinu"));
		
		
	}

}
