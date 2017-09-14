package com.sri.algo.tree;

public class HieghtOfBinaryTree {

	public static int height(Node node) {
		
		if (node == null) {
			return 0;
		}

		return 1 + Integer.max(height(node.left), height(node.right));
	}
	
	public static void main(String[] args) {

		BinaryTree binaryTree = new BinaryTree(10);
		binaryTree.insertLeft(10, 20);
		binaryTree.insertRight(10, 30);

		// binaryTree.insertLeft(20, 40);
		binaryTree.insertRight(20, 60);

		binaryTree.insertLeft(30, 70);
		binaryTree.insertRight(70, 80);

		System.out.println(height(binaryTree.getRoot()));
	}


}
