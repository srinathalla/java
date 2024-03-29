package com.sri.algo.tree.leet.easy;

import com.sri.algo.tree.leet.TreeNode;

/**
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

	You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
	
	Example 1:
	
	Input: 
		Tree 1                     Tree 2                  
	          1                         2                             
	         / \                       / \                            
	        3   2                     1   3                        
	       /                           \   \                      
	      5                             4   7                  
	Output: 
	Merged tree:
		     3
		    / \
		   4   5
		  / \   \ 
		 5   4   7
		 
 * @author salla
 *
 */
public class MergeTwoBinaryTrees {
	
	/**
	 * T.C : O(min(n,m))
	 * @param t1
	 * @param t2
	 * @return
	 */
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

		if (t1 == null) {
			return t2;
		}

		if (t2 == null) {
			return t1;
		}

		TreeNode node = new TreeNode(t1.val + t2.val);

		node.left = mergeTrees(t1.left, t2.left);
		node.right = mergeTrees(t1.right, t2.right);

		return node;

	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		TreeNode root1 = new TreeNode(2);
		root1.left = new TreeNode(3);
		root1.right = new TreeNode(4);
		
		MergeTwoBinaryTrees mergeTwoBinaryTrees = new MergeTwoBinaryTrees();
		
		TreeNode merged = mergeTwoBinaryTrees.mergeTrees(root, root1);
		
		System.out.println(merged);
	
		
	}

}
