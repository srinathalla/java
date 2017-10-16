package com.sri.algo.tree.cp;

import com.sri.algo.tree.BinaryTree;
import com.sri.algo.tree.Node;

public class SubTree {

	public static boolean isSubTree(Node T1, Node T2) {

		Node childOfT1 = find(T1, T2);

		if (childOfT1 == null) {
			return false;
		}

		return areIdentical(childOfT1, T2);

	}

	private static boolean areIdentical(Node T1, Node T2) {

		if (T1 == null && T2 == null) {
			return true;
		}

		if (T1 == null || T2 == null) {
			return false;
		}

		return T1.data == T2.data && areIdentical(T1.left, T2.left) && areIdentical(T1.right, T2.right);

	}

	private static Node find(Node T1, Node T2) {

		if (T1 == null || T2 == null) {
			return null;
		}

		if (T1.data == T2.data) {
			return T1;
		}

		Node T2InT1 = find(T1.left, T2);

		if (T2InT1 != null) {
			return T2InT1;
		}

		return find(T1.right, T2);
	}

	public static void main(String[] args) {

		BinaryTree binaryTreeT2 = new BinaryTree(10);
		binaryTreeT2.insertLeft(10, 4);
		binaryTreeT2.insertRight(10, 6);
		binaryTreeT2.insertLeft(6, 30);

		BinaryTree binaryTreeT1 = new BinaryTree(26);
		binaryTreeT1.insertLeft(26, 10);
		binaryTreeT1.insertRight(26, 3);
		binaryTreeT1.insertRight(3, 3);

		binaryTreeT1.insertLeft(10, 4);
		binaryTreeT1.insertRight(10, 6);
		binaryTreeT1.insertLeft(6, 30);

		System.out.println(isSubTree(binaryTreeT1.getRoot(), binaryTreeT2.getRoot()));

	}

}
