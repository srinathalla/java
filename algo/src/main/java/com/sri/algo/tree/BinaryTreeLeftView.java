package com.sri.algo.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLeftView {
	
	
	public List<Node> leftView(Node root)
	{
		List<Node> nodes  = new ArrayList<>();
		
		populateLeftViewNodes(root,nodes); 
		
		return nodes;
	}
	
	public void populateLeftViewNodes(Node node,List<Node> nodes)
	{
		if(node != null)
		{
			nodes.add(node);
			
			if (node.left != null)
			{
				populateLeftViewNodes(node.left,nodes);
			}
			else if(node.right != null)
			{
				populateLeftViewNodes(node.right,nodes);
			}
		}
	}
	
	public static void main(String[] args) {
		
		BinaryTree binaryTree = new BinaryTree(10);
		binaryTree.insertLeft(10, 20);
		binaryTree.insertRight(10, 30);
		
		binaryTree.insertLeft(20, 40);
		binaryTree.insertRight(20, 60);
		
		System.out.println(new BinaryTreeLeftView().leftView(binaryTree.getRoot()));
	}

}
