package com.sri.algo.tree;

public class MergeTwoBSTs {

	public static void merge(Node root1, Node root2) {

		Node head1 = BinaryTreeToDLL.binaryTreeTodll(root1);

		Node head2 = BinaryTreeToDLL.binaryTreeTodll(root2);

		Node mergedHead = mergeLists(head1, head2);

		BinaryTreeToDLL.printList(mergedHead);
	}

	private static Node mergeLists(Node h1, Node h2) {

		if (h1 == null && h2 == null) {
			return null;
		}

		if (h1 == null) {
			return h2;
		}

		if (h2 == null) {
			return h1;
		}

		if (h1.data <= h2.data) {

			Node mergedHead = mergeLists(h1.right, h2);
			h1.right = mergedHead;

			if (mergedHead != null) {
				mergedHead.left = h1;
			}

			return h1;
		} else {
			Node mergedHead = mergeLists(h1, h2.right);
			h2.right = mergedHead;

			if (mergedHead != null) {
				mergedHead.left = h1;
			}

			return h2;
		}
	}

}
