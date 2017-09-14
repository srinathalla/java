package com.sri.algo.tree;

public class IsFullBinaryTree {

	/**
	 * A full binary tree is one where each node has two or no children. 
	 * Eg : Full binary tree example. 
	 *                  1
	 *              5        4
	 *           3      7 
	 *           
	 *           Eg : Not Full binary tree example. 
	 *                    1
	 *              5        4
	 *           3      7       8
	 * 
	 * Time Complexity O(n) .
	 * 
	 * @param node
	 * @return
	 */
	public static boolean isFullBinaryTree(Node node) {
		// Is Node null
		if (node == null) {
			return true;
		}

		// Is leaf node ?
		if (node.left == null && node.right == null) {
			return true;
		}

		// If both nodes are present then both left and right
		// sub trees have to be full binary trees.
		if (node.left != null && node.right != null) {
			return isFullBinaryTree(node.left) && isFullBinaryTree(node.right);
		}

		return false;
	}

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree(10);
		binaryTree.insertLeft(10, 20);
		binaryTree.insertRight(10, 30);

		binaryTree.insertLeft(20, 40);
		binaryTree.insertRight(20, 60);

		System.out.println(isFullBinaryTree(binaryTree.getRoot()));
		
		binaryTree.insertRight(30, 40);
		
		System.out.println(isFullBinaryTree(binaryTree.getRoot()));
	}
}
