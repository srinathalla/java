package com.sri.algo.backtrack.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 	The n-queens puzzle is the problem of placing n queens on an n×n chess board such that no two 
 *  queens attack each other.

	Given an integer n, return all distinct solutions to the n-queens puzzle.
	
	Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' 
	and '.' both indicate a queen and an empty space respectively.
	
	Example:
	
	Input: 4
	Output: [
	 [".Q..",  // Solution 1
	  "...Q",
	  "Q...",
	  "..Q."],
	
	 ["..Q.",  // Solution 2
	  "Q...",
	  "...Q",
	  ".Q.."]
	]
	
	Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
	
 * @author salla
 *
 */
public class NQueensProblem {

	List<List<String>> result;

	public List<List<String>> solveNQueens(int n) {

		result = new ArrayList<>();

		char[][] grid = new char[n][n];

		for (char[] row : grid) {
			Arrays.fill(row, '.');
		}

		placeQueens(0, grid);

		return result;

	}

	private boolean isValidCell(int r, int c, char[][] grid) {

		for (int j = 0; j < c; j++) {
			if (grid[r][j] == 'Q') {
				return false;
			}
		}

		int i = r - 1, j = c - 1;
		while (i >= 0 && j >= 0) {

			if (grid[i][j] == 'Q') {
				return false;
			}
			
			i--;
			j--;

		}
		
		i = r + 1; 
		j = c - 1;
		while (i < grid.length && j >= 0) {

			if (grid[i][j] == 'Q') {
				return false;
			}
			
			i++;
			j--;

		}

		return true;
	}

	private void addToResult(char[][] grid) {
		List<String> board = new ArrayList<>();

		for (char[] row : grid) {
			board.add(new String(row));
		}

		result.add(board);
	}

	private void placeQueens(int j, char[][] grid) {

		if (j == grid[0].length) {

			addToResult(grid);
			return;
		}

		for (int i = 0; i < grid.length; i++) {
			if (isValidCell(i, j, grid)) {
				grid[i][j] = 'Q';
				placeQueens(j + 1, grid);
				grid[i][j] = '.'; // back track.
			}
		}
	}
	
	private Set<Integer> col = new HashSet<Integer>();
    private Set<Integer> diag1 = new HashSet<Integer>();
    private Set<Integer> diag2 = new HashSet<Integer>();
    
    public List<List<String>> solveNQueensBetter(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(res,new ArrayList<String>(), 0, n);
        return res;
    }
    private void dfs(List<List<String>> res, List<String> list, int row, int n){
        if (row == n){
            res.add(new ArrayList<String>(list));
            return;
        }
        for (int i = 0; i < n; i++){
            if (col.contains(i) || diag1.contains(row + i) || diag2.contains(row - i)) continue;
            
            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[i] = 'Q';
            String rowString = new String(charArray);
            
            list.add(rowString);
            col.add(i);
            diag1.add(row + i);
            diag2.add(row - i);
            
            dfs(res, list, row + 1, n);
            
            list.remove(list.size() - 1);
            col.remove(i);
            diag1.remove(row + i);
            diag2.remove(row - i);
        }
    }
	
	public static void main(String[] args) {
		
		
		NQueensProblem nqueensProblem = new NQueensProblem();
		
		System.out.println(nqueensProblem.solveNQueens(4));
		
	}

}
