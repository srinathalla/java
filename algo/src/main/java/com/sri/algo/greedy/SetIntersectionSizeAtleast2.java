package com.sri.algo.greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * An integer interval [a, b] (for integers a < b) is a set of all consecutive
 * integers from a to b, including a and b.
 * 
 * Find the minimum size of a set S such that for every integer interval A in
 * intervals, the intersection of S with A has size at least 2.
 * 
 * Example 1: Input: intervals = [[1, 3], [1, 4], [2, 5], [3, 5]] Output: 3
 * Explanation: Consider the set S = {2, 3, 4}. For each interval, there are at
 * least 2 elements from S in the interval. Also, there isn't a smaller size set
 * that fulfills the above condition. Thus, we output the size of this set,
 * which is 3.
 * 
 * Example 2: Input: intervals = [[1, 2], [2, 3], [2, 4], [4, 5]] Output: 5
 * Explanation: An example of a minimum sized set is {1, 2, 3, 4, 5}.
 * 
 * @author salla
 *
 */
public class SetIntersectionSizeAtleast2 {

	private Set<Integer> set = new HashSet<>();

	/**
	 * T.C : O(n logn) where n is number of intervals.
	 * 
	 * @param intervals
	 * @return
	 */
	public int intersectionSizeTwo(int[][] intervals) {

		Arrays.sort(intervals, (int[] a, int[] b) -> a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]);

		int max = -1, secondMax = -1, minIntersectionSize = 0;

		for (int[] interval : intervals) {
			int a = interval[0];
			int b = interval[1];
			boolean max_in = false, secondMax_in = false;

			if (a <= max) {
				max_in = true;
			}

			if (a <= secondMax) {
				secondMax_in = true;
			}

			if (max_in && secondMax_in) {
				continue;
			}

			minIntersectionSize += max_in ? 1 : 2;

			secondMax = max_in ? max : b - 1;
			max = b;

			if (!max_in)
			{
				set.add(secondMax);
			}
			
			set.add(max);
		}

		return minIntersectionSize;
	}

	public static void main(String[] args) {

		int[][] intervals = new int[][] { { 1, 3 }, { 1, 4 }, { 2, 5 }, { 3, 5 } };

		SetIntersectionSizeAtleast2 si = new SetIntersectionSizeAtleast2();

		System.out.println(si.intersectionSizeTwo(intervals));
		
		System.out.println(si.set);

	}

}
