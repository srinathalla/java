package com.sri.algo.array.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * @author salla
 *
 */
public class InsertInterval {

	private static class Interval {
		int start;
		int end;

		Interval(int s, int e) {
			this.start = s;
			this.end = e;
		}

		@Override
		public String toString() {
			return start + "," + end;
		}
	}

	
	/**
	 * T.C : O(n)
	 * where n is number of intervals.
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

		List<Interval> result = new ArrayList<>();

		if (intervals.size() == 0) {
			result.add(newInterval);
			return result;
		}

		if (intervals.get(intervals.size() - 1).end < newInterval.start) {
			result.addAll(intervals);
			result.add(newInterval);
			return result;
		}

		int i = 0, n = intervals.size();

		while (i < n && intervals.get(i).end < newInterval.start) {
			result.add(intervals.get(i++));
		}

		if (i == n) {
			return result;
		}

		Interval interval = intervals.get(i);
		if (interval.start > newInterval.end) {
			result.add(newInterval);
		} else {
			interval.start = Integer.min(interval.start, newInterval.start);
			interval.end = Integer.max(interval.end, newInterval.end);

			i++;
			while (i < n && intervals.get(i).start <= interval.end) {
				interval.start = Integer.min(interval.start, intervals.get(i).start);
				interval.end = Integer.max(interval.end, intervals.get(i).end);
				i++;
			}
			result.add(interval);
		}

		if (i < n) {
			copy(result, intervals, i);
		}

		return result;
	}

	private void copy(List<Interval> result, List<Interval> intervals, int pos) {

		for (int i = pos; i < intervals.size(); i++) {
			result.add(intervals.get(i));
		}
	}
	
	public List<Interval> insertInterval(List<Interval> intervals, Interval newInterval) {

		int n = intervals.size();
		List<Interval>  result = new ArrayList<>();
		
		int i=0;
		
		// add all the non swapped intervals to the result.
		while(i < n && intervals.get(i).end < newInterval.start)
		{
			result.add(intervals.get(i++));
		}
		
		// merge all the swapped intervals.
		while (i < n && intervals.get(i).start <= newInterval.end)
		{
			newInterval.start = Integer.min(newInterval.start, intervals.get(i).start);
			newInterval.end = Integer.max(newInterval.end, intervals.get(i).end);
			i++;
		}
		
		result.add(newInterval);
		
		while(i < n)
		{
			result.add(intervals.get(i++));
		}
		
		return result;
	}

	public static void main(String[] args) {

		InsertInterval insertInterval = new InsertInterval();

		List<Interval> intervals = new ArrayList<>();

		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(3, 5));
		intervals.add(new Interval(6, 7));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(12, 16));

		intervals = insertInterval.insert(intervals, new Interval(4, 8));

		System.out.println(intervals);
		
		List<Interval> intervals2 = insertInterval.insertInterval(intervals, new Interval(4, 8));

		System.out.println(intervals2);

	}

}
