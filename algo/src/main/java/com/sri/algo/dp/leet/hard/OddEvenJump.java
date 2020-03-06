package com.sri.algo.dp.leet.hard;

import java.util.Map.Entry;
import java.util.TreeMap;

public class OddEvenJump {

	public int oddEvenJumps(int[] A) {

		int n = A.length, ans = 1;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		boolean[] higher = new boolean[n];
		boolean[] lower = new boolean[n];
		higher[n - 1] = true;
		lower[n - 1] = true;
		map.put(A[n - 1], n - 1);

		for (int i = n - 2; i >= 0; i--) {
			Entry<Integer, Integer> hi = map.ceilingEntry(A[i]), lo = map.floorEntry(A[i]);
			if (hi != null) {
				higher[i] = lower[hi.getValue()];
			}

			if (lo != null) {
				lower[i] = higher[lo.getValue()];
			}

			map.put(A[i], i);
			if (higher[i]) {
				ans++;
			}
		}

		return ans;
	}

	public static void main(String[] args) {

		OddEvenJump oddEvenJump = new OddEvenJump();
		System.out.println(
			oddEvenJump.oddEvenJumps(new int[] { 10, 13, 12, 14, 15 }));

	}

}
