package com.sri.algo.array.leet;

import java.util.Arrays;

import com.sri.algo.array.PrintArray;

/**
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example 1:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4] Example 2:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1]
 * 
 * @author salla
 *
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

	/**
	 * T.C O(logn)
	 * 
	 * idea is to do two binary searches when a target is found at mid, 
	 * l..m for first and m..h for last element
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] searchRange(int[] nums, int target) {

		int n = nums.length;

		if (n == 0) {
			return new int[] { -1, -1 };
		}

		int first = -1, last = -1, l = 0, h = n - 1;
		while (l <= h) {
			int m = (l + h) / 2;
			if (nums[m] == target) {
				first = search(nums, l, m, target, true);
				last = search(nums, m, h, target, false);
				break;

			} else if (nums[m] > target) {
				h = m - 1;
			} else {
				l = m + 1;
			}
		}

		return new int[] { first, last };
	}

	private int search(int[] nums, int l, int h, int target, boolean findFirst) {

		int res = -1;
		while (l <= h) {
			int m = (l + h) / 2;
			if (nums[m] == target) {

				if (findFirst) {
					res = m;
					h = m - 1;
				} else {
					res = m;
					l = m + 1;
				}
			} else if (nums[m] > target) {
				h = m - 1;
			} else {
				l = m + 1;
			}
		}

		return res;
	}

	public static void main(String[] args) {

		FindFirstAndLastPositionOfElementInSortedArray find = new FindFirstAndLastPositionOfElementInSortedArray();

		int[] res = find.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8);

		PrintArray.print(res);

		res = find.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6);
		PrintArray.print(res);
	}

}
