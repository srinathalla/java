package com.sri.algo.tree.leet.easy;

import com.sri.algo.tree.leet.TreeNode;

/**
 * Invert a binary tree.

	Example:
	
	Input:
	
	     4
	   /   \
	  2     7
	 / \   / \
	1   3 6   9
	Output:
	
	     4
	   /   \
	  7     2
	 / \   / \
	9   6 3   1
	
 * @author salla
 *
 */
public class InvertBinaryTree {
	
	/**
	 * T.C : O(n)
	 * 
	 * @param root
	 * @return
	 */
	 public TreeNode invertTree(TreeNode root) {
		 
		 if (root == null)
		 {
			 return root;
		 }
		 
		 TreeNode left = invertTree(root.left);
		 
		 TreeNode right =  invertTree(root.right);
		 
		 root.left = right;
		 root.right = left;
		 
		 return root;
	        
	    }

}
