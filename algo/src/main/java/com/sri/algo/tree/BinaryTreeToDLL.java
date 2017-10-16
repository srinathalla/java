package com.sri.algo.tree;

/**
 * Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place.
 * The left and right pointers in nodes are to be used as previous and next
 * pointers respectively in converted DLL. The order of nodes in DLL must be
 * same as inorder of the given Binary Tree. The first node of Inorder traversal
 * (left most node in BT) must be head node of the DLL.
 * 
 *  input:
 * 	2
	2
	1 2 R 1 3 L
	4
	10 20 L 10 30 R 20 40 L 20 60 R
	
	output:
	3 1 2 
	2 1 3 
	40 20 60 10 30 
	30 10 60 20 40 
	
	Time Complexity: O(n) as all nodes are visited only once.
 * 
 *
 */
public class BinaryTreeToDLL {

	public static Node binaryTreeTodll(Node root) {

		if (root == null) {
			return null;
		}

		Node prev = binaryTreeTodll(root.left);
		Node curr = prev;

		// Tail node of left tree should be linked to the left of the root.
		if (curr != null) {
			while (curr.right != null) {
				curr = curr.right;
			}
			curr.right = root;
		}
		root.left = curr;

		// Head node of right tree should be linked to the right of the root.
		curr = binaryTreeTodll(root.right);
		if (curr != null) {
			curr.left = root;
		}
		root.right = curr;

		 // If left tree is empty root becomes the head of the dll.
		return prev != null ? prev : root;
	}

	public static void printList(Node head) {

		while (head != null) {
			System.out.print(head.data + " ");

			head = head.right;
		}
	}

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree(5);
		tree.root.left = new Node(3);
		tree.root.right = new Node(6);
		tree.root.left.right = new Node(4);
		tree.root.left.left = new Node(1);
		tree.root.right.right = new Node(8);
		tree.root.left.left.right = new Node(2);
		tree.root.left.left.left = new Node(0);
		tree.root.right.right.left = new Node(7);
		tree.root.right.right.right = new Node(9);

		Node head = binaryTreeTodll(tree.root);
		printList(head);

	}

}
