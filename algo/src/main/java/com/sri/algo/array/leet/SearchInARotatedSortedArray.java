package com.sri.algo.array.leet;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Example 1:
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4 Example 2:
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 3 Output: -1
 * 
 * @author salla
 *
 */
public class SearchInARotatedSortedArray {

	public int search(int[] nums, int target) {

		int n = nums.length;
		if (n == 0) {
			return -1;
		}

		if (n == 1) {
			return nums[0] == target ? 0 : -1;
		}

		int l = 0, h = n - 1;

		while (l < h - 1) {

			int mid = l + (h - l) / 2;

			if (nums[mid] == target) {
				return mid;
			}

			if (nums[mid] > nums[h]) {
				if (target < nums[mid] && target < nums[h] || (target > nums[mid])) {
					l = mid + 1;
				} else {
					h = mid;
				}
			}

			else if (nums[mid] < nums[h]) {
				if (target < nums[mid] || target > nums[h]) {
					h = mid -1;
				} else {
					l = mid + 1;
				}
			}
		}

		if (nums[l] == target) {
			return l;
		}

		if (nums[h] == target) {
			return h;
		}

		return -1;
	}

	public static void main(String[] args) {

		SearchInARotatedSortedArray search = new SearchInARotatedSortedArray();

		//System.out.println(search.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
		
	// 	System.out.println(search.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3));
		
		System.out.println(search.search(new int[] { 8,9,2,3,4}
				,9));

}

}
