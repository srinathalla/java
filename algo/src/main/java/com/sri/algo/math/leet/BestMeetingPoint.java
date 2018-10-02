package com.sri.algo.math.leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * A group of two or more people wants to meet and minimize the total travel
 * distance. You are given a 2D grid of values 0 or 1, where each 1 marks the
 * home of someone in the group. The distance is calculated using Manhattan
 * Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 * 
 * Example:
 * 
 * 
 * Input:
 * 
 * 1 - 0 - 0 - 0 - 1 | | | | | 0 - 0 - 0 - 0 - 0 | | | | | 0 - 0 - 1 - 0 - 0
 * 
 * Output: 6
 * 
 * Explanation: Given three people living at (0,0), (0,4), and (2,2): The point
 * (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is
 * minimal. So return 6.
 *
 */
public class BestMeetingPoint {

	/**
	 * T.C :O(m*n) + O(2*mnlogmn) + O(mn) => O(mnlogmn)
	 * 
	 * @param grid
	 * @return
	 */
	public int minTotalDistanceUsingSortingPoints(int[][] grid) {

		int n = grid.length;

		int m = grid[0].length;

		List<Integer> rows = new ArrayList<>();
		List<Integer> cols = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					rows.add(i);
					cols.add(j);
				}
			}
		}

		int row = rows.size() / 2;
		int col = cols.size() / 2;
		Collections.sort(cols);

		return getDistance(rows, rows.get(row)) + getDistance(cols, cols.get(col));
	}

	/**
	 * T.C O(4*m*n) => O(m*n) S.C :O(m*n)
	 * 
	 * @param grid
	 * @return
	 */
	public int minTotalDistanceByGatheringPointsInSortedOrder(int[][] grid) {

		List<Integer> rows = gatherRows(grid); // O(mn)
		List<Integer> cols = gatherColumns(grid); // O(mn)

		int row = rows.size() / 2;

		int col = cols.size() / 2;

		return getDistance(rows, rows.get(row)) + getDistance(cols, cols.get(col));
	}

	private List<Integer> gatherRows(int[][] grid) {

		List<Integer> rows = new ArrayList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					rows.add(i);
				}
			}
		}
		return rows;
	}

	private List<Integer> gatherColumns(int[][] grid) {

		List<Integer> cols = new ArrayList<>();

		for (int j = 0; j < grid[0].length; j++) {
			for (int i = 0; i < grid.length; i++) {
				if (grid[i][j] == 1) {
					cols.add(j);
				}
			}
		}

		return cols;
	}

	private int getDistance(List<Integer> points, int origin) {
		int dist = 0;

		for (Integer p : points) {
			dist += Math.abs(p - origin);
		}

		return dist;
	}

	public int minTotalDistance(int[][] grid) {

		List<Integer> rows = gatherRows(grid); // O(mn)
		List<Integer> cols = gatherColumns(grid); // O(mn)

		return getDistance(rows) + getDistance(cols);
	}

	private int getDistance(List<Integer> points) {

		int i = 0, j = points.size() - 1;

		int d = 0;

		while (i < j) {
			d += points.get(j) - points.get(i);
			i++;
			j--;
		}

		return d;
	}

	public static void main(String[] args) {

		BestMeetingPoint bmp = new BestMeetingPoint();

		System.out
				.println(bmp.minTotalDistance(new int[][] { { 1, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 } }));

	}

}
