package com.sri.algo.tree;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class BinaryTree {
	Node root;
	Map<Integer, Node> nodes = new HashMap<>();

	public Node getRoot() {
		return root;
	}

	public BinaryTree(int rootData) {
		root = new Node(rootData);

		nodes.put(rootData, root);

	}

	public Node insertRight(int nodeData, int data) {

		Node rightChild = new Node(data);

		nodes.get(nodeData).right = rightChild;
		nodes.put(data, rightChild);

		return rightChild;

	}

	public Node insertLeft(int nodeData, int data) {

		Node lChild = new Node(data);

		nodes.get(nodeData).left = lChild;
		nodes.put(data, lChild);

		return lChild;

	}

	public Node findNode(int data) {

		return findNode(root, data);
	}

	private Node findNode(Node node, int data) {
		if (node != null) {
			if (node.data == data) {
				return node;
			}

			Node lChild = findNode(node.left, data);

			if (lChild != null) {
				return lChild;
			}

			Node rChild = findNode(node.right, data);

			if (rChild != null) {
				return rChild;
			}
		}

		return null;
	}
	
	public Set<Node> printCornerNodes()
	{
		 Set<Node> nodes = new LinkedHashSet<>();
		 
		 nodes.add(root);
		 
		 Queue<Node> lChilds = new LinkedList<>();
		 populateLeftChilds(root, lChilds);
		 
		 Queue<Node> rChilds = new LinkedList<>();
		 populateRightChilds(root, rChilds);
		 

		 while (!lChilds.isEmpty() && !rChilds.isEmpty())
		 {
			 nodes.add(lChilds.poll()); 
			 nodes.add(rChilds.poll()); 	 
		 }
		 
		 if (lChilds.isEmpty())
		 {
			 while (!rChilds.isEmpty())
			 {
				 nodes.add(rChilds.poll());
			 }
		 }
		 else
		 {
			 while (!lChilds.isEmpty())
			 {
				 nodes.add(lChilds.poll());	 
			 }
		 }
		 
		 return nodes;
	}
	
	private void populateLeftChilds(Node node, Queue<Node> leftChilds)
	{
		if (node.left != null)
		{
			leftChilds.add(node.left);
			populateLeftChilds(node.left,leftChilds);
		}
	}
	
	private void populateRightChilds(Node node, Queue<Node> rChilds)
	{
		if (node.right != null)
		{
			rChilds.add(node.right);
			populateRightChilds(node.right,rChilds);
		}
	}
	
	public Collection<Integer> computeVerticalSumsInBinaryTree()
	{
		
		Map<Integer,Integer> hdToVSMap = new LinkedHashMap<>();
		
		populatehdToVSMap(root, 0 , hdToVSMap);
		
		return hdToVSMap.values();
		
	}
	
	private void populatehdToVSMap(Node node,int hd, Map<Integer,Integer> hdToVSMap)
	{
		if (node != null)
		{
			populatehdToVSMap(node.left, hd -1, hdToVSMap);
			
			int vs = hdToVSMap.get(hd) == null ? node.data : node.data + hdToVSMap.get(hd);
			
			hdToVSMap.put(hd, vs);
			
			populatehdToVSMap(node.right, hd + 1, hdToVSMap);
		}
		
	}

	public static void main(String[] args) {

		try (Scanner in = new Scanner(System.in)) {
			int tests = in.nextInt();

			BinaryTree binaryTree = null;
			for (int test = 0; test < tests; test++) {
				int edges = in.nextInt();

				for (int i = 0; i < edges; i++) {
					int node = in.nextInt();
					int child = in.nextInt();
					String op = in.next();

					if (binaryTree == null) {
						binaryTree = new BinaryTree(node);
					}

					if (op.equals("L")) {
						binaryTree.insertLeft(node, child);
					}

					else if (op.equals("R")) {
						binaryTree.insertRight(node, child);
					}
				}
				
				System.out.println();
				//System.out.println(binaryTree.printCornerNodes());
				
				System.out.println(binaryTree.computeVerticalSumsInBinaryTree());
				binaryTree = null;

			}
		}
	}

}
