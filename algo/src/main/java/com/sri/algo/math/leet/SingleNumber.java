package com.sri.algo.math.leet;

import java.util.Arrays;

public class SingleNumber {
	
	public int maxSubArray(int[] nums) {

		int max = nums[0];
		int globalMax = nums[0];

		for (int i = 1; i < nums.length; i++) {
			max = Integer.max(nums[i], max + nums[i]);
			globalMax = Integer.max(globalMax, max);
		}

		return globalMax;

	}
	 
	public static void main(String[] args) {
		
		SingleNumber sn = new SingleNumber();
	
		
	}

}
