package com.sri.algo.tree.leet;

import java.util.HashMap;
import java.util.Map;

import com.sri.algo.tree.leet.BinaryTreeFromPreAndInOrder.TreeNode;

public class BinaryTreeFromPostAndInOrder {
	
	 public TreeNode buildTree(int[] inorder, int[] postorder) {
		 
		 if (postorder == null || postorder.length == 0 || 
	    			inorder == null || inorder.length ==0 || 
	    			postorder.length != inorder.length)
	    	{
	    		return null;
	    	}
	    	
	    	int n = inorder.length;
	    	
	    	Map<Integer, Integer> map = new HashMap<>();
	    	
	    	for (int i= 0; i< inorder.length;i++)
	    	{
	    		map.put(inorder[i], i);
	    	}
	    	
	    	return constructTree(postorder,0,n-1, inorder, 0, n-1,map);
	        
	    }
	 
	    
	    private TreeNode constructTree(int[] pre, int ps, int pe, 
	    		int[] in, int is, int ie, Map<Integer, Integer> map)
	    {
	    	
	    	if (is > ie || ps > pe)
	    	{
	    		return null;
	    	}
	    	
	    	int ri = map.get(pre[pe]);
	    	
	    	TreeNode root = new TreeNode(pre[pe]);
	    	
	    	TreeNode left = constructTree(pre, ps, ps + ri - is -1, in, is, ri -1, map);
	    	TreeNode right = constructTree(pre, ps + ri - is, pe -1, in, ri + 1, ie, map);
	    	
	    	root.left = left;
	    	root.right = right;
	    	
	    	return root;
	    }
	    
	    public static void main(String[] args) {
	    	
	    	 BinaryTreeFromPostAndInOrder binaryTreeFromPostAndInOrder = 
	     			new BinaryTreeFromPostAndInOrder();
	     	
	     	TreeNode node = 
	     			
	 			binaryTreeFromPostAndInOrder.buildTree( new int[] {9,3,15,20,7},new int[] {9,15,7,20,3});
	     	
	     	System.out.println(node);
			
		}
	    
	   


}
