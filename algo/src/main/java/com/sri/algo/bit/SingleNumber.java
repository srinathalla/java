package com.sri.algo.bit;

/**
 * Given a non-empty array of integers, every element appears three times except
 * for one, which appears exactly once. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 * Example 1:
 * 
 * Input: [2,2,3,2] Output: 3
 * 
 * @author srialla
 *
 */
public class SingleNumber {

	public int singleNumber(int[] A) {
		int ones = 0, twos = 0;
		for (int i = 0; i < A.length; i++) {
			ones = (ones ^ A[i]) & ~twos;
			twos = (twos ^ A[i]) & ~ones;
		}
		return ones;
	}
	
	public static void main(String[] args) {
		
		SingleNumber singleNumber = new SingleNumber();
		singleNumber.singleNumber(new int[] {0,1,0,1,0,1,99});
		
	}

}
