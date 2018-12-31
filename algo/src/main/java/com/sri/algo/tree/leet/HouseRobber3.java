package com.sri.algo.tree.leet;

import java.util.HashMap;
import java.util.Map;

/**
 * The thief has found himself a new place for his thievery again. There is only
 * one entrance to this area, called the "root." Besides the root, each house
 * has one and only one parent house. After a tour, the smart thief realized
 * that "all houses in this place forms a binary tree". It will automatically
 * contact the police if two directly-linked houses were broken into on the same
 * night.
 * 
 * Determine the maximum amount of money the thief can rob tonight without
 * alerting the police.
 * 
 * Example 1:
 * 
 * Input: [3,2,3,null,3,null,1]
 * 
 * 3 / \ 2 3 \ \ 3 1
 * 
 * Output: 7 Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1
 * = 7. Example 2:
 * 
 * Input: [3,4,5,1,3,null,1]
 * 
 * 3 / \ 4 5 / \ \ 1 3 1
 * 
 * Output: 9 Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 * 
 * @author salla
 *
 */
public class HouseRobber3 {

	Map<TreeNode, Integer> map = new HashMap<>();

	public int robNaive(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int val = 0;
		if (root.left != null) {
			val += rob(root.left.left) + rob(root.left.right);
		}

		if (root.right != null) {
			val += rob(root.right.left) + rob(root.right.right);
		}

		return Integer.max(val + root.val, rob(root.left) + rob(root.right));

	}

	/**
	 * T.C : O(n)
	 * S.C : O(n)
	 * 
	 * @param root
	 * @return
	 */
	public int robUsingMap(TreeNode root) {

		if (root == null) {
			return 0;
		}

		if (!map.containsKey(root)) {
			int val = 0;
			if (root.left != null) {
				val += rob(root.left.left) + rob(root.left.right);
			}

			if (root.right != null) {
				val += rob(root.right.left) + rob(root.right.right);
			}

			map.put(root, Integer.max(val + root.val, rob(root.left) + rob(root.right)));
		}
		return map.get(root);
	}
	
	/**
	 * T.C O(n)
	 * 
	 * @param root
	 * @return
	 */
	public int rob(TreeNode root) {

		if (root == null) {
			return 0;
		}
		int[] res = robSub(root);

		return Integer.max(res[0], res[1]);

	}
	
	private int[] robSub(TreeNode node)
	{	
		if (node == null) {
			return new int[] { 0, 0 };
		}
		
		int[] left = robSub(node.left);
		int[] right = robSub(node.right);
		
		int[] res = new int[2];
		
		res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		res[1] = node.val + left[0] + right[0];
		
		return res;
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		HouseRobber3 hr3 = new HouseRobber3();

		long init = System.currentTimeMillis();
		System.out.println(hr3.rob(root));
		
		long finalTime = System.currentTimeMillis();
		
		System.out.println(finalTime - init);
		
		 init = System.currentTimeMillis();
		System.out.println(hr3.rob(root));
		
		 finalTime = System.currentTimeMillis();
		
		System.out.println(finalTime - init);
	}

}
