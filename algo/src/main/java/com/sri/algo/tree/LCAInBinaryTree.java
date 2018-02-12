package com.sri.algo.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree (not a binary search tree) and 
 * two values say n1 and n2, write a program to find the least common ancestor.
 * 
 * @author salla
 *
 */
public class LCAInBinaryTree 
{
	
	/**
	 * Time Complexity : O(n) where n is the number of nodes.
	 * Two pass + one comparision total T.C O(3n).
	 * Space Complexity is O(2n).
	 * 
	 * @param root
	 * @param node1
	 * @param node2
	 * @return
	 */
	public static Node LCA(Node root,int node1,int node2)
	{	
		List<Node> nodes1List = new ArrayList<>();
		List<Node> nodes2List = new ArrayList<>();
		
		findNode(root, node1, nodes1List);
		findNode(root, node2, nodes2List);
			
		int i = 0,j = 0;	
		Node lca = null;
		
		while(i < nodes1List.size() && j < nodes2List.size())
		{		
			if(nodes1List.get(i) == nodes2List.get(j))
			{
				lca = nodes1List.get(i);
				i++;
				j++;
			}
			else
			{
				break;
			}	
		}
		
		return lca;
	}
	
	static class NodeStatus
	{
		boolean isPresent = false;
	}
	
	/**
	 * /**
	 * Time Complexity : O(n) where n is the number of nodes.
	 * Single pass solution.
	 * 
	 * Space Complexity is O(2).
	 * 
	 * TODO : When one of the key's is not present in the tree it should return null.
	 * 
	 * @param root
	 * @param node1
	 * @param node2
	 * @return
	 * 
	 */
	public static Node LCAInSinglePass(Node node, int key1, int key2)
	{
		
		if (node == null)
		{
			return null;
		}
		
		NodeStatus key1Status = new NodeStatus();
		NodeStatus key2Status = new NodeStatus();
		
		return LCAInSinglePass(node,key1,key2,key1Status,key2Status);
	}
	
	private static Node LCAInSinglePass(Node node, int key1, int key2, NodeStatus key1Status, NodeStatus key2Status)
	{
		if (node == null)
		{
			return null;
		}
		
		if (node.data == key1)
		{
			key1Status.isPresent = true;
			return node;
		}
		
		if (node.data == key2)
		{
			key2Status.isPresent = true;
			return node;
		}
		
		Node leftLCA = LCAInSinglePass(node.left, key1, key2, key1Status, key2Status);
		Node rLCA = LCAInSinglePass(node.right, key1, key2, key1Status, key2Status);
		
		if(leftLCA != null &&  rLCA != null)
		{
			return node;
		}
		
		 return leftLCA != null ? leftLCA : rLCA;	
	}
	
	/**
	 * Time Complexity is O(n). 
	 * where n is the number of nodes.
	 * 
	 * @param root
	 * @param node
	 * @param nodesList
	 * @return
	 */
	private static boolean findNode(Node root,int key,List<Node> nodesList)
	{
		nodesList.add(root);	
		if(root.data == key)
		{
			return true;
		}
				
		if(root.left != null && findNode(root.left, key, nodesList))
		{
			return true;
		}
		
		if (root.right != null && findNode(root.right, key, nodesList))
		{
			return true;
		}
		
		// Back track.
		nodesList.remove(nodesList.size() -1);		
		return false;
	}	
	
	public static void main(String[] args) {
		
		 /**
		 * 
		 *        10
		 *     5       30
		 * 3      9        70
		 *                    80 */
		 
		    BinaryTree binaryTree = new BinaryTree(10);
			binaryTree.insertLeft(10, 5);
			binaryTree.insertRight(10, 30);

			binaryTree.insertLeft(5, 3);
			binaryTree.insertRight(5, 9);

			binaryTree.insertRight(30, 70);
			binaryTree.insertRight(70, 80);

			/*System.out.println(LCA(binaryTree.getRoot(),9,80));
			System.out.println(LCA(binaryTree.getRoot(),30,80));
			System.out.println(LCA(binaryTree.getRoot(),5,9));
			System.out.println(LCA(binaryTree.getRoot(),70,80));*/
			
			
			System.out.println(LCAInSinglePass(binaryTree.getRoot(),9,80));
			System.out.println(LCAInSinglePass(binaryTree.getRoot(),30,80));
			System.out.println(LCAInSinglePass(binaryTree.getRoot(),3,9));
			System.out.println(LCAInSinglePass(binaryTree.getRoot(),70,80));
	}


}
