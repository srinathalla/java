package com.sri.algo.array.leet.medium;

import com.sri.algo.array.PrintArray;

public class SpiralMatrix2 {
	
	/**
	 * T.C : O(n)
	 * @param n
	 * @return
	 */
	public int[][] generateMatrix(int n) {

		int[][] m = new int[n][n];

		int rs = 0, re = n-1, cs = 0, ce = n-1, c = 0;

		while (rs <= re && cs <= ce) {
			int i = rs;
			for (int j = cs; j <= ce; j++) {
				m[i][j] = ++c;
			}
			rs++;

			int j = ce;
			for (i = rs; i <= re; i++) {
				m[i][j] = ++c;
			}
			ce--;

			i = re;
			for (j = ce; j >= cs && i >= rs; j--) {
				m[i][j] = ++c;
			}
			re--;

			j = cs;
			for (i = re; i >= rs && j <= ce; i--) {
				m[i][j] = ++c;
			}
			cs++;
		}

		return m;

	}

	public static void main(String[] args) {
		
		SpiralMatrix2 spiralMatrix2 = new SpiralMatrix2();
		
		int[][] table = spiralMatrix2.generateMatrix(4);
		
		PrintArray.print2dArray(table);

	}

}
