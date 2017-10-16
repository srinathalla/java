package com.sri.algo.dp.cp;

import java.util.Scanner;

/**
 * You are given a matrix having N rows and M columns. The special property of
 * this matrix is that some of the cells of this matrix are blocked i.e. they
 * cannot be reached. Now you have to start from the cell (1,1) and reach the
 * end (N,M) provided during the journey you can move horizontally right from
 * the current cell or vertically down from the current cell.Can you answer the
 * number of ways you can traverse the matrix obeying the above constraints
 * starting from (1,1) and ending at (N,M).Output your answer modulo 10^9+7.
 * 
 * Input 1 3 3 2 1 2 3 2 Output :
 * 
 * Explanation : For the above test case there is only one path from (1,1)
 * to(3,3) which is (1,1)->(2,1)->(2,2)->(2,3)->(3,3)
 * 
 * @author KH2024
 *
 */
public class SpecialMatrix {

	public static int count(int[][] matrix, int n, int m) {

		int[][] table = new int[n][m];

		for (int i = 0; i < n; i++) {
		
			for (int j = 0; j < m; j++) {
				if (i == 0 && j == 0) {
					table[i][j] = 1;
				} else {

					if (matrix[i][j] == -1) {
						table[i][j] = 0;
					} else {

						table[i][j] = table[i][j] + (j > 0 && matrix[i][j - 1] != -1 ? table[i][j - 1] : 0);

						table[i][j] = table[i][j] + (i > 0 && matrix[i - 1][j] != -1 ? table[i - 1][j] : 0);

						table[i][j] = table[i][j] % ((int) Math.pow(10, 9) + 7);
					}
				}

			}
		}

		return table[n - 1][m - 1];
	}

	public static void main(String[] args) {

		// System.out.println(count(new int[][] { { 0, -1, 0 }, { 0, 0, 0 }, { 0, -1, 0
		// } }, 3, 3));

		try (Scanner in = new Scanner(System.in)) {
			int testCount = in.nextInt();

			for (int k = 0; k < testCount; k++) {
				int n = in.nextInt();
				int m = in.nextInt();
				int l = in.nextInt();
				int[][] matrix = new int[n][m];

				for (int i = 0; i < l; i++) {

					matrix[in.nextInt() - 1][in.nextInt() - 1] = -1;

				}

				System.out.println(count(matrix, n, m));
			}
		}
	}

}
