package com.sri.algo.tree.leet;

import java.util.Stack;

/**
 * Given a binary tree with n nodes, your task is to check if it's possible to
 * partition the tree to two trees which have the equal sum of values after
 * removing exactly one edge on the original tree.
 * 
 * Example 1: Input: 5 / \ 10 10 / \ 2 3
 * 
 * Output: True Explanation: 5 / 10
 * 
 * Sum: 15
 * 
 * 10 / \ 2 3
 * 
 * Sum: 15 Example 2: Input: 1 / \ 2 10 / \ 2 20
 * 
 * Output: False Explanation: You can't split the tree into two trees with equal
 * sum after removing exactly one edge on the tree.
 * 
 * Note: The range of tree node value is in the range of [-100000, 100000]. 1 <=
 * n <= 10000
 *
 */
public class EqualTreePartition {

	Stack<Long> stack;

	public boolean checkEqualTree(TreeNode root) {

		if (root == null) {
			return false;
		}

		stack = new Stack<>();

		long rootSum = postOrder(root);
		stack.pop();

		if (rootSum % 2 == 0) {

			while (!stack.isEmpty()) {

				long treeSum = stack.pop();
				if (treeSum == rootSum / 2) {
					return true;
				}
			}
		}

		return false;

	}

	private long postOrder(TreeNode node) {

		if (node == null) {
			return 0;
		}

		long lSum = postOrder(node.left);

		long rSum = postOrder(node.right);

		stack.push(lSum + rSum + node.val);

		return lSum + rSum + node.val;

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(6);
		// root.left.right = new TreeNode(5);

		EqualTreePartition equalTreePartition = new EqualTreePartition();

		System.out.println(equalTreePartition.checkEqualTree(root));

		TreeNode root1 = new TreeNode(0);
		root.left = new TreeNode(-1);
		root.right = new TreeNode(1);

		System.out.println(equalTreePartition.checkEqualTree(root1));

	}

}
