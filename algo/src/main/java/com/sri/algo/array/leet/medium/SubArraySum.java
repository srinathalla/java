package com.sri.algo.array.leet.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SubArraySum {

	public int subarraySum(int[] nums, int k) {

		int count = 0;
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];

			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}

			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}

		return count;
	}

	public static void main(String[] args) {

		SubArraySum subArraySum = new SubArraySum();

		System.out.println(subArraySum.subarraySum(new int[] { 1, 1, 1 }, 2));

		System.out.println(subArraySum
				.subarraySum(new int[] { -624, -624, -624, -624, -624, -624, -624, -624, -624, -624 }, -624));

	}

}
