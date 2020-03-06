package com.sri.algo.array.leet;

/**
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 * 
 * Example 1:
 * 
 * Input: [2,3,-2,4] Output: 6 Explanation: [2,3] has the largest product 6.
 * Example 2:
 * 
 * Input: [-2,0,-1] Output: 0 Explanation: The result cannot be 2, because
 * [-2,-1] is not a subarray.
 * 
 * @author salla
 *
 */
public class MaxProductSubArray {

	
	/**
	 * T.C : O(n)
	 * 
	 * single pass similar to kadane algorithm but we need to keep min_curr also 
	 * when we encounter a negative number min_curr will give max value.
	 * 
	 * @param nums
	 * @return
	 */
	public int maxProduct(int[] nums) {

		int n = nums.length;
		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return nums[0];
		}

		int max_curr = nums[0], min_curr = nums[0], max_global = nums[0];

		for (int i = 1; i < n; i++) {

			// swap min and max when a -ve number is seen.
			if (nums[i] < 0) {
				int t = max_curr;
				max_curr = min_curr;
				min_curr = t;
			}
			
			max_curr = Integer.max(nums[i], max_curr * nums[i]);
			min_curr = Integer.min(nums[i], min_curr * nums[i]);
			


			max_global = Integer.max(max_global, max_curr);
			
			System.out.println("max_curr : " + max_curr + " min_curr : " + min_curr  + " max_global :" + max_global);
		}

		return max_global;
	}

	public static void main(String[] args) {

		MaxProductSubArray maxProd = new MaxProductSubArray();

		// System.out.println(maxProd.maxProduct(new int[] { -2, 3, -2, 4 }));

		System.out.println(maxProd.maxProduct(new int[] { -2, 0, -1 }));
		
		System.out.println(maxProd.maxProduct(new int[] { -9, -1, -3,-4 }));

	}

}
