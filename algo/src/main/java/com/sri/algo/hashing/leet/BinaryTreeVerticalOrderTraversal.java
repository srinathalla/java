package com.sri.algo.hashing.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Given a binary tree, return the vertical order traversal of its nodes'
 * values. (ie, from top to bottom, column by column).
 * 
 * If two nodes are in the same row and column, the order should be from left to
 * right.
 * 
 * Examples 1:
 * 
 * Input: [3,9,20,null,null,15,7]
 * 
 * 3 /\ / \ 9 20 /\ / \ 15 7
 * 
 * Output:
 * 
 * [ [9], [3,15], [20], [7] ]
 * 
 * @author salla
 *
 */
public class BinaryTreeVerticalOrderTraversal {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> verticalOrderUsingTreeMap(TreeNode root) {

		TreeMap<Integer, List<Integer>> map = new TreeMap<>();

		Queue<NW> q = new LinkedList<>();

		q.add(new NW(root, 0));

		while (!q.isEmpty()) {
			NW curr = q.poll();

			if (!map.containsKey(curr.dist)) {
				map.put(curr.dist, new ArrayList<>());
			}
			map.get(curr.dist).add(curr.node.val);

			if (curr.node.left != null) {
				q.add(new NW(curr.node.left, curr.dist - 1));
			}

			if (curr.node.right != null) {
				q.add(new NW(curr.node.right, curr.dist + 1));
			}
		}

		return new ArrayList<>(map.values());
	}

	static class NW {
		TreeNode node;

		int dist;

		public NW(TreeNode node, int dist) {
			super();
			this.node = node;
			this.dist = dist;
		}
	}

	/**
	 * T.C : O(n)
	 * 
	 * where n is number of nodes.
	 * 
	 * Space complexity : O(n)
	 * 
	 * @param root
	 * @return
	 */
	public List<List<Integer>> verticalOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<>();

		if (root == null) {
			return result;
		}

		Map<Integer, List<Integer>> map = new HashMap<>();

		Queue<TreeNode> q = new LinkedList<>();
		Queue<Integer> distq = new LinkedList<>();

		q.add(root);
		distq.add(0);

		int min = 0, max = 0;

		while (!q.isEmpty()) {
			TreeNode curr = q.poll();
			Integer dist = distq.poll();

			if (!map.containsKey(dist)) {
				map.put(dist, new ArrayList<>());
			}
			map.get(dist).add(curr.val);

			if (curr.left != null) {
				q.add(curr.left);
				distq.add(dist - 1);

				min = Integer.min(min, dist - 1);
			}

			if (curr.right != null) {
				q.add(curr.right);
				distq.add(dist + 1);
				max = Integer.max(max, dist + 1);
			}
		}

		for (int i = min; i <= max; i++) {
			result.add(map.get(i));
		}

		return result;
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		BinaryTreeVerticalOrderTraversal vo = new BinaryTreeVerticalOrderTraversal();

		System.out.println(vo.verticalOrder(root));

	}

}
