package com.sri.algo.string;

import java.util.Scanner;
import java.util.Stack;

public class SuperReducedString {

	/**
	 * Eg 1: input : aaabccddd o/p : abd
	 * 
	 * Eg 2 : i/p : abba o/p : Empty String
	 * 
	 * 
	 * @param input
	 * @return
	 */
	public String deleteMatchedPairOfAdjacentLetters(String input) {
		char[] inputChars = input.toCharArray();

		// Replace adjacent pair of characters with ' ' if matched.
		for (int index = 0; index < inputChars.length - 1; index++) {
			if (inputChars[index] == inputChars[index + 1]) {
				inputChars[index] = ' ';
				inputChars[index + 1] = ' ';
				index++;
			}
		}
		// Prepare new string excluding empty char from character array.
		StringBuilder str = new StringBuilder();
		for (char ch : inputChars) {
			if (ch != ' ') {
				str.append(ch);
			}
		}

		String result = str.length() != 0 ? str.toString() : "Empty String";

		// Recurse till input is not empty or adjacent pair cannot be deleted
		// further,
		if (!result.equals(input) && !result.equals("Empty String")) {
			result = deleteMatchedPairOfAdjacentLetters(str.toString());
		}

		return result;
	}

	/**
	 * Eg 1: input : aaabccddd o/p : abd
	 * 
	 * Eg 2 : i/p : abba o/p : Empty String
	 * 
	 * 
	 * @param input
	 * @return
	 */
	public String deleteMatchedPairOfAdjacentLettersUsingStack(String input) {
		char[] inputChars = input.toCharArray();

		Stack<Character> stack = new Stack<>();
		stack.push(inputChars[0]);

		for (int index = 1; index < inputChars.length; index++) {
			// Pop element from stack if character match.
			if (inputChars[index] == stack.peek()) {
				stack.pop();
			} else {
				// Push the character onto the stack.
				stack.push(inputChars[index]);
			}
		}

		StringBuilder str = new StringBuilder();

		// Append characters in reverse order to prepare final string.
		while (!stack.isEmpty()) {
			str.insert(0, stack.pop());
		}

		return str.length() != 0 ? str.toString() : "Empty String";
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String input = in.next();

		SuperReducedString strOperations = new SuperReducedString();
		System.out.println(strOperations.deleteMatchedPairOfAdjacentLettersUsingStack(input));

	}

}
