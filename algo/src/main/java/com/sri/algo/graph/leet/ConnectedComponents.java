package com.sri.algo.graph.leet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConnectedComponents {

	int count = 0;

	public int countComponents(int n, int[][] edges) {

		Map<Integer, Set<Integer>> g = new HashMap<>();

		for (int i = 0; i < n; i++) {
			g.put(i, new HashSet<>());
		}

		for (int[] edge : edges) {

			g.get(edge[0]).add(edge[1]);
			g.get(edge[1]).add(edge[0]);
		}

		boolean[] visited = new boolean[n];
		for (Integer v : g.keySet()) {
			if (!visited[v]) {
				dfs(g, v, visited);
				count++;
			}
		}

		return count;
	}

	private void dfs(Map<Integer, Set<Integer>> g, int v, boolean[] visited) {
		visited[v] = true;

		for (Integer adjV : g.get(v)) {
			if (!visited[adjV]) {
				dfs(g, adjV, visited);
			}
		}
	}

	public static void main(String[] args) {

		ConnectedComponents cc = new ConnectedComponents();

		System.out.println(cc.countComponents(5, new int[][] { { 0, 1 }, { 1, 2 }, { 3, 4 } }));

	}

}
