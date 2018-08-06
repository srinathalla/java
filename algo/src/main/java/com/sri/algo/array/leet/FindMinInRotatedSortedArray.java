package com.sri.algo.array.leet;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Example 1: Input: [3,4,5,1,2] Output: 1 Example 2:
 * 
 * Input: [4,5,6,7,0,1,2] Output: 0
 * 
 * Input: [4,5,6,7,8,1,2] Output: 1
 * 
 * Input: [7,8,1,2,3,4,5,6] Output: 1
 * 
 * @author salla
 *
 */
public class FindMinInRotatedSortedArray {

	/**
	 * O(logn)
	 * 
	 * @param arr
	 * @return
	 */
	public int findMinMyArroach(int[] arr) {
		int n = arr.length;

		if (n == 1) {
			return arr[0];
		}

		int l = 0, h = n - 1;
		if (arr[0] < arr[n - 1]) {
			return arr[0];
		}

		if (n == 2) {
			return arr[0] < arr[1] ? arr[0] : arr[1];
		}

		while (l <= h) {
			int mid = l + (h - l) / 2;

			if ((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == n - 1 || arr[mid] > arr[mid + 1])) {
				return arr[mid + 1];
			}

			if ((mid == n - 1 || arr[mid] < arr[mid + 1]) && (mid == 0 || arr[mid] < arr[mid - 1])) {
				return arr[mid];
			}

			if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
				if (arr[mid] > arr[l]) {
					l = mid + 1;
				} else {
					h = mid - 1;
				}
			}
		}
		return -1;
	}

	/**
	 * T.C :O(logn)
	 * 
	 * 
	 * Idea is to compare the mid ele with right most element
	 * 
	 * if arr[mid] > arr[right]  -> move right as we are in bigger area we need to move right to get a smaller number.
	 * else -> move left as we are in smaller area we need to move left,
	 * 
	 * more readbale code ..
	 * 
	 * @param nums
	 * @return
	 */
	public int findMin(int[] nums) {

		int n = nums.length;

		if (nums == null || n == 0) {
			return Integer.MIN_VALUE;
		}

		if (n == 1) {
			return nums[0];
		}

		int l = 0, h = n - 1;

		while (l < h - 1) {
			int mid = l + (h - l) / 2;

			if (nums[mid] > nums[h]) {
				l = mid;
			} else {
				h = mid;
			}
		}

		if (nums[l] < nums[h]) {
			return nums[l];
		}

		return nums[h];
	}

	public static void main(String[] args) {

		FindMinInRotatedSortedArray findMin = new FindMinInRotatedSortedArray();

		// System.out.println(findMin.findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));

		// System.out.println(findMin.findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));

		// System.out.println(findMin.findMin(new int[] { 5, 1, 2, 3, 4 }));
		
		System.out.println(findMin.findMin(new int[] { 3, 1, 2}));

		// System.out.println(findMin.findMin(new int[] { 2, 1 }));

	}

}
