package com.sri.algo.math.leet;

/**
 * On a N * N grid, we place some 1 * 1 * 1 cubes that are axis-aligned with the
 * x, y, and z axes.
 * 
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid
 * cell (i, j).
 * 
 * Now we view the projection of these cubes onto the xy, yz, and zx planes.
 * 
 * A projection is like a shadow, that maps our 3 dimensional figure to a 2
 * dimensional plane.
 * 
 * Here, we are viewing the "shadow" when looking at the cubes from the top, the
 * front, and the side.
 * 
 * Input: [[2]] Output: 5 Example 2:
 * 
 * Input: [[1,2],[3,4]] Output: 17
 * 
 * Return the total area of all three projections.
 * 
 * @author salla
 *
 */
public class ProjectionAreaof3DShapes {

	/**
	 * T.C : O(n*n)
	 * two pass solution.
	 * 
	 *  get sum of xy + yz + zx planes projection
	 *  
	 *  xy -> sum of non zero elements
	 *  xz -> sum of max values of each column.
	 *  yz ->sum of max values of each row.
	 * 
	 * 
	 * @param grid
	 * @return
	 */
	public int projectionArea(int[][] grid) {

		int n = grid.length;
		int m = grid[0].length;
		int sum = 0;

		for (int i = 0; i < n; i++) {

			int rMax = Integer.MIN_VALUE;
			for (int j = 0; j < m; j++) {
				if (grid[i][j] != 0) {
					sum++;
				}
				rMax = Integer.max(rMax, grid[i][j]);
			}
			sum += rMax;
		}

		for (int j = 0; j < m; j++) {

			int cMax = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				cMax = Integer.max(cMax, grid[i][j]);
			}
			sum += cMax;
		}

		return sum;
	}

	public static void main(String[] args) {

		ProjectionAreaof3DShapes projArea = new ProjectionAreaof3DShapes();

		System.out.println(projArea.projectionArea(new int[][] { { 1, 2 }, { 3, 4 } }));

		System.out.println(projArea.projectionArea(new int[][] { { 2 } }));

	}

}
