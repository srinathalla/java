package com.sri.algo.tree;

public class CountLeafNodes {
	
	static class NodeCounter
	{
		int value;
	}
	
	public static int countLeafNodes(Node root)
	{
		NodeCounter nc = new NodeCounter();
		countLeafNodes(root, nc);
		
		return nc.value;
	}
	
	
	private static void countLeafNodes(Node node,NodeCounter nc)
	{
		if (node == null)
		{
			return;
		}
			
		if (node.left == null && node.right == null)
		{
			 nc.value = nc.value + 1;
		}
		
		
		countLeafNodes(node.left, nc);
		
		countLeafNodes(node.right, nc);
		
	}
	
	public static void main(String[] args) {

			BinaryTree binaryTree = new BinaryTree(10);
			binaryTree.insertLeft(10, 20);
			binaryTree.insertRight(10, 30);

			binaryTree.insertLeft(20, 40);
			binaryTree.insertRight(20, 60);

			binaryTree.insertLeft(30, 70);
			binaryTree.insertRight(70, 80);
			
			binaryTree.insertLeft(40, 90);
			binaryTree.insertLeft(90, 100);

			System.out.println(countLeafNodes(binaryTree.getRoot()));
		
	}

}
