package com.sri.algo.dp.leet.hard;

/**
 * Given a square grid of integers arr, a falling path with non-zero shifts is a
 * choice of exactly one element from each row of arr, such that no two elements
 * chosen in adjacent rows are in the same column.
 * 
 * Return the minimum sum of a falling path with non-zero shifts.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [[1,2,3],[4,5,6],[7,8,9]] Output: 13 Explanation: The possible
 * falling paths are: [1,5,9], [1,5,7], [1,6,7], [1,6,8], [2,4,8], [2,4,9],
 * [2,6,7], [2,6,8], [3,4,8], [3,4,9], [3,5,7], [3,5,9] The falling path with
 * the smallest sum is [1,5,7], so the answer is 13.
 * 
 * @author srialla
 *
 */
public class MinFallingPathSum {

	public int minFallingPathSum(int[][] arr) {

		int rows = arr.length;
		int cols = arr[0].length;

		for (int i = 1; i < rows; i++) {
			int[] mins = getTwoMins(arr[i - 1]);
			for (int j = 0; j < cols; j++) {

				if (arr[i - 1][j] == mins[0]) {
					arr[i][j] += mins[1];
				} else {
					arr[i][j] += mins[0];
				}
			}
		}

		int res = Integer.MAX_VALUE;
		for (int j = 0; j < cols; j++) {
			res = Math.min(arr[rows - 1][j], res);
		}

		return res;

	}

	private int[] getTwoMins(int[] a) {

		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, minIdx = -1;
		for (int i = 0; i < a.length; i++) {
			if (min1 > a[i]) {
				minIdx = i;
				min1 = a[i];
			}
		}

		for (int i = 1; i < a.length; i++) {

			if (i == minIdx) {
				continue;
			}
			if (min2 > a[i]) {
				min2 = a[i];
			}
		}

		return new int[] { min1, min2 };
	}

	public static void main(String[] args) {

		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		MinFallingPathSum minFallingPathSum = new MinFallingPathSum();
		System.out.println(minFallingPathSum.minFallingPathSum(arr));

	}

}
