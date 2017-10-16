package com.sri.algo.tree.cp;

import com.sri.algo.tree.BinaryTree;
import com.sri.algo.tree.Node;

public class MinDepth {

	/*
	 * Please note that it's Function problem i.e. you need to write your solution
	 * in the form of Function(s) only. Driver Code to call/invoke your function
	 * would be added by GfG's Online Judge.
	 */

	static class Level {
		int val = Integer.MAX_VALUE;;
	}

	static int minDepth(Node root) {
		Level level = new Level();
		minDepth(root, 1, level);

		return level.val;

	}

	static void minDepth(Node root, int nodesCount, Level level) {

		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			level.val = Integer.min(level.val, nodesCount);
		}

		minDepth(root.left, nodesCount + 1, level);
		minDepth(root.right, nodesCount + 1, level);

	}
	
	public static void main(String[] args) {
		

		BinaryTree binaryTree = new BinaryTree(15);
		binaryTree.insertLeft(15, 10);
		binaryTree.insertLeft(10, 8);

		binaryTree.insertRight(10, 12);
		binaryTree.insertRight(15, 20);

		binaryTree.insertLeft(20, 16);
		binaryTree.insertRight(20, 25);

		System.out.println(minDepth(binaryTree.getRoot()));
		
	}

}
