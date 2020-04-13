package com.sri.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	public int sumFourDivisors(int[] nums) {

		int sum = 0;

		for (int no : nums) {
			Set<Integer> l = new HashSet<>();
			l.add(1);
			l.add(no);

			for (int j = 2; j <= Math.sqrt(no); j++) {

				if (no % j == 0) {
					l.add(j);
					l.add(no / j);
				}

				if (l.size() > 4) {
					break;
				}

			}

			if (l.size() == 4) {
				for (int n : l) {
					sum += n;
				}
			}
		}

		return sum;

	}

	public static void main(String[] args) {

		Solution s = new Solution();

		System.out.println(s.sumFourDivisors(new int[] {21,4,7}));

	}

}
