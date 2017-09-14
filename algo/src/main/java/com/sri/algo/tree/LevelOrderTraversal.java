package com.sri.algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

	/**
	 * 
	 * Time Complexity O(n).
	 * Using queue nodes are traversed in level order and added to list.
	 * 
	 */
	public static List<Node> levelOrder(Node root) {
		List<Node> nodes = new ArrayList<>();

		Queue<Node> nodesQueue = new LinkedList<>();

		nodesQueue.add(root);

		while (!nodesQueue.isEmpty()) {

			Node node = nodesQueue.poll();
			nodes.add(node);

			if (node.left != null) {
				nodesQueue.add(node.left);
			}

			if (node.right != null) {
				nodesQueue.add(node.right);
			}
		}

		return nodes;
	}
	
	public static void main(String[] args) {

		BinaryTree binaryTree = new BinaryTree(10);
		binaryTree.insertLeft(10, 20);
		binaryTree.insertRight(10, 30);

		binaryTree.insertLeft(20, 40);
		binaryTree.insertRight(20, 60);

		binaryTree.insertLeft(30, 70);
		binaryTree.insertRight(70, 80);

		System.out.println(levelOrder(binaryTree.getRoot()));
	}

}
