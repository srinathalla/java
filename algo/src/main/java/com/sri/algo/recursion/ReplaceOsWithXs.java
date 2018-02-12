package com.sri.algo.recursion;

import java.util.Scanner;

/**
 * Given a matrix of size NxM where every element is either ‘O’ or ‘X’, replace ‘O’ with ‘X’ 
 * if surrounded by ‘X’. A ‘O’ (or a set of ‘O’) is considered to be by surrounded by ‘X’ if
 * there are ‘X’ at locations just below, just above, just left and just right of it.
 * 
 * Input: mat[N][M] =  {{'X', 'O', 'X', 'X', 'X', 'X'},
                     {'X', 'O', 'X', 'X', 'O', 'X'},
                     {'X', 'X', 'X', 'O', 'O', 'X'},
                     {'O', 'X', 'X', 'X', 'X', 'X'},
                     {'X', 'X', 'X', 'O', 'X', 'O'},
                     {'O', 'O', 'X', 'O', 'O', 'O'},
                    };
   Output: mat[N][M] =  {{'X', 'O', 'X', 'X', 'X', 'X'},
                      {'X', 'O', 'X', 'X', 'X', 'X'},
                      {'X', 'X', 'X', 'X', 'X', 'X'},
                      {'O', 'X', 'X', 'X', 'X', 'X'},
                      {'X', 'X', 'X', 'O', 'X', 'O'},
                      {'O', 'O', 'X', 'O', 'O', 'O'},
                    };
                    
                    Time Complexity  : O(N^2)(M^2).
 *
 */
public class ReplaceOsWithXs {

	public static void replaceOsWithX(char[][] table, int N, int M) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				// All sides should be filled with X
				// Even if immediate neighbour is not X recursively look for X.
			    // We traverse entire row and column i.e Time taken N*M for each cell over all
				// T.C is N*M*N*M. i.e (N^2)*(M^2)
				if (table[i][j] == 'O' && 
						hasLeftX(table, i, j, N, M) && 
						hasRightX(table, i, j, N, M) &&
						hasTopX(table, i, j, N, M) && 
						hasBottomX(table, i, j, N, M)) {
					
					table[i][j] =  'X';
				}
			}
		}
	}

	private static boolean isValid(int r, int c, int N, int M) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

	private static boolean hasLeftX(char[][] table, int r, int c, int N, int M) {
		if (!isValid(r, c - 1, N, M)) {
			return false;
		}

		if (table[r][c - 1] == 'X') {
			return true;
		}

		return hasLeftX(table, r, c - 1, N, M);
	}

	private static boolean hasRightX(char[][] table, int r, int c, int N, int M) {
		if (!isValid(r, c + 1, N, M)) {
			return false;
		}

		if (table[r][c + 1] == 'X') {
			return true;
		}

		return hasRightX(table, r, c + 1, N, M);
	}

	private static boolean hasTopX(char[][] table, int r, int c, int N, int M) {
		if (!isValid(r - 1, c, N, M)) {
			return false;
		}

		if (table[r - 1][c] == 'X') {
			return true;
		}

		return hasTopX(table, r - 1, c, N, M);
	}

	private static boolean hasBottomX(char[][] table, int r, int c, int N, int M) {
		if (!isValid(r + 1, c, N, M)) {
			return false;
		}

		if (table[r + 1][c] == 'X') {
			return true;
		}

		return hasBottomX(table, r + 1, c, N, M);
	}
	
	private static void print(char[][] table,int N,int M)
	{
		for (int i = 0; i < N; i++) 
		{
			for (int j = 0; j < M; j++) 
			{
				System.out.print(table[i][j] + " ");	
				
			}
		}

	}
	
	public static void main(String[] args) {
		
		/*char[][] table =  new char[][]{
			    {'X', 'O', 'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'O', 'O', 'X'},
                {'O', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'O', 'X', 'O'},
                {'O', 'O', 'X', 'O', 'O', 'O'},
               };
		
		replaceOsWithX(table,6,6);
		
		print(table,6,6);*/
		/**
		 * Input:
			4 7
			O O O O X X O O X O X O O X X X X X O X O O X X X O O O 
			
			Its Correct output is:
			O O O O X X O O X O X O O X X X X X O X O O X X X O O O
			
			And Your Code's Output is:
			O O O O X X O O X O X O X X X X X X O X O O X X X O O O
		 */

		try (Scanner in = new Scanner(System.in)) {
			int testCount = in.nextInt();

			for (int i = 0; i < testCount; i++) {
				int N = in.nextInt();
				int M = in.nextInt();

				String s = in.nextLine();
				while (s.isEmpty()) {
					s = in.nextLine();
				}
				s.trim();
				String[] dictionary = s.split(" ");

				char[][] charsMatrix = new char[N][M];

				int pos = 0;
				for (int l = 0; l < N; l++) {
					for (int m = 0; m < M; m++) {
						charsMatrix[l][m] = dictionary[pos].charAt(0);
						pos++;
					}
				}
				
				replaceOsWithX(charsMatrix,N,M);
				
				print(charsMatrix,N,M);

				System.out.println();

			}
		}

	}

}
