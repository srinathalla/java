package com.sri.algo.stack;

import java.util.HashMap;
import java.util.Map;

public class LongestWellPerformingInterval {

	public int longestWPI(int[] A) {

		int res = 0, score = 0, n = A.length;
		Map<Integer, Integer> seen = new HashMap<>();

		for (int i = 0; i < n; i++) {
			score += A[i] > 8 ? 1 : -1;

			if (score > 0) {
				res += 1;
			} else {
				seen.putIfAbsent(score, i);
				if (seen.containsKey(score - 1)) {
					res = Math.max(res, i - seen.get(score - 1));
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {

		int[] arr = new int[] { 9, 6, 0, 6, 6, 9, 9, 9 };

		LongestWellPerformingInterval longestWellPerformingInterval = new LongestWellPerformingInterval();
		System.out.println(longestWellPerformingInterval.longestWPI(arr));

	}

}
