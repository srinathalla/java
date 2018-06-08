package com.sri.algo.tree.cp;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given a non-empty binary search tree and a target value, find k values in the
 * BST that are closest to the target.
 * 
 * Note: Given target value is a floating point. You may assume k is always
 * valid, that is: k ≤ total nodes. You are guaranteed to have only one unique
 * set of k values in the BST that are closest to the target. Follow up: Assume
 * that the BST is balanced, could you solve it in less than O(n) runtime (where
 * n = total nodes)?
 * 
 * @author salla
 *
 */
public class ClosestBSTValue {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * Priority Queue based implementation.
	 * 
	 * Do in Order traversal and add to a priority Queue and return first k
	 * elements.
	 * 
	 * T.C : O(n + k) .
	 * 
	 * @param root
	 * @param target
	 * @param k
	 * @return
	 */
	public List<Integer> closestKValues(TreeNode root, double target, int k) 
	{
		List<Integer> res = new ArrayList<>();

		if (k == 0) {
			return res;
		}

		// Default is min heap based implementation, as we are adding 
		// elements to queue during in order traversal elements in heap will not be rearranged.
		// hence T.C remains O(n).
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		inOrder(root, target, k, pq);

		while (k > 0) {
			res.add(pq.poll());
			k--;
		}

		return res;
	}

	private void inOrder(TreeNode root, double target, int k, PriorityQueue<Integer> queue) {
		if (root == null) {
			return;
		}

		inOrder(root.left, target, k, queue);

		// Keep the queue size as k. i.e queue will hold k closest elements.
		if (queue.size() == k) {
			if (Math.abs(target - root.val) < Math.abs(target - queue.peek())) {
				queue.poll();
			} else {
				return;
			}
		}

		queue.add(root.val);

		inOrder(root.right, target, k, queue);
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(5);

		root.left = new TreeNode(2);
		root.left.right = new TreeNode(3);

		ClosestBSTValue closest = new ClosestBSTValue();

		System.out.println(closest.closestKValues(root, 2.571429, 1));

	}

}
