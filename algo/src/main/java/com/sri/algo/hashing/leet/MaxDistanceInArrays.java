package com.sri.algo.hashing.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given m arrays, and each array is sorted in ascending order. Now you can pick
 * up two integers from two different arrays (each array picks one) and
 * calculate the distance. We define the distance between two integers a and b
 * to be their absolute difference |a-b|. Your task is to find the maximum
 * distance.
 * 
 * Example 1: Input: [[1,2,3], [4,5], [1,2,3]] Output: 4 Explanation: One way to
 * reach the maximum distance 4 is to pick 1 in the first or third array and
 * pick 5 in the second array. Note: Each given array will have at least 1
 * number. There will be at least two non-empty arrays. The total number of the
 * integers in all the m arrays will be in the range of [2, 10000]. The integers
 * in the m arrays will be in the range of [-10000, 10000].
 * 
 * @author salla
 *
 */
public class MaxDistanceInArrays {

	public int maxDistance(List<List<Integer>> arrays) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (List<Integer> list : arrays) {
			min = Integer.min(min, list.get(0));
			max = Integer.max(max, list.get(list.size() - 1));
		}

		return max - min;
	}

	public static void main(String[] args) {
		Integer[][] distances = new Integer[][] { { 1, 2, 3 }, { 0, 0, 4 }, { 7, 6, 5 } };

		List<List<Integer>> distancesList = new ArrayList<>();

		for (Integer[] arr : distances) {
			distancesList.add(Arrays.asList(arr));
		}

		MaxDistanceInArrays dist = new MaxDistanceInArrays();

		System.out.println(dist.maxDistance(distancesList));
	}

}
