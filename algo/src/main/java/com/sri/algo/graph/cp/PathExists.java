package com.sri.algo.graph.cp;

public class PathExists {

	public static boolean hasPathExists(int[][] matrix) {

		boolean[][] visited = new boolean[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1) {
					return hasPathExists(i, j, matrix, visited);
				}
			}
		}
		
		return false;
	}

	public static boolean hasPathExists(int i, int j, int[][] matrix, boolean[][] visited) {

		visited[i][j] = true;

		if (matrix[i][j] == 2) {
			return true;
		}

		if (j < matrix[0].length - 1 && !visited[i][j + 1] && matrix[i][j + 1] != 0 && hasPathExists(i, j + 1, matrix, visited)) {
			return true;
		}
		if (j > 0 && !visited[i][j - 1] && matrix[i][j - 1] != 0 && hasPathExists(i, j - 1, matrix, visited)) {
			return true;
		}
		if (i < matrix.length - 1 && !visited[i +1][j] && matrix[i + 1][j] != 0 && hasPathExists(i + 1, j, matrix, visited)) {
			return true;
		}
		if (i > 0 &&  !visited[i - 1][j] && matrix[i - 1][j] != 0 && hasPathExists(i - 1, j, matrix, visited)) {
			return true;
		}

		return false;

	}
	
	public static void main(String[] args) {
		
		int[][] arr = new int[][] {{ 0 , 3 , 2 },
            { 3 , 3 , 0 },
            { 1 , 3 , 0 }};
		
		System.out.println(hasPathExists(arr));
		
		int[][] arr1 = new int[][] {{ 0 , 3 , 1 , 0 },
            { 3 , 0 , 3 , 3 },
            { 2 , 3 , 0 , 3 },
            { 0 , 3 , 3 , 3 }};
            
		System.out.println(hasPathExists(arr1));
	}

}
