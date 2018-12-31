package com.sri.algo.tree.leet;

import java.util.HashMap;
import java.util.Map;

public class PathSum4 {

	int ans = 0;

	public int pathSumUsingTree(int[] nums) {
		TreeNode root = new TreeNode(nums[0] % 10);
		for (int num : nums) {
			if (num == nums[0])
				continue;
			int depth = num / 100, pos = num / 10 % 10, val = num % 10;
			pos--;
			TreeNode cur = root;
			for (int d = depth - 2; d >= 0; --d) {
				if (pos < 1 << d) {
					if (cur.left == null)
						cur.left = new TreeNode(val);
					cur = cur.left;
				} else {
					if (cur.right == null)
						cur.right = new TreeNode(val);
					cur = cur.right;
				}
				pos %= 1 << d;
			}
		}

		dfs(root, 0);
		return ans;
	}

	public void dfs(TreeNode node, int sum) {
		if (node == null)
			return;
		sum += node.val;
		if (node.left == null && node.right == null) {
			ans += sum;
		} else {
			dfs(node.left, sum);
			dfs(node.right, sum);
		}
	}

	Map<Integer, Integer> map;
	public int pathSum(int[] nums) {

		 map = new HashMap<>();

		for (int num : nums) {
			int key = num / 10;
			int val = num % 10;

			map.put(key, val);
		}

		dfs(nums[0]/10, 0);
		return ans;
	}
	
	private void dfs(int num,int sum)
	{
		if (!map.containsKey(num))
		{
			return;
		}
		sum += map.get(num);
		int d = num/10;
		int p = num % 10;
		
		int left = (d + 1) * 10 + (2 * p -1);
		
		int right = (d + 1) * 10 + (2 * p);
		
		if (!map.containsKey(left) && !map.containsKey(right))
		{
			ans += sum;
		}
		
		dfs(left,sum);
		dfs(right,sum);
	}

	public static void main(String[] args) {

		PathSum4 pathSum4 = new PathSum4();

		System.out.println(pathSum4.pathSum(new int[] { 113, 215, 221 }));

	}

}
