package com.sri.algo.greedy.leet;

import java.util.stream.IntStream;

import com.sri.algo.array.PrintArray;

public class ThreeEqualParts {

	public int[] threeEqualParts(int[] A) {

		int count = (int) IntStream.of(A).filter(a -> a == 1).count();

		if (count == 0) {
			return new int[] { 0, A.length - 1 };
		}

		if (count % 3 != 0) {
			return new int[] { -1, -1 };
		}

		int k = count / 3;

		count = 0;
		int start = -1, mid = -1, end = -1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 1) {
				count++;
			}

			if (start == -1 && count == 1) {
				start = i;
			}

			else if (mid == -1 && count == k + 1) {
				mid = i;
			} else if (end == -1 && count == 2 * k + 1) {
				end = i;
				break;
			}
		}

		while (end < A.length && A[start] == A[mid] && A[mid] == A[end]) {
			start++;
			mid++;
			end++;
		}

		if (end == A.length) {
			return new int[] { start - 1, mid };
		}

		return new int[] { -1, -1 };

	}
	
	public static void main(String[] args) {
		
		ThreeEqualParts threeEqualParts = new ThreeEqualParts();
		PrintArray.print(
			threeEqualParts.threeEqualParts(new int[] {1,0,1,0,1}));
		
	}

}
