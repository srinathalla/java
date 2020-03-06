package com.sri.algo.heap.leet.medium;

import java.util.PriorityQueue;

public class MinimumCostToConnectKSticks {

	public int connectSticks(int[] sticks) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int stick : sticks) {
			pq.add(stick);
		}

		int sum = 0;
		while (pq.size() > 1) {
			int connectedSum = pq.poll() + pq.poll();
			sum += connectedSum;
			pq.add(connectedSum);
		}
		return sum;

	}

}
