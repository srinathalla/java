package com.sri.algo.array.leet.medium;

import java.util.Arrays;

import com.sri.algo.array.PrintArray;

/**
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

	Example 1:
	
	Input: nums = [1, 5, 1, 1, 6, 4]
	Output: One possible answer is [1, 4, 1, 5, 1, 6].
	Example 2:
	
	Input: nums = [1, 3, 2, 2, 3, 1]
	Output: One possible answer is [2, 3, 1, 3, 1, 2].
	Note:
	You may assume all input has valid answer.
	
	Follow Up:
	Can you do it in O(n) time and/or in-place with O(1) extra space?


 * @author salla
 *
 */
public class WiggleSort2 {
	
	public void wiggleSort(int[] nums) {
		
			int[] copy = Arrays.copyOfRange(nums, 0, nums.length);
		    
			Arrays.sort(copy);
			
			int i =0, j =nums.length -1;
			
			int k =0;
			while(i <= j)
			{
				if(k % 2 == 0)
				{
					nums[k++] = copy[i++];
				}
				else
				{
					nums[k++] = copy[j--];
				}
			}
	        
	    }
	
	public static void main(String[] args) {
		
		WiggleSort2 wiggleSort2 = new WiggleSort2();
		
		int[] nums = new int[] {1, 3, 2, 2, 3, 1};
		
		wiggleSort2.wiggleSort(nums);
		
		PrintArray.print(nums);
		
	}

}
