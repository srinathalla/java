package com.sri.algo.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LCAInBST {
	
	static class BST
	{
		
		public Node insert(Node root,int data)
		{ 
			Node node = null;
			if(root == null)
			{
				node =  new Node(data);
			}
			
			else if(root.data < data)
			{
				node = insert(root.right,data);
				
				root.right = root.right != null ? root.right : node;
			}
			else
			{
				node = insert(root.left,data);
				root.left = root.left != null ? root.left : node;
			}
			
			return node;	
		}
		
	}

	static Node lcaUsingPathFinding(Node root, int v1, int v2) {

		List<Node> pathToV1 = new ArrayList<>();
		List<Node> pathToV2 = new ArrayList<>();
		
		findPath(root,v1,pathToV1);
		findPath(root,v1,pathToV2);
		
		int index1 = 0;
		int index2 = 0;
		
		Node lca = null;
		while (index1 < pathToV1.size() && index2 < pathToV2.size())
		{		
			if (pathToV1.get(index1).equals(pathToV2.get(index2)))
			{
				lca = pathToV1.get(index1);
			}
		}
		
		return lca;
	}
	
	static Node lca(Node root, int v1, int v2) {

		
		if(root.data < v1 && root.data < v2)
		{
			return lca(root.right,v1,v2);
		}
		
		else if(root.data > v1 && root.data > v2)
		{
			return lca(root.left,v1,v2);
		}
		
		return root;
	}
	
	
	static void findPath(Node curr, int v1,List<Node> pathToNode)
	{	
		pathToNode.add(curr);
		
		if(curr.data == v1)
		{
			return;
		}

		if(curr.data < v1)
		{
			findPath(curr.right,v1,pathToNode);
		}
		else
		{
			findPath(curr.left,v1,pathToNode);
		}	
	}
	
	public static void main(String[] args) {
		
		
		try(Scanner in = new Scanner(System.in))
		{
			int n1 = in.nextInt();
			int h1[] = new int[n1];
			
			Node root = null;
	        for(int h1_i=0; h1_i < n1; h1_i++){
	            h1[h1_i] = in.nextInt();
	            
	           Node node =  new BST().insert(root, h1[h1_i]);
	            
	            root = root == null ? new BST().insert(root, h1[h1_i]) : root;
	        }
	        
	        int v1 = in.nextInt();
	        int v2 = in.nextInt();
	        
	        System.out.println(lca(root, v1, v2));
		}
	}
	

}
