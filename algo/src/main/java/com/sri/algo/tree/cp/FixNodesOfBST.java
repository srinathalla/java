package com.sri.algo.tree.cp;

import com.sri.algo.tree.BinaryTree;
import com.sri.algo.tree.Node;

/**
 *  Two elements of a binary search tree (BST) are swapped by mistake.

	Recover the tree without changing its structure.
	
	Time Complexity O(n).
	Auxillary Space : O(h) i.e is height of binary tree.
	
	This can be further improved by using morris in order traversal.
	
 *  @author salla
 *
 */
public class FixNodesOfBST {

	static class NodeWrapper {
		Node node;

		NodeWrapper(Node node) {
			this.node = node;
		}
	}

	public static Node fixNode(Node root) {

		NodeWrapper prev = new NodeWrapper(null), first = new NodeWrapper(null), last = new NodeWrapper(null);

		fixNode(root, prev, first, last);

		if (first.node != null && last.node != null) {
			int temp = first.node.data;
			first.node.data = last.node.data;
			last.node.data = temp;
		} 

		return root;
	}

	public static void fixNode(Node node, NodeWrapper prev, NodeWrapper first, NodeWrapper last) {

		if (node == null) {
			return;
		}

		fixNode(node.left, prev, first, last);

		if (prev.node != null && node.data < prev.node.data) {
			if (first.node == null) {
				first.node = prev.node;
				last.node = node;
			} else  {
				last.node = node;
			}
		}

		prev.node = node;

		fixNode(node.right, prev, first, last);

	}
	
	    private Node prev,first,last;

	    public void recoverTree(Node root) 
	    {
	        
	        inOrder(root);  

	        if (first != null && last != null)
	        {
	            int temp = last.data;
	            last.data = first.data;
	            first.data = temp;    
	        }
	    }
	    
	    private void inOrder(Node root)
	    {
	        if(root == null)
	        {
	            return;
	        }
	        inOrder(root.left);  
	        
	        if (prev != null && prev.data > root.data)
	        {
	            
	            if (first == null)
	            {
	            	// When adjacent nodes are swapped.
	                first = prev;
	                last = root;
	            }
	            else
	            {
	            	// When nodes are not adjacent. i.e nodes are not parent,child.
	                last = root;
	            }
	        }
	        prev = root;
	        
	        inOrder(root.right);
	        
	    }

	public static void main(String[] args) {

		/*BinaryTree binaryTreeT2 = new BinaryTree(10);
		binaryTreeT2.insertLeft(10, 5);
		binaryTreeT2.insertRight(10, 8);
		binaryTreeT2.insertLeft(5, 2);
		binaryTreeT2.insertRight(5, 20);

		Node root = fixNode(binaryTreeT2.getRoot());
		System.out.println(root.right);
		*/
		BinaryTree binaryTreeT3 = new BinaryTree(0);
		binaryTreeT3.insertLeft(0, 1);
		
		FixNodesOfBST fN = new FixNodesOfBST();
		fN.recoverTree(binaryTreeT3.getRoot());
		
		System.out.println(binaryTreeT3.getRoot().data);

	}

}
