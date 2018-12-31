package com.sri.algo.array.leet.medium;

import com.sri.algo.array.PrintArray;

/**
 *  Given an unsorted array nums, reorder it in-place such that 
 *  nums[0] <= nums[1] >= nums[2] <= nums[3]....

	Example:
	
	Input: nums = [3,5,2,1,6,4]
	Output: One possible answer is [3,5,1,6,2,4]
	
 * @author salla
 *
 */
public class WiggleSort {
	
	
	/**
	 * T.C : O(n)
	 * @param nums
	 */
	public void wiggleSort(int[] nums) {

		boolean isLess = true;

		for (int i = 0; i < nums.length - 1; i++) {
			
			
			if(isLess)
			{
				
				if(nums[i] > nums[i+1])
				{
					swap(nums,i,i+1);
				}
			}
			else
			{
				if(nums[i] < nums[i+1])
				{
					swap(nums,i,i+1);
				}
			}
			
			isLess = !isLess;

		}

	}
	
	
	private void swap(int[] nums, int i, int j) {

		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		
		WiggleSort wiggleSort = new WiggleSort();
		
		int[] arr = new int[] {3,5,2,1,6,4};
		
		wiggleSort.wiggleSort(arr);
		
		PrintArray.print(arr);
		
	}

}
