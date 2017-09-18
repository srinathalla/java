package com.sri.algo.tree;

public class MaxRootToLeafPath {

	static class Sum {
		int value;
	}

	/**
	 * Time Complexity O(n)
	 * 
	 * @param root
	 * @return
	 */
	public static int maxRootToLeafPathSum(Node root) {
		Sum sum = new Sum();
		sum.value = Integer.MIN_VALUE;

		maxRootToLeafPathSum(root, root.data, sum);

		return sum.value;

	}

	/**
	 * Top down approach.
	 * 
	 * @param node
	 * @param pathSum
	 * @param maxPathSum
	 */
	public static void maxRootToLeafPathSum(Node node, Integer pathSum, Sum maxPathSum) {

		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			if (pathSum > maxPathSum.value) {
				maxPathSum.value = pathSum;
			}
		}

		if (node.left != null) {
			maxRootToLeafPathSum(node.left, pathSum + node.left.data, maxPathSum);
		}

		if (node.right != null) {
			maxRootToLeafPathSum(node.right, pathSum + node.right.data, maxPathSum);
		}

	}

	/**
	 * Bottom up approach.
	 * 
	 * @param node
	 * @param pathSum
	 * @param maxPathSum
	 */
	public static int maxRootToLeafPathSumButtonUp(Node node) {

		if (node == null) {
			return 0;
		}
		
		return
			Integer.max(
				maxRootToLeafPathSum(node.left),
				maxRootToLeafPathSum(node.right)) + node.data;	
	}

	public static void main(String[] args) {

		BinaryTree binaryTree = new BinaryTree(10);
		binaryTree.insertLeft(10, 20);
		binaryTree.insertRight(10, 30);

		binaryTree.insertLeft(20, 40);
		binaryTree.insertRight(20, 80);

		binaryTree.insertLeft(30, 70);
		binaryTree.insertRight(30, 80);

		System.out.println(maxRootToLeafPathSum(binaryTree.getRoot()));
		
		System.out.println(maxRootToLeafPathSumButtonUp(binaryTree.getRoot()));
	}

}
