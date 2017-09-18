package com.sri.algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class LinkNodesLevelWise {

	/**
	 * Time Complexity  O(n)
	 * Space Complexity Used Map as extra space.
	 * 
	 * @param root
	 */
	public static void linkNodesLevelWiseUsingTreeMap(Node root) 
	{
		
		if (root == null) {
			return;
		}

		Map<Integer, List<Node>> levelOrderMap = new TreeMap<>();
		
		fillLevelOrder(root, 0, levelOrderMap);
		printLevelOrderMap(levelOrderMap);		
	}
	
	/**
	 * Time Complexity  O(n)
	 * 
	 * @param root
	 */
	public static void linkNodesLevelWise(Node root) 
	{
		
		if (root == null) {
			return;
		}
		
		Queue<NodeContainer> queue = new LinkedList<>();
		
		queue.add(new NodeContainer(root).withLevel(0));

		NodeContainer prev = null;
		while (!queue.isEmpty())
		{	
			NodeContainer nc = queue.poll();			
			if (prev != null && prev.level == nc.level)
			{
				prev.node.next = nc.node;	
			}
			
			prev = nc;
			
			if (nc.node.left != null)
			{
				queue.add(new NodeContainer(nc.node.left).withLevel(nc.level + 1));
			}
			if (nc.node.right != null)
			{
				queue.add(new NodeContainer(nc.node.right).withLevel(nc.level + 1));
			}	
		}
		
		printLinkedListsFromTree(root,0,new Level(-1));
	}
	
	private static void printLinkedListsFromTree(Node node,int level,Level maxlevel)
	{
		
		if (node == null)
		{
			return;
		}
		
		if (level > maxlevel.value)
		{
			maxlevel.value = level;
			
			// Print the linked list created from nodes present in the current level.
			System.out.println();
			Node curr = node;
			while(curr != null)
			{
				System.out.print(curr.data);
				curr = curr.next;
				
				System.out.print("-->");
				if (curr == null)
				{
					System.out.print(" null");
				}
				
			}
		}
		
		printLinkedListsFromTree(node.left, level + 1, maxlevel);
		printLinkedListsFromTree(node.right, level + 1, maxlevel);
			
	}
	
	
	
	
	private static void printLevelOrderMap(Map<Integer, List<Node>> levelOrderMap)
	{
		for (Entry<Integer,List<Node>> entry : levelOrderMap.entrySet())
		{
			
			List<Node> nodesList = entry.getValue();
			
			Node prev = nodesList.get(0);
			
			if (nodesList.size() > 1)
			{
				for (int index =1 ;index < nodesList.size() ; index++)
				{
					prev.next = nodesList.get(index);
					
					prev = prev.next;
				}
			}
			
			prev.next = null;
			
			printList(nodesList.get(0));
		}
	}
	
	private static void printList(Node node)
	{
		System.out.println();
		while(node  != null)
		{
			System.out.print(node);
			
			
			node = node.next;
			
			if (node != null)
			{
				System.out.print("-->");
			}
			else
			{
				System.out.print("--> null");
			}
		}
	}

	/**
	 * Does pre order traversal and fills levelOrderMap with key as the level, value as the node.
	 * Order of traversal can be in-order, pre-order, post-order.
	 * all the traversals visit nodes in same level from left to right.
	 * @param node
	 * @param level
	 * @param levelOrderMap
	 */
	private static void fillLevelOrder(Node node, int level, Map<Integer, List<Node>> levelOrderMap) {

		if (node != null) {

			if (!levelOrderMap.containsKey(level)) {
				levelOrderMap.put(level, new ArrayList<Node>());
			}

			levelOrderMap.get(level).add(node);

			fillLevelOrder(node.left, level + 1, levelOrderMap);
			fillLevelOrder(node.right, level + 1, levelOrderMap);
		}

	}
	
	public static void main(String[] args) {

		BinaryTree binaryTree = new BinaryTree(10);
		binaryTree.insertLeft(10, 20);
		binaryTree.insertRight(10, 30);

		binaryTree.insertLeft(20, 40);
		binaryTree.insertRight(20, 60);

		binaryTree.insertLeft(30, 70);
		binaryTree.insertRight(30, 80);

		linkNodesLevelWiseUsingTreeMap(binaryTree.getRoot());
		
		linkNodesLevelWise(binaryTree.getRoot());
	}

}
