package com.sri.algo.tree.cp;

import com.sri.algo.tree.BinaryTree;
import com.sri.algo.tree.Node;


/**
 *	Find the distance between two keys in a binary tree, no parent pointers are given. 
 *	Distance between two nodes is the minimum number of edges to be traversed to
 *  reach one node from other.
 *
 *  @author salla
 *
 */
public class DistanceBetweenTwoNodesInBST 
{
	public static int distance(Node root,Node node1,Node node2)
	{	
		Node lca = LeastCommonAncestor(root,node1,node2);
		
	    /**
	     * The distance between two nodes can be obtained in terms of lowest common ancestor. Following is the formula.

		    Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2 * Dist(root, lca) 
		   'n1' and 'n2' are the two given keys
		    'root' is root of given Binary Tree.
		    'lca' is lowest common ancestor of n1 and n2
			Dist(n1, n2) is the distance between n1 and n2.
	     */
		return distance(root,node1) + 
			   distance(root,node2) - 
			   (2 * distance(root,lca));		
	}
	
	
	private static int distance(Node root, Node node)
	{
		if(root.data == node.data)
		{
			return 0;
		}
		
		if (node.data < root.data)
		{
			return 1 + distance(root.left,node);
		}
		
		return 1 + distance(root.right, node);	
	}
	
	private static Node LeastCommonAncestor(Node root,Node node1,Node node2)
	{
		
		if(node1.data > node2.data)
		{
			return LCA(root,node1,node2);
		}
		
		return LCA(root,node2,node1);
		 
	}
	
	 private static Node LCA(Node root,Node bigger,Node smaller)
	 {
		 
		 if(smaller.data > root.data)
		 {
			 return LCA(root.right,bigger,smaller);
		 }
		 
		 if(bigger.data < root.data)
		 {
			 return LCA(root.left,bigger,smaller);
		 }
		 	 
		 return root; 
	 }
	 
	 public static void main(String[] args) {
		
		 /**
		 * 
		 *        10
		 *   5         30
		 *       9        70
		 *                    80 */
		 
		    BinaryTree binaryTree = new BinaryTree(10);
			binaryTree.insertLeft(10, 5);
			binaryTree.insertRight(10, 30);

			// binaryTree.insertLeft(20, 40);
			binaryTree.insertRight(5, 9);

			binaryTree.insertRight(30, 70);
			binaryTree.insertRight(70, 80);
			
			Node node9 = binaryTree.getRoot().left.right;
			Node node80 = binaryTree.getRoot().right.right.right;

			System.out.println(distance(binaryTree.getRoot(),node9,node80));
	}

}
