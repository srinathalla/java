package com.sri.algo.array.cp;

import java.util.BitSet;

/**
 * Given an unsorted array of size n. Array elements are in range from 1 to n.
 * One number 'A' from set {1, 2, …n} is missing and one number 'B' occurs twice
 * in array. Find these two numbers.
 * 
 * Note: If you find multiple answers then print the Smallest number found.
 * 
 *
 */
public class MissingNRepeatingNos {

	public static void findMissingNRepeating(int[] arr, int N) {

		BitSet bitSet = new BitSet(N);
		int repeated = -1, missing = -1;

		// Set bits in the range.
		for (int no : arr) {

			// If this bit is already set for current number then this is repeated.
			if (!bitSet.get(no - 1)) {
				bitSet.set(no - 1);
			} else if (repeated == -1) {
				repeated = no;
			}
		}

		for (int i = 0; i < N; i++) {
			if (!bitSet.get(i)) {
				missing = i + 1;
				break;
			}
		}

		System.out.println(repeated + " " + missing);
	}

	public static void main(String[] args) {

		findMissingNRepeating(new int[] { 2, 2 }, 2);

		findMissingNRepeating(new int[] { 1, 3, 3 }, 3);
	}

}
