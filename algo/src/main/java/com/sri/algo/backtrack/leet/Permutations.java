package com.sri.algo.backtrack.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.

	Example:
	
	Input: [1,2,3]
	Output:
	[
	  [1,2,3],
	  [1,3,2],
	  [2,1,3],
	  [2,3,1],
	  [3,1,2],
	  [3,2,1]
	]
	
 * @author salla
 *
 */
public class Permutations {
	List<List<Integer>> result;

	public List<List<Integer>> permute(int[] nums) {

		result = new ArrayList<>();

		permute(nums, 0);

		return result;

	}

	private void permute(int[] nums, int l) {

		if (l == nums.length) {

			List<Integer> p = new ArrayList<>();

			for (int no : nums) {
				p.add(no);
			}

			result.add(p);
			return;
		}

		for (int i = l; i < nums.length; i++) {

			int tmp = nums[l];
			nums[l] = nums[i];
			nums[i] = tmp;

			permute(nums, l + 1);

			tmp = nums[l];
			nums[l] = nums[i];
			nums[i] = tmp;
		}

	}
	
	public static void main(String[] args) {
		
		Permutations permutations = new Permutations();
		
		System.out.println(permutations.permute(new int[] {1,2,3}));
		
	}

}
