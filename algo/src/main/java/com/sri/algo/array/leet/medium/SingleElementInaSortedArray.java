package com.sri.algo.array.leet.medium;

/**
 * 
 * Given a sorted array consisting of only integers where every 
 * element appears twice except for one element which appears once. 
 * Find this single element that appears only once.
 * 
 * @author salla
 *
 */
public class SingleElementInaSortedArray {
	
	public int singleNonDuplicate(int[] nums) {

		int start = 0, end = nums.length - 1;

		while (start < end) {
			int m = start + (end - start) / 2;

			if (m % 2 == 1) {
				m--;
			}

			if (nums[m] != nums[m + 1]) {
				end = m;
			}

			else {
				start = m + 2;
			}
		}

		return nums[start];

	}
	
	public static void main(String[] args) {
		
		SingleElementInaSortedArray singleElementInaSortedArray = new
				SingleElementInaSortedArray();
		
		
		System.out.println(
			singleElementInaSortedArray.singleNonDuplicate(new int[] 
				{1,1,2,3,3,4,4,8,8}));
		
	}

}
