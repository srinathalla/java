package com.sri.algo.tree;

public class DiameterOfBinaryTree {
	static class  Hieght {
		int h = 0;
	}

	public static int getDiameter(Node node, Hieght hieght) 
	{
		
		Hieght lh = new Hieght();
		Hieght rh = new Hieght();
		
		if (node == null) {
			hieght.h = 0;
			return 0;
		}

		int ld = getDiameter(node.left, lh);
		int rd = getDiameter(node.right, rh);
		
		hieght.h = Math.max(lh.h, rh.h) + 1;

		return Math.max(lh.h + rh.h + 1, Math.max(ld, rd));

	}
	
	public static int getDiameterUsingMaxRootToLeafAppraoch(Node node, Counter c) 
	{
		
		if (node == null) {	
			return 0;
		}

		int ld = getDiameterUsingMaxRootToLeafAppraoch(node.left, c);
		int rd = getDiameterUsingMaxRootToLeafAppraoch(node.right, c);
		
		// Update c at each node that has both children.
		if (node.left != null && node.right != null)
		{
			c.val = Integer.max(c.val, ld + rd + 1);
		}

		// Returns max root to leaf path sum originating at current node.
		// Each node value is assumed as 1.
		return Math.max(ld,rd) + 1;
	}
	
	   public static int d = 0;
	   /* Complete the function to get diameter of a binary tree */
	    public static int diameter(Node node)
	    {
	         if (node == null)
	         {
	             return 0;
	         }
	         
	         int dia = diameter(node.left) + diameter(node.right) + 1;
	         
	         d = Integer.max(dia,d);
	         
	         return d;
	    }


	public static void main(String[] args) {

		BinaryTree binaryTree = new BinaryTree(10);
		binaryTree.insertLeft(10, 20);
		binaryTree.insertRight(10, 30);

		binaryTree.insertLeft(20, 40);
		binaryTree.insertRight(20, 60);

		System.out.println(getDiameter(binaryTree.getRoot(),new Hieght()));
		
		Counter c  = new Counter();
		c.val = Integer.MIN_VALUE;
		
		getDiameterUsingMaxRootToLeafAppraoch(binaryTree.getRoot(),c);
		
		System.out.println(c.val);
		
		System.out.println(diameter(binaryTree.getRoot()));
	}
}
