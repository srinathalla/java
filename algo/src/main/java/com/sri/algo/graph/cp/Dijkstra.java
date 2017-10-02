package com.sri.algo.graph.cp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Dijkstra {

	static class HeadpNode {
		public HeadpNode(int v, int wt) {
			super();
			this.v = v;
			this.wt = wt;
		}

		int v;
		int wt;
	}

	private static HeadpNode getMin(Map<Integer, Integer> keys) {
		int minValue = Integer.MAX_VALUE;
		int minKey = Integer.MAX_VALUE;

		Iterator<Entry<Integer, Integer>> iter = keys.entrySet().iterator();

		while (iter.hasNext()) {
			Entry<Integer, Integer> entry = iter.next();

			if (entry.getValue() < minValue) {
				minValue = entry.getValue();
				minKey = entry.getKey();
			}
		}

		keys.remove(minKey);

		return new HeadpNode(minKey, minValue);
	}

	public static Map<Integer, Integer> dijkstra(EdgeWeightedGraph g) {

		int V = g.getV();
		Map<Integer, Integer> keys = new HashMap<>();

		Map<Integer, Integer> parentsMap = new HashMap<>();

		Map<Integer, Integer> distanceMap = new HashMap<>();

		keys.put(0, 0);
		parentsMap.put(0, null);
		distanceMap.put(0, 0);
		for (int i = 1; i < V; i++) {
			keys.put(i, Integer.MAX_VALUE);
		}

		while (!keys.isEmpty()) {
			HeadpNode heapNode = getMin(keys);
			distanceMap.put(heapNode.v, heapNode.wt);

			Iterator<Edge> iter = g.getAdj().get(heapNode.v).iterator();
			while (iter.hasNext()) {
				Edge edge = iter.next();

				int nd = edge.wt + distanceMap.get(edge.from);
				if (keys.containsKey(edge.to) && keys.get(edge.to) > nd ) {
					keys.put(edge.to, nd);
					parentsMap.put(edge.to, edge.from);
				}
			}
		}

		return distanceMap;

	}

	public static void main(String[] args) {

		EdgeWeightedGraph g = new EdgeWeightedGraph(5);

		g.addEdge(0, 1, 2);
		g.addEdge(0, 3, 6);
		g.addEdge(1, 3, 8);
		g.addEdge(1, 2, 3);
		g.addEdge(1, 4, 5);
		g.addEdge(3, 4, 9);

		System.out.println(dijkstra(g));

	}

}
