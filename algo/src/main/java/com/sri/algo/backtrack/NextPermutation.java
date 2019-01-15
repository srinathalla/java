package com.sri.algo.backtrack;

import com.sri.algo.array.PrintArray;

/**
 *  Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

	If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
	
	The replacement must be in-place and use only constant extra memory.
	
	Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

	1,2,3 → 1,3,2
	3,2,1 → 1,2,3
	1,1,5 → 1,5,1
	
 * @author salla
 *
 */
public class NextPermutation {

	/**
	 * T.C : O(n)
	 * 
	 * @param nums
	 */
	public void nextPermutation(int[] nums) {

		int i = nums.length - 2;

		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}

		if (i >= 0) {
			int j = nums.length - 1;
			while (nums[j] <= nums[i]) {
				j--;
			}
			
			swap(nums, i, j);
		}

		reverse(nums, i + 1);
	}

	private void reverse(int[] nums, int start) {
		int end = nums.length - 1;

		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[j];
		nums[j] = nums[i];
		nums[i] = tmp;
	}

	public static void main(String[] args) {
		
		NextPermutation np = new NextPermutation();
		
		int[]  p = new int[] {1,2,3};
		np.nextPermutation(p);
		
	     PrintArray.print(p);
	}
	

}
