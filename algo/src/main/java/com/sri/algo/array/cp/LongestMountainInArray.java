package com.sri.algo.array.cp;

/**
 * Let's call any (contiguous) subarray B (of A) a mountain if the following
 * properties hold:
 * 
 * B.length >= 3 There exists some 0 < i < B.length - 1 such that B[0] < B[1] <
 * ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1] (Note that B could be any
 * subarray of A, including the entire array A.)
 * 
 * Given an array A of integers, return the length of the longest mountain.
 * 
 * Return 0 if there is no mountain.
 * 
 * Example 1:
 * 
 * Input: [2,1,4,7,3,2,5] Output: 5 Explanation: The largest mountain is
 * [1,4,7,3,2] which has length 5. Example 2:
 * 
 * Input: [2,2,2] Output: 0 Explanation: There is no mountain.
 * 
 * @author salla
 *
 */
public class LongestMountainInArray {

	/**
	 * Two pointer solution..
	 * 
	 * T.C O(n) .
	 * Single pass solution .
	 * Auxillary space : O(1)..
	 * 
	 * @param arr
	 * @return
	 */
	public int longestMountain(int[] arr) {

		int n = arr.length;
		
		if (n < 3)
		{
			return 0;
		}

		int i = 0, max = 0, lcount = 0, rcount = 0;

		while (i < n-2) {
			while (i < n - 1 && arr[i] >= arr[i + 1]) {
				i++;
			}

			while (i < n - 1 && arr[i] < arr[i + 1]) {
				lcount++;
				i++;
			}

			while (i < n - 1 && arr[i] > arr[i + 1]) {
				rcount++;
				i++;
			}

			if (rcount > 0) {
				max = Integer.max(max, lcount + rcount + 1);
			}

			lcount = 0;
			rcount = 0;
		}

		return max;

	}

	public static void main(String[] args) {

		LongestMountainInArray lmia = new LongestMountainInArray();

		System.out.println(lmia.longestMountain(new int[] { 2, 1, 4, 7, 3, 2, 5 }));
		
		System.out.println(lmia.longestMountain(new int[] { 2,2,2 }));

	}

}
