package com.sri.algo.tree;

public class BinaryTreesAreIdentical {
	
	
	public static boolean areIdentical(Node root1 , Node root2)
	{
		
		if (root1 == null && root2 == null)
		{
			return true;
		}
		
		if (root1 != null && root2 != null)
		{
			return root1.data == root2.data &&
				areIdentical(root1.left, root2.left) &&
				areIdentical(root1.right , root2.right);
		}
		
		return false;	
	}
	
	public static void main(String[] args) {

		BinaryTree binaryTree = new BinaryTree(10);
		binaryTree.insertLeft(10, 20);
		binaryTree.insertRight(10, 30);

		// binaryTree.insertLeft(20, 40);
		binaryTree.insertRight(20, 60);

		binaryTree.insertLeft(30, 70);
		binaryTree.insertRight(70, 80);

		System.out.println(areIdentical(binaryTree.getRoot(), binaryTree.getRoot()));
	}


}
