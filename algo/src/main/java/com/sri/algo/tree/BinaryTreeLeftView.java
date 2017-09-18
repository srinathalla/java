package com.sri.algo.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLeftView {

	/**
	 *  Left view is the first node present in each level.
	 *  
	 *              10
 *             20        40
 *        30         60
 *               70
 *               
 *            Left View is 10,20,30 ,70
	 *  
	 * @param root
	 * @return
	 */
	public static List<Node> leftView(Node root) {
		List<Node> nodes = new ArrayList<>();

		Level maxLevel = new Level();
		maxLevel.value = -1;

		populateLeftViewNodes(root, 0, maxLevel, nodes);

		return nodes;
	}

	public static void populateLeftViewNodes(Node node, int level, Level maxLevel, List<Node> nodes) 
	{	
		if (node != null) {
			
			if (level > maxLevel.value) {
				nodes.add(node);
				maxLevel.value = level;
			}

			populateLeftViewNodes(node.left, level + 1, maxLevel, nodes);
			populateLeftViewNodes(node.right, level + 1, maxLevel, nodes);
		}
	}

	public static void main(String[] args) {

		BinaryTree binaryTree = new BinaryTree(10);
		binaryTree.insertLeft(10, 20);
		binaryTree.insertRight(10, 30);

		 binaryTree.insertLeft(20, 40);
		binaryTree.insertRight(20, 60);

		binaryTree.insertLeft(30, 70);
		binaryTree.insertRight(70, 80);

		System.out.println(leftView(binaryTree.getRoot()));
	}

}
