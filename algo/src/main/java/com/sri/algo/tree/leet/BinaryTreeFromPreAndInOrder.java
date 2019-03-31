package com.sri.algo.tree.leet;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromPreAndInOrder {
	
	public static class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		 }
	
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	
    	if (preorder == null || preorder.length == 0 || 
    			inorder == null || inorder.length ==0 || 
    			preorder.length != inorder.length)
    	{
    		return null;
    	}
    	
    	int n = inorder.length;
    	
    	Map<Integer, Integer> map = new HashMap<>();
    	
    	for (int i= 0; i< inorder.length;i++)
    	{
    		map.put(inorder[i], i);
    	}
    	
    	return constructTree(preorder,0,n-1, inorder, 0, n-1,map);
        
    }
    
    private TreeNode constructTree(int[] pre, int ps, int pe, 
    		int[] in, int is, int ie, Map<Integer, Integer> map)
    {
    	
    	if (is > ie || ps > pe)
    	{
    		return null;
    	}
    	
    	int ri = map.get(pre[ps]);
    	
    	TreeNode root = new TreeNode(pre[ps]);
    	
    	TreeNode left = constructTree(pre, ps + 1, ps + ri - is, in, is, ri -1, map);
    	TreeNode right = constructTree(pre, ps + ri - is + 1, pe, in, ri + 1, ie, map);
    	
    	root.left = left;
    	root.right = right;
    	
    	return root;
    }
    
    public static void main(String[] args) {
    	
    	BinaryTreeFromPreAndInOrder binaryTreeFromPreAndInOrder = 
    			new BinaryTreeFromPreAndInOrder();
    	
    	TreeNode node = 
    			
			binaryTreeFromPreAndInOrder.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
    	
    	System.out.println(node);
		
	}

}
