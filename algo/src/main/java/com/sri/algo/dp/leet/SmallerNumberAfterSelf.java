package com.sri.algo.dp.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sri.algo.array.PrintArray;

/**
 *  You are given an integer array nums and you have to return a new counts array. 
 *  The counts array has the property 
 *  where counts[i] is the number of smaller elements to the right of nums[i].
 * 
 *  Input: [5,2,6,1]
	Output: [2,1,1,0] 
	Explanation:
	To the right of 5 there are 2 smaller elements (2 and 1).
	To the right of 2 there is only 1 smaller element (1).
	To the right of 6 there is 1 smaller element (1).
	To the right of 1 there is 0 smaller element.
	
 * @author salla
 *
 */
public class SmallerNumberAfterSelf {
	
	
	
	public List<Integer> countSmaller(int[] nums) {
		
		int n = nums.length;
		if (n == 0)
		{
			return new ArrayList<>();
		}

	    Integer[] ans = new Integer[n];
	    List<Integer> sorted = new ArrayList<>();
	    
	    for (int i=n-1; i>=0;i--)
	    {
	    	int idx = findIndex(sorted, nums[i]);
	    	
	    	ans[i] = idx;
	    	sorted.add(idx, nums[i]);
	    }
	    
	    
	    return Arrays.asList(ans);
	    
	}
	private int findIndex(List<Integer> sorted, int target) {
	   
		if (sorted.size() == 0)
		{
			return 0;
		}

		int start = 0, end = sorted.size() -1;
		if (sorted.get(end) < target)
		{
			return end + 1;
		}
		if (sorted.get(start) >= target)
		{
			return 0;
		}
		
		while (start < end - 1)
		{
			int m = start + (end - start)/2;
			
			if (target > sorted.get(m))
			{
				start = m + 1;
			}
			else
			{
				end = m;
			}
		}
		
		if (sorted.get(start) > target)
		{
			return start;
		}
		
		return end;
	}
	
	
	public static void main(String[] args) {
		
		SmallerNumberAfterSelf smallerNumberAfterSelf = new SmallerNumberAfterSelf();
		
		System.out.println(
			smallerNumberAfterSelf.countSmaller(new int[] {5,2,6,1}));
		
	}

}
