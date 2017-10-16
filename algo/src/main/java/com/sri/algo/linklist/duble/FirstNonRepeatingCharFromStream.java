package com.sri.algo.linklist.duble;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class FirstNonRepeatingCharFromStream {

	public static void printFirstNonRepeatingChar(char[] chars) {
		Set<Character> charSet = new LinkedHashSet<>();
		boolean[] visited = new boolean[255];

		for (char ch : chars) {
			if (!visited[ch]) {
				charSet.add(ch);
				visited[ch] = true;
			} else if (charSet.contains(ch)) {
				charSet.remove(ch);
			}

			if (charSet.isEmpty()) {
				System.out.print(-1 + " ");
			} else {
				System.out.print(charSet.iterator().next() + " ");
			}
		}
	}

	public static void main(String[] args) {

		// printFirstNonRepeatingChar("aabc".toCharArray());

		try (Scanner in = new Scanner(System.in)) {
			int testCount = in.nextInt();

			for (int i = 0; i < testCount; i++) {
				int n1 = in.nextInt();
				char[] stream = new char[n1];

				for (int j = 0; j < n1; j++) {
					char ch = in.next().charAt(0);

					while (ch == 32) {
						ch = in.next().charAt(0);
					}
					stream[j] = ch;

				}

				printFirstNonRepeatingChar(stream);
			}
		}

	}

}
