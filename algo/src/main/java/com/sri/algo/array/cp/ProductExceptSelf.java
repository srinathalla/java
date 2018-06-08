package com.sri.algo.array.cp;

import com.sri.algo.array.PrintArray;

/**
 * Given an array of n integers where n > 1, nums, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Solve it without division and in O(n).
 * 
 * For example, given [1,2,3,4], return [24,12,8,6].
 * 
 * Follow up: Could you solve it with constant space complexity? (Note: The
 * output array does not count as extra space for the purpose of space
 * complexity analysis.)
 * 
 * @author salla
 *
 */
public class ProductExceptSelf {

	/**
	 * Two pass solution.
	 *  
	 * Idea is to compute left sub Array product in first pass
	 * Multiply it with right sub Array product in second pass.
	 * 
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];

		if (n == 0) {
			return res;
		}

		res[0] = 1;

		// res[i] stores left sub array product
		for (int i = 1; i < n; i++) {
			res[i] = res[i - 1] * nums[i - 1];
		}

		int right = 1;
		
		// res[i] stores product of (left sub array product and right sub array product).
		for (int i = n - 1; i >= 0; i--) {
			res[i] = res[i] * right;

			right = right * nums[i];
		}

		return res;
	}

	public static void main(String[] args) {
		ProductExceptSelf pes = new ProductExceptSelf();

		int[] res = pes.productExceptSelf(new int[] { 1, 2, 3, 4 });
		PrintArray.print(res);

	}

}
