package com.sri.algo.array.leet;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 * 
 * Example 1:
 * 
 * Input: [1,3,5] Output: 1 Example 2:
 * 
 * Input: [2,2,2,0,1] Output: 0
 * 
 * @author salla
 *
 */
public class FindMinInrotatedSortedArray2 {

	public int findMin(int[] nums) {

		int n = nums.length;

		if (n == 0) {
			return Integer.MIN_VALUE;
		}

		if (n == 1) {
			return nums[0];
		}

		int l = 0, h = n - 1;

		while (l < h - 1) {
			int mid = l + (h - l) / 2;

			if (nums[mid] > nums[h]) {
				l = mid + 1;
			} 
			else if (nums[mid] < nums[h]){
				h = mid;
			}
			else
			{
				h--;
			}
		}

		if (nums[l] < nums[h]) {
			return nums[l];
		}

		return nums[h];
	}
	
	
	public static void main(String[] args) {
		
		FindMinInrotatedSortedArray2 findMin = new FindMinInrotatedSortedArray2();
		
		System.out.println(findMin.findMin(new int[] {1, 3, 5}));
		
		System.out.println(findMin.findMin(new int[] {2,2,2,0,1}));
		
		System.out.println(findMin.findMin(new int[] {3,3,1,3}));
		
		System.out.println(findMin.findMin(new int[] {3,3,1,3}));
		
		System.out.println(findMin.findMin(new int[] {10,1,10,10,10}));
		
		System.out.println(findMin.findMin(new int[] {10,1,1,1,1}));
		
		
	}

}
