package com.sri.algo.array.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array nums, where the range of elements are in the
 * inclusive range [lower, upper], return its missing ranges.
 * 
 * Example:
 * 
 * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99, Output: ["2",
 * "4->49", "51->74", "76->99"]
 * 
 * @author salla
 *
 */
public class MissingRanges {

	
	/**
	 * T.C : O(n)
	 * 
	 * Single pass we will be able to identify the missing ranges as numbers are sorted.
	 * 
	 * @param nums
	 * @param lower
	 * @param upper
	 * @return
	 */
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {

		int n = nums.length;
		List<String> res = new ArrayList<>();

		StringBuilder sb = new StringBuilder();
		if (n == 0) {
			res.add(lower != upper ? sb.append(lower).append("->").append(upper).toString()
					: sb.append(lower).toString());
			return res;

		}

		long miss = lower;
		for (int no : nums) {

			if (miss < no) {
				sb.append(miss);

				if (miss != no - 1) {
					sb.append("->").append(no - 1);
				}
				res.add(sb.toString());
				sb.setLength(0);
			}

			// this will go out of range when no becomes Integer.MAX,so miss should be a long, and no should be casted to long before incrementing.
			miss = (long)no + 1;
		}

		if (miss <= upper) {
			sb.append(miss);

			if (upper > miss) {
				sb.append("->").append(upper);	
			}
			res.add(sb.toString());
		}

		return res;
	}
	
	private String getRange(int lo, int hi)
	{
		return lo == hi ? String.valueOf(lo) : lo + "->" + hi; 
	}
	
	public List<String> findMissingRangesWithoutBuilder(int[] nums, int lower, int upper) {

		int n = nums.length;
		List<String> res = new ArrayList<>();

		if (n == 0) {
			res.add(getRange(lower, upper));
			return res;
		}

		long miss = lower;
		
		for (int no : nums)
		{
			if (miss < no)
			{
				res.add(getRange((int)miss, no - 1));
			}
			
			miss = (long)no + 1;
		}
		
		if(miss <= upper)
		{
			res.add(getRange((int)miss, upper));
		}

		return res;
	}

	public static void main(String[] args) {

		MissingRanges missRanges = new MissingRanges();

		 System.out.println(missRanges.findMissingRanges(new int[] { 0, 1, 3, 50, 75 }, 0, 99));
		 System.out.println(missRanges.findMissingRangesWithoutBuilder
					(new int[] { 0, 1, 3, 50, 75 }, 0, 99));
		 
		System.out.println(missRanges.findMissingRanges(new int[] { -1 }, -1, 0));
		
		System.out.println(missRanges.findMissingRangesWithoutBuilder
				(new int[] { -1 }, -1, 0));
		
		System.out.println(missRanges.findMissingRanges(new int[] { 1,1,1 }, 1, 1));
		System.out.println(missRanges.findMissingRanges(new int[] { 2147483647}, 0, 2147483647));
		
		System.out.println(missRanges.findMissingRangesWithoutBuilder
			(new int[] { 2147483647}, 0, 2147483647));

				

	}

}
