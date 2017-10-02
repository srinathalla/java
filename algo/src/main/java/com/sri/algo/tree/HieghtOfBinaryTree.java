package com.sri.algo.tree;

import java.util.Scanner;

public class HieghtOfBinaryTree {

	public static int height(Node node) {
		
		if (node == null) {
			return 0;
		}

		return 1 + Integer.max(height(node.left), height(node.right));
	}
	
	public static void main(String[] args) {

		/*BinaryTree binaryTree = new BinaryTree(10);
		binaryTree.insertLeft(10, 20);
		binaryTree.insertRight(10, 30);

		// binaryTree.insertLeft(20, 40);
		binaryTree.insertRight(20, 60);

		binaryTree.insertLeft(30, 70);
		binaryTree.insertRight(70, 80);

		System.out.println(height(binaryTree.getRoot()));*/
		

		try (Scanner in = new Scanner(System.in)) {
			int tests = in.nextInt();

			BinaryTree binaryTree = null;
			for (int test = 0; test < tests; test++) {
				int edges = in.nextInt();

				for (int i = 0; i < edges; i++) {
					int node = in.nextInt();
					int child = in.nextInt();
					String op = in.next();

					if (binaryTree == null) {
						binaryTree = new BinaryTree(node);
					}

					if (op.equals("L")) {
						binaryTree.insertLeft(node, child);
					}

					else if (op.equals("R")) {
						binaryTree.insertRight(node, child);
					}
				}
				
				System.out.println();
				//System.out.println(binaryTree.printCornerNodes());
				
				System.out.println(height(binaryTree.root));
				binaryTree = null;

			}
		}
	}


}
