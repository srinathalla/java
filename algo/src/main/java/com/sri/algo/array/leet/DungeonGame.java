package com.sri.algo.array.leet;

import java.util.Arrays;

/**
 * The demons had captured the princess (P) and imprisoned her in the
 * bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid
 * out in a 2D grid. Our valiant knight (K) was initially positioned in the
 * top-left room and must fight his way through the dungeon to rescue the
 * princess.
 * 
 * The knight has an initial health point represented by a positive integer. If
 * at any point his health point drops to 0 or below, he dies immediately.
 * 
 * Some of the rooms are guarded by demons, so the knight loses health (negative
 * integers) upon entering these rooms; other rooms are either empty (0's) or
 * contain magic orbs that increase the knight's health (positive integers).
 * 
 * In order to reach the princess as quickly as possible, the knight decides to
 * move only rightward or downward in each step.
 * 
 * 
 * @author salla
 *
 */
public class DungeonGame {

	private static class Health {
		int ih;
		int ch;

		public Health(int ih, int ch) {
			super();
			this.ih = ih;
			this.ch = ch;
		}

		@Override
		public String toString() {
			return this.ih + "," + this.ch;
		}
	}

	/**
	 * T. C O(n*n)
	 * 
	 * This approach doesn't work taking path that gives min initial health might
	 * not give the correct result if we go top to bottom ..
	 * 
	 * @param dungeon
	 * @return
	 */
	public int calculateMinimumHPTopToBottom(int[][] dungeon) {

		int n = dungeon.length;
		int m = dungeon[0].length;

		if (n == 1 && m == 1) {
			return dungeon[0][0] >= 0 ? 0 : -dungeon[0][0] + 1;
		}

		Health[][] dp = new Health[n][m];

		Health prev = new Health(1, 1);
		for (int i = 0; i < n; i++) {
			dp[i][0] = getHealth(dungeon[i][0], prev);
			prev = dp[i][0];
		}

		prev = dp[0][0];
		for (int i = 1; i < m; i++) {
			dp[0][i] = getHealth(dungeon[0][i], prev);
			prev = dp[0][i];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {

				Health left = getHealth(dungeon[i][j], dp[i][j - 1]);

				Health top = getHealth(dungeon[i][j], dp[i - 1][j]);
				dp[i][j] = left.ih < top.ih ? left : top;
			}
		}
		return dp[n - 1][m - 1].ih;
	}

	private Health getHealth(int curr, Health prev) {
		Health h = null;

		int ch = prev.ch + curr;
		if (ch >= 1) {
			h = new Health(prev.ih, ch);
		} else {
			h = new Health(prev.ih + -(ch) + 1, 1);
		}
		return h;
	}

	public int calculateMinimumHP(int[][] dungeon) {

		int n = dungeon.length;
		int m = dungeon[0].length;

		if (n == 1 && m == 1) {
			return dungeon[0][0] >= 0 ? 1 : -dungeon[0][0] + 1;
		}

		int[][] dp = new int[n + 1][m + 1];
		for (int[] row : dp) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}

		dp[n][m - 1] = 1;
		dp[n - 1][m] = 1;

		for (int i = n - 1; i >= 0; i--) {
			for (int j = m - 1; j >= 0; j--) {
				
				int need = Integer.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
				dp[i][j] = need <= 0 ? 1 : need;
				System.out.println("need :" + need);
			}
		}

		return dp[0][0];
	}

	public static void main(String[] args) {

		DungeonGame dg = new DungeonGame();

		// int[][] grid = new int[][] { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };

		int[][] grid = new int[][] { { 1, -3, 3 }, { 0, -2, 0 }, { -3, -3, -3 } };

		System.out.println(dg.calculateMinimumHP(grid));

	}

}
