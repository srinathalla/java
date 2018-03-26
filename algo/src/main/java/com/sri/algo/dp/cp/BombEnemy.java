package com.sri.algo.dp.cp;

/**
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0'
 * (the number zero), return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column from the planted
 * point until it hits the wall since the wall is too strong to be destroyed.
 * Note that you can only put the bomb at an empty cell.
 * 
 * Example: For the given grid
 * 
 * 0 E 0 0 E 0 W E 0 E 0 0
 * 
 * return 3. (Placing a bomb at (1,1) kills 3 enemies)
 * 
 * @author salla
 *
 */
public class BombEnemy {

	/**
	 * Idea is to visit each empty cell and kill enemies by moving up, moving down,
	 * moving left, moving right.
	 * 
	 * T.C : O(n^2(n + m)).
	 * 
	 * Can we do better ?
	 * 
	 * @param grid
	 * @return
	 */
	public int maxKilledEnemies(char[][] grid) {

		int n = grid.length;
		int m = grid[0].length;

		int max = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				// Need to pace bomb at empty cell.
				if (grid[i][j] == '0') {

					int r = i, c = j;
					int count = 0;
					// go up.
					while (r >= 0) {
						if (grid[r][j] == 'E') {
							count++;
						} else if (grid[i][c] == 'W') {
							break;
						}
						r--;
					}

					// go down.
					r = i;
					while (r < n) {
						if (grid[r][j] == 'E') {
							count++;
						} else if (grid[i][c] == 'W') {
							break;
						}
						r++;
					}

					// go left.
					while (c >= 0) {
						if (grid[i][c] == 'E') {
							count++;
						} else if (grid[i][c] == 'W') {
							break;
						}
						c--;
					}

					// go right.
					c = j;
					while (c < m) {
						if (grid[i][c] == 'E') {
							count++;
						} else if (grid[i][c] == 'W') {
							break;
						}
						c++;
					}

					// compute maximum at each empty position.
					max = Integer.max(max, count);
				}

			}
		}

		return max;

	}

	/**
	 * T.C : O(n*m).
	 * 
	 * Idea is to compute all enemies for each row only once. i.e when j == 0 || grid[i][j-1] == 'W'
	 * Compute all enemies for each column only once.  i.e  when i == 0 || grid[i-1][j] == 'W'
	 * 
	 * return max (row[i] + col[j]);
	 * 
	 * While computing we need to stop when ever a wall is encountered.
	 * 
	 * We need to reset row pointer to zero when previous column is a wall.
	 * We need to reset col pointer to zero when previous row is a wall.
	 * 
	 * @param grid
	 * @return
	 */
	public int maxKilledEnemiesWithDP(char[][] grid) {
		int n = grid.length;
		int m = n == 0 ? 0 : grid[0].length;
		int max = 0;

		int rowKill = 0;
		int[] colKill = new int[m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (j == 0 || grid[i][j - 1] == 'W') {
					rowKill = 0;
					for (int k = j; k < m && grid[i][k] != 'W'; k++) {
						rowKill += grid[i][k] == 'E' ? 1 : 0;
					}
				}

				if (i == 0 || grid[i - 1][j] == 'W') {
					colKill[j] = 0;
					for (int k = i; k < n && grid[k][j] != 'W'; k++) {
						colKill[j] += grid[k][j] == 'E' ? 1 : 0;
					}
				}

				if (grid[i][j] == '0') {
					max = Integer.max(max, rowKill + colKill[j]);
				}
			}
		}

		return max;
	}

	public static void main(String[] args) {

		BombEnemy be = new BombEnemy();

		char[][] grid = new char[][] { { '0', 'E', '0', '0' }, { 'E', '0', 'W', 'E' }, { '0', 'E', '0', '0' } };

		System.out.println(be.maxKilledEnemies(grid));

		System.out.println(be.maxKilledEnemiesWithDP(grid));

	}

}
