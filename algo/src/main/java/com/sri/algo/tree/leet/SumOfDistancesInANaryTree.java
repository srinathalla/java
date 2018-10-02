package com.sri.algo.tree.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sri.algo.array.PrintArray;

/**
 * An undirected, connected tree with N nodes labelled 0...N-1 and N-1 edges are
 * given.
 * 
 * The ith edge connects nodes edges[i][0] and edges[i][1] together.
 * 
 * Return a list ans, where ans[i] is the sum of the distances between node i
 * and all other nodes.
 * 
 * Example 1:
 * 
 * Input: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]] Output:
 * [8,12,6,10,10,10] Explanation: Here is a diagram of the given tree: 0 / \ 1 2
 * /|\ 3 4 5
 * 
 * We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
 * equals 1 + 1 + 2 + 2 + 2 = 8. Hence, answer[0] = 8, and so on.
 * 
 * Note: 1 <= N <= 10000
 * 
 *
 */
public class SumOfDistancesInANaryTree {

	private int N;
	private List<Set<Integer>> graph;
	private int total = 0;
	int[] ans, count;

	/**
	 * T.C : O(N*N)
	 * 
	 * wil lead to TLE when N = 10000
	 * 
	 * where distance of each node to all other nodes can be calculated in O(n).
	 * 
	 * @param N
	 * @param edges
	 * @return
	 */
	public int[] sumOfDistancesInTreeNaive(int N, int[][] edges) {

		this.N = N;

		this.graph = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			graph.add(new HashSet<>());
		}

		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		int[] result = new int[N];
		for (int i = 0; i < N; i++) {
			dfs(i, -1, 0);
			result[i] = total;
			total = 0;
		}

		return result;

	}

	public int[] sumOfDistancesInTree(int N, int[][] edges) {

		this.N = N;
		this.graph = new ArrayList<>();
		ans = new int[N];
		count = new int[N];
		Arrays.fill(count, 1);

		for (int i = 0; i < N; i++) {
			graph.add(new HashSet<>());
		}

		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		dfs(0, -1);
		dfs2(0, -1);

		return ans;

	}

	private void dfs2(int node, int p) {

		for (int child : graph.get(node)) {
			if (child != p) {
				ans[child] = ans[node] - count[child] + N - count[child];
				dfs2(child, node);
			}
		}
	}

	private void dfs(int node, int p) {

		for (int child : graph.get(node)) {
			if (child != p) {
				dfs(child, node);
				count[node] += count[child];
				ans[node] += ans[child] + count[child];
			}
		}
	}

	private void dfs(int node, int parent, int dist) {

		total += dist;

		for (int child : graph.get(node)) {

			if (child != parent) {
				dfs(child, node, dist + 1);
			}
		}
	}

	public static void main(String[] args) {

		SumOfDistancesInANaryTree sumOfDistancesInANaryTree = new SumOfDistancesInANaryTree();
		int[] result = sumOfDistancesInANaryTree.sumOfDistancesInTree(6,
				new int[][] { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 }, { 2, 5 } });

		PrintArray.print(result);

	}

}
