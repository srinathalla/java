package com.sri.algo.graph.leet;

public class RemoveDuplicatesFromSortedArray {
	
	/**
	 * Single pass solution using two pointers.
	 * 
	 * @param nums
	 * @return
	 */
	 public int removeDuplicates(int[] nums) {
	          	
			int i=0;		
			for (int j =1; j < nums.length; j++)
			{	
				if(nums[j] != nums[i])
				{
					nums[i+1] = nums[j];
					i++;
				}
			}
			
			return i + 1;
	    }
	 
	 public static void main(String[] args) {
		
		 RemoveDuplicatesFromSortedArray solution = new 
				 RemoveDuplicatesFromSortedArray();

			System.out.println(
				solution.removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
			
			System.out.println(
					solution.removeDuplicates(new int[] {1,2}));
			
	}

}
