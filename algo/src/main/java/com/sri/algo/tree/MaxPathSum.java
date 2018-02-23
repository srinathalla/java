package com.sri.algo.tree;

/**
 *   Time Complexity : O(n).
 *   
 *   Single Pass Solution.
 *   
 *   Given a binary tree, find the maximum path sum.

	For this problem, a path is defined as any sequence of nodes from some starting node to 
	any node in the tree along the parent-child connections. The path must contain at least 
	one node and does not need to go through the root.
	
	For example:
	Given the below binary tree,
	
	       1
	      / \
	     2   3
	     
	O/P : 6.
 * 
 * @author salla
 *
 */
public class MaxPathSum {

	private int max_val = Integer.MIN_VALUE;

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			this.val = x;
		}
	}

	public int maxPathSum(TreeNode root) {

		maxPathSubTree(root);

		return max_val;

	}

	public int maxPathSubTree(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int ls, rs;
		ls = Integer.max(0, maxPathSubTree(root.left));
		rs = Integer.max(0, maxPathSubTree(root.right));

		max_val = Integer.max(max_val, ls + rs + root.val);

		return Integer.max(ls, rs) + root.val;
	}

	public static void main(String[] args) {

		MaxPathSum pathSum = new MaxPathSum();
		TreeNode treeNode = new TreeNode(-3);
		System.out.println(pathSum.maxPathSum(treeNode));
		
		TreeNode treeNode1 = new TreeNode(1);
		treeNode1.left = new TreeNode(2);
		treeNode1.right = new TreeNode(3);
		System.out.println(pathSum.maxPathSum(treeNode1));

	}

}
