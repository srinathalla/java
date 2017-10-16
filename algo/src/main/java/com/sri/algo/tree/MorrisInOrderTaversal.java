package com.sri.algo.tree;

public class MorrisInOrderTaversal {

	public static void morrisTraversal(Node root) {
		
		
		if (root == null)
		{
			return;
		}
		
		Node curr = root,prev;
		
		while(curr != null)
		{	
			if(curr.left == null)
			{
				System.out.println(curr.data);
				curr = curr.right;
			}
			else
			{
				
				prev = curr.left;
				
				while(prev.right != null && prev.right != curr)
				{
					prev = prev.right;
				}
				
				
				 // At each node we link the predecessor.right with the current node.
				if (prev.right == null)
				{
					prev.right = curr;
					curr = prev;
				}
				else
				{
					 // After completing the left sub tree of current node
					// each predecessor.right is set back to null.
					prev.right = null;
					System.out.println(curr.data);
					curr = curr.right;
				}
				
			}
			
		}
	}

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree(5);
		tree.root.left = new Node(3);
		tree.root.right = new Node(6);
		tree.root.left.right = new Node(4);
		tree.root.left.left = new Node(1);
		tree.root.right.right = new Node(8);
		tree.root.left.left.right = new Node(2);
		tree.root.left.left.left = new Node(0);
		tree.root.right.right.left = new Node(7);
		tree.root.right.right.right = new Node(9);

		morrisTraversal(tree.root);

	}
}
