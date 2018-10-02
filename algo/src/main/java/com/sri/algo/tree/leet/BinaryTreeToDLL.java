package com.sri.algo.tree.leet;

/**
 * Convert a BST to a sorted circular doubly-linked list in-place. Think of the
 * left and right pointers as synonymous to the previous and next pointers in a
 * doubly-linked list.
 * 
 * Let's take the following BST as an example, it may help you understand the
 * problem better:
 * 
 * 
 * 
 * 
 * 
 * We want to transform this BST into a circular doubly linked list. Each node
 * in a doubly linked list has a predecessor and successor. For a circular
 * doubly linked list, the predecessor of the first element is the last element,
 * and the successor of the last element is the first element.
 * 
 * The figure below shows the circular doubly linked list for the BST above. The
 * "head" symbol means the node it points to is the smallest element of the
 * linked list.
 * 
 * 
 * Specifically, we want to do the transformation in place. After the
 * transformation, the left pointer of the tree node should point to its
 * predecessor, and the right pointer should point to its successor. We should
 * return the pointer to the first element of the linked list.
 * 
 * The figure below shows the transformed BST. The solid line indicates the
 * successor relationship, while the dashed line means the predecessor
 * relationship.
 * 
 * 
 * 
 * @author salla
 *
 */
public class BinaryTreeToDLL {

	public TreeNode treeToDoublyList(TreeNode root) {

		if (root == null) {
			return null;
		}

		TreeNode node = inOrder(root, new TreeNode[] { null });

		TreeNode head, tail = null;

		TreeNode curr = node;
		while (curr.left != null) {
			curr = curr.left;
		}
		head = curr;

		curr = node;
		while (curr.right != null) {
			curr = curr.right;
		}
		tail = curr;

		tail.right = head;
		head.left = tail;

		return head;
	}

	/**
	 * Idea is to use previous pointer and link previous with current by doing 
	 * in order traversal.
	 * 
	 * @param curr
	 * @param prev
	 * @return
	 */
	private TreeNode inOrder(TreeNode curr, TreeNode[] prev) {

		if (curr == null) {
			return null;
		}

		inOrder(curr.left, prev);

		curr.left = prev[0];

		if (prev[0] != null) {
			prev[0].right = curr;
		}

		prev[0] = curr;

		inOrder(curr.right, prev);

		return curr;
	}
	
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		
		BinaryTreeToDLL binaryTreeToDLL = new BinaryTreeToDLL();
		
		TreeNode head = binaryTreeToDLL.treeToDoublyList(root);
		System.out.println(head);
		
		
	}

}
