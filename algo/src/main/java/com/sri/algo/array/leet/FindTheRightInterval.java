package com.sri.algo.array.leet;

import java.util.TreeMap;

import com.sri.algo.array.PrintArray;
import com.sri.algo.greedy.domain.Interval;

public class FindTheRightInterval {

	/**
	 * T.C : O(nlogn) to build a tree map
	 * 
	 * S C : O(n).
	 * 
	 * @param intervals
	 * @return
	 */
	public int[] findRightInterval(Interval[] intervals) {

		int n = intervals.length;
		int[] res = new int[n];

		TreeMap<Integer, Integer> map = new TreeMap<>();

		for (int i = 0; i < n; i++) {
			map.put(intervals[i].start, i);
		}

		for (int i = 0; i < n; i++) {
			java.util.Map.Entry<Integer, Integer> ceiling = map.ceilingEntry(intervals[i].end);
			res[i] = ceiling != null ? ceiling.getValue() : -1;
		}

		return res;
	}

	public static void main(String[] args) {

		Interval[] intervals = new Interval[3];
		intervals[0] = new Interval(1, 4);
		intervals[1] = new Interval(2, 3);
		intervals[2] = new Interval(3, 4);

		FindTheRightInterval find = new FindTheRightInterval();
		int[] res = find.findRightInterval(intervals);

		PrintArray.print(res);

	}

}
