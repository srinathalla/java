package com.sri.algo.array.leet.medium;

import com.sri.algo.array.PrintArray;

public class ClosestDivisors {

	public int[] closestDivisors(int num) {
		int[] res = new int[] { 1, num + 1 };

		for (int i = 2; i <= Math.sqrt(num) + 1; i++) {

			if ((num + 2) % i == 0) {
				res[0] = i;
				res[1] = (num + 2) / i;
			}

			if ((num + 1) % i == 0) {
				res[0] = i;
				res[1] = (num + 1) / i;
			}
		}

		return res;
	}

	public static void main(String[] args) {

		ClosestDivisors closestDivisors = new ClosestDivisors();
		PrintArray.print(closestDivisors.closestDivisors(9));

	}

}
