package com.sri.algo.array.leet.medium;

public class TicTacToe {

	int[] r;
	int[] c;
	int d = 0;
	int ad = 0;
	int n;

	/** Initialize your data structure here. */
	public TicTacToe(int n) {

		this.r = new int[n];
		this.c = new int[n];
		this.n = n;

	}

	/**
	 * Player {player} makes a move at ({row}, {col}).
	 * 
	 * @param row    The row of the board.
	 * @param col    The column of the board.
	 * @param player The player, can be either 1 or 2.
	 * @return The current winning condition, can be either: 0: No one wins. 1:
	 *         Player 1 wins. 2: Player 2 wins.
	 */
	public int move(int row, int col, int player) {
		
		int add = player == 1 ? 1 : -1;
		this.r[row] += add;
		this.c[col] += add;
		
		if(row == col)
		{
			this.d += add;
		}
		
		if(row + col == this.n - 1)
		{
			this.ad += add;
		}
		
		if(Math.abs(this.r[row]) == this.n || Math.abs(this.c[col]) == this.n ||
		   Math.abs(this.d) == this.n || Math.abs(this.ad) == this.n)
		{
			return 1;
		}
		
		return 0;

	}

	/**
	 * Your TicTacToe object will be instantiated and called as such: TicTacToe obj
	 * = new TicTacToe(n); int param_1 = obj.move(row,col,player);
	 */

}
