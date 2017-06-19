package com.sri.algo.array;

import java.io.IOException;
import java.util.Scanner;

public class MissingNumber {

	private static long getSumOfNNumbers(int n) {
		return (n * (n + 1)) / 2;
	}

	public static void main(String[] args) throws IOException {

		try (Scanner in = new Scanner(System.in)) {

			int tests = in.nextInt();

			for (int test = 0; test < tests; test++) {

				int n = in.nextInt();
				long expectedSum = getSumOfNNumbers(n);

				long actualSum = 0;
				for (int i = 0; i < n - 1; i++) {
					actualSum = actualSum + in.nextInt();
				}
				System.out.println(expectedSum - actualSum);

			}
		}
	}

}
