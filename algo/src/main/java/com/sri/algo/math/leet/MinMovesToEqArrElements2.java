package com.sri.algo.math.leet;

import java.util.Arrays;

/**
 * Given a non-empty integer array, find the minimum number of moves required to
 * make all array elements equal, where a move is incrementing a selected
 * element by 1 or decrementing a selected element by 1.
 * 
 * You may assume the array's length is at most 10,000.
 * 
 * Example:
 * 
 * Input: [1,2,3]
 * 
 * Output: 2
 * 
 * Explanation: Only two moves are needed (remember each move increments or
 * decrements one element):
 * 
 * [1,2,3] => [2,2,3] => [2,2,2]
 * 
 * @author salla
 *
 */
public class MinMovesToEqArrElements2 {

	/**
	 * T.C : O(nlogn)
	 * 
	 * Idea is to find the median and make all the elements equal to median. will
	 * give min number of moves.
	 * 
	 * @param nums
	 * @return
	 */
	public int minMoves2(int[] nums) {

		int n = nums.length;

		if (n == 1) {
			return 0;
		}

		Arrays.sort(nums);

		int moves = 0;
		int i = 0, j = n - 1;

		while (i < j) {
			moves += nums[j] - nums[i];
			i++;
			j--;
		}

		return moves;
	}

	public static void main(String[] args) {

		MinMovesToEqArrElements2 minMoves = new MinMovesToEqArrElements2();

		System.out.println(minMoves.minMoves2(new int[] { 1, 2, 3 }));
	}

}
