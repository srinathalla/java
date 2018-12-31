package com.sri.algo.array;

/**
 * Given an unsorted integer array, find the first missing positive integer.

   For example,
   Given [1,2,0] return 3,
   and [3,4,-1,1] return 2.

   Your algorithm should run in O(n) time and uses constant space.
   
   
   Logic here is to place the the number in the right position. 1 -> index 0 , 2 -> index 1.
   
   Two pass solutions first pass we place each number in the relevant slot.
   In second pass we identify the first index where index + 1 is not present in this slot.
   
 * @author salla
 *
 */
public class MissingPositive 
{

	public int firstMissingPositive(int[] nums)
	{
		    if (nums.length == 0  || (nums.length == 1 && nums[0]  != 1))
	        {
	        	return 1;
	        }
	            
			for(int i =0;i <nums.length; i++)
			{
				// skip negative numbers, 
				// skip numbers that are already present in the right slots,
				// skip positive numbers that are beyond the array size.
				while(nums[i] > 0 && nums[i] <= nums.length &&  nums[i] != nums[nums[i] -1])
				{	
					int temp = nums[i];
					nums[i] = nums[nums[i] -1];
					nums[temp -1] = temp;
				}
			}
			
			
			for (int i=0;i<nums.length;i++)
			{
				if(nums[i] != i + 1)
				{
					return  i + 1;
					
				}
			}
			
			return nums.length + 1;
    }
	
	public static void main(String[] args) {
		
		MissingPositive mp = new MissingPositive();
		
		System.out.println(mp.firstMissingPositive(new int[] {1, 2, 0}));
		
		System.out.println(mp.firstMissingPositive(new int[] {3, 4, -1, 1}));
		
		System.out.println(mp.firstMissingPositive(new int[] {1, 1}));
		
		System.out.println(mp.firstMissingPositive(new int[] {3, 2}));
		
		System.out.println(mp.firstMissingPositive(new int[] {}));
		
		System.out.println(mp.firstMissingPositive(new int[] {1}));
		
	}
}
