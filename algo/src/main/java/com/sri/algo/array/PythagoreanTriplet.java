package com.sri.algo.array;

import java.util.Arrays;

public class PythagoreanTriplet {

	/**
	 * Search the array for 3 entries(a, b, c) such that a^2 + b^2 = c ^2.
	 *  
	 * @param arr
	 * @return
	 */
	public static boolean hasPythagoreanTriplet(int[] arr) {

		// At each entry store the square of itself. 
		// TC : O(n).
		for (int index = 0; index < arr.length; index++) {
			arr[index] = arr[index] * arr[index];
		}

		// Time Complexity O(nlogn)
		Arrays.sort(arr);

		// Time Complexity O(n^2)
		// Fix c and look for other two entries.
		for (int i = arr.length - 1; i >= 2; i--) {

			int l = 0;
			int m = i - 1;

			while (l < m) {
				if (arr[l] + arr[m] == arr[i]) {
					return true;
				}

				if (arr[l] + arr[m] < arr[i]) {
					l++;
				} else {
					m--;
				}
			}
		}

		return false;
	}

}
