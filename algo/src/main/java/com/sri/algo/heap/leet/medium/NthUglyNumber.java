package com.sri.algo.heap.leet.medium;

/**
 *  Write a program to find the n-th ugly number.

	Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
	
	Example:
	
	Input: n = 10
	Output: 12
	Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
	Note:  
	
	1 is typically treated as an ugly number.
	n does not exceed 1690.
	
 * @author salla
 *
 */
public class NthUglyNumber {

	/**
	 * T.C : O(n)
	 * S.C : O(n)
	 * 
	 * @param n
	 * @return
	 */
	public int nthUglyNumber(int n) {

		int[] ugly = new int[n];

		ugly[0] = 1;

		int i2 = 0, i3 = 0, i5 = 0;
		int f2 = 2, f3 = 3, f5 = 5;

		for (int i = 1; i < n; i++) {

			int min = Integer.min(f2, Integer.min(f3, f5));
			ugly[i] = min;

			if (min == f2) {
				f2 = 2 * ugly[++i2];
			}
			if (min == f3) {
				f3 = 3 * ugly[++i3];
			}
			if (min == f5) {
				f5 = 5 * ugly[++i5];
			}
		}

		return ugly[n - 1];

	}

	public static void main(String[] args) {

		NthUglyNumber nthUglyNumber = new NthUglyNumber();

		System.out.println(nthUglyNumber.nthUglyNumber(18));

	}

}
