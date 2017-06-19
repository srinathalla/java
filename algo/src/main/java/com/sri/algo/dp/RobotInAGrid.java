package com.sri.algo.dp;

import java.util.HashSet;
import java.util.Set;

public class RobotInAGrid {
	

	public static void printAllPaths(int[][] array, int r, int c, String path,Set<String> allPaths) {

		if (r == array.length -1)
		{
			for (int j = c ; j < array[0].length ;j++)
			{
				path = path + array[r][j];
			}
			
			allPaths.add(path);
			return;
		}
		
		if (c == array[0].length -1)
		{
			for (int i = r ; i < array.length ;i++)
			{
				path = path + array[i][c];
			}
			
			allPaths.add(path);
			return;
		}
		
		path = path + array[r][c];
		printAllPaths(array, r+1,c,path,allPaths);
		printAllPaths(array, r,c + 1,path,allPaths);

	}

	// Returns count of possible paths to reach
	// cell at row number m and column number n from
	// the topmost left to bottom most right (cell at 1, 1)
	static int numberOfPaths(int m, int n) {

		int[][] countMatrix = new int[m][n];

		// To reach any cell in first column count of paths is 1.
		for (int i = 0; i < m; i++) {
			countMatrix[i][0] = 1;
		}

		// To reach any cell in first row count of paths is 1.
		for (int j = 0; j < n; j++) {
			countMatrix[0][j] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				countMatrix[i][j] = countMatrix[i - 1][j] + countMatrix[i][j - 1];
			}
		}

		return countMatrix[m - 1][n - 1];
	}

	// Driver program to test above function
	public static void main(String args[]) {
		// System.out.println(numberOfPaths(3, 3));

		int[][] ar = new int[][] { { 1, 2, 3 }, { 4, 5, 6 },{7,8,9}};
		
		Set<String> allPaths = new HashSet<String>();
	
		printAllPaths(ar,0, 0, "",allPaths);
		
		System.out.println(allPaths);
	}

}
