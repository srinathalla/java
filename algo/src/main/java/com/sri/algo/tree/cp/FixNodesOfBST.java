package com.sri.algo.tree.cp;

import com.sri.algo.tree.BinaryTree;
import com.sri.algo.tree.Node;

public class FixNodesOfBST {

	static class NodeWrapper {
		Node node;

		NodeWrapper(Node node) {
			this.node = node;
		}
	}

	public static Node fixNode(Node root) {

		NodeWrapper prev = new NodeWrapper(null), first = new NodeWrapper(null), last = new NodeWrapper(null),
				mid = new NodeWrapper(null);

		fixNode(root, prev, first, mid, last);

		if (first.node != null && last.node != null) {
			int temp = first.node.data;
			first.node.data = last.node.data;
			last.node.data = temp;
		} else {
			int temp = first.node.data;
			first.node.data = mid.node.data;
			mid.node.data = temp;
		}

		return root;
	}

	public static void fixNode(Node node, NodeWrapper prev, NodeWrapper first, NodeWrapper mid, NodeWrapper last) {

		if (node == null) {
			return;
		}

		fixNode(node.left, prev, first, mid, last);

		if (prev.node != null && node.data < prev.node.data) {
			if (first.node == null) {
				first.node = prev.node;
				mid.node = node;
			} else if (last.node == null) {
				last.node = node;
			}
		}

		prev.node = node;

		fixNode(node.right, prev, first, mid, last);

	}

	public static void main(String[] args) {

		BinaryTree binaryTreeT2 = new BinaryTree(10);
		binaryTreeT2.insertLeft(10, 5);
		binaryTreeT2.insertRight(10, 8);
		binaryTreeT2.insertLeft(5, 2);
		binaryTreeT2.insertRight(5, 20);

		Node root = fixNode(binaryTreeT2.getRoot());
		System.out.println(root.right);

	}

}
