package com.sri.algo.dp;

import java.util.Scanner;

public class Sample {

	public static boolean isPartionable(int[] arr, int n) {
		int sum = 0;

		for (int a : arr) {
			sum = sum + a;
		}

		if (sum % 2 == 1) {
			return false;
		}

		return hasSubsetWithSum(arr, n, sum / 2);
	}

	public static boolean hasSubsetWithSum(int[] arr, int n, int sum) {
		boolean[][] table = new boolean[n + 1][sum + 1];

		for (int i = 0; i <= n; i++) {
			table[i][0] = true;
		}

		for (int i = 1; i <= sum; i++) {
			table[0][i] = false;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (arr[i-1] > j) {
					table[i][j] = table[i - 1][j];
				} else {
					table[i][j] = table[i - 1][j] || table[i][j - arr[i - 1]];
				}
			}
		}

		return table[n][sum];
	}

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int testCount = in.nextInt();

			for (int i = 0; i < testCount; i++) {
				int n = in.nextInt();
				int[] arr = new int[n];

				for (int j = 0; j < n; j++) {
					arr[j] = in.nextInt();
				}

				if (isPartionable(arr, n)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}

}
