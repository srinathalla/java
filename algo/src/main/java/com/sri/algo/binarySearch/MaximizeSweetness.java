package com.sri.algo.binarySearch;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class MaximizeSweetness {

	public int maximizeSweetness(int[] sweetness, int K) {

		IntSummaryStatistics stats = IntStream.of(sweetness).summaryStatistics();
		long high = stats.getSum();
		long low = stats.getMin();

		while (low < high) {
			long mid = (low + high + 1)/2;
			int sum = 0, cuts = 0;
			for (int s : sweetness) {
				sum += s;
				if (sum >= mid) {
					sum = 0;
					if (++cuts > K) {
						break;
					}
				}
			}

			if (cuts > K ) {
				low = mid;
			} else {
				high = mid - 1;

			}
		}

		return (int) low;
	}

	public static void main(String[] args) {

		int[] sweetness = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int K = 5;
		
		MaximizeSweetness ms = new MaximizeSweetness();
		System.out.println(ms.maximizeSweetness(sweetness, K));
	}

}
