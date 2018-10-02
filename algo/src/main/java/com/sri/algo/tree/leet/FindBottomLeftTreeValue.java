package com.sri.algo.tree.leet;

/**
	 * Given a binary tree, find the leftmost value in the last row of the tree.
	
	Example 1:
	Input:
	
	    2
	   / \
	  1   3
	
	Output: 1
	Example 2: 
	Input:
	
	        1
	       / \
	      2   3
	     /   / \
	    4   5   6
	       /
	      7
	
	Output: 7
 * 
 * 
 * @author salla
 *
 */
public class FindBottomLeftTreeValue {

	public int findBottomLeftValue(TreeNode root) {

		int[] max = new int[] { -1, -1 };
		findBottomLeftValue(root, 0, max);

		return max[1];

	}

	private void findBottomLeftValue(TreeNode node, int d, int[] max) {

		if (node == null) {
			return;
		}

		if (d > max[0]) {
			max[0] = d;
			max[1] = node.val;
		}

		findBottomLeftValue(node.left, d + 1, max);
		findBottomLeftValue(node.right, d + 1, max);

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		FindBottomLeftTreeValue findBottomLeftTreeValue = new FindBottomLeftTreeValue();

		System.out.println(findBottomLeftTreeValue.findBottomLeftValue(root));

	}

}
