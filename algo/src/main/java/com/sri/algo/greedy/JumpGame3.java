package com.sri.algo.greedy;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * Example 1:
 * 
 * Input: [2,3,1,1,4] Output: true Explanation: Jump 1 step from index 0 to 1,
 * then 3 steps to the last index. Example 2:
 * 
 * Input: [3,2,1,0,4] Output: false Explanation: You will always arrive at index
 * 3 no matter what. Its maximum jump length is 0, which makes it impossible to
 * reach the last index.
 * 
 * @author salla
 *
 */
public class JumpGame3 {

	/**
	 * T.C : O(n).
	 * 
	 * @param a
	 * @return
	 */
	public boolean canJump(int[] a) {

		int n = a.length;

		if (n == 1) {
			return true;
		}

		if (a[0] == 0) {
			return false;
		}

		int currJump = 0, nextJump = 0;
		for (int i = 0; i < n; i++) {
			nextJump = Integer.max(nextJump, i + a[i]);

			if (nextJump >= n - 1) {
				return true;
			}

			if (i == currJump) {
				if (nextJump == currJump) {
					return false;
				}
				currJump = nextJump;
			}
		}

		return false;
	}
	
	/**
	 * T.C : O (n)
	 * @param a
	 * @return
	 */
	public boolean canJumpTraverseBack(int[] a) {

		int currPos = a.length -1;
		
		for (int i= a.length -2; i>=0; i--)
		{
			if (i + a[i] >= currPos)
			{
				currPos = i;
			}
		}

		return currPos == 0;
	}
	
	

	public static void main(String[] args) {

		JumpGame3 jg3 = new JumpGame3();

		System.out.println(jg3.canJump(new int[] { 2, 3, 1, 1, 4 }));

		System.out.println(jg3.canJump(new int[] { 3, 2, 1, 0, 4 }));

	}

}
