package com.sri.algo.dp;

public class LongestIncreasingSubSequence {

	public static int longIncreasingSubSequence(int[] arr) {
		int seqCount[] = new int[arr.length];

		for (int i = 0; i < seqCount.length; i++) {
			seqCount[i] = 1;
		}

		for (int i = 1; i < arr.length; i++) {

			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					seqCount[i] = Math.max(seqCount[j] + 1, seqCount[i]);
				}
			}
		}

		int max = 0;
		for (int i = 0; i < seqCount.length; i++) {
			max = Math.max(seqCount[i], max);
		}

		return max;
	}

	public static int longIncreasingSSWithDP(int[] arr) {
		int seqCount[] = new int[arr.length];

		for (int i = 0; i < seqCount.length; i++) {
			seqCount[i] = 1;
		}

		for (int i = 1; i < arr.length; i++) {

			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					seqCount[i] = Math.max(seqCount[j] + 1, seqCount[i]);
				}
			}
		}

		int max = 0;
		for (int i = 0; i < seqCount.length; i++) {
			max = Math.max(seqCount[i], max);
		}

		return max;
	}

	public int lengthOfLIS(int[] nums) {

		int n = nums.length;
		
		if (n < 2)
		{
			return n;
		}
		
		int[] seqcount = new int[n];

		for (int i = 0; i < n; i++) {

			seqcount[i] = 1;
		}

		for (int i = 1; i < n; i++) {

			for (int j = 0; j < i; j++) {

				if (nums[i] > nums[j]) {
					seqcount[i] = Integer.max(seqcount[i], seqcount[j] + 1);
				}
			}
		}

		int max = 0;

		for (int i = 0; i < n; i++) {
			max = Integer.max(max, seqcount[i]);
		}

		return max;

	}

	public static void main(String[] args) {
		/*
		 * System.out.println(LongestIncreasingSubSequence
		 * .longIncreasingSubSequence(new int[] { 10, 22, 9, 33, 21, 50, 41, 60, 80 }));
		 */
		
		LongestIncreasingSubSequence lis = new LongestIncreasingSubSequence();
		
		System.out.println(lis.lengthOfLIS(new int[] {1,3,5,4,7}));

		/*try (Scanner in = new Scanner(System.in)) {
			int testCount = in.nextInt();

			for (int i = 0; i < testCount; i++) {
				int n = in.nextInt();
				int[] arr = new int[n];

				for (int j = 0; j < n; j++) {
					arr[j] = in.nextInt();
				}

				System.out.println(longIncreasingSubSequence(arr));
			}
		}*/

	}

}
