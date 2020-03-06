package com.sri.algo.array.leet.medium;

public class RemoveDuplicatesFromSortedArray {
	
	public int removeDuplicates(int[] nums) {
	    int i = 0;
	    for (int n : nums)
	        if (i < 2 || n > nums[i-2])
	            nums[i++] = n;
	    return i;
	}
	
	public static void main(String[] args) {
		
		
		int[] arr = new int[]{1,1,1,2,2,3};
		
		RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
		System.out.println(
			removeDuplicatesFromSortedArray.removeDuplicates(arr));
	}

}
