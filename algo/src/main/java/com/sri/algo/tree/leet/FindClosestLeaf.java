package com.sri.algo.tree.leet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FindClosestLeaf {

	public int findClosestLeaf(TreeNode root, int k) {

		Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
		dfs(root, null, graph);

		Queue<TreeNode> q = new LinkedList<>();

		Set<TreeNode> seen = new HashSet<>();

		for (TreeNode node : graph.keySet()) {
			if (node != null && node.val == k) {
				q.add(node);
				seen.add(node);
				break;
			}
		}

		while (!q.isEmpty()) {
			TreeNode curr = q.poll();

			if (curr != null && graph.get(curr).size() == 1) {
				return curr.val;
			}

			for (TreeNode child : graph.get(curr)) {

				if (!seen.contains(child)) {
					q.add(child);
					seen.add(child);
				}

			}
		}

		return -1;

	}

	private void dfs(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> graph) {

		if (node != null) {
			if (!graph.containsKey(node)) {
				graph.put(node, new LinkedList<>());

			}

			if (!graph.containsKey(parent)) {
				graph.put(parent, new LinkedList<>());
			}

			graph.get(node).add(parent);
			graph.get(parent).add(node);

			dfs(node.left, node, graph);
			dfs(node.right, node, graph);
		}

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.left.left = new TreeNode(5);
		root.left.left.left.left = new TreeNode(6);

		FindClosestLeaf findClosestLeaf = new FindClosestLeaf();

		System.out.println(findClosestLeaf.findClosestLeaf(root, 2));

	}

}
