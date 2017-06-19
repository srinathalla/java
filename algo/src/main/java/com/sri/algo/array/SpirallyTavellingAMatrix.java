package com.sri.algo.array;

import java.util.ArrayList;
import java.util.List;

public class SpirallyTavellingAMatrix {

	public static void spirallyTraverseMatrix(int[][] matrix,int rEnd,int cEnd,
			List<Integer> spiralEntries) {

		int rStart = 0;
		int cStart = 0;
		
		while (rStart <= rEnd && cStart <= cEnd) 
		{
			// Traverse start row.
			for (int j = cStart; j <= cEnd; j++) {
				spiralEntries.add(matrix[rStart][j]);
			}
			rStart++;

			// Traverse last column.
			for (int i = rStart; i <= rEnd; i++) {
				spiralEntries.add(matrix[i][cEnd]);
			}
			cEnd--;

			// Traverse last row.
			if (rEnd >= rStart) {
				for (int j = cEnd; j >= cStart; j--) {
					spiralEntries.add(matrix[rEnd][j]);
				}
				rEnd--;
			}

			// Traverse first column.
			if (cEnd >= cStart && rEnd >= rStart) {
				for (int i = rEnd; i >= rStart; i--) {
					spiralEntries.add(matrix[i][cStart]);
				}
				cStart++;
			}
		}

	}

	public static void main(String[] args) {

		int[][] multi = new int[][]{
			  { 1, 2, 3, 4 },
			  { 5, 6, 7, 8 },
			  { 9, 10, 11, 12 },
			  { 13, 14, 15, 16 }
			};
		
		List<Integer> spiralEntries = new ArrayList<>();
			
		spirallyTraverseMatrix(multi,multi.length -1, multi[0].length -1, spiralEntries);
		
		System.out.println(spiralEntries);
	}
}
