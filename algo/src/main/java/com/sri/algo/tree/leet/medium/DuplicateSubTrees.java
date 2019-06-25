package com.sri.algo.tree.leet.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 Given a binary tree, return all duplicate subtrees. For each kind 
 of duplicate subtrees, you only need to return the root node of any
 one of them.

   Two trees are duplicate if they have the same structure with same 
   node values.
   
 @author salla

**/
public class DuplicateSubTrees {
	
	public static class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		 }
	
	    int t;
	    Map<String, Integer> trees;
	    Map<Integer, Integer> count;
	    List<TreeNode> ans;

	    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
	       
	    	t =1;    	
	    	trees = new HashMap<>();
	    	count = new HashMap<>();
	    	ans = new ArrayList<>();
	    	
	    	lookup(root);
	    	
	    	return ans;
	    	
	    }

	    public int lookup(TreeNode node) 
	    {
	      
	    	if (node == null)
	    	{
	    		return 0;
	    	}
	    	
	    	String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
	    	
	    	int uid = trees.computeIfAbsent(serial, a -> t++);
	    	count.put(uid, count.getOrDefault(uid, 0) + 1);
	    	
	    	if (count.get(uid) == 2)
	    	{
	    		ans.add(node);
	    	}
	    	
	    	return uid;
	    	
	    }
        
    

}
