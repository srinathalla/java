package com.sri.algo.dp.leet.medium;

public class MaximumSubarraySumwithOneDeletion {

	public int maximumSum(int[] arr) {

		int n = arr.length;
		int[] maxEndHere = new int[n];
		maxEndHere[0] = arr[0];
		int max = arr[0];

		for (int i = 1; i < n; i++) {
			maxEndHere[i] = Math.max(arr[i], arr[i] + maxEndHere[i - 1]);
			max = Math.max(max, maxEndHere[i]);

		}

		int[] maxStartHere = new int[n];
		maxStartHere[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			maxStartHere[i] = Math.max(arr[i], arr[i] + maxStartHere[i + 1]);
		}

		for (int i = 1; i < n - 1; i++) {
			max = Math.max(max, maxEndHere[i - 1] + maxStartHere[i + 1]);
		}

		return max;
	}

	public static void main(String[] args) {

		MaximumSubarraySumwithOneDeletion maximumSubarraySumwithOneDeletion = new MaximumSubarraySumwithOneDeletion();
		System.out.println(maximumSubarraySumwithOneDeletion.maximumSum(new int[] { 1, -2, 0, 3 }));
		System.out.println(maximumSubarraySumwithOneDeletion.maximumSum(new int[] { 1,-2,-2,3 }));
	}

}
