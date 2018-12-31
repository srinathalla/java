package com.sri.algo.heap.leet.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import com.sri.algo.array.PrintArray;

public class FindKPairsWithSmallestSum {

	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {

		List<int[]> result = new ArrayList<>();

		if (nums1.length == 0 || nums2.length == 0) {
			return result;
		}

		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);

		for (int no : nums1) {
			q.add(new int[] { no, nums2[0], 0 });
		}

		for(int i=0; i < k && i < nums1.length * nums2.length; i++) {
			int[] a = q.poll();

			result.add(new int[] { a[0], a[1] });

			if (a[2] != nums2.length - 1) {
				q.add(new int[] { a[0], nums2[a[2] + 1] , a[2] + 1 });
			}
		}

		return result;

	}

	public static void main(String[] args) {

		FindKPairsWithSmallestSum findKPairsWithSmallestSum = new FindKPairsWithSmallestSum();

		List<int[]> result = findKPairsWithSmallestSum.kSmallestPairs(new int[] { 1, 2, 4 }, new int[] { -1, 1, 2 },
				100);

		for (int[] a : result) {
			PrintArray.print(a);
			System.out.print(",");
		}
	}

}
