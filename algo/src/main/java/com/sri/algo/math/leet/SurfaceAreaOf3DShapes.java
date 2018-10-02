package com.sri.algo.math.leet;

/**
 * On a N * N grid, we place some 1 * 1 * 1 cubes.
 * 
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid
 * cell (i, j).
 * 
 * Return the total surface area of the resulting shapes.
 * 
 * Example 1:
 * 
 * Input: [[2]] Output: 10 Example 2:
 * 
 * Input: [[1,2],[3,4]] Output: 34 Example 3:
 * 
 * Input: [[1,0],[0,2]] Output: 16 Example 4:
 * 
 * Input: [[1,1,1],[1,0,1],[1,1,1]] Output: 32
 * 
 * @author salla
 *
 */
public class SurfaceAreaOf3DShapes {

	/**
	 * T.C : O(4*n^2) => O(n ^ 2)
	 * 
	 * @param grid
	 * @return
	 */
	public int surfaceArea(int[][] grid) {

		int n = grid.length;
		int m = grid[0].length;

		int[] r = new int[] { 0, 0, -1, 1 };
		int[] c = new int[] { -1, 1, 0, 0 };

		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (grid[i][j] > 0) {
					ans += 2;

					for (int k = 0; k < 4; k++) {
						int nv = 0;

						int nr = i + r[k];
						int nc = j + c[k];

						if (0 <= nr && nr < n && 0 <= nc && nc < m) {
							nv = grid[nr][nc];
						}
						ans += Math.max(grid[i][j] - nv, 0);
					}
				}
			}
		}

		return ans;

	}

	public static void main(String[] args) {

		SurfaceAreaOf3DShapes sr = new SurfaceAreaOf3DShapes();

		// System.out.println(sr.surfaceArea(new int[][] { { 2 } }));

		// System.out.println(sr.surfaceArea(new int[][] { { 1, 2 } }));

		System.out.println(sr.surfaceArea(new int[][] { { 1, 0 }, { 0, 2 } }));

	}

}
