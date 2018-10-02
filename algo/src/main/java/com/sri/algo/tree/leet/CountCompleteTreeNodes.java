package com.sri.algo.tree.leet;

/**
 * Given a complete binary tree, count the number of nodes.
 * 
 * Note:
 * 
 * Definition of a complete binary tree from Wikipedia: In a complete binary
 * tree every level, except possibly the last, is completely filled, and all
 * nodes in the last level are as far left as possible. It can have between 1
 * and 2h nodes inclusive at the last level h.
 * 
 * Example:
 * 
 * Input: 1 / \ 2 3 / \ / 4 5 6
 * 
 * Output: 6
 *
 */
public class CountCompleteTreeNodes {

	/**
	 * T.C : O(n)
	 * 
	 * @param root
	 * @return
	 */
	public int countNodesRecursive(TreeNode root) {

		if (root == null) {
			return 0;
		}

		return 1 + countNodesRecursive(root.left) + countNodesRecursive(root.right);

	}

	public int countNodes(TreeNode root) {

		if (root == null) {
			return 0;
		}

		TreeNode left = root, right = root;
		int d = 0;
		while (right != null) {
			d++;

			left = left.left;
			right = right.right;
		}

		return left == null ? ((1 << d) - 1) : 1 + countNodes(root.left) + countNodes(root.right);

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		CountCompleteTreeNodes countCompleteTreeNodes = new CountCompleteTreeNodes();

		System.out.println(countCompleteTreeNodes.countNodes(root));

	}

}
