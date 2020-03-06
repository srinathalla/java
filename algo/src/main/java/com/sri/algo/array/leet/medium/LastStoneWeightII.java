package com.sri.algo.array.leet.medium;

import java.util.PriorityQueue;

public class LastStoneWeightII {

	public int lastStoneWeightII(int[] stones) {

		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		for (int stone : stones) {
			pq.add(stone);
		}
		while (pq.size() > 1) {
			int a = pq.poll();
			int b = pq.poll();
			if (Math.abs(a - b) > 0) {
				pq.add(Math.abs(a - b));
			}
		}
		return pq.isEmpty() ? 0 : pq.poll();
	}

	public static void main(String[] args) {

		LastStoneWeightII lastStoneWeightII = new LastStoneWeightII();
		System.out.println(lastStoneWeightII.lastStoneWeightII(new int[] { 2, 7, 4, 1, 8, 1 }));

	}

}
