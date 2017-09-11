package com.sri.algo.dp;

public class Palindrome {

	public static long getFibonacciNumber(int n) {
		if (n <= 1) {
			return n;
		}

		return getFibonacciNumber(n - 1) + getFibonacciNumber(n - 2);
	}

	public static long getFibonacciNumberWithDP(int n) {
		if (n <= 1) {
			return n;
		}
		long[] table = new long[n + 1];

		table[0] = 0;
		table[1] = 1;

		for (int i = 2; i <= n; i++) {
			table[i] = table[i - 1] + table[i - 2];
		}
		return table[n];
	}

	public static long getFibonacciNumberWithMemoization(int n) {
		long[] table = new long[n + 1];

		return getFibonacciNumberWithMemoization(n, table);
	}

	private static long getFibonacciNumberWithMemoization(int n, long[] table) {
		if (n <= 1) {
			table[n] = n;
		}

		else if (table[n] == 0) {
			table[n] = getFibonacciNumberWithMemoization(n - 1, table)
					+ getFibonacciNumberWithMemoization(n - 2, table);
		}

		return table[n];
	}

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		// System.out.println(getFibonacciNumber(47));
		long end = System.currentTimeMillis();

		System.out.println("Time Taken in seconds: " + (end - start) / 1000);

		start = System.currentTimeMillis();
		System.out.println(getFibonacciNumberWithMemoization(160));
		end = System.currentTimeMillis();

		System.out.println("Time Taken in milli seconds with Memo: " + (end - start));

		start = System.currentTimeMillis();
		System.out.println(getFibonacciNumberWithDP(160));
		end = System.currentTimeMillis();

		System.out.println("Time Taken in milli seconds with DP: " + (end - start));
	}

}
