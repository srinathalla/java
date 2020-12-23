package com.sri.algo.hashing.leet;

import java.util.ArrayList;
import java.util.HashMap;

public class FindTwoNonOverlappingSubArrays {

	public int minSumOfLengths(int[] arr, int target) {

		var seen = new HashMap<Integer, Integer>();
		seen.put(0, -1);

		int ps = 0;
		for (int i = 0; i < arr.length; i++) {
			ps += arr[i];
			seen.put(ps, i);
		}

		int lmin = Integer.MAX_VALUE;
		int res = Integer.MAX_VALUE;
		ps = 0;
		for (int i = 0; i < arr.length; i++) {
			int a = arr[i];
			ps += a;

			if (seen.containsKey(ps - target)) {
				lmin = Math.min(lmin, i - seen.get(ps - target));
			}
			
			if (seen.containsKey(ps + target))
				res = Math.min(res, lmin + seen.get(ps + target) - i);
		}
		return res != Integer.MAX_VALUE ? res : -1;
	}

	public static void main(String[] args) {

		FindTwoNonOverlappingSubArrays findTwoNonOverlappingSubArrays = new FindTwoNonOverlappingSubArrays();

		System.out.println(findTwoNonOverlappingSubArrays.minSumOfLengths(new int[] { 3,2,2,4,3}, 3));

	}

}
