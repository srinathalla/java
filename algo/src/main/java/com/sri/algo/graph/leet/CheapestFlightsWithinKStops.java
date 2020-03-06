package com.sri.algo.graph.leet;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * There are n cities connected by m flights. Each fight starts from city u and
 * arrives at v with a price w.
 * 
 * Now given all the cities and flights, together with starting city src and the
 * destination dst, your task is to find the cheapest price from src to dst with
 * up to k stops. If there is no such route, output -1.
 * 
 * @author srialla
 *
 */
public class CheapestFlightsWithinKStops {

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

		Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
		for (int[] flight : flights) {
			if (!graph.containsKey(flight[0])) {
				graph.put(flight[0], new HashMap<>());
			}
			graph.get(flight[0]).put(flight[1], flight[2]);
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
		pq.add(new int[] { src, K + 1, 0 });

		while (!pq.isEmpty()) {

			int[] flight = pq.poll();
			int cost = flight[2];
			int steps = flight[1];
			int node = flight[0];
			if (node == dst) {
				return cost;
			}
			if (steps > 0) {
				Map<Integer, Integer> adj = graph.getOrDefault(node, new HashMap<>());
				for (int adv : adj.keySet()) {
					pq.add(new int[] { adv, steps - 1, cost + adj.get(adv) });
				}
			}
		}

		return -1;

	}

	public static void main(String[] args) {
		
		int n = 3; 
		int[][] edges = {{0,1,100},{1,2,100},{0,2,500}};
		int src = 0, dst = 2, k = 1;
		CheapestFlightsWithinKStops cheapestFlightsWithinKStops = new CheapestFlightsWithinKStops();
		System.out.println(
			cheapestFlightsWithinKStops.findCheapestPrice(n, edges, src, dst, k));
	}

}
