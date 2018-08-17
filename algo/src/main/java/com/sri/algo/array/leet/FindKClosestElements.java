package com.sri.algo.array.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a sorted array, two integers k and x, find the k closest elements to x
 * in the array. The result should also be sorted in ascending order. If there
 * is a tie, the smaller elements are always preferred.
 * 
 * Example 1: Input: [1,2,3,4,5], k=4, x=3 Output: [1,2,3,4] Example 2: Input:
 * [1,2,3,4,5], k=4, x=-1 Output: [1,2,3,4] Note: The value k is positive and
 * will always be smaller than the length of the sorted array. Length of the
 * given array is positive and will not exceed 104 Absolute value of elements in
 * the array and x will not exceed 104
 * 
 * @author salla
 *
 */
public class FindKClosestElements {

	/**
	 * T.C : O(logn) + O(2k)
	 * @param arr
	 * @param k
	 * @param x
	 * @return
	 */
	public List<Integer> findClosestElements(int[] arr, int k, int x) {

		int n = arr.length;

		if (n == 0 || k == 0) {
			return new ArrayList<>();
		}

		if (x <= arr[0]) {
			return copy(arr, 0, k);
		}

		if (x >= arr[n - 1]) {
			return copy(arr, n - k, k);
		}

		int idx = Arrays.binarySearch(arr, 0, n - 1, x);

		if (idx < 0) {
			idx = -(idx + 1);
		}

		int l = idx - 1, r = arr[idx] == x ? idx + 1 : idx;
		LinkedList<Integer> dq = new LinkedList<>();

		if (arr[idx] == x) {
			dq.addLast(x);
		}

		while (l >= 0 && l >= idx - k && r <= idx + k && r < n) {
			if (dq.size() == k) {
				break;
			}
			if (Math.abs(x - arr[l]) <= Math.abs(x - arr[r])) {
				dq.addFirst(arr[l]);
				l--;
			} else {
				dq.addLast(arr[r]);
				r++;
			}
		}

		while (dq.size() != k) {
			if (l < 0) {
				dq.addLast(arr[r++]);
			} else {
				dq.addFirst(arr[l--]);
			}
		}

		return dq;
	}

	private List<Integer> copy(int[] arr, int start, int k) {

		List<Integer> result = new ArrayList<>();

		for (int i = start; i < start + k; i++) {
			result.add(arr[i]);
		}

		return result;
	}

	public static void main(String[] args) {

		FindKClosestElements findKClosestElements = new FindKClosestElements();

		// System.out.println(findKClosestElements.findClosestElements(new int[] { 1, 2,
		// 3, 4, 5 }, 4, 3));

		// System.out.println(findKClosestElements.findClosestElements(new int[] { 1, 2,
		// 3, 4, 5 }, 4, -1));

		System.out.println(findKClosestElements.findClosestElements(new int[] { 0, 1, 1, 1, 2, 3, 6, 7, 8, 9 }, 9, 4));

	}

}
