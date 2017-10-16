package com.sri.algo.tree.cp;

import java.util.LinkedList;
import java.util.Queue;

import com.sri.algo.tree.BinaryTree;
import com.sri.algo.tree.Node;

/**
 * Given a Binary Tree, Print the corner nodes at each level. The node at the
 * leftmost and the node at the rightmost.
 * 
 * 15 10 20 8 12 16 25.
 * 
 * For example, output for following is 15, 10, 20, 8, 25.
 * 
 *
 */
public class LeftMostNRightMostNodes {

	static class NodeWrapper {
		Node node;
		int level;

		NodeWrapper(Node node, int level) {
			this.node = node;
			this.level = level;
		}
	}

	public static void printLeftNRightMostNodes(Node root) {

		Queue<NodeWrapper> queue = new LinkedList<>();
		queue.add(new NodeWrapper(root, 0));

		int curr_level = -1;
		Node first = null, last = null;

		while (!queue.isEmpty()) {

			NodeWrapper wrapper = queue.poll();

			if (wrapper.level > curr_level) {

				if (last != null && last != first) {
					System.out.print(last.data + " ");
				}

				curr_level = wrapper.level;
				first = last = wrapper.node;
				System.out.print(first.data + " ");
			} else {
				last = wrapper.node;
			}

			if (wrapper.node.left != null) {
				queue.add(new NodeWrapper(wrapper.node.left, wrapper.level + 1));
			}
			if (wrapper.node.right != null) {
				queue.add(new NodeWrapper(wrapper.node.right, wrapper.level + 1));
			}
		}

		if (last != null && last != first) {
			System.out.print(last.data + " ");
		}
	}

	public static void printLeftNRightMostNodesWithoutLevel(Node root) {

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null); // null indicates end of level.

		// Holds first and last nodes in each level.
		Node first = null, last = null;

		while (!queue.isEmpty()) {

			Node node = queue.poll();
			if(node == null)
			{	
				// After reaching end of level print its first and last node's and
				// reset first,last to null.
				if(first != null)
				{
					System.out.print(first.data + " ");
					if(first != last)
					{
						System.out.print(last.data + " ");
					}
					
					
					
					
					first = null;
					last = null;
					queue.add(null);
				}
			}
			else
			{
				if (first == null) {
					first = last = node;
				}
				else
				{
					last = node;
				}
				
				if (node.left != null) {
					queue.add(node.left);
				}

				if (node.right != null) {
					queue.add(node.right);
				}
			}

			
		}
	}

	public static void main(String[] args) {

		BinaryTree binaryTree = new BinaryTree(15);
		binaryTree.insertLeft(15, 10);
		binaryTree.insertLeft(10, 8);

		binaryTree.insertRight(10, 12);
		binaryTree.insertRight(15, 20);

		binaryTree.insertLeft(20, 16);
		binaryTree.insertRight(20, 25);

		printLeftNRightMostNodes(binaryTree.getRoot());
		

		System.out.println();

		BinaryTree binaryTree1 = new BinaryTree(1);
		binaryTree1.insertRight(1, 2);
		binaryTree1.insertRight(2, 3);

		printLeftNRightMostNodes(binaryTree1.getRoot());
		
		System.out.println();
		
		printLeftNRightMostNodesWithoutLevel(binaryTree.getRoot());
		
		System.out.println();
		printLeftNRightMostNodesWithoutLevel(binaryTree1.getRoot());
	}

}
