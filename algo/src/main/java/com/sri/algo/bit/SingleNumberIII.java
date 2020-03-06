package com.sri.algo.bit;

import com.sri.algo.array.PrintArray;

public class SingleNumberIII {

	public int[] singleNumber(int[] nums) {

		int diff = 0;

		for (int no : nums) {
			diff ^= no;
		}

		diff &= -diff;

		int[] ret = new int[2];

		for (int num : nums) {
			if ((num & diff) == 0) {
				ret[0] ^= num;
			} else {
				ret[1] ^= num;
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		
		SingleNumberIII singleNumberIII = new SingleNumberIII();
		PrintArray
		.print(
			singleNumberIII.singleNumber(new int[] {1,2,1,3,2,5}));
		
	}

}
