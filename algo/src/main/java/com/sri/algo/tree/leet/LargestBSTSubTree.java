package com.sri.algo.tree.leet;

/**
 * Given a binary tree, find the largest subtree which is a Binary Search Tree
 * (BST), where largest means subtree with largest number of nodes in it.
 * 
 * Note: A subtree must include all of its descendants.
 * 
 * Example:
 * 
 * Input: [10,5,15,1,8,null,7]
 * 
 * 10 / \ 5 15 / \ \ 1 8 7
 * 
 * Output: 3 Explanation: The Largest BST Subtree in this case is the
 * highlighted one. The return value is the subtree's size, which is 3.
 * 
 * @author salla
 *
 */
public class LargestBSTSubTree {

	int size = 0;

	/**
	 * T.C : O(n)
	 * Single pass solution .
	 * 
	 * @param root
	 * @return
	 */
	public int largestBSTSubtree(TreeNode root) {

		largestBST(root);

		return size;
	}

	private int[] largestBST(TreeNode node) {

		if (node == null) {

			return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE, 0 };

		}

		int[] left = largestBST(node.left);

		int[] right = largestBST(node.right);

		if (left[2] == -1 || right[2] == -1 || left[1] > node.val || right[0] < node.val) {

			return new int[] { 0, 0, -1 };
		}

		size = Integer.max(size, 1 + left[2] + right[2]);

		return new int[] { Integer.min(left[0], node.val), Integer.max(right[1], node.val), 1 + left[2] + right[2] };

	}
	
	public static void main(String[] args) {
		
	}

}
