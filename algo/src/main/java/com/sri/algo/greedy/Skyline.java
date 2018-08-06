package com.sri.algo.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

import com.sri.algo.array.PrintArray;

/**
 * A city's skyline is the outer contour of the silhouette formed by all the
 * buildings in that city when viewed from a distance. Now suppose you are given
 * the locations and height of all the buildings as shown on a cityscape photo
 * (Figure A), write a program to output the skyline formed by these buildings
 * collectively (Figure B).
 * 
 * @author salla
 *
 */
public class Skyline {

	class Point {
		int x;
		int h;
		boolean isStart;

		public Point(int x, int h, boolean isStart) {
			super();
			this.x = x;
			this.h = h;
			this.isStart = isStart;
		}

	}

	public List<int[]> getSkylineWithPq(int[][] buildings) {

		List<int[]> result = new ArrayList<>();

		List<int[]> heights = new ArrayList<>();

		for (int[] building : buildings) {
			heights.add(new int[] { building[0], -building[2] });
			heights.add(new int[] { building[1], building[2] });
		}

		Collections.sort(heights, (a, b) -> {

			if (a[0] != b[0]) {
				return a[0] - b[0];
			}
			return a[1] - b[1];
		});

		Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		pq.offer(0);

		int prev = 0;

		for (int[] h : heights) {
			if (h[1] < 0) {
				pq.offer(-h[1]);
			} else {
				pq.remove(h[1]);
			}

			int curr = pq.peek();

			if (curr != prev) {
				result.add(new int[] { h[0], curr });
				prev = curr;
			}
		}

		return result;
	}

	/**
	 * O(2nlog2n) for sorting the the points..
	 * 
	 * we add each point once and remove once from tree map 
	 * each operation takes log(n) time . overall 2nlog2n
	 * 
	 * over T.c  O(2nlog2n) +  O(2nlog2n) =>  O(nlogn)
	 * 
	 * this is faster than priority queue based implementation
	 * as remove in priority queue is slower i.e O(n)
	 * 
	 * T.C
	 * 
	 * @param buildings
	 * @return
	 */
	public List<int[]> getSkylineWithTreeMap(int[][] buildings) {

		int n = buildings.length;

		List<int[]> result = new ArrayList<>();

		List<int[]> heights = new ArrayList<>();

		if (n == 0) {
			return result;
		}

		if (n == 1) {
			result.add(new int[] { buildings[0][0], buildings[0][2] });
			result.add(new int[] { buildings[0][1], 0 });
			return result;
		}

		// add 2 entries for each building, each entry is split into entries one start
		// and other end..
		// make start as -ve so that we need not create a separate wrapper .
		for (int[] building : buildings) {
			heights.add(new int[] { building[0], -building[2] });
			heights.add(new int[] { building[1], building[2] });
		}

		Collections.sort(heights, (a, b) -> {

			// sort points based on position.
			// if two points are at same position 3 scenarios are possible
			// 1) two start, 2) two end, 3) one start one end
			// case 1 : taller building should be processed first.
			// case 2 : shorter building should be processed first
			// case 3 : start should be processed before end.

			if (a[0] != b[0]) {
				return a[0] - b[0];
			}
			return a[1] - b[1]; // sort based on height ..
		});

		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(0, 1);

		int prev = 0;
		for (int[] h : heights) {
			if (h[1] < 0) {
				int key = -h[1];
				map.put(key, map.getOrDefault(key, 0) + 1);
			} else {
				map.put(h[1], map.get(h[1]) - 1);

				if (map.get(h[1]) == 0) {
					map.remove(h[1]);
				}
			}

			int curr = map.lastKey();

			if (curr != prev) {
				result.add(new int[] { h[0], curr });
				prev = curr;
			}
		}

		return result;

	}

	public static void main(String[] args) {

		Skyline skyline = new Skyline();

		int[][] buildings = new int[][] { { 2, 9, 10 }, { 2, 3, 12 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 },
				{ 19, 24, 8 } };

		List<int[]> result = skyline.getSkylineWithTreeMap(buildings);

		for (int[] arr : result) {
			PrintArray.print(arr);
		}
	}

}
