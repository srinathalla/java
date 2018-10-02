package com.sri.algo.math.leet;

import java.util.Arrays;

public class MinMovesToEqualArrayElements {

	/**
	 * T.C : O(nlogn) for sorting .
	 * 
	 * 
	 * 
	 * @param nums
	 * @return
	 */
	public int minMovesUsingSorting(int[] nums) {

		int n = nums.length;

		Arrays.sort(nums);

		int moves = 0;

		for (int i = n - 1; i > 0; i--) {
			moves += nums[i] - nums[0];
		}

		return moves;
	}

	/**
	 * T.C : O(n).
	 * 
	 * @param nums
	 * @return
	 */
	public int minMoves(int[] nums) {

		int min = nums[0];
		int moves = 0;
		for (int val : nums) {
			moves += val;

			if (min > val) {
				min = val;
			}
		}

		return moves - nums.length * min;
	}

	public static void main(String[] args) {

		MinMovesToEqualArrayElements minMoves = new MinMovesToEqualArrayElements();

		System.out.println(minMoves.minMoves(new int[] { 1, 2, 3 }));

	}

}
