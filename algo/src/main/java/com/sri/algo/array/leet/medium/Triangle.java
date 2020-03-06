package com.sri.algo.array.leet.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

	public int minimumTotal(List<List<Integer>> triangle) {

		int rows = triangle.size();
		int cols = triangle.get(rows - 1).size();
		int[][] dp = new int[rows][cols];
		for(int[] row: dp)
		{
			Arrays.fill(row, Integer.MAX_VALUE);
		}

		return dfs(0, 0, triangle, dp);
	}

	private int dfs(int r, int c, List<List<Integer>> triangle, int[][] dp) {
		if (r == triangle.size()) {
			return 0;
		}
		if (dp[r][c] != Integer.MAX_VALUE) {
			return dp[r][c];
		}

		int left = dfs(r + 1, c, triangle, dp);
		int right = dfs(r + 1, c + 1, triangle, dp);
		dp[r][c] = Math.min(left, right) + triangle.get(r).get(c);

		return dp[r][c] ;
	}

	public static void main(String[] args) {

		Triangle triangle = new Triangle();

		List<List<Integer>> list = new ArrayList();

		list.add(Arrays.asList(2));
		list.add(Arrays.asList(3, 4));
		list.add(Arrays.asList(6, 5, 7));
		list.add(Arrays.asList(4, 1, 8, 3));

		System.out.println(triangle.minimumTotal(list));

	}

}
