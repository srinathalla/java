package com.sri.algo.math.leet;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {

	static class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	/**
	 * T.C O(n*n) S.C : O(n)
	 * 
	 * @param points
	 * @return
	 */
	public int maxPoints(Point[] points) {

		int n = points.length;

		if (n <= 2) {
			return n;
		}

		Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

		int res = 0;

		for (int i = 0; i < n; i++) {

			map.clear();
			int overlap = 0;
			int max = 0;
			for (int j = i + 1; j < n; j++) {

				Integer x = points[j].x - points[i].x;

				Integer y = points[j].y - points[i].y;

				 // when points are overlapping with current point just keep track of the overlapped point
				//  and continue processing next point.
				if (x == 0 && y == 0) {
					overlap++;
					continue;
				}

				Integer gcd = gcd(x, y);

				if (gcd != 0) {
					x /= gcd;
					y /= gcd;
				}

				if (map.containsKey(x)) {
					map.get(x).put(y, map.get(x).getOrDefault(y, 0) + 1);

				} else {
					Map<Integer, Integer> m = new HashMap<>();
					m.put(y, 1);
					map.put(x, m);
				}
				max = Integer.max(max, map.get(x).get(y));
			}
			res = Integer.max(res, max + overlap + 1);
		}

		return res;

	}

	private int gcd(int a, int b) {

		if (b == 0) {
			return a;
		}

		return gcd(b, a % b);
	}
	
	   

	public static void main(String[] args) {

		MaxPointsOnALine maxPoints = new MaxPointsOnALine();

		// [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]

		Point[] points = new Point[] { new Point(1, 1), new Point(3, 2), new Point(5, 3), new Point(4, 1),
				new Point(2, 3), new Point(1, 4) };

		System.out.println(maxPoints.maxPoints(points));

	}

}
