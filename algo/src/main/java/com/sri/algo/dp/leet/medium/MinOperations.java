package com.sri.algo.dp.leet.medium;

import java.util.HashMap;
import java.util.Map;

public class MinOperations {

	Map<Integer, Integer> dp = new HashMap<>();
	int res = Integer.MAX_VALUE;

	public int minOperations(int[] nums, int x) {

		int target = -x;
		for (int no : nums) {
			target += no;
		}

		if (target == 0) {
			return nums.length;
		}

		var map = new HashMap<Integer, Integer>();
		map.put(0, -1);

		int s = 0;
		int res = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {

			s += nums[i];

			if (map.containsKey(s - target)) {
				int v = map.get(s - target);
				res += Math.max(res, i - v);
			}

			map.put(s, i);
		}

		return res == Integer.MIN_VALUE ? -1 : nums.length - res;
	}

	public static void main(String[] args) {

		MinOperations mo = new MinOperations();

		int[] arr = new int[] { 1, 1, 4, 2, 3 };
		int x = 5;
		System.out.println(mo.minOperations(arr, x));

	}

}
