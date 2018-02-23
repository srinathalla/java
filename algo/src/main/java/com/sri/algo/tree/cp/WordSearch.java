package com.sri.algo.tree.cp;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in
 * the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once in a word.
 * 
 * For example, Given words = ["oath","pea","eat","rain"] and
 * 
 * board =
 * 
 * [ ['o','a','a','n'], ['e','t','a','e'], ['i','h','k','r'], ['i','f','l','v']
 * ]
 * 
 * Return ["eat","oath"].
 * 
 * @author salla
 *
 */
public class WordSearch {

	static class TrieNode {
		TrieNode[] children = new TrieNode[26];
		boolean isEnd;
		String value;
	}

	private TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();

		for (String word : words) {
			char[] chars = word.toCharArray();

			TrieNode curr = root;
			for (char ch : chars) {
				int index = ch - 'a';

				if (curr.children[index] == null) {
					curr.children[index] = new TrieNode();
				}

				curr = curr.children[index];
			}
			curr.isEnd = true;
			curr.value = word;
		}

		return root;
	}

	public List<String> findWords(char[][] board, String[] words) {

		int n = board.length;
		int m = board[0].length;

		List<String> matchedWords = new ArrayList<>();
		TrieNode root = buildTrie(words);


		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				
				dfs(board, root, i, j, n, m, matchedWords);

			}
		}

		return matchedWords;

	}

	private boolean isInRange(int i, int j, int n, int m) {

		return i >= 0 && i < n && j >= 0 && j < m;
	}

	public void dfs(char[][] board, TrieNode root, int i, int j, int n, int m,
			List<String> matchedWords) {
		
		char ch = board[i][j];
		if(root.children[ch - 'a'] == null)
		{
			return;
		}
		
		board[i][j] = '@';
		
		root = root.children[ch - 'a'];
		if (root.isEnd) {	
			matchedWords.add(0, root.value);
			root.isEnd = false;	 // This is to avoid duplicates Strings during search.
		}

		int[] adjRows = new int[] { -1, 0, 0, 1 };
		int[] adjCol = new int[] { 0, -1, 1, 0 };

		for (int l = 0; l < 4; l++) {
			int adjR = adjRows[l] + i;
			int adjC = adjCol[l] + j;

			if (isInRange(adjR, adjC, n, m) && board[adjR][adjC] != '@') {
				dfs(board, root, adjR, adjC, n, m, matchedWords);

			}
		}

		// Back track.
		board[i][j] = ch;

	}

	public static void main(String[] args) {

		long init = System.currentTimeMillis();
		WordSearch ws = new WordSearch();
		
		String[] words = new String[] { "oath", "pea", "eat", "rain" };
		char[][] board = new char[][] { { 'a', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		System.out.println(ws.findWords(board, words));

		String[] words1 = new String[] { "a" };
		char[][] board1 = new char[][] { { 'a', 'a' } };
		System.out.println(ws.findWords(board1, words1));
		
		String[] words3 = new String[] { "acdb" };
		char[][] board3 = new char[][] { { 'a', 'b'}, { 'c', 'd' } };
		System.out.println(ws.findWords(board3, words3));
		
		long finalTime = System.currentTimeMillis();
		
		System.out.println("Time Taken : " + (finalTime - init));

	}

}
