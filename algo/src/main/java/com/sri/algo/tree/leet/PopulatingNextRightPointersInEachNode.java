package com.sri.algo.tree.leet;

/**
 * Given a binary tree
 * 
 * struct TreeLinkNode { TreeLinkNode *left; TreeLinkNode *right; TreeLinkNode
 * *next; } Populate each next pointer to point to its next right node. If there
 * is no next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * 
 * You may only use constant extra space. Recursive approach is fine, implicit
 * stack space does not count as extra space for this problem.
 * 
 * @author salla
 *
 */
public class PopulatingNextRightPointersInEachNode {

	/**
	 * Idea here is to use level order traversal and use next pointer to link nodes at each level.
	 * 
	 * T.C : O(n)
	 * S.C : O(1)
	 * 
	 * as we visit each node only once..
	 * 
	 * @param root
	 */
	public void connect(TreeNode root) {

		while (root != null) {

			TreeNode temp = new TreeNode(0);
			TreeNode cc = temp;

			while (root != null) {
				if (root.left != null) {
					cc.next = root.left;
					cc = cc.next;
				}

				if (root.right != null) {
					cc.next = root.right;
					cc = cc.next;
				}
				root = root.next;
			}

			root = temp.next;
		}

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		PopulatingNextRightPointersInEachNode pnr = new PopulatingNextRightPointersInEachNode();

		pnr.connect(root);

		System.out.println(root);

	}

}
