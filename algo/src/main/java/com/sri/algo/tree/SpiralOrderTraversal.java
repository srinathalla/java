package com.sri.algo.tree;

import java.util.Stack;

public class SpiralOrderTraversal {
	
	
	/** 
	 *      For the given tree
	 *         
	 *             1
	 *         2        3
	 *     7     6    5     4
	 *     
	 *     Spiral Order : 1 2 3 4 5 6 7 
	 */
	public static void spiralOrderTraversal(Node root)
	{
		Stack<Node> rToL = new Stack<>();	
		Stack<Node> LToR = new Stack<>();
		
		rToL.push(root);
		
		while (!rToL.isEmpty() || !LToR.isEmpty())
		{	
			
			 while (!rToL.isEmpty())
			 {		 
				 Node node = rToL.pop();
				 System.out.print(node.data + " ");
				
				 if (node.right != null)
				 {
					 LToR.push(node.right);
				 }
				 if (node.left != null)
				 {
					 LToR.push(node.left);
				 }
			 }
			 
			 while (!LToR.isEmpty())
			 {
				 Node node = LToR.pop();
				 System.out.print(node.data + " ");
				 
				 if (node.left != null)
				 {
					 rToL.push(node.left);
				 }
				 if (node.right != null)
				 {
					 rToL.push(node.right);
				 }
			 }
		}
	}
	
	public static void main(String[] args) 
	{
		BinaryTree binaryTree = new BinaryTree(10);
		binaryTree.insertLeft(10, 20);
		binaryTree.insertRight(10, 30);

		 binaryTree.insertLeft(20, 40);
		binaryTree.insertRight(20, 60);

		binaryTree.insertLeft(30, 70);
		binaryTree.insertRight(30, 80);
		
		 binaryTree.insertLeft(40 , 35); 
		 binaryTree.insertRight(40 , 45);
		
		spiralOrderTraversal(binaryTree.getRoot());
		
	}

}
