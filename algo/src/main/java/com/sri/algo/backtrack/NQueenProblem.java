package com.sri.algo.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other. Given an integer n, print all
 * distinct solutions to the n-queens puzzle. Each solution contains distinct
 * board configurations of the n-queens’ placement, where the solutions are a
 * permutation of [1,2,3..n] in increasing order, here the number in the ith
 * place denotes that the ith-column queen is placed in the row with that
 * number. For eg below figure represents a chessboard [3 1 4 2].
 * 
 * 
 * Input 2 1 4 Output: [1 ] [2 4 1 3 ] [3 1 4 2 ]
 *
 */
public class NQueenProblem {
	
	private void print(List<List<Integer>> solutionsList)
	{
		StringBuilder allSolStr = new StringBuilder();
		for (List<Integer> sol : solutionsList) 
		{
			
			StringBuilder solStr = new StringBuilder("[");
			
			for (Integer no : sol)
			{
				solStr.append(no);
				solStr.append(" ");
			}
			solStr.append("]");
			allSolStr.append(solStr);
			allSolStr.append(" ");
		}
		
		System.out.println(allSolStr.toString());
	}

	/**
	 * Checks whether current queen position is safe. We only need to check
	 * positions in range of 0 to col-1 as only they are filled before this method
	 * is called.
	 * 
	 * @param board
	 * @param row
	 * @param col
	 * @return
	 */
	boolean isSafe(int board[][], int row, int col) {

		// Check whether any queen is already placed in the current row.
		for (int j =0;j < col;j++)
		{
			// No two queens should be placed in the same row.
			if (board[row][j] == 1)
			{
				return false;
			}
		}
		
		// No queen should be present in upper diagonal of current queen position.
		for(int i = row, j = col;i>=0 && j >=0; i--,j--)
		{
			if (board[i][j] == 1)
			{
				return false;
			}
		}
		
		// No queen should be present in upper diagonal of current queen position.
		for(int i = row, j = col;i< board.length && j >=0; i++,j--)
		{
			if (board[i][j] == 1)
			{
				return false;
			}
		}

		return true;
	}

	/**
	 * Recursively places all the queens in various positions ensuring they dont
	 * kill each other, back tracking when ever a queen position is not valid.
	 * 
	 * @param board
	 * @param col
	 * @return
	 */
	void solveNQueen(int N) {
		List<Integer> rowNos = new ArrayList<>();
		List<List<Integer>> solutionsList = new ArrayList<>();
		
		int board[][] = new int[N][N];
		
		solveNQueen(board, 0, rowNos, solutionsList);
		
		print(solutionsList);
	}
	
	void solveNQueen(int board[][], int col,List<Integer> rowNos,List<List<Integer>> solutionsList) {

		// Base condition, return when the current column reaches board size i.e 
		// all queens are safely placed in the chess board one in each column.
		if (col == board.length) {
			
			List<Integer> clone = new ArrayList<>();
			clone.addAll(rowNos);
			
			solutionsList.add(clone);
			return;
		}
		
		for (int i=0;i < board.length ; i++)
		{
			
			// Check current cell is a valid cell.
			if(isSafe(board,i,col))
			{
				// Place the current queen in ith row.
				board[i][col] = 1;
				rowNos.add(col,i + 1); // Add row no of curr queen.
				solveNQueen(board,col + 1,rowNos,solutionsList); // Recurse for the next queen i.e col + 1.
				
				// backtrack the current queen position.
				board[i][col] = 0;
				rowNos.remove(col); // remove the row added for the curr queen.	
			}
		}

	}

	// driver program to test above function
	public static void main(String args[]) {
		NQueenProblem Queen = new NQueenProblem();
		Queen.solveNQueen(9);

	}

}
