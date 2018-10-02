package com.sri.algo.tree.leet;

/**
 * Given a binary tree, find the length of the longest consecutive sequence
 * path.
 * 
 * The path refers to any sequence of nodes from some starting node to any node
 * in the tree along the parent-child connections. The longest consecutive path
 * need to be from parent to child (cannot be the reverse).
 * 
 * Example 1:
 * 
 * Input:
 * 
 * 1 \ 3 / \ 2 4 \ 5
 * 
 * Output: 3
 * 
 * Explanation: Longest consecutive sequence path is 3-4-5, so return 3. Example
 * 2:
 * 
 * Input:
 * 
 * 2 \ 3 / 2 / 1
 * 
 * Output: 2
 * 
 * Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return
 * 2.
 * 
 *
 * 
 */
public class BinaryTreeLongestConsecutiveSequence {

	private int ans = Integer.MIN_VALUE;

	/**
	 * T.C : O(n) single pass solution.
	 * 
	 * @param root
	 * @return
	 */
	public int longestConsecutivedfs(TreeNode root) {

		if (root == null) {
			return 0;
		}

		longestConsecutive(root, 1);

		return ans;

	}

	private void longestConsecutive(TreeNode root, int count) {

		ans = Integer.max(ans, count);

		if (root.left != null) {
			longestConsecutive(root.left, root.left.val == root.val + 1 ? count + 1 : 1);
		}

		if (root.right != null) {
			longestConsecutive(root.right, root.right.val == root.val + 1 ? count + 1 : 1);
		}

	}

	/**
	 * T.C : O(n)
	 * 
	 * We use parent pointer to compare node values.
	 * 
	 * @param root
	 * @return
	 */
	public int longestConsecutive(TreeNode root) {

		if (root == null) {
			return 0;
		}

		ans = 1;
		longestConsecutive(root, null, 1);

		return ans;

	}

	private void longestConsecutive(TreeNode node, TreeNode parent, int count) {

		if (node == null) {
			return;
		}

		if (parent != null) {
			if (node.val - parent.val == 1) {
				count++;
				ans = Integer.max(ans, count);
			} else {
				count = 1;
			}
		}

		longestConsecutive(node.left, node, count);

		longestConsecutive(node.right, node, count);

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		BinaryTreeLongestConsecutiveSequence binaryTreeLongestConsecutiveSequence = new BinaryTreeLongestConsecutiveSequence();
		System.out.println(binaryTreeLongestConsecutiveSequence.longestConsecutive(root));
	

	}

}
