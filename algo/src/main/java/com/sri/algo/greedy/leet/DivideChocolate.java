package com.sri.algo.greedy.leet;

import java.util.stream.IntStream;

public class DivideChocolate {

	public int maximizeSweetness(int[] A, int K) {

		int left = IntStream.of(A).min().getAsInt();
		int right = IntStream.of(A).sum();
		while (left < right) {
			int mid = (left + right + 1) / 2;
			int cuts = 0, sum = 0;

			for (int a : A) {
				sum += a;
				if (sum >= mid) {
					sum = 0;
					if (++cuts > K) {
						break;
					}
				}
			}

			if (cuts > K) {
				left = mid;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}

	public static void main(String[] args) {

		DivideChocolate divideChocolate = new DivideChocolate();

		int[] sweetness = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int K = 5;
		System.out.println(divideChocolate.maximizeSweetness(sweetness, K));

	}
}
