package com.sri.algo.tree.leet.medium;

/**
 * Given a binary tree root and an integer target, delete all the leaf nodes
 * with value target.
 * 
 * Note that once you delete a leaf node with value target, if it's parent node
 * becomes a leaf node and has the value target, it should also be deleted (you
 * need to continue doing that until you can't).
 * 
 * @author srialla
 *
 */
public class DeleteLeaves {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	boolean found = false;

	public TreeNode removeLeafNodes(TreeNode root, int target) {

		found = false;
		while (true) {
			if (root.left == null && root.right == null && root.val == target) {
				return null;
			}
			found = false;
			removeLeafNodes(root, target, -1, null);
			if (!found) {
				break;
			}
		}

		return root;
	}

	public void removeLeafNodes(TreeNode node, int target, int dir, TreeNode parent) {

		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null && node.val == target) {
			if (dir == 0) {
				parent.left = null;
			} else if (dir == 1) {
				parent.right = null;
			}

			found = true;
		}

		removeLeafNodes(node.left, target, 0, node);
		removeLeafNodes(node.right, target, 1, node);

	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(4);
		
		DeleteLeaves dl = new DeleteLeaves();
		root = dl.removeLeafNodes(root, 2);
		System.out.println(root);
		
	}

}
