package com.sri.algo.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	 public List<Integer> inorderTraversal(TreeNode root) {
		 
			 List<Integer> result = new ArrayList<>();
			 Stack<TreeNode> stack = new Stack<>();
			 
			 TreeNode curr = root;
			 
			 while (curr != null || !stack.isEmpty())
			 {
				 
				 if (curr != null)
				 {
					 stack.push(curr);
					 curr = curr.left;
				 }
				 else
				 {
					 TreeNode popped = stack.pop();
					 result.add(popped.val);
					 
					 curr = popped.right;
				 }
			 }
			 
			 return result;
	        
	    }

}
