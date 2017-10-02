package com.sri.algo.graph.cp;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {

	public static void dfs(int v, LinkedList<Integer>[] adj, boolean[] visited) {
		visited[v] = true;

		System.out.print(v + " ");

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n]) {
				dfs(n, adj, visited);
			}
		}
	}

	public static void main(String[] args) {

		DiGraph g1 = new DiGraph(4);

		g1.addEdge(0, 1);
		g1.addEdge(1, 3);
		g1.addEdge(0, 2);

		boolean[] visited = new boolean[4];

		dfs(0, g1.getAdjacencyListAsArray(), visited);
	}

}
