package com.sri.algo.dp.cp;

import java.util.Scanner;

public class LastTwodigitsOfFibonacci {

	public static long lastTwoDigitsOfFibonacciSeries(int n) {

		long[] cache = new long[300];
		long nthFibo = lastTwoDigits(n % 300, cache);

		return nthFibo;

	}

	private static long lastTwoDigits(int n, long[] cache) {

		if (n <= 1) {
			return n;
		}

		cache[0] = 0;
		cache[1] = 1;

		for (int i = 2; i <= n; i++) {

			cache[i] = (cache[i - 2] + cache[i - 1]) % 100;
		}

		return cache[n];

	}

	public static void main(String[] args) {

		try (Scanner in = new Scanner(System.in)) {
			int testCount = in.nextInt();

			for (int i = 0; i < testCount; i++) {

				System.out.println(lastTwoDigitsOfFibonacciSeries(in.nextInt()));
			}
		}
	}

}
