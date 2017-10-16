package com.sri.algo.graph.cp;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class WordBoggle {

	public static Set<String> allWords(char[][] matrix, int N, int M, String[] dictionary) {

		boolean[][] visited = new boolean[N][M];

		Set<String> words = new TreeSet<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(i, j, N, M, matrix, visited, "" + matrix[i][j], dictionary, words);
			}
		}

		return words;
	}

	private static void addIfPresentInDictionary(String word, String[] dictionary, Set<String> wordsSet) {
		if (word == null || word.isEmpty()) {
			return;
		}

		for (String s : dictionary) {
			if (s.equals(word)) {

				wordsSet.add(word);
				break;

			}
		}
	}

	private static boolean isValid(int i, int j, int N, int M) {
		return i >= 0 && i < N && j >= 0 && j < M;
	}

	public static void dfs(int i, int j, int N, int M, char[][] matrix, boolean[][] visited, String s,
			String[] dictionary, Set<String> words) {

		visited[i][j] = true;

		addIfPresentInDictionary(s, dictionary, words);

		// all 8 moves possible.
		int[] row = new int[] { 0, 0, -1, -1, -1, 1, 1, 1 };
		int[] col = new int[] { -1, 1, 0, -1, 1, 0, -1, 1 };

		for (int l = 0; l < 8; l++) {
			int adjR = i + row[l];
			int adjC = j + col[l];

			if (isValid(adjR, adjC, N, M) && !visited[adjR][adjC]) {
				dfs(adjR, adjC, N, M, matrix, visited, s + matrix[adjR][adjC], dictionary, words);
			}
		}

		// Need to reset visited status after visiting all children reachable
		// so that other dfs call's can visit this cell.
		visited[i][j] = false;

	}

	public static void main(String[] args) {

		/*
		 * String[] dict = new String[] { "GEEKS", "FOR", "QUIZ", "GO" }; char[][] arr =
		 * new char[][] { { 'G', 'I', 'Z' }, { 'U', 'E', 'K' }, { 'Q', 'S', 'E' } };
		 * 
		 * System.out.println(allWords(arr, 3, 3,dict));
		 */

		try (Scanner in = new Scanner(System.in)) {
			int testCount = in.nextInt();

			for (int i = 0; i < testCount; i++) {
				in.nextInt();
				String s = in.nextLine();
				while (s.isEmpty()) {
					s = in.nextLine();
				}
				s.trim();
				String[] dictionary = s.split(" ");

				int N = in.nextInt();
				int M = in.nextInt();

				String charStr = in.nextLine();
				while (charStr.isEmpty()) {
					charStr = in.nextLine();
				}
				charStr.trim();
				String[] chars = charStr.split(" ");

				char[][] charsMatrix = new char[N][M];

				int pos = 0;
				for (int l = 0; l < N; l++) {
					for (int m = 0; m < M; m++) {
						charsMatrix[l][m] = chars[pos].charAt(0);
						pos++;
					}
				}

				Set<String> words = allWords(charsMatrix, N, M, dictionary);
				for (String word : words) {
					System.out.print(word + " ");
				}
				
				if (words.isEmpty())
				{
					System.out.print(-1);
				}
				System.out.println();

			}
		}
	}

}
