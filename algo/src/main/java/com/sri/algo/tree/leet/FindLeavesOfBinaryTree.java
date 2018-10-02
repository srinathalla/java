package com.sri.algo.tree.leet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

 

	Example:
	
	Input: [1,2,3,4,5]
	  
	          1
	         / \
	        2   3
	       / \     
	      4   5    

	Output: [[4,5,3],[2],[1]]
	 
	
	Explanation:
	
	1. Removing the leaves [4,5,3] would result in this tree:
	
	          1
	         / 
	        2          
	 
	
	2. Now removing the leaf [2] would result in this tree:
	
	          1          
	 
	
	3. Now removing the leaf [1] would result in the empty tree:
	
	          []         
 */
public class FindLeavesOfBinaryTree {

	public List<List<Integer>> findLeaves(TreeNode root) {

		List<List<Integer>> res = new ArrayList<>();

		if (root == null) {
			return res;
		}

		while (root.left != null || root.right != null) {

			List<Integer> list = new ArrayList<>();
			addLeaves(root, null, -1, list);
			res.add(list);
		}

		List<Integer> rootList = new ArrayList<>();
		rootList.add(root.val);
		res.add(rootList);

		return res;

	}

	// This method recursively gathers all the leaf nodes and unlinks them from its parent .
	private void addLeaves(TreeNode node, TreeNode parent, int direction, List<Integer> list) {

		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {

			list.add(node.val);
			if (parent != null) {
				if (direction == 0) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			}

			return;
		}

		addLeaves(node.left, node, 0, list);
		addLeaves(node.right, node, 1, list);
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		FindLeavesOfBinaryTree findLeaves = new FindLeavesOfBinaryTree();

		System.out.println(findLeaves.findLeaves(root));
	}

}
