package com.sri.algo.graph.cp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * Prim’s algorithm is also a Greedy algorithm. It starts with an empty spanning
 * tree. The idea is to maintain two sets of vertices. The first set contains
 * the vertices already included in the MST, the other set contains the vertices
 * not yet included. At every step, it considers all the edges that connect the
 * two sets, and picks the minimum weight edge from these edges. After picking
 * the edge, it moves the other endpoint of the edge to the set containing MST.
 * A group of edges that connects two set of vertices in a graph is called cut
 * in graph theory. So, at every step of Prim’s algorithm, we find a cut (of two
 * sets, one contains the vertices already included in MST and other contains
 * rest of the verices), pick the minimum weight edge from the cut and include
 * this vertex to MST Set (the set that contains already included vertices).
 *
 */

public class PrimsAlgorithm {

	private static int getMin(Map<Integer, Integer> keys) {
		int min = Integer.MAX_VALUE;
		int minKey = Integer.MAX_VALUE;

		Iterator<Entry<Integer, Integer>> iter = keys.entrySet().iterator();

		while (iter.hasNext()) {
			Entry<Integer, Integer> entry = iter.next();

			if (entry.getValue() < min) {
				min = entry.getValue();
				minKey = entry.getKey();
			}
		}

		keys.remove(minKey);

		return minKey;
	}

	public static void minSpanningTree(EdgeWeightedGraph g) {

		int V = g.getV();
		Map<Integer, Integer> keys = new HashMap<>();

		Map<Integer, Integer> parentsMap = new HashMap<>();

		keys.put(0, 0);
		parentsMap.put(0, null);
		for (int i = 1; i < V; i++) {
			keys.put(i, Integer.MAX_VALUE);
		}

		while (!keys.isEmpty()) {
			int minV = getMin(keys);
			Iterator<Edge> iter = g.getAdj().get(minV).iterator();
			while (iter.hasNext()) {
				Edge edge = iter.next();

				if (keys.containsKey(edge.to) && keys.get(edge.to) > edge.wt) {
					keys.put(edge.to, edge.wt);
					parentsMap.put(edge.to, edge.from);
				}
			}
		}

		System.out.println(parentsMap);

	}

	public static void main(String[] args) {

		EdgeWeightedGraph g = new EdgeWeightedGraph(5);

		g.addEdge(0, 1, 2);
		g.addEdge(0, 3, 6);
		g.addEdge(1, 3, 8);
		g.addEdge(1, 2, 3);
		g.addEdge(1, 4, 5);
		g.addEdge(3, 4, 9);

		minSpanningTree(g);

	}

}
