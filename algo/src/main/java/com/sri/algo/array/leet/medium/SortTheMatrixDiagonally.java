package com.sri.algo.array.leet.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import com.sri.algo.array.PrintArray;

/**
 * Given a m * n matrix mat of integers, sort it diagonally in ascending order
 * from the top-left to the bottom-right then return the sorted array.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]] Output:
 * [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
 * 
 * @author srialla
 *
 */
public class SortTheMatrixDiagonally {

	public int[][] diagonalSort(int[][] mat) {

		int n = mat.length, m = mat[0].length;
		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (!map.containsKey(i - j)) {
					map.put(i - j, new PriorityQueue<Integer>());
				}

				map.get(i - j).add(mat[i][j]);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				mat[i][j] = map.get(i - j).poll();
			}
		}

		return mat;
	}

	public static void main(String[] args) {

		SortTheMatrixDiagonally sortTheMatrixDiagonally = new SortTheMatrixDiagonally();

		int[][] mat = { { 3, 3, 1, 1 }, { 2, 2, 1, 2 }, { 1, 1, 1, 2 } };
		mat = sortTheMatrixDiagonally.diagonalSort(mat);
		PrintArray.print2dArray(mat);

	}

}
