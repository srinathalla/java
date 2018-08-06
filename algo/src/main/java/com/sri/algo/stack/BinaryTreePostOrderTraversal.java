package com.sri.algo.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * Input: [1,null,2,3] 1 \ 2 / 3
 * 
 * Output: [3,2,1]
 * 
 * @author salla
 *
 */
public class BinaryTreePostOrderTraversal {

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> postorderTraversal(TreeNode root) {

		LinkedList<Integer> result = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;

		while (!stack.isEmpty() || p != null) {

			if (p != null) {
				stack.push(p);
				result.addFirst(p.val);
				p = p.right;
			} else {
				TreeNode poppedNode = stack.pop();
				p = poppedNode.left;
			}

		}

		return result;

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);

		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(4);

		BinaryTreePostOrderTraversal btp = new BinaryTreePostOrderTraversal();

		System.out.println(btp.postorderTraversal(root));

	}

}
