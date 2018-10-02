package com.sri.algo.math.leet;

/**
 * A sequence of number is called arithmetic if it consists of at least three
 * elements and if the difference between any two consecutive elements is the
 * same.
 * 
 * For example, these are arithmetic sequence:
 * 
 * 1, 3, 5, 7, 9 // 
 * 7, 7, 7, 7 // 
 * 3, -1, -5, -9 //
 * 
 *
 */
public class ArithmeticSlices {

	/**
	 * T.C : O (n*n)
	 * 
	 * @param A
	 * @return
	 */
	public int numberOfArithmeticSlicesBruteForce(int[] A) {
		int count = 0;
		for (int i = 0; i < A.length - 2; i++) {

			int d = A[i + 1] - A[i];

			for (int j = i + 2; j < A.length; j++) {
				if (A[j] - A[j - 1] == d) {
					count++;
				} else {
					break;
				}
			}
		}

		return count;
	}

	/**
	 * T.C O(n) S.C O(1)
	 * 
	 * @param A
	 * @return
	 */
	public int numberOfArithmeticSlicesWithDP(int[] A) {
		int count = 0;
		int sum = 0;
		for (int i = 2; i < A.length; i++) {

			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				count++;
				sum += count;
			} else {
				count = 0;
			}
		}

		return sum;
	}

	/***
	 * T.C : O(n)
	 * S.C : O(1)
	 * @param A
	 * @return
	 */
	public int numberOfArithmeticSlices(int[] A) {
		int count = 0;
		int sum = 0;
		for (int i = 2; i < A.length; i++) {

			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				count++;
			} else {

				sum += (count * (count + 1)) / 2;
				count = 0;
			}
		}

		return sum + count * (count + 1)/2;
	}

	public static void main(String[] args) {

		ArithmeticSlices as = new ArithmeticSlices();

		System.out.println(as.numberOfArithmeticSlices(new int[] { 1, 2, 3, 4 }));

		System.out.println(as.numberOfArithmeticSlicesWithDP(new int[] { 1, 2, 3, 4 }));

	}

}
