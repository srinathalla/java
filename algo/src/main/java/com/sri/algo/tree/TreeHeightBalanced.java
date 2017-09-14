package com.sri.algo.tree;

public class TreeHeightBalanced {
	
	
	/**
	 * Left Tree should be balanced,
	 * Right tree should be balanced.
	 * Math.abs(left tree height, right tree height) <= 1.
	 * 
	 * Time Complexity O(n).
	 * @param node
	 * @return
	 */
	public static boolean isHeightBalanced(Node node)
	{
		
		return isHeightBalanced(node, new Height());
	}
	
	private static boolean isHeightBalanced(Node node, Height h)
	{
		
		if (node == null)
		{
			h.value = 0;
			return true;
		}
		
		Height lh = new Height();
		Height rh = new Height();
		
		boolean ltb = isHeightBalanced(node.left, lh) ;
		boolean rtb = isHeightBalanced(node.right, rh);
		
		h.value = Integer.max(lh.value, rh.value) + 1;
		
		return 
			ltb &&
		    rtb &&
			Math.abs(lh.value - rh.value) <= 1;
	}
	
	
	public static void main(String[] args) {
		
		BinaryTree binaryTree = new BinaryTree(10);
		binaryTree.insertLeft(10, 20);
		binaryTree.insertRight(10, 30);

		binaryTree.insertLeft(20, 40);
		binaryTree.insertRight(20, 60);

		binaryTree.insertLeft(30, 70);
		binaryTree.insertRight(30, 80);
		
		System.out.println(isHeightBalanced(binaryTree.root));
		
	}

}
