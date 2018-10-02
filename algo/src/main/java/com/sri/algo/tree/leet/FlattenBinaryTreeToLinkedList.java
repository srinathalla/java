package com.sri.algo.tree.leet;

public class FlattenBinaryTreeToLinkedList {

	public void flatten(TreeNode root) {

		flatten(root, new TreeNode[] { null });

	}

	public void flatten(TreeNode curr, TreeNode[] p) {

		if (curr == null) {
			return;
		}

		p[0] = curr;

		flatten(curr.left, p);
		
		if (curr.left != null) {
			p[0].right = curr.right;
			curr.right = curr.left;
			curr.left = null;
		}

		flatten(p[0].right, p);

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);

		FlattenBinaryTreeToLinkedList flattenBinaryTreeToLinkedList = new FlattenBinaryTreeToLinkedList();

		flattenBinaryTreeToLinkedList.flatten(root);
		System.out.println(root);
	}

}
