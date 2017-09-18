package com.sri.algo.tree;

public class IsBST {

	/**
	 * Checks if given binary tree is BST.
	 * @param root
	 * @return
	 */
	public static boolean isBST(Node root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/**
	 * Checks for BST.
	 * @param node
	 * @param min
	 * @param max
	 * @return
	 */
	private static boolean isBST(Node node, int min, int max) {
		if (node == null) {
			return true;
		}

		
		return min < node.data && node.data < max && // Node should be in between min and max.
				isBST(node.left, min, node.data) // For left tree max should be curr node data.
				&& isBST(node.left, node.data, max); // For right tree min should be curr node data.

	}
	
	public static void main(String[] args) {
		
		BinaryTree binaryTree = new BinaryTree(10);
		binaryTree.insertLeft(10, 20);
		binaryTree.insertRight(10, 30);

		binaryTree.insertLeft(20, 40);
		binaryTree.insertRight(20, 60);

		binaryTree.insertLeft(30, 70);
		binaryTree.insertRight(70, 80);

		System.out.println(isBST(binaryTree.getRoot()));
		
		BinaryTree binaryTree1 = new BinaryTree(10);
		binaryTree.insertLeft(10, 5);
		binaryTree.insertRight(10, 20);
		
		System.out.println(isBST(binaryTree1.getRoot()));

		
	}

}
