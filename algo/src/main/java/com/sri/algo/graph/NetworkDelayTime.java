package com.sri.algo.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {

	private int result = 0;

	public int networkDelayTime(int[][] times, int N, int K) {

		var graph = new HashMap<Integer, List<int[]>>();
		this.result = 0;

		for (int i = 1; i <= N; i++) {
			graph.put(i, new ArrayList<>());
		}

		for (int[] time : times) {
			int u = time[0];
			int v = time[1];
			int w = time[2];

			graph.get(u).add(new int[] { v, w });
		}

		boolean[] seen = new boolean[N + 1];

		var q = new PriorityQueue<int[]>(Comparator.comparing(a -> a[1]));
		q.add(new int[] { K, 0 });

		while (q.size() > 0) {
			int[] p = q.poll();
			int v = p[0];
			int cost = p[1];
			result = Math.max(result, cost);

			if (seen[v]) {
				continue;
			}

			seen[v] = true;
			for (int[] adj : graph.get(v)) {
				q.add(new int[] { adj[0], adj[1] + cost });
			}
		}

		return this.result;
	}

	public static void main(String[] args) {

		int[][] times = new int[][] { { 1,2, 1 }, { 2, 3, 2 }, { 1,3, 2} };
		int N = 3, K = 1;

		NetworkDelayTime ndt = new NetworkDelayTime();
		System.out.println(ndt.networkDelayTime(times, N, K));
	}
}
