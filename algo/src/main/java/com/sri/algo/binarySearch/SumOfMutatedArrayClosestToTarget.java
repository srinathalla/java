package com.sri.algo.binarySearch;

import java.util.Arrays;

public class SumOfMutatedArrayClosestToTarget {

	public int findBestValue(int[] A, int target) {
		Arrays.sort(A);
		int n = A.length, i = 0;
		while (i < n && target > A[i] * (n - i)) {
			target -= A[i++];
		}
		if (i == n)
			return A[n - 1];
		int res = target / (n - i);
		if (target - res * (n - i) > (res + 1) * (n - i) - target)
			res++;
		return res;
	}

	public static void main(String[] args) {

		int[] arr = new int[] { 4, 9, 3 };
		SumOfMutatedArrayClosestToTarget s = new SumOfMutatedArrayClosestToTarget();
		System.out.println(
			s.findBestValue(arr, 10));
	}

}
