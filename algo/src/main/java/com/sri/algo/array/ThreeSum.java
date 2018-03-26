package com.sri.algo.array;
import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.

   Note: The solution set must not contain duplicate triplets.

   For example, given array S = [-1, 0, 1, 2, -1, -4],

	A solution set is:
	[
	  [-1, 0, 1],
	  [-1, -1, 2]
	]
	
	Time Complexity : O(n * n)
	Auxillary space : O(1).
	
 * @author salla
 *
 */
public class ThreeSum {
	
	/**
	 * Idea is to sort the elements and fix the last element of the three and 
	 * sweep the rest of the array with 
	 * first pointer as start and 
	 * other pointer as last -1.
	 * 
	 * To handle duplicate sets we need to handle duplicate elements while processing. 
	 * 
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums) 
	{	
		List<List<Integer>> result = new ArrayList<>();
		
		if(nums.length < 3)
		{
			return result;
		}
		
		Arrays.sort(nums);
		
		int a, c = nums.length -1, b;
		while(c >= 2)
		{
			a = 0 ;
			b = c -1;
			while(a < b)
			{
				int res = nums[a] + nums[b] + nums[c] ;
				
				if (res == 0)
				{
					List<Integer> combination = new ArrayList<>();
					combination.add(nums[a]);
					combination.add(nums[b]);
					combination.add(nums[c]);
					result.add(combination);
					
					// This is to avoid duplicate sets. we have processed nums[a] 
					// so all subsequent position's with the same number can be ignored.
					while(a < b && nums[a] == nums[a +1])
					{
						a++;
					}
					
					// This is to avoid duplicate sets. we have processed nums[b] 
					// so all subsequent position's with the same number can be ignored.
					while(a < b && nums[b] == nums[b - 1])
					{
						b--;
					}
				
					a++;
					b--;
				}
				else if(res < 0)
				{
					a++;
				}
				else
				{
				   b--;
				}
			}
			
			// This is to avoid duplicate sets.
			while(c >= 2 && nums[c] == nums[c -1])
			{
				c--;
			}
			c--;
			
		}
		
		return result;
        
    }
	
	public static void main(String[] args) {
		
		ThreeSum ts = new ThreeSum();
		System.out.println(ts.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
		
		System.out.println(ts.threeSum(new int[] {0,0,0,0}));
		
		System.out.println(ts.threeSum(new int[] {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));
		
	}

}
