package com.sri.algo.trie;

public class TrieNode {

	private static final int ALPHABETS_SIZE = 26;

	private TrieNode[] children = new TrieNode[ALPHABETS_SIZE];

	private boolean isEnd = false;
	
	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public TrieNode[] getChildren() {
		return children;
	}

	

}
