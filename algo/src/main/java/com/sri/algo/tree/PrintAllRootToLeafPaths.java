package com.sri.algo.tree;

public class PrintAllRootToLeafPaths {
	
	
	public static void printRootToLeafPaths(Node root)
	{
		
		printRootToLeafPaths(root,"");
		
	}
	
	public static void printRootToLeafPaths(Node node,String path)
	{
		
		if (node == null)
		{
			return;
		}
		
		path =  
			path.isEmpty() ? 
				path + node.data : 
				path + "," + node.data;
		
		if (node.left == null && node.right == null)
		{
			System.out.println("Path :" + path);
		}
		
		
		printRootToLeafPaths(node.left , path);
		printRootToLeafPaths(node.right , path);
		
	}
	
	public static void main(String[] args) {
		
		
		BinaryTree binaryTree = new BinaryTree(10);
		binaryTree.insertLeft(10, 20);
		binaryTree.insertRight(10, 30);

		 binaryTree.insertLeft(20, 40);
		binaryTree.insertRight(20, 80);

		binaryTree.insertLeft(30, 70);
		binaryTree.insertRight(30, 80);
		
		printRootToLeafPaths(binaryTree.getRoot());
	}

}
