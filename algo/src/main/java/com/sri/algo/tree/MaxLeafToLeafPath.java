package com.sri.algo.tree;

public class MaxLeafToLeafPath {
	

	public static int maxLeafToLeafPathSum(Node root)
	{
		Counter c = new Counter();
		c.val = Integer.MIN_VALUE;
		
		maxLeafToLeafPathSum(root, c);
		
		return c.val;
	}
	
	public static int maxLeafToLeafPathSum(Node node,Counter c) {

		if (node == null) {
			return 0;
		}
		
		Integer ls = maxLeafToLeafPathSum(node.left, c);
		
		Integer rs = maxLeafToLeafPathSum(node.right, c);
		
		if (node.left != null && node.right != null)
		{
			c.val = Integer.max(c.val, ls + rs + node.data);
		}
		
		return
			Integer.max(
					ls,
					rs) + node.data;	
	}
	
	public static void main(String[] args) {
		

			BinaryTree binaryTree = new BinaryTree(10);
			binaryTree.insertLeft(10, 20);
			binaryTree.insertRight(10, 30);

			binaryTree.insertLeft(20, 40);
			binaryTree.insertRight(20, 80);

			binaryTree.insertLeft(30, 70);
			binaryTree.insertRight(30, 80);

			System.out.println(maxLeafToLeafPathSum(binaryTree.getRoot()));
			
		
	}


}
