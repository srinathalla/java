package com.sri.algo.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialize's and De-Serializes a binary tree.
   For example, you may serialize the following tree

   I/P :
   
     1
    / \
   2   3
     / \
    4   5
  as "[1,2,N,N,3,4,N,N,5]", 
  
  Time Complexity : O(n).
  Uses pre-order traversal to serialize the tree.
  Used 'N' as null indicator.
 
 * @author salla
 *
 */
public class SerializeNDeSerializeBinaryTree 
{	
	    private static char DE_LIMITER = ',';
	    private static char NULL_VALUE = 'N';
	    
		public String serialize(Node node)
		{	
			StringBuilder sb =  new StringBuilder();	
			serialize(node, sb);
			sb.deleteCharAt(sb.length()-1);
			
			return sb.toString();
		}
		
		private void serialize(Node node, StringBuilder sb)
		{
			if (node == null)
			{
				sb.append(NULL_VALUE).append(DE_LIMITER);
				return;
			}
			
			sb.append(node.data).append(DE_LIMITER);
			
			serialize(node.left, sb);
			serialize(node.right, sb);		
		}
		
		public Node deserialize(String serData)
		{	
		
			Queue<String> serDataQ = new LinkedList<>();
			
			String[] nodes = serData.split(",");
			
			for (String node : nodes)
			{
				serDataQ.add(node);
			}
		
			Node root = deSerialize(serDataQ);
			
			return root;
		}
		
		private Node deSerialize(Queue<String> serDataQ)
		{
			if (serDataQ.isEmpty()) 
			{
				return null;
			}
			
			if(serDataQ.peek().equals("N"))
			{
				serDataQ.poll();
				return null;
			}
				
			Node root = new Node(Integer.valueOf(serDataQ.poll()));
			
			
			root.left = deSerialize(serDataQ);
			root.right = deSerialize(serDataQ);
			
			return root;
		}
	
	public static void main(String[] args)
	{	
		SerializeNDeSerializeBinaryTree treeSerializer = new SerializeNDeSerializeBinaryTree();
		
		BinaryTree binaryTree = new BinaryTree(10);
		binaryTree.insertLeft(10, 20);
		binaryTree.insertRight(10, 30);

		binaryTree.insertLeft(20, 40);
		binaryTree.insertRight(20, 60);

		binaryTree.insertLeft(30, 70);
		binaryTree.insertRight(30, 80);
		
		String serializedTree = treeSerializer.serialize(binaryTree.getRoot());
		System.out.println(serializedTree);
		
		Node desNode = treeSerializer.deserialize(serializedTree);
		
		String deserializedTree = treeSerializer.serialize(desNode);
		System.out.println(deserializedTree);
		
		
	}

}
