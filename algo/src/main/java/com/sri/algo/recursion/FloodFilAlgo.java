package com.sri.algo.recursion;

/**
 * Given a 2D screen, location of a pixel in the screen ie(x,y) and a color(K), 
 * your task is to replace color of the given pixel and all adjacent(excluding diagonally adjacent) 
 * same colored pixels with the given color K.
 * Example:

                      {{1, 1, 1, 1, 1, 1, 1, 1},
                      {1, 1, 1, 1, 1, 1, 0, 0},
                      {1, 0, 0, 1, 1, 0, 1, 1},
                      {1, 2, 2, 2, 2, 0, 1, 0},
                      {1, 1, 1, 2, 2, 0, 1, 0},
                      {1, 1, 1, 2, 2, 2, 2, 0},
                      {1, 1, 1, 1, 1, 2, 1, 1},
                      {1, 1, 1, 1, 1, 2, 2, 1},
                      };

                        x=4, y=4, color=3 

                     {{1, 1, 1, 1, 1, 1, 1, 1},
                     {1, 1, 1, 1, 1, 1, 0, 0},
                     {1, 0, 0, 1, 1, 0, 1, 1}, 
                     {1, 3, 3, 3, 3, 0, 1, 0},
                     {1, 1, 1, 3, 3, 0, 1, 0},
                     {1, 1, 1, 3, 3, 3, 3, 0},
                     {1, 1, 1, 1, 1, 3, 1, 1},
                     {1, 1, 1, 1, 1, 3, 3, 1}, 
                     };
 *
 *   
 *
 */
public class FloodFilAlgo {

	/**
	 * Can be solved using recursion(dfs) or bfs.
	 * 
	 * @param table
	 * @param x
	 * @param y
	 * @param k
	 */

	public static void floodFill(int[][] table, int x, int y, int k) {

		boolean[][] visited = new boolean[table.length][table[0].length];

		floodFill(table, x, y, table[x][y], k,table.length,table[0].length, visited);

	}

	private static boolean isValid(int i, int j, int r, int c) {
		return i >= 0 && i < r && j >= 0 && j < c;
	}

	public static void floodFill(int[][] table, int r, int c, int actColor , int k, int n, int m, boolean[][] visited) {

		table[r][c] = k;
		visited[r][c] = true;

		int[] row = { 0, 0, 1, -1 };
		int[] col = { 1, -1, 0, 0 };

		for (int i = 0; i < 4; i++) {
			int cRow = r + row[i];
			int cCol = c + col[i];

			if (isValid(cRow, cCol, n, m) && !visited[cRow][cCol] && table[cRow][cCol] == actColor) {
				floodFill(table, cRow, cCol, actColor , k, n, m, visited);
			}
		}

	}
	
	public static void main(String[] args) {
		
		int[][] table =  {{1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
                };
		
		floodFill(table,4,4,3);
		
		System.out.println(table);
		
	}

}
