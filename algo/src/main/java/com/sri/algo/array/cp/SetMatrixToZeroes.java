package com.sri.algo.array.cp;

import java.util.HashSet;
import java.util.Set;

import com.sri.algo.array.PrintArray;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 * 
 * @author salla
 *
 */
public class SetMatrixToZeroes {

	/**
	 * Two pass solution with extra space. O(n + m) Can we do better.
	 * 
	 * @param matrix
	 */
	public void setZeroes(int[][] matrix) {
		int r = matrix.length;
		if (r == 0) {
			return;
		}

		int c = matrix[0].length;

		Set<Integer> zr = new HashSet<>();
		Set<Integer> zc = new HashSet<>();

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (matrix[i][j] == 0) {
					zr.add(i);
					zc.add(j);
				}
			}
		}

		for (int i = 0; i < r; i++) {
			if (zr.contains(i)) {
				for (int j = 0; j < c; j++) {
					matrix[i][j] = 0;
				}
			} else {
				for (int j = 0; j < c; j++) {
					if (zc.contains(j)) {
						matrix[i][j] = 0;
					}
				}

			}
		}
	}

	public void setZeroesWithO1Space(int[][] matrix) {
		int r = matrix.length;
		if (r == 0) {
			return;
		}

		int c = matrix[0].length;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = r-1; i >= 0; i--) 
		{
			for (int j = c-1; j >= 0; j--) 
			{
				if (matrix[i][0] == 0 || matrix[0][j] == 0)
				{
					matrix[i][j] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
		SetMatrixToZeroes sm = new SetMatrixToZeroes();

		sm.setZeroesWithO1Space(arr);

		PrintArray.print2dArray(arr);
	}

}
