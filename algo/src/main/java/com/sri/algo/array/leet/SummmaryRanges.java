package com.sri.algo.array.leet;

import java.util.ArrayList;
import java.util.List;

public class SummmaryRanges {

	public List<String> summaryRanges(int[] nums) {

		List<String> result = new ArrayList<>();
		
		if (nums.length == 0)
		{
			return result;
		}

		int start = 0, end = 0;

		for (int i = 1; i < nums.length; i++) {

			if (nums[i] != nums[i - 1] + 1) {
				result.add(start == end ? nums[start] + "": nums[start] + "->" + nums[end]);
				start = i;

			}
			end = i;
		}
		result.add(start == end ? nums[start] + "": nums[start] + "->" + nums[end]);
		
		
		return result;

	}
	
	
	public static void main(String[] args) {
		
		
		SummmaryRanges sr = new SummmaryRanges();
		System.out.println(sr.summaryRanges(new int[] {0,1,2,4,5,7}));
		System.out.println(sr.summaryRanges(new int[] {0,2,3,4,6,8,9}));
		
	}

}
