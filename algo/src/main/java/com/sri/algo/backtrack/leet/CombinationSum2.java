package com.sri.algo.backtrack.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sums to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers. The solution set
 * must not contain duplicate combinations. Example 1:
 * 
 * Input: candidates = [10,1,2,7,6,1,5], target = 8, A solution set is: [ [1,
 * 7], [1, 2, 5], [2, 6], [1, 1, 6] ] Example 2:
 * 
 * Input: candidates = [2,5,2,1,2], target = 5, A solution set is: [ [1,2,2],
 * [5] ]
 * 
 * @author salla
 *
 */
public class CombinationSum2 {

	List<List<Integer>> result;

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {

		result = new ArrayList<>();

		Arrays.sort(candidates);

		dfs(candidates, 0, target, 0, new ArrayList<>());

		return result;
	}

	public void dfs(int[] candidates, int i, int target, int sum, List<Integer> combination) {

		if (sum == target) {
			List<Integer> entry = new ArrayList<>(combination);

			Collections.sort(entry);
			if (!result.contains(entry)) {

				result.add(entry);
			}
		}

		while (sum == 0 && i > 0 && i < candidates.length && candidates[i] == candidates[i - 1]) {
			i++;
		}

		if (sum >= target || i >= candidates.length) {
			return;
		}

		combination.add(candidates[i]);
		dfs(candidates, i + 1, target, sum + candidates[i], combination);

		combination.remove(combination.size() - 1);

		dfs(candidates, i + 1, target, sum, combination);

	}

	public static void main(String[] args) {

		CombinationSum2 sample = new CombinationSum2();
		/*
		 * System.out.println( sample.combinationSum2(new int[] {10,1,2,7,6,1,5}, 8));
		 */

		System.out.println(sample.combinationSum2(new int[] { 1, 1 }, 1));

	}
}
