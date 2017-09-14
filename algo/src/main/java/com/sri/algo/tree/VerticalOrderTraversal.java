package com.sri.algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;


public class VerticalOrderTraversal {
	
	static class NodeContainer
	{
		
		public NodeContainer(Node node, int hd) {
			super();
			this.node = node;
			this.hd = hd;
		}
		public Node node;
		public int hd;
	}
	
	public static void verticalOrderWithLevelOrder(Node root)
	{
		
		 Map<Integer,List<Node>> verticalOrderMap= new TreeMap<>();
		 Queue<NodeContainer> nodesQueue = new LinkedList<>();
		 
		 nodesQueue.add(new NodeContainer(root, 0));
		 
		 while (!nodesQueue.isEmpty())
		 {
			 NodeContainer nodeContainer = nodesQueue.poll(); 
			 Node node = nodeContainer.node;
			 int hd = nodeContainer.hd;
			 
			 if (!verticalOrderMap.containsKey(hd))
			 {
				verticalOrderMap.put(hd, new ArrayList<Node>());
			 }
			 verticalOrderMap.get(hd).add(node); 
			 
			 if (node.left != null)
			 {
				 nodesQueue.add(new NodeContainer(node.left, hd -1));
			 }
			 if (node.right != null)
			 {
				 nodesQueue.add(new NodeContainer(node.right, hd + 1));
			 }
		 }
		
		for (Entry<Integer, List<Node>> entry : verticalOrderMap.entrySet())
		{
			System.out.println(entry.getValue());
		}
		
	}
	
	public static void verticalOrder(Node root)
	{
		
		Map<Integer,List<Node>> verticalOrderMap= new TreeMap<>();
		
		verticalOrder(root, 0 , verticalOrderMap);
		
		for (Entry<Integer, List<Node>> entry : verticalOrderMap.entrySet())
		{
			System.out.println(entry.getValue());
		}
		
	}
	
	/**
	 * Vertical order entries are filled using  pre order traversal.
	 * 
	 * @param node
	 * @param hd
	 * @param verticalOrderMap
	 */
	private static void verticalOrder(Node node,int hd, Map<Integer,List<Node>> verticalOrderMap)
	{
		if(node == null)
		{
			return;
		}
		
		if (!verticalOrderMap.containsKey(hd))
		{
			verticalOrderMap.put(hd, new ArrayList<Node>());
		}
		
		verticalOrderMap.get(hd).add(node);
		
		verticalOrder(node.left, hd - 1,verticalOrderMap);	
		verticalOrder(node.right, hd + 1,verticalOrderMap);
		
	}

	public static void main(String[] args) {
		

		BinaryTree binaryTree = new BinaryTree(10);
		binaryTree.insertLeft(10, 20);
		binaryTree.insertRight(10, 30);

		binaryTree.insertLeft(20, 40);
		binaryTree.insertRight(20, 60);

		binaryTree.insertLeft(30, 70);
		binaryTree.insertRight(70, 80);

		verticalOrderWithLevelOrder(binaryTree.getRoot());
	
		
	}
}
