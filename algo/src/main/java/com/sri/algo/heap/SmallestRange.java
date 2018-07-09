package com.sri.algo.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import com.sri.algo.array.PrintArray;

/**
 * You have k lists of sorted integers in ascending order. Find the smallest
 * range that includes at least one number from each of the k lists.
 * 
 * We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c
 * if b-a == d-c.
 * 
 * Example 1: Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]] Output: [20,24]
 * Explanation: List 1: [4, 10, 15, 24,26], 24 is in range [20,24]. List 2: [0,
 * 9, 12, 20], 20 is in range [20,24]. List 3: [5, 18, 22, 30], 22 is in range
 * [20,24].
 * 
 * @author salla
 *
 */
public class SmallestRange {

	/**
	 * This is similar to merge n sorted arrays.
	 * 
	 * T.C : O (n m * longn);
	 * 
	 * @param nums
	 * @return
	 */
	public int[] smallestRangeWithArray(int[][] nums) {
		PriorityQueue<Entry> pq = new PriorityQueue<>((Entry a, Entry b) -> a.val - b.val);

		int max = Integer.MIN_VALUE;

		int n = nums.length;

		for (int i = 0; i < n; i++) {
			pq.add(new Entry(nums[i][0], i, 0));
			max = Integer.max(max, nums[i][0]);
		}

		int start = -1, end = -1, range = Integer.MAX_VALUE;
		while (pq.size() == nums.length) {

			Entry currEntry = pq.poll();

			if (max - currEntry.val < range) {
				range = max - currEntry.val;
				start = currEntry.val;
				end = max;
			}

			if (currEntry.idx + 1 < nums[currEntry.row].length) {
				currEntry.idx++;
				currEntry.val = nums[currEntry.row][currEntry.idx];
				pq.offer(currEntry);
				max = Integer.max(max, currEntry.val);
			}
		}

		return new int[] { start, end };
	}

	public int[] smallestRange(List<List<Integer>> nums) {
		PriorityQueue<Entry> pq = new PriorityQueue<>((Entry a, Entry b) -> a.val - b.val);

		int max = Integer.MIN_VALUE;

		int n = nums.size();

		for (int i = 0; i < n; i++) {
			pq.add(new Entry(nums.get(i).get(0), i, 0));
			max = Integer.max(max, nums.get(i).get(0));
		}

		int start = -1, end = -1, range = Integer.MAX_VALUE;
		while (pq.size() == nums.size()) {

			Entry currEntry = pq.poll();

			if (max - currEntry.val < range) {
				range = max - currEntry.val;
				start = currEntry.val;
				end = max;
			}

			if (currEntry.idx + 1 < nums.get(currEntry.row).size()) {
				currEntry.idx++;
				currEntry.val = nums.get(currEntry.row).get(currEntry.idx);
				pq.offer(currEntry);
				max = Integer.max(max, currEntry.val);
			}
		}

		return new int[] { start, end };
	}

	private static class Entry {

		int val;
		int row;
		int idx;

		public Entry(int val, int row, int idx) {
			super();
			this.val = val;
			this.row = row;
			this.idx = idx;
		}
	}

	public static void main(String[] args) {

		SmallestRange sr = new SmallestRange();

		int[][] nums = new int[][] { { 4, 10, 15, 24, 26 }, { 0, 9, 12, 20 }, { 5, 18, 22, 30 } };
		PrintArray.print(sr.smallestRangeWithArray(nums));

		List<List<Integer>> numsList = new ArrayList<>();
		numsList.add(Arrays.asList(new Integer[] { 4, 10, 15, 24, 26 }));
		numsList.add(Arrays.asList(new Integer[] { 0, 9, 12, 20 }));
		numsList.add(Arrays.asList(new Integer[] { 5, 18, 22, 30 }));

		PrintArray.print(sr.smallestRange(numsList));

	}

}
