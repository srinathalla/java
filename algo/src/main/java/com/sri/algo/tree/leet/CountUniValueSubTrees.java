package com.sri.algo.tree.leet;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a binary tree, count the number of uni-value subtrees.
 * 
 * A Uni-value subtree means all nodes of the subtree have the same value.
 * 
 * Example :
 * 
 * Input: root = [5,1,5,5,5,null,5]
 * 
 * 5 / \ 1 5 / \ \ 5 5 5
 * 
 * Output: 4
 * 
 * @author salla
 *
 */
public class CountUniValueSubTrees {

	private int ans = 0;

	/**
	 * T.C : O(n) 
	 * S.C : O(n)
	 * 
	 * Idea is to do post order traversal and keep track of root nodes
	 * who create a uni- val sub trees.
	 * 
	 * @param root
	 * @return
	 */
	public int countUnivalSubtreesUsingSet(TreeNode root) {

		if (root == null) {
			return 0;
		}

		postOrder(root, new HashSet<TreeNode>());

		return ans;

	}

	private void postOrder(TreeNode node, Set<TreeNode> uniValSub) {

		if (node == null) {
			return;
		}

		postOrder(node.left, uniValSub);
		postOrder(node.right, uniValSub);

		boolean isUniValLeft = false, isUniValRight = false;

		isUniValLeft = node.left == null ? true : node.left.val == node.val && uniValSub.contains(node.left);
		isUniValRight = node.right == null ? true : node.right.val == node.val && uniValSub.contains(node.right);

		if (isUniValLeft && isUniValRight) {
			uniValSub.add(node);
			ans++;
		}
	}

	/**
	 * /**
	 * T.C : O(n) 
	 * S.C : O(1) we use two variables..
	 *
	 * 
	 * Idea is to do post order traversal and return status of current sub tree whether
	 * it is a uni val tree or not, this in turn is used by the parent.
	 * 
	 * @param root
	 * @return
	 *
	 * @param root
	 * @return
	 */
	public int countUnivalSubtrees(TreeNode root) {

		if (root == null) {
			return 0;
		}

		postOrder(root);

		return ans;

	}

	private boolean postOrder(TreeNode node) {

		if (node == null) {
			return true;
		}

		boolean isUniValLeft = postOrder(node.left);
		boolean isUniValRight = postOrder(node.right);

		if (isUniValLeft && isUniValRight) {

			if ((node.left == null || node.left.val == node.val)
					&& (node.right == null || node.right.val == node.val)) {
				ans++;
				return true;
			}

		}

		return false;
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(3);

		CountUniValueSubTrees countUniValueSubTrees = new CountUniValueSubTrees();

		System.out.println(countUniValueSubTrees.countUnivalSubtrees(root));

	}

}
