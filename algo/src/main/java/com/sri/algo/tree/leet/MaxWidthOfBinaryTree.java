package com.sri.algo.tree.leet;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 *  Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.
	
	The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.
	
	Example 1:
	Input: 
	
	           1
	         /   \
	        3     2
	       / \     \  
	      5   3     9 
	
	Output: 4
	Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
	Example 2:
	Input: 

          1
         /  
        3    
       / \       
      5   3     

	Output: 2
	Explanation: The maximum width existing in the third level with the length 2 (5,3).
	Example 3:
	Input: 
	
	          1
	         / \
	        3   2 
	       /        
	      5      
	
	Output: 2
	Explanation: The maximum width existing in the second level with the length 2 (3,2).
	Example 4:
	Input: 
	
	          1
	         / \
	        3   2
	       /     \  
	      5       9 
	     /         \
	    6           7
	Output: 8
	Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).


 * 
 * @author salla
 *
 */
public class MaxWidthOfBinaryTree {

	/**
	 * T.C : O(n)
	 * S.C : O(2^h) where h is height of the tree, queue at any point of time will not 
	 * hold more than 2^h nodes..
	 * 
	 * TODO : Use dfs and solve the same problem.
	 * 
	 * @param root
	 * @return
	 */
	public int widthOfBinaryTree(TreeNode root) {

		int max = 0;

		if (root == null) {
			return 0;
		}

		Queue<NW> q = new LinkedList<>();
		q.add(new NW(root, 0, 0));

		int pd = -1;
		int lmin = -1, lmax = -1;
		while (!q.isEmpty()) {
			NW curr = q.poll();

			if (curr.d != pd) {
				max = Integer.max(max, lmax - lmin + 1);
				lmin = lmax = curr.p;
				pd = curr.d;
			} else {
				lmax = Integer.max(lmax, curr.p);
			}

			if (curr.node.left != null) {
				q.add(new NW(curr.node.left, curr.d + 1, 2 * curr.p + 1));
			}

			if (curr.node.right != null) {
				q.add(new NW(curr.node.right, curr.d + 1, 2 * curr.p + 2));
			}
		}

		max = Integer.max(max, lmax - lmin + 1);
		return max;

	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		
		MaxWidthOfBinaryTree widthOfBinaryTree = new MaxWidthOfBinaryTree();
		
		System.out.println(widthOfBinaryTree.widthOfBinaryTree(root));
		
	}

}
