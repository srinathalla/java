package com.sri.algo.tree.cp;

import com.sri.algo.tree.BinaryTree;
import com.sri.algo.tree.Node;

/**
 * Given a BST,  and a reference to a Node x the task is to 
 * find the Inorder Successor of the node . 
 * 
 *  Input:
	2
	7
	20 8 22 4 12 10 14
	8
	7
	20 8 22 4 12 10 14
	10
	
	Output:
	10
	12
	
	T.C => O(n).

 * @author salla
 *
 */
public class InOrderSuccessor {

	static class NW {
		Node node;

		public NW(Node node) {
			this.node = node;
		}
	}

	public static Node inorderSuccessor(Node root, Node k) {
		NW nw = new NW(null);
		NW prev = new NW(null);

		inOrder(root, k, prev, nw);

		if (nw.node == null) {
			nw.node = new Node(-1);
		}

		return nw.node;
	}

	private static void inOrder(Node node, Node k, NW prev, NW nw) {
		if (node == null) {
			return;
		}

		inOrder(node.left, k, prev, nw);

		if (nw.node != null) {
			return;
		}

		if (prev.node != null && prev.node.data == k.data) {
			nw.node = node;
			return;
		}

		prev.node = node;

		inOrder(node.right, k, prev, nw);

	}
	
	public static void main(String[] args) {
		
		
		BinaryTree binaryTree = new BinaryTree(20);
		binaryTree.insertLeft(20, 8);
		binaryTree.insertRight(20, 22);

		binaryTree.insertRight(8, 12);
		binaryTree.insertLeft(8, 4);
	

		Node root = binaryTree.getRoot();
		Node k = root.left;
		System.out.println(inorderSuccessor(root,k).data);
		System.out.println(inorderSuccessor(root,root).data);
	}

}
