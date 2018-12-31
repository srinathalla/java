package com.sri.algo.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sri.algo.greedy.domain.Interval;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]] Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * 
 * Input: [[1,4],[4,5]] Output: [[1,5]] Explanation: Intervals [1,4] and [4,5]
 * are considerred overlapping.
 * 
 * @author salla
 *
 */
public class MergeIntervals {

	/**
	 * T.C : O(nlogn)
	 * @param intervals
	 * @return
	 */
	public List<Interval> merge(List<Interval> intervals) {

		int n = intervals.size();
		if (n <= 1) {
			return intervals;
		}

		List<Interval> mintervals = new ArrayList<>();

		Collections.sort(intervals, (a, b) -> a.start - b.start);
		Interval prev = intervals.get(0), curr = null;
		mintervals.add(prev);
		for (int i = 1; i < n; i++) {

			curr = intervals.get(i);

			if (curr.start > prev.end) {

				mintervals.add(curr);
				prev = curr;

			} else {
				prev.end = Integer.max(prev.end, curr.end);
			}
		}

		return mintervals;
	}
	
	public static void main(String[] args) {
		
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(15, 18));
		
		MergeIntervals mi = new MergeIntervals();
		intervals = mi.merge(intervals);
		System.out.println(intervals);
		
	}

}
