package com.sri.algo.array.leet;

/**
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and
 * return its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * 
 * You may imagine that nums[-1] = nums[n] = -∞.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,1] Output: 2 Explanation: 3 is a peak element and your
 * function should return the index number 2. Example 2:
 * 
 * Input: nums = [1,2,1,3,5,6,4] Output: 1 or 5 Explanation: Your function can
 * return either index number 1 where the peak element is 2, or index number 5
 * where the peak element is 6.
 * 
 * @author salla
 *
 */
public class FindThePeakElement {

	/**
	 *  T.C : O(logn) S.C : O(1).
	 * 
	 *  Idea is to check ith element is peak element or not
	 * 
	 *  if(nums[i] > nums[i +1]) then i is a peak element.
	 *  
	 *  as there can be many peak elements we can print any peak element index, so we
	 *  use a binary search to find the peak..
	 * 
	 * 
	 * @param nums
	 * @return
	 */
	public int findPeakElement(int[] nums) {
		int n = nums.length;

		if (n == 1) {
			return nums[0];
		}

		int l = 0, h = n - 1;

		while (l < h) {
			int m = l + (h - l) / 2;

			if (nums[m] > nums[m + 1]) {
				h = m;
			} else {
				l = m + 1;
			}
		}

		return l;
	}

	public static void main(String[] args) {

		FindThePeakElement find = new FindThePeakElement();

		System.out.println(find.findPeakElement(new int[] { 1, 2, 3, 1 }));

	}

}
