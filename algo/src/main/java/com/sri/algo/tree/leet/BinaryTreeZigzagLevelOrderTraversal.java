package com.sri.algo.tree.leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

	For example:
	Given binary tree [3,9,20,null,null,15,7],
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its zigzag level order traversal as:
	[
	  [3],
	  [20,9],
	  [15,7]
	]

 * 
 * @author salla
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {

	/**
	 * T.C : O(n)
	 * S.C : O(2^n) where q will hold maximum of nodes at nth level.
	 * 
	 * @param root
	 * @return
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> res = new ArrayList<>();
		
		if (root == null)
        {
            return res;
        }

		Queue<NW> q = new LinkedList<>();
		q.add(new NW(root, 0));

		int pd = -1;
		while (!q.isEmpty()) {
			NW curr = q.poll();

			if (curr.d != pd) {
				res.add(new LinkedList<>());
				pd = curr.d;
			}

			if (curr.d % 2 == 0) {
				LinkedList<Integer> list = (LinkedList<Integer>) res.get(curr.d);
				list.addLast(curr.node.val);
			} else {
				LinkedList<Integer> list = (LinkedList<Integer>) res.get(curr.d);
				list.addFirst(curr.node.val);
			}

			if (curr.node.left != null) {
				q.add(new NW(curr.node.left, curr.d + 1));
			}

			if (curr.node.right != null) {
				q.add(new NW(curr.node.right, curr.d + 1));
			}
		}

		return res;
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		BinaryTreeZigzagLevelOrderTraversal zigZag = new BinaryTreeZigzagLevelOrderTraversal();

		System.out.println(zigZag.zigzagLevelOrder(root));

	}
}
