package com.sri.algo.tree.cp;

import com.sri.algo.tree.BinaryTree;
import com.sri.algo.tree.Node;

/**
 * Given root of binary search tree and K as input, find K-th smallest element in BST. 
 * Your task is to return the K-th smallest element 
 * in BST from the function k_smallest_element().
 *
 *  Input:
	1
	5
	20 8 4 22 12
	3 
	
	Output:
	12
	
	T.C : O(n)
 *
 */
public class KThSmallest {

	static class NW {
		Node node;

		public NW(Node node) {
			this.node = node;
		}
	}

	static class Counter {
		int val;
	}

	public static Node kThSmallest(Node root, int k) {
		NW nw = new NW(null);

		inOrder(root, k, new Counter(), nw);

		if (nw.node == null) {
			nw.node = new Node(-1);
		}

		return nw.node;
	}

	private static void inOrder(Node node, int k, Counter c, NW nw) {
		if (node == null) {
			return;
		}

		inOrder(node.left, k, c, nw);

		if (nw.node != null) {
			return;
		}
		c.val++;

		if (c.val == k) {
			nw.node = node;
			return;
		}

		inOrder(node.right, k, c, nw);
	}

	public static void main(String[] args) {

		BinaryTree binaryTree = new BinaryTree(20);
		binaryTree.insertLeft(20, 8);
		binaryTree.insertRight(20, 22);

		binaryTree.insertRight(8, 12);
		binaryTree.insertLeft(8, 4);

		Node root = binaryTree.getRoot();

		System.out.println(kThSmallest(root, 3).data);
		System.out.println(kThSmallest(root, 4).data);
	}

}
