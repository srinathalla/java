package com.sri.algo.stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class IterativePreOrderTraversal {
	
	
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) 
		      { 
		    	  val = x; 
	    	  }
		  }
	
	public List<Integer> preorderTraversal(TreeNode root) {
		
		
		LinkedList<TreeNode> stack = new LinkedList<>();
		LinkedList<Integer> result = new LinkedList<>();
		
		if (root == null)
		{
			return result;
		}
		stack.add(root);
		while (!stack.isEmpty())
		{
			TreeNode curr = stack.pollLast();
			result.add(curr.val);
			
			if (curr.right != null)
			{
				stack.add(curr.right);
			}
			
			if (curr.left != null)
			{
				stack.add(curr.left);
			}	
		}
		
		return result;

	}

}
