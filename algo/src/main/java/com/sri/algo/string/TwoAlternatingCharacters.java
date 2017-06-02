package com.sri.algo.string;

import java.util.Scanner;

public class TwoAlternatingCharacters {

	private final int LOWER_CASE_A = 'a';

	public int longestAlternatingTwoCharString(String input) {
		
		if(input.length() < 2)
		{
			return 0;
		}

		char[][] alphabets = new char[26][26];
		int[][] visitedValues = new int[26][26];

		for (char c : input.toCharArray()) {

			int index = (int) (c - LOWER_CASE_A);
			
			for (int i = 0; i < 26; i++) {
				
				if (visitedValues[index][i] != -1) {			
					if (alphabets[index][i] != c) {
						alphabets[index][i] = c;		
						// Increment visit count;
						visitedValues[index][i]++;
					} else {
						//If same character is visited again respective char combination can be ignored.
						visitedValues[index][i] = -1;
					}
				}
				if (visitedValues[i][index] != -1) {		
					if(alphabets[i][index] != c)
					{
						alphabets[i][index] = c;
						visitedValues[i][index] ++;
					}
					else {
						visitedValues[i][index] = -1;
					}
				}
			}
		}
			
			
		int longestString = 0;
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				if (visitedValues[i][j] > longestString) {
					longestString = visitedValues[i][j];
				}
			}
		}
		
		return longestString;
	}

	public static void main(String[] args) {

		try (Scanner in = new Scanner(System.in)) {
			in.nextInt();
			String input = in.next();

			TwoAlternatingCharacters strOperations = new TwoAlternatingCharacters();

			System.out.println(strOperations.longestAlternatingTwoCharString(input));

			// System.out.println(strOperations.maxLength);
		}

	}

}
