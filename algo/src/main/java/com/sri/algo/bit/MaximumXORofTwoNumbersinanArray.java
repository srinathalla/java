package com.sri.algo.bit;

import java.util.HashSet;
import java.util.Set;

public class MaximumXORofTwoNumbersinanArray {

	public int findMaximumXOR(int[] nums) {
		int max = 0, mask = 0;

		for (int i = 31; i >= 0; i--) {
			mask = mask | 1 << i;
			Set<Integer> set = new HashSet<>();
			for (int no : nums) {
				set.add(no & mask);
			}

			int tmp = max | 1 << i;

			for (int prefix : set) {
				if (set.contains(prefix ^ tmp)) {
					max = tmp;
					break;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {

		MaximumXORofTwoNumbersinanArray maximumXORofTwoNumbersinanArray = new MaximumXORofTwoNumbersinanArray();
		System.out.println(maximumXORofTwoNumbersinanArray.findMaximumXOR(new int[] { 3, 10, 5, 25, 2, 8 }));

	}

}
