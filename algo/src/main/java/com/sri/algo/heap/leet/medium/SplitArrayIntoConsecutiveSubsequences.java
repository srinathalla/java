package com.sri.algo.heap.leet.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * You are given an integer array sorted in ascending order (may contain
 * duplicates), you need to split them into several subsequences, where each
 * subsequences consist of at least 3 consecutive integers. Return whether you
 * can make such a split.
 * 
 * Example 1: Input: [1,2,3,3,4,5] Output: True Explanation: You can split them
 * into two consecutive subsequences : 1, 2, 3 3, 4, 5 Example 2: Input:
 * [1,2,3,3,4,4,5,5] Output: True Explanation: You can split them into two
 * consecutive subsequences : 1, 2, 3, 4, 5 3, 4, 5
 * 
 * @author salla
 *
 */
public class SplitArrayIntoConsecutiveSubsequences {

	public boolean isPossibleWithOpenCloseIntervals(int[] nums) {

		Integer prev = null;
		int prevCount = 0;
		Queue<Integer> starts = new LinkedList<>();
		int anchor = 0;
		for (int i = 0; i < nums.length; ++i) {
			int t = nums[i];
			if (i == nums.length - 1 || nums[i + 1] != t) {
				int count = i - anchor + 1;
				if (prev != null && t - prev != 1) {
					while (prevCount-- > 0)
						if (prev < starts.poll() + 2)
							return false;
					prev = null;
				}

				if (prev == null || t - prev == 1) {
					while (prevCount > count) {
						prevCount--;
						if (t - 1 < starts.poll() + 2)
							return false;
					}
					while (prevCount++ < count)
						starts.add(t);
				}
				prev = t;
				prevCount = count;
				anchor = i + 1;
			}
		}

		while (prevCount-- > 0)
			if (nums[nums.length - 1] < starts.poll() + 2)
				return false;
		return true;

	}

	private static class Counter extends HashMap<Integer, Integer> {

		public int get(int k) {
			return super.containsKey(k) ? super.get(k) : 0;
		}

		public void  add(int k, int v) {
			 put(k, get(k) + v);
		}
	}

	/**
	 * T.C : O(n)
	 * S.C : O(n)
	 * 
	 * @param nums
	 * @return
	 */
	public boolean isPossible(int[] nums) {
		
		if (nums.length < 3)
		{
			return false;
		}

		Counter count = new Counter();
		Counter tails = new Counter();

		for (int num : nums) {
			count.add(num, 1);
		}
		
		for (int num: nums)
		{
			if (count.get(num) == 0)
			{
				continue;
			}
			else if (tails.get(num) > 0)
			{
				tails.add(num, -1);
				tails.add(num + 1, 1);
			}
			else if (count.get(num + 1) > 0 && count.get(num + 2) > 0)
			{
				count.add(num + 1, -1);
				count.add(num + 2, -1);
				tails.add(num + 3, 1);
			}
			else
			{
				return false;
			}
			count.add(num, -1);
		}

		return true;
	}

	public static void main(String[] args) {

		SplitArrayIntoConsecutiveSubsequences splitArrayIntoConsecutiveSubsequences = new SplitArrayIntoConsecutiveSubsequences();

		System.out.println(splitArrayIntoConsecutiveSubsequences.isPossibleWithOpenCloseIntervals(new int[] { 1, 2, 3, 3, 4, 5 }));

	}

}
