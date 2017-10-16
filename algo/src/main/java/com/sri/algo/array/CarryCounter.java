package com.sri.algo.array;

import java.util.Scanner;

/**
 * Given two numbers. Add the numbers and find the count of carries in their
 * addition.
 * 
 * Input: 2 345 234 2345 535
 * 
 * Output: 0 1
 *
 */
public class CarryCounter {

	public static int carryCount(long M, long N) {
		if (M == 0 || N == 0) {
			return 0;
		}

		int carry = 0;
		int count = 0;
		while (M > 0 || N > 0) {
			int mR = (int) (M % 10);
			M = M / 10;

			int nR = (int) (N % 10);
			N = N / 10;

			int sum = mR + nR + carry;
			if (sum >= 10) {
				carry = sum / 10;
				count++;
			} else {
				carry = 0;
			}
		}

		return count;
	}

	public static void main(String[] args) {

		/*
		 * System.out.println(carryCount(345 , 234));
		 * 
		 * System.out.println(carryCount(2345 ,535));
		 */

		try (Scanner in = new Scanner(System.in)) {
			int testCount = in.nextInt();

			for (int i = 0; i < testCount; i++) {
				long n = in.nextLong();
				long m = in.nextLong();

				System.out.println(carryCount(n, m));

			}
		}

	}

}
