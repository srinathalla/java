package com.sri.algo.array.cp;

import java.util.Arrays;

/**
 * Given an array of n integers nums and a target, find the number of index
 * triplets i, j, k with 0 <= i < j < k < n that satisfy the condition
 * 
 * nums[i] + nums[j] + nums[k] < target.
 * 
 * Example:
 * 
 * Input: nums = [-2,0,1,3], and target = 2 Output: 2 Explanation: Because there
 * are two triplets which sums are less than 2: [-2,0,1] [-2,0,3]
 * 
 * @author salla
 *
 */
public class ThreeSumSmaller {

	/**
	 * T.C : O(n^2)
	 * Use two pointers..
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int threeSumSmaller(int[] nums, int target) {

		int n = nums.length;

		if (n < 3) {
			return 0;
		}
		
		Arrays.sort(nums);

		int count = 0;

		for (int i = 0; i <= n - 3; i++) {

			int low = i + 1, high = n - 1;

			while (low < high) {
				if (nums[i] + nums[low] + nums[high] < target) {
					count += high - low;
					low++;
				} else {
					high--;
				}
			}
		}

		return count;
	}
	
	public int threeSumSmallerApproach2(int[] nums, int target) {

		int n = nums.length;

		if (n < 3) {
			return 0;
		}
		
		Arrays.sort(nums);

		int count = 0;

		for (int i = n-1; i >= 2; i--) {

			int low = 0, high = i - 1;

			while (low < high) {
				if (nums[i] + nums[low] + nums[high] >= target) {
					
					high--;				
				} else {
					count += high - low;
					low++;
					
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {

		ThreeSumSmaller ts = new ThreeSumSmaller();

		System.out.println(ts.threeSumSmaller(new int[] { -2, 0, 1, 3 }, 2));
		
		System.out.println(ts.threeSumSmaller(new int[] { 3, 1, 0,-2}, 4));
		
		System.out.println(ts.threeSumSmallerApproach2(new int[] { -2, 0, 1, 3 }, 2));
		
		System.out.println(ts.threeSumSmallerApproach2(new int[] { 3, 1, 0,-2}, 4));

	}

}
