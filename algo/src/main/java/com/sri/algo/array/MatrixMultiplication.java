package com.sri.algo.array;

public class MatrixMultiplication {

	public static int[][] matMultiply(int[][] A, int[][] B) {
		int r = A.length;
		int c = B[0].length;
		int[][] C = new int[r][c];

		for (int i = 0; i < r; i++) {

			for (int j = 0; j < c; j++) {
				int s = 0;
				for (int k = 0; k < A[0].length; k++) {
					s = s + A[i][k] * B[k][j];
				}

				C[i][j] = s;
			}
		}
		return C;
	}

	public static void main(String[] args) {
		
		int[][] res = matMultiply(new int[][] {{1,2},{3,4}} , new int[][] {{5,6},{7,8}});

		System.out.println(res);
	}

}
