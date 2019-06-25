package com.sri.algo.tree;

import java.util.ArrayList;
import java.util.List;

public class CheckCompletenessOfBinaryTree {
	
	public static class TreeNode {
		    int val;
		    TreeNode left;
		    TreeNode right;
		    TreeNode(int x) { val = x; }
		}
	
	
	 public boolean isCompleteTree(TreeNode root) {
		 
		 List<WNode> nodes= new ArrayList<>();
		 nodes.add(new WNode(root, 1));
		 
		 int i =0;
		 while(i< nodes.size())
		 {
			 WNode wnode = nodes.get(i++);
			 
			 if (wnode.node != null)
			 {
				 if(wnode.node.left != null)
				 {
					 nodes.add(new WNode(wnode.node.left, wnode.code * 2));
				 }
				 if(wnode.node.right != null)
				 {
					 nodes.add(new WNode(wnode.node.right, wnode.code * 2 + 1));
				 }
			 }
		 }
		 
		 return nodes.get(i -1).code == nodes.size();
	        
	 }
	 
	 
	 private static class WNode
	 {
		 TreeNode node;
		 int code;
		public WNode(TreeNode node, int code) {
			super();
			this.node = node;
			this.code = code;
		}
		 
	 }
	 
	 public static void main(String[] args) {
		 
		 TreeNode root = new TreeNode(1);
		 root.left = new TreeNode(2);
		 root.right = new TreeNode(3);
		 root.right.left = new TreeNode(4);
		 
		 CheckCompletenessOfBinaryTree checkCompletenessOfBinaryTree = new
				 CheckCompletenessOfBinaryTree();
		 
		 System.out.println(
			 checkCompletenessOfBinaryTree.isCompleteTree(root));
		 
		 
		
	}

}
