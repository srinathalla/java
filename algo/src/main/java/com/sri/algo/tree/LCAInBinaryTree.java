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
	
	
	
	/**
	 * /**
	 * Time Complexity : O(n) where n is the number of nodes.
	 * Single pass solution.
	 * 
	 * Space Complexity is O(2).
	 * 
	 * The solution assumes both nodes are present in the tree.
	 * 
	 * Recursive call to each sub tree gives the possible lca from the sub tree.
	 * 
	 * Idea is we search for the target nodes from left,right sub trees based on the match we decide lca.
	 * 
	 * If both left and right tree return matching node's ->  lca is the root.
	 * else lca is returned from either of the sub trees.
	 * 
	 * 
	 * @param root
	 * @param node1
	 * @param node2
	 * @return
	 * 
	 */
	public static Node LCAInSinglePass(Node root, Node p, Node q)
	{ 
        if (root == null || root == p || root == q)
        {
            return root;
        }
        
        Node left = LCAInSinglePass(root.left,p,q);
        
        Node right = LCAInSinglePass(root.right,p,q);
        
        return left == null ? right : right == null ? left : root;
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
			Node node5 = binaryTree.insertLeft(10, 5);
			Node node30 =  binaryTree.insertRight(10, 30);

			Node node3 =  binaryTree.insertLeft(5, 3);
			Node node9 =  binaryTree.insertRight(5, 9);

			Node node70 = binaryTree.insertRight(30, 70);
			Node node80 = binaryTree.insertRight(70, 80);

			/*System.out.println(LCA(binaryTree.getRoot(),9,80));
			System.out.println(LCA(binaryTree.getRoot(),30,80));
			System.out.println(LCA(binaryTree.getRoot(),5,9));
			System.out.println(LCA(binaryTree.getRoot(),70,80));*/
			
			
			System.out.println(LCAInSinglePass(binaryTree.getRoot(),node9,node80));
			System.out.println(LCAInSinglePass(binaryTree.getRoot(),node30,node80));
			System.out.println(LCAInSinglePass(binaryTree.getRoot(),node3,node9));
			System.out.println(LCAInSinglePass(binaryTree.getRoot(),node70,node80));
	}


}
