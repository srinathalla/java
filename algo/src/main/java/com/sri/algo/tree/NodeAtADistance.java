package com.sri.algo.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a Binary Tree and a positive integer k, count all distinct nodes that
 * are distance k from a leaf node. Here k distance from a leaf means k levels
 * higher than a leaf node. For example if k is more than height of Binary Tree,
 * then nothing should be counted. Expected time complexity is O(n) where n is
 * the number nodes in the given Binary Tree.
 *       Given i/P: and k =2  
 *              1
 *          2        3
 *       5      4  6     7
 *                   8
 *                   
 *                   o/p Distinct nodes at a distance of 2 from leaf nodes are: 1,3 => 2
 */
public class NodeAtADistance {

	public static int countDistinctNodes(Node node, int k) {

		if (node == null) {
			return 0;
		}

		List<Node> pathNodes = new ArrayList<>();
		Set<Node> distinctNodes = new HashSet<>();

		countDistinctNodes(node, k, pathNodes, distinctNodes);

		return distinctNodes.size();

	}

	public static void countDistinctNodes(Node node, int k, List<Node> pathNodes, Set<Node> distinctNodesAtKDistance) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			if (pathNodes.size() >= k) {
				distinctNodesAtKDistance.add(pathNodes.get(pathNodes.size() - k));
			}
			return;
		}

		pathNodes.add(node);

		countDistinctNodes(node.left, k, pathNodes, distinctNodesAtKDistance);
		countDistinctNodes(node.right, k, pathNodes, distinctNodesAtKDistance);

		pathNodes.remove(node);

	}

	public static void main(String[] args) {

		BinaryTree binaryTree = new BinaryTree(1);
		binaryTree.insertLeft(1, 2);
		binaryTree.insertRight(2, 4);

		binaryTree.insertLeft(2, 5);
		binaryTree.insertRight(1, 3);

		binaryTree.insertLeft(3, 6);
		binaryTree.insertRight(6, 8);

		binaryTree.insertRight(3, 7);

		System.out.println(countDistinctNodes(binaryTree.getRoot(),2));

	}
}
