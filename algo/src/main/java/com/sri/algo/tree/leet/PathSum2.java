package com.sri.algo.tree.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 * 5 / \ 4 8 / / \ 11 13 4 / \ / \ 7 2 5 1 Return:
 * 
 * [ [5,4,11,2], [5,8,4,5] ]
 * 
 * @author salla
 *
 */
public class PathSum2 {

	/**
	 * T.C : O(n).
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {

		List<List<Integer>> result = new ArrayList<>();

		pathSum(root, 0, sum, new ArrayList<>(), result);

		return result;

	}

	private void pathSum(TreeNode node, int pathSum, int sum, List<Integer> path, List<List<Integer>> result) {

		if (node == null) {
			return;
		}

		path.add(node.val);

		if (node.left == null && node.right == null) {
			if (pathSum + node.val == sum) {
				result.add(new ArrayList<>(path));
			}

		} else {

			pathSum(node.left, pathSum + node.val, sum, path, result);

			pathSum(node.right, pathSum + node.val, sum, path, result);
		}

		path.remove(path.size() - 1);

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		PathSum2 ps2 = new PathSum2();

		System.out.println(ps2.pathSum(root, 8));

	}
}
