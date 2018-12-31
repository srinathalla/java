package com.sri.algo.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given N axis-aligned rectangles where N > 0, determine if they all together
 * form an exact cover of a rectangular region.
 * 
 * Each rectangle is represented as a bottom-left point and a top-right point.
 * For example, a unit square is represented as [1,1,2,2]. (coordinate of
 * bottom-left point is (1, 1) and top-right point is (2, 2)).
 * 
 * @author salla
 *
 */
public class PerfectRectangle {

	/**
	 * 1) area of all rectangles should be equal to (min_x- max_x)*(min_y-max_y) 2)
	 * 
	 * @param rectangles
	 * @return
	 */
	public boolean isRectangleCoverUsingList(int[][] rectangles) {
		int x1 = Integer.MAX_VALUE, //
				y1 = Integer.MAX_VALUE, //
				x2 = Integer.MIN_VALUE, //
				y2 = Integer.MIN_VALUE;//

		Set<List<Integer>> allPoints = new HashSet<>();
		int area = 0;

		for (int[] p : rectangles) {
			x1 = Integer.min(x1, p[0]);
			y1 = Integer.min(y1, p[1]);
			x2 = Integer.max(x2, p[2]);
			y2 = Integer.max(y2, p[3]);
			area += (p[2] - p[0]) * (p[3] - p[1]);

			List<Integer> point = prepareList(p[0], p[1]);
			if (!allPoints.add(point)) {
				allPoints.remove(point);
			}
			point = prepareList(p[0], p[3]);
			if (!allPoints.add(point)) {
				allPoints.remove(point);
			}
			point = prepareList(p[2], p[3]);
			if (!allPoints.add(point)) {
				allPoints.remove(point);
			}
			point = prepareList(p[2], p[1]);
			if (!allPoints.add(point)) {
				allPoints.remove(point);
			}
		}

		if (allPoints.size() != 4 || !allPoints.contains(prepareList(x1, y1))
				|| !allPoints.contains(prepareList(x1, y2)) || !allPoints.contains(prepareList(x2, y1))
				|| !allPoints.contains(prepareList(x2, y2))) {
			return false;
		}

		return area == (y2 - y1) * (x2 - x1);
	}

	/**
	 * 
	 * T.C : O(n) .
	 * The right answer must satisfy two conditions:
	 * 
	 * 1) the large rectangle area should be equal to the sum of small rectangles count
	 * 2) count of all the other points should be even, and that of all the four corner points
	 * should be one
	 * 
	 * @param rectangles
	 * @return
	 */
	public boolean isRectangleCover(int[][] rectangles) {
		int x1 = Integer.MAX_VALUE, //
				y1 = Integer.MAX_VALUE, //
				x2 = Integer.MIN_VALUE, //
				y2 = Integer.MIN_VALUE;//

		Set<String> allPoints = new HashSet<>();
		int area = 0;

		for (int[] p : rectangles) {
			x1 = Integer.min(x1, p[0]);
			y1 = Integer.min(y1, p[1]);
			x2 = Integer.max(x2, p[2]);
			y2 = Integer.max(y2, p[3]);
			area += (p[2] - p[0]) * (p[3] - p[1]);

			String point = prepareString(p[0], p[1]);
			if (!allPoints.add(point)) {
				allPoints.remove(point);
			}
			point = prepareString(p[0], p[3]);
			if (!allPoints.add(point)) {
				allPoints.remove(point);
			}
			point = prepareString(p[2], p[3]);
			if (!allPoints.add(point)) {
				allPoints.remove(point);
			}
			point = prepareString(p[2], p[1]);
			if (!allPoints.add(point)) {
				allPoints.remove(point);
			}
		}

		// only corner points should remain in the set..
		// if any corner point is missing its not a perfect rectangle. 
		// all the rest of points count would be exactly two if perfect rectangle ..
		if (allPoints.size() != 4 || !allPoints.contains(prepareString(x1, y1))
				|| !allPoints.contains(prepareString(x1, y2)) || !allPoints.contains(prepareString(x2, y1))
				|| !allPoints.contains(prepareString(x2, y2))) {
			return false;
		}

		return area == (y2 - y1) * (x2 - x1);
	}

	private List<Integer> prepareList(int x, int y) {
		List<Integer> list = new ArrayList<>();
		list.add(x);
		list.add(y);

		return list;
	}

	private String prepareString(int x, int y) {

		return x + ":" + y;
	}

	public static void main(String[] args) {

		PerfectRectangle pr = new PerfectRectangle();
		int[][] rectangles = { { 1, 1, 3, 3 }, { 3, 1, 4, 2 }, { 3, 2, 4, 4 }, { 1, 3, 2, 4 }, { 2, 3, 3, 4 } };

		System.out.println(pr.isRectangleCover(rectangles));

		int[][] rectangles1 = { { 1, 1, 2, 3 }, { 1, 3, 2, 4 }, { 3, 1, 4, 2 }, { 3, 2, 4, 4 } };

		System.out.println(pr.isRectangleCover(rectangles1));

		int[][] rectangles2 = { { 1, 1, 3, 3 }, //
				{ 3, 1, 4, 2 }, //
				{ 1, 3, 2, 4 }, //
				{ 3, 2, 4, 4 } //
		};

		System.out.println(pr.isRectangleCover(rectangles2));

		int[][] rectangles3 = { { 1, 1, 3, 3 }, //
				{ 3, 1, 4, 2 }, //
				{ 1, 3, 2, 4 }, //
				{ 2, 2, 4, 4 } //
		};

		System.out.println(pr.isRectangleCover(rectangles3));

		int[][] rectangles4 = { { 0, 0, 1, 1 }, { 0, 1, 3, 2 }, { 1, 0, 2, 2 } };

		System.out.println(pr.isRectangleCover(rectangles4));

	}

}
