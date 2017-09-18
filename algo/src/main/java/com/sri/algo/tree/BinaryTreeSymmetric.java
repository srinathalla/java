package com.sri.algo.tree;

public class BinaryTreeSymmetric {
	
	
	public static boolean isSymmetric(Node root)
	{
		return isMirror(root.left , root.right);
	}
	
	private static boolean isMirror(Node node1, Node node2)
	{
		
		if (node1 == null && node2 == null)
		{
			return true;
		}
		
		if (node1 == null || node2 == null)
		{
			return false;
		}
		
		return node1.data == node2.data &&
			isMirror(node1.left, node2.right) &&
			isMirror(node1.right, node2.left);
	}
	
	
	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree(1);
		
		bt.getRoot().left = new Node(2);
		bt.getRoot().right = new Node(2);
		
		bt.getRoot().left.left = new Node(3);
		bt.getRoot().left.right = new Node(4);
		
		bt.getRoot().right.left = new Node(4);
		bt.getRoot().right.right = new Node(3);
		
		
		System.out.println(isSymmetric(bt.getRoot()));
	}

}
