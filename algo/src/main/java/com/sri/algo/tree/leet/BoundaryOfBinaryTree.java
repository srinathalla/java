package com.sri.algo.tree.leet;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author salla
 *
 */
public class BoundaryOfBinaryTree {

	public List<Integer> boundaryOfBinaryTree(TreeNode root) {

		List<Integer> result = new ArrayList<>();
		
		if (root == null)
		{
			return result;
		}

		result.add(root.val);
		
		TreeNode curr = root.left;

		while (curr != null && (curr.left != null || curr.right != null)) {
			result.add(curr.val);

			if (curr.left != null) {
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}

		addLeaves(root.left, result);
		addLeaves(root.right, result);
		
		curr =  root.right;
		Stack<Integer> stack = new Stack<>();
		while (curr != null && (curr.left != null || curr.right != null)) {
			stack.add(curr.val);

			if (curr.right != null) {
				curr = curr.right;
			} else {
				curr = curr.left;
			}
		}
		
		while (!stack.isEmpty())
		{
			result.add(stack.pop());
		}

		return result;

	}

	private void addLeaves(TreeNode node, List<Integer> result) {

		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			result.add(node.val);
			return;
		}

		addLeaves(node.left, result);
		addLeaves(node.right, result);
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(4);
		
		
		
		BoundaryOfBinaryTree boundaryOfBinaryTree = new BoundaryOfBinaryTree();
		
		System.out.println(boundaryOfBinaryTree.boundaryOfBinaryTree(root));
		
	}

}
