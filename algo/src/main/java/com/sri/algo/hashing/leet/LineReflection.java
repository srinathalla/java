package com.sri.algo.hashing.leet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis
 * that reflect the given points.
 * 
 * Example 1:
 * 
 * Input: [[1,1],[-1,1]] Output: true Example 2:
 * 
 * Input: [[1,1],[-1,-1]] Output: false
 * 
 * @author salla
 *
 */
public class LineReflection {

	/**
	 * Two pass solution. T.C : O(n)
	 * 
	 * @param points
	 * @return
	 */
	public boolean isReflected(int[][] points) {

		Set<Integer> pset = new HashSet<>();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int[] point : points) {

			min = Integer.min(min, point[0]);
			max = Integer.max(max, point[0]);
			pset.add(Arrays.hashCode(point));
		}

		int sum = min + max;

		for (int[] point : points) {
			if (!pset.contains(Arrays.hashCode(new int[] { sum - point[0], point[1] }))) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {

		LineReflection lr = new LineReflection();

		System.out.println(lr.isReflected(new int[][] { { 1, 1 }, { -1, 1 } }));
		
		System.out.println(lr.isReflected(new int[][] { { 1, 1 }, { -1, -1 } }));

	}

}
