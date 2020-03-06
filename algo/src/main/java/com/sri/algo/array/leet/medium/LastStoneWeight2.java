package com.sri.algo.array.leet.medium;

import java.util.stream.IntStream;

/**
 * We have a collection of rocks, each rock has a positive integer weight.
 * 
 * Each turn, we choose any two rocks and smash them together. Suppose the
 * stones have weights x and y with x <= y. The result of this smash is:
 * 
 * If x == y, both stones are totally destroyed; If x != y, the stone of weight
 * x is totally destroyed, and the stone of weight y has new weight y-x. At the
 * end, there is at most 1 stone left. Return the smallest possible weight of
 * this stone (the weight is 0 if there are no stones left.)
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [2,7,4,1,8,1] Output: 1 Explanation: We can combine 2 and 4 to get 2
 * so the array converts to [2,7,1,8,1] then, we can combine 7 and 8 to get 1 so
 * the array converts to [2,1,1,1] then, we can combine 2 and 1 to get 1 so the
 * array converts to [1,1,1] then, we can combine 1 and 1 to get 0 so the array
 * converts to [1] then that's the optimal value.
 * 
 * @author srialla
 *
 */
public class LastStoneWeight2 {

	public int lastStoneWeightII(int[] stones) {

		int sum = IntStream.of(stones).sum();
		int n = stones.length;

		boolean[][] dp = new boolean[n + 1][sum/2 + 1];

		for (int i = 0; i <= sum/2; i++) {
			dp[0][i] = false;
		}
		for (int i = 0; i < n + 1; i++) {
			dp[i][0] = true;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum/2; j++) {
				if (j >= stones[i - 1]) {
					dp[i][j] = dp[i - 1][j - stones[i - 1]] || dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}

			}
		}

		int i = sum / 2, k = 0;
		while (i >= 0) {
			if (dp[n][i - k]) {
				break;
			}
			k++;
		}

		int closer = i - k;

		return Math.abs(closer - (sum - closer));
	}

	public static void main(String[] args) {
		
		LastStoneWeight2 lastStoneWeight2 = new LastStoneWeight2();
		System.out.println(
			lastStoneWeight2.lastStoneWeightII(new int[] {2,7,4,1,8,1}));
	
		System.out.println(
				lastStoneWeight2.lastStoneWeightII(new int[] {31,26,33,21,40}));
	
		
	}

}
