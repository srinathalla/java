package com.sri.algo.graph.cp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class MinCostPath {

	private static class HeadpNode {
		private HeadpNode(Vertex v, int wt) {
			super();
			this.v = v;
			this.wt = wt;
		}

		Vertex v;
		int wt;
	}

	private static HeadpNode getMin(Map<Vertex, Integer> keys) {
		int minValue = Integer.MAX_VALUE;
		Vertex minKey = null;

		Iterator<Entry<Vertex, Integer>> iter = keys.entrySet().iterator();

		while (iter.hasNext()) {
			Entry<Vertex, Integer> entry = iter.next();

			if (entry.getValue() < minValue) {
				minValue = entry.getValue();
				minKey = entry.getKey();
			}
		}

		keys.remove(minKey);

		return new HeadpNode(minKey, minValue);
	}

	public static Map<Vertex, Integer> dijkstra(EdgeWtGraph g, Vertex src, int wt) {

		Map<Vertex, Integer> keys = new HashMap<>();
		Map<Vertex, Vertex> parentsMap = new HashMap<>();

		Map<Vertex, Integer> distanceMap = new HashMap<>();
		Map<Vertex, LinkedList<VEdge>> vertices = g.adj;

		for (Vertex v : vertices.keySet()) {

			if (!v.equals(src)) {
				keys.put(v, Integer.MAX_VALUE);
			} else {
				keys.put(src, wt);
			}
		}

		while (!keys.isEmpty()) {
			HeadpNode heapNode = getMin(keys);
			distanceMap.put(heapNode.v, heapNode.wt);

			Iterator<VEdge> iter = g.adj.get(heapNode.v).iterator();
			while (iter.hasNext()) {
				VEdge edge = iter.next();

				int nd = edge.wt + distanceMap.get(edge.from);
				if (keys.containsKey(edge.to) && keys.get(edge.to) > nd) {
					keys.put(edge.to, nd);
					parentsMap.put(edge.to, edge.from);
				}
			}
		}

		return distanceMap;

	}

	static class Vertex {
		int i;
		int j;

		public Vertex(int i, int j) {

			this.i = i;
			this.j = j;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + i;
			result = prime * result + j;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Vertex other = (Vertex) obj;
			if (i != other.i)
				return false;
			if (j != other.j)
				return false;
			return true;
		}

	}

	static class VEdge {
		Vertex from;
		Vertex to;
		int wt;

		public VEdge(Vertex from, Vertex to, int wt) {
			super();
			this.from = from;
			this.to = to;
			this.wt = wt;
		}
	}

	static class EdgeWtGraph {

		int V; // No. of vertices
		int E; // No. of edges.

		// Array of lists for Adjacency List Representation
		private Map<Vertex, LinkedList<VEdge>> adj;

		// Constructor
		public EdgeWtGraph(int v, int E) {
			V = v;
			adj = new HashMap<Vertex, LinkedList<VEdge>>();
		}

		public EdgeWtGraph(int v) {
			this(v, 0);
		}

		// Function to add an edge into the graph
		public void addEdge(Vertex from, Vertex to, int wt) {

			if (adj.get(from) == null) {
				adj.put(from, new LinkedList<VEdge>());
			}

			if (adj.get(to) == null) {
				adj.put(to, new LinkedList<VEdge>());
			}

			E++;
			adj.get(from).add(new VEdge(from, to, wt));

		}
	}

	public static int minCost(int[][] matrix, int N, int M) {

		EdgeWtGraph g = new EdgeWtGraph(N * M);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				Vertex from = new Vertex(i, j);
				if (i + 1 < N - 1) {
					g.addEdge(from, new Vertex(i + 1, j), matrix[i + 1][j]);
				}

				if (i > 0) {
					g.addEdge(from, new Vertex(i - 1, j), matrix[i - 1][j]);
				}

				if (j < M - 1) {
					g.addEdge(from, new Vertex(i, j + 1), matrix[i][j + 1]);
				}
				if (j > 0) {
					g.addEdge(from, new Vertex(i, j - 1), matrix[i][j - 1]);
				}
			}
		}
		
		Map<Vertex, Integer> srcToVertexDistances = dijkstra(g, new Vertex(0, 0), matrix[0][0]);
		
		return srcToVertexDistances.get(new Vertex(N-1, M-1));

	}

	public static void main(String[] args) {

		int table[][] = { { 31, 100, 65, 12, 18 }, { 10, 13, 47, 157, 6 }, { 100, 113, 174, 11, 33 },
				{ 88, 124, 41, 20, 140 }, { 99, 32, 111, 41, 20 } };

		System.out.println(minCost(table, 5, 5));
	}

}
