package com.sri.algo.array.cp;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array
 * if you can flip at most one 0.
 * 
 * Example 1: Input: [1,0,1,1,0] Output: 4 Explanation: Flip the first zero will
 * get the the maximum number of consecutive 1s. After flipping, the maximum
 * number of consecutive 1s is 4.
 * 
 * @author salla
 *
 */
public class MaxConsecutiveOnes {

	/**
	 * T.C O(n).
	 * 
	 * Two pointer based solution..
	 * 
	 * prev pointer points to ones before zero and curr points to ones after zero.
	 * 
	 * when ever we see a zero we try to calculate max ones..
	 * 
	 * eg   1,0,1 -> 3
	 *      0,0,0 -> 1
	 *      1,1,1 -> 3
	 *      1,1,1,0 -> 4
	 * 
	 * 
	 * @param nums
	 * @return
	 */
	public int findMaxConsecutiveOnes(int[] nums) {

		int prevOnesCount = 0;
		int max = 0, currOnesCount = 0;

		for (int no : nums) {

			if (no == 1) {
				currOnesCount++;

			} else {
				max = Integer.max(max, prevOnesCount + currOnesCount);

				prevOnesCount = currOnesCount + 1;
				currOnesCount = 0;
			}
		}

		if (nums[nums.length - 1] == 1) {
			max = Integer.max(max, prevOnesCount + currOnesCount);
		}

		if (nums[nums.length - 1] == 0) {
			max = Integer.max(max, prevOnesCount);
		}

		return max;
	}

	public static void main(String[] args) {

		MaxConsecutiveOnes mc = new MaxConsecutiveOnes();

		System.out.println(mc.findMaxConsecutiveOnes(new int[] { 1, 0, 1, 1, 0 }));

		System.out.println(mc.findMaxConsecutiveOnes(new int[] { 1, 1, 1, 1, 0 }));

		System.out.println(mc.findMaxConsecutiveOnes(new int[] { 0, 0 }));

		System.out.println(mc.findMaxConsecutiveOnes(new int[] { 1, 0, 1 }));
	}

}
