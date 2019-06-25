package com.sri.algo.array.leet.easy;

/**
 * 	Given an array nums and a value val, remove all instances of that value in-place and 
 *  return the new length. Do not allocate extra space for another array, you must do this 
 *  by modifying the input array in-place with O(1) extra memory.
	
	The order of elements can be changed. It doesn't matter what you leave beyond the new 
	length.
	
	Example 1:
	
	Given nums = [3,2,2,3], val = 3,
	
	Your function should return length = 2, with the first two elements of nums being 2.
	
	It doesn't matter what you leave beyond the returned length.
	
 * @author salla
 *
 */
public class RemoveElement {

	/**
	 * T.C :  O (n)
	 * @param nums
	 * @param val
	 * @return
	 */
	public int removeElement(int[] nums, int val) {

		int i = 0, j = nums.length - 1;

		while (i <= j) {

			while (j >= 0 && nums[j] == val) {
				j--;
			}

			while (i < nums.length && nums[i] != val) {
				i++;
			}

			if (j >= 0 && i < nums.length && i < j)
			{
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
				j--;
			}

		

		}
		
		return j + 1;

	}
	
	public static void main(String[] args) {
		
		RemoveElement removeElement = new RemoveElement();
		
		/*System.out.println(
			removeElement.removeElement(new int[] {0,1,2,2,3,0,4,2}, 2));*/
		
		System.out.println(
				removeElement.removeElement(new int[] {3,2,2,3}, 3));
		
	}
}
