package com.sri.algo.array.leet.medium;

public class MinSwapsToMakeSeqIncreasing {

	public int minSwap(int[] A, int[] B) {
		int swap = 1, fix = 0;

		for (int i = 1; i < A.length; i++) {
			if (A[i - 1] >= B[i] || B[i - 1] >= A[i]) {
				swap++;
			} else if (A[i - 1] >= A[i] || B[i - 1] >= B[i]) {
				int temp = fix;
				fix = swap;
				swap = temp + 1;
			} else {
				int min = Math.min(swap, fix);
				swap = min + 1;
				fix = min;
			}
		}
		return Math.min(swap, fix);
	}

	public static void main(String[] args) {

		MinSwapsToMakeSeqIncreasing minSwapsToMakeSeqIncreasing = new MinSwapsToMakeSeqIncreasing();
		System.out.println(minSwapsToMakeSeqIncreasing.minSwap(new int[] { 1, 3, 5, 4 }, new int[] { 1, 2, 3, 7 }));

	}

}
