package com.sri.algo.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public List<Integer> preorderTraversal(TreeNode root) 
	{
		LinkedList<Integer> result = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		
		TreeNode p = root;
		
		while (p != null || !stack.isEmpty())
		{
			
			if (p != null)
			{
				stack.push(p);
				result.add(p.val);	
				p = p.left;	
			}
			else
			{
				TreeNode node = stack.pop();
				p =  node.right;
			}
		}
		
		return result;
		
		
	}

}
