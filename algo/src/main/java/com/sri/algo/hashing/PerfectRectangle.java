package com.sri.algo.hashing;

import java.util.HashSet;
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

	public boolean isRectangleCover(int[][] rectangles) {
		int rMin = Integer.MAX_VALUE, cMin = Integer.MAX_VALUE, rMax = Integer.MIN_VALUE, cMax = Integer.MIN_VALUE;

		Set<String> allPoints = new HashSet<>();

		for (int i = 0; i < rectangles.length; i++) {
			int cStart  = rectangles[i][0], rStart = rectangles[i][1], 
					cEnd  = rectangles[i][2], rEnd = rectangles[i][3];

			rMin = Integer.min(rMin, rStart);
			cMin = Integer.min(cMin, cStart);
			rMax = Integer.max(rMax, rEnd);
			cMax = Integer.max(cMax, cEnd);

			for (int l = rStart; l < rEnd; l++) {
				for (int m = cStart; m < cEnd; m++) {
					String p = l + "," + m;
					if (allPoints.contains(p)) {
						return false;
					}
					allPoints.add(p);
				}
			}
		}

		for (int i = rMin; i < rMax; i++) {
			for (int j = cMin; j < cMax; j++) {
				String p = i + "," + j;
				if (!allPoints.contains(p)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		PerfectRectangle pr = new PerfectRectangle();
		 int[][] rectangles = {
	              {1,1,3,3},
	              {3,1,4,2},
	              {3,2,4,4},
	              {1,3,2,4},
	              {2,3,3,4}
	            };
		
		 System.out.println(pr.isRectangleCover(rectangles));
		
		int[][] rectangles1 = {
		              {1,1,2,3},
		              {1,3,2,4},
		              {3,1,4,2},
		              {3,2,4,4}
		};
		
		System.out.println(pr.isRectangleCover(rectangles1));
		
	}

}
