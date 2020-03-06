package com.sri.algo.hashing.leet;

import java.util.stream.IntStream;

public class SubArrayWithEqualSum {

	public int numSubarraysWithSum(int[] A, int S) {

		int sum = IntStream.of(A).sum();
		int[] map = new int[sum + 1];
		map[0] =1;
		int res = 0;

		sum = 0;
		for (int no : A) {
			sum += no;
			if (sum >= S) {
				res += map[sum - S];
			}

			map[sum]++;
		}

		return res;
	}
	
	public static void main(String[] args) {
		
		SubArrayWithEqualSum subArrayWithEqualSum = new SubArrayWithEqualSum();
		System.out.println(
			subArrayWithEqualSum.numSubarraysWithSum(new int[] {1,0,1,0,1}, 2));
		System.out.println(
				subArrayWithEqualSum.numSubarraysWithSum(new int[] {1,0,1,0,1,0}, 2));
		
	}

}
