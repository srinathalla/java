package com.sri.algo.graph.leet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * 
 * 	Given n nodes labeled from 0 to n-1 and a list of undirected edges 
 * (each edge is a pair of nodes), write a function to check whether these edges
 *  make up a valid tree.

	Example 1:
	
	Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
	Output: true
	
 * @author salla
 *
 */
public class GraphValidTree {

	boolean hasCycle = false;
	int count;

	public boolean validTree(int n, int[][] edges) {

		Map<Integer, Set<Integer>> graph = new HashMap<>();

		for (int i = 0; i < n; i++) {
			graph.put(i, new HashSet<>());
		}

		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		boolean[] visited = new boolean[n];
		boolean[] visiting = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(graph, visited, i,i, visiting);
				count++;
			}
		}

		return (hasCycle || count > 1) ? false : true;

	}

	private void dfs(Map<Integer, Set<Integer>> graph, boolean[] visited, int v, int p, boolean[] visiting) {

		if (hasCycle) {
			return;
		}

		visited[v] = true;
		visiting[v] = true;

		for (Integer adjV : graph.get(v)) {

			if (!visited[adjV]) {
				dfs(graph, visited, adjV, v, visiting);
			} else if (visiting[adjV] && adjV != p) {
				hasCycle = true;
			}
		}

		visiting[v] = false;
	}

	public static void main(String[] args) {

		GraphValidTree graphValidTree = new GraphValidTree();

		System.out.println(graphValidTree.validTree(5, new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } }));

	}

}
