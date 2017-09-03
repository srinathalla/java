package com.sri.algo.dp;

public class MinJumps {

	public static int minJumps(int[] arr) {
		return minJumps(arr, 0, arr.length - 1);
	}

	private static int minJumps(int[] arr, int l, int h) {
		if (l == h) {
			return 0;
		}

		if (arr[l] == 0) {
			return Integer.MAX_VALUE;
		}

		int minJumps = Integer.MAX_VALUE;
		for (int i = l + 1; i <= h && i <= l + arr[l]; i++) {

			int jumps = minJumps(arr, i, h);
			minJumps = Integer.min(jumps + 1, minJumps);
		}
		return minJumps;
	}

	// Time complexitiy O(n^2)
	public static int minJumpsWithDP(int[] arr) {

		int[] jumpsArr = new int[arr.length];

		if (arr[0] == 0) {
			return Integer.MAX_VALUE;
		}

		jumpsArr[0] = 0;
		for (int i = 1; i < arr.length; i++) {

			jumpsArr[i] = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {

				if (j + arr[j] >= i && jumpsArr[j] != Integer.MAX_VALUE) {
					jumpsArr[i] = Integer.min(jumpsArr[i], jumpsArr[j] + 1);
				}
			}
		}

		return jumpsArr[jumpsArr.length - 1];
	}

	/**
	 * Returns minimum number of jumps to reach arr[n-1] from arr[0]
	 * 
	 * Time Complexity O(n)
	 * @param arr
	 * @param n
	 * @return
	 */
	public static int minJumpsWithDPInBigOOFN(int arr[], int n) {

		// The number of jumps needed to reach the starting index is 0
		if (n <= 1)
			return 0;

		// Return -1 if not possible to jump
		if (arr[0] == 0)
			return -1;

		// initialization
		int maxReach = arr[0]; // stores all time the maximal reachable index in the array.
		int step = arr[0]; // stores the amount of steps we can still take
		int jump = 1;// stores the amount of jumps necessary to reach that maximal reachable
						// position.

		// Start traversing array
		int i = 1;
		for (i = 1; i < n; i++) {
			// Check if we have reached the end of the array
			if (i == n - 1)
				return jump;

			// updating maxReach
			maxReach = Integer.max(maxReach, i + arr[i]);

			// we use a step to get to the current index
			step--;

			// If no further steps left
			if (step == 0) {
				// we must have used a jump
				jump++;

				// Check if the current index/position or lesser index
				// is the maximum reach point from the previous indexes
				if (i >= maxReach)
					return -1;

				// re-initialize the steps to the amount
				// of steps to reach maxReach from position i.
				step = maxReach - i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		
		int[] input= new int[] { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		
		System.out.println(minJumpsWithDPInBigOOFN(input, input.length));
	}

}
