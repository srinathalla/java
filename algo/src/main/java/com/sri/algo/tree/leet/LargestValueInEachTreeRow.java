package com.sri.algo.tree.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * You need to find the largest value in each row of a binary tree.

	Example:
	Input: 
	
	          1
	         / \
	        3   2
	       / \   \  
	      5   3   9 

	Output: [1, 3, 9]
	
 * @author salla
 *
 */
public class LargestValueInEachTreeRow {

	/**
	 * T.C : O(n)
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> largestValues(TreeNode root) {

		List<Integer> result = new ArrayList<>();

		largestValues(root, 0, result);

		return result;

	}

	private void largestValues(TreeNode node, int h, List<Integer> result) {

		if (node == null) {
			return;
		}

		if (result.size() == h) {
			result.add(node.val);
		} else {
			result.set(h, Integer.max(result.get(h), node.val));
		}

		largestValues(node.left, h + 1, result);
		largestValues(node.right, h + 1, result);

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		LargestValueInEachTreeRow largestValueInEachTreeRow = new LargestValueInEachTreeRow();

		System.out.println(largestValueInEachTreeRow.largestValues(root));
	}

}
