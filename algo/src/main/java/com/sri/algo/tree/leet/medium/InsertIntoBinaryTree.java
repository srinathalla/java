package com.sri.algo.tree.leet.medium;

public class InsertIntoBinaryTree {
	
	public class TreeNode {
		    int val;
		    TreeNode left;
		    TreeNode right;
		    TreeNode(int x) { val = x; }
		}

	public TreeNode insertIntoBST(TreeNode root, int val) {
		
		TreeNode curr = root, parent = null;
		
		while (curr != null)
		{
			parent = curr;
			
			curr = curr.val < val ? curr.right : curr.left;
		}
		
		if (parent.val < val)
		{
			parent.right = new TreeNode(val);
		}
		else
		{
			parent.left = new TreeNode(val);
		}
		
		return root;

	}

}
