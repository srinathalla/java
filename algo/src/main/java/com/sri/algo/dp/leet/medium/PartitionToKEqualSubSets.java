package com.sri.algo.dp.leet.medium;

import java.util.stream.IntStream;

/**
 * Given an array of integers nums and a positive integer k, find whether it's
 * possible to divide this array into k non-empty subsets whose sums are all
 * equal.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4 Output: True Explanation: It's
 * possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal
 * sums.
 * 
 * @author srialla
 *
 */
public class PartitionToKEqualSubSets {

	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = IntStream.of(nums).sum();
		if (k <= 0 || sum % k != 0) {
			return false;
		}
		return canPartition(nums, k, 0, new boolean[nums.length], 0, sum / k);

	}

	private boolean canPartition(int[] nums, int k, int start, boolean[] visited, int sum, int target) {
		if (k == 1) {
			return true;
		}

		if (sum == target) {
			return canPartition(nums, k - 1, 0, visited, 0, target);
		}

		if (sum > target) {
			return false;
		}

		for (int i = start; i < nums.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				if (canPartition(nums, k, i + 1, visited, sum + nums[i], target)) {
					return true;
				}
				visited[i] = false;
			}
		}
		return false;

	}
	
	public static void main(String[] args) {
		
		PartitionToKEqualSubSets partitionToKEqualSubSets = new PartitionToKEqualSubSets();
		System.out.println(
			partitionToKEqualSubSets.canPartitionKSubsets(new int[] {4, 3, 2, 3, 5, 2, 1}, 4));
		
	}

}
