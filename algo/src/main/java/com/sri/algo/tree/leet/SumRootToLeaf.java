package com.sri.algo.tree.leet;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Input: [1,2,3] 1 / \ 2 3 Output: 25 Explanation: The root-to-leaf path 1->2
 * represents the number 12. The root-to-leaf path 1->3 represents the number
 * 13. Therefore, sum = 12 + 13 = 25.
 * 
 * Example 2:
 * 
 * Input: [4,9,0,5,1] 4 / \ 9 0 / \ 5 1 Output: 1026 Explanation: The
 * root-to-leaf path 4->9->5 represents the number 495. The root-to-leaf path
 * 4->9->1 represents the number 491. The root-to-leaf path 4->0 represents the
 * number 40. Therefore, sum = 495 + 491 + 40 = 1026.
 * 
 * @author salla
 *
 */
public class SumRootToLeaf {

	/**
	 * T.C : O(n)
	 * 
	 * Single pass solution.
	 * 
	 * @param root
	 * @return
	 */
	public int sumNumbers(TreeNode root) {

		int[] ans = new int[] { 0 };
		sumNumbers(root, 0, ans);

		return ans[0];

	}

	private void sumNumbers(TreeNode node, int num, int[] sum) {

		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			sum[0] += num * 10 + node.val;
		} else {

			sumNumbers(node.left, num * 10 + node.val, sum);
			sumNumbers(node.right, num * 10 + node.val, sum);
		}

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		SumRootToLeaf sumRootToLeaf = new SumRootToLeaf();

		System.out.println(sumRootToLeaf.sumNumbers(root));

	}

}
