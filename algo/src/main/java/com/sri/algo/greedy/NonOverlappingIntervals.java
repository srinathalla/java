package com.sri.algo.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sri.algo.greedy.domain.Interval;

/**
 * Given a collection of intervals, find the minimum number of intervals you
 * need to remove to make the rest of the intervals non-overlapping.
 * 
 * Note: You may assume the interval's end point is always bigger than its start
 * point. Intervals like [1,2] and [2,3] have borders "touching" but they don't
 * overlap each other.
 * 
 * Example 1: Input: [ [1,2], [2,3], [3,4], [1,3] ]
 * 
 * Output: 1
 * 
 * Explanation: [1,3] can be removed and the rest of intervals are
 * non-overlapping. Example 2: Input: [ [1,2], [1,2], [1,2] ]
 * 
 * Output: 2
 * 
 * Explanation: You need to remove two [1,2] to make the rest of intervals
 * non-overlapping. Example 3: Input: [ [1,2], [2,3] ]
 * 
 * Output: 0
 * 
 * Explanation: You don't need to remove any of the intervals since they're
 * already non-overlapping.
 * 
 * 
 *
 */
public class NonOverlappingIntervals {

	/**
	 * T.C : O(nlogn) where n is number of intervals.
	 * 
	 * Sort intervals based on start time using two pointers based on greedy will be
	 * able to find out min overlaps to be erased..
	 * 
	 * 3 scenarios are possible
	 * 
	 * a---------b c---d => prev becomes a-d
	 * 
	 * a---------b c----d => prev becomes c-d, we will erase a-b so count increases
	 * by 1.
	 * 
	 * a---------b c---------d => prev remains a-b, we will erase c-d so count
	 * increases by 1.
	 * 
	 * 
	 * @param intervals
	 * @return
	 */
	public int eraseOverlapIntervals(Interval[] intervals) {

		int n = intervals.length;

		if (n < 2) {
			return 0;
		}

		// Sort based on start time.
		Arrays.sort(intervals, (Interval a, Interval b) -> (a.start != b.start ? a.start - b.start : (a.end - b.end)));

		int eraseCount = 0;
		Interval prevInterval = intervals[0];

		for (int i = 1; i < n; i++) {

			Interval currInterval = intervals[i];

			if (currInterval.start >= prevInterval.end) {
				prevInterval.end = currInterval.end;
			} else {
				if (currInterval.end <= prevInterval.end) {
					prevInterval = currInterval;
				}
				eraseCount++;
			}
		}
		return eraseCount;
	}

	/**
	 * T.C : O(nlogn) where n is number of intervals.
	 * 
	 * Sort intervals based on end time using two pointers based on greedy will be
	 * able to find out min overlaps to be erased..
	 * 
	 * 3 scenarios are possible
	 * 
	 * a---------b c---d => prev becomes a-d
	 * 
	 * a---------b c---------------d => prev remains a-b, we will erase a-b so count
	 * increases by 1.
	 * 
	 * a---------b c---------d => prev remains a-b, we will erase c-d so count
	 * increases by 1.
	 * 
	 * 
	 * @param intervals
	 * @return
	 */
	public int eraseOverlapIntervalsSortByEndTime(Interval[] intervals) {

		int n = intervals.length;

		if (n < 2) {
			return 0;
		}

		// Sort based on end time.
		Arrays.sort(intervals, (Interval a, Interval b) -> (a.end - b.end));

		int eraseCount = 0;
		Interval prevInterval = intervals[0];

		for (int i = 1; i < n; i++) {

			Interval currInterval = intervals[i];

			if (currInterval.start >= prevInterval.end) {
				prevInterval.end = currInterval.end;
			} else {
				eraseCount++;
			}
		}
		return eraseCount;
	}

	public static void main(String[] args) {

		List<Interval> employeeSchedule1 = new ArrayList<>();
		employeeSchedule1.add(new Interval(1, 2));
		employeeSchedule1.add(new Interval(2, 3));
		employeeSchedule1.add(new Interval(3, 4));
		employeeSchedule1.add(new Interval(1, 3));

		NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals();

		// System.out.println(nonOverlappingIntervals.eraseOverlapIntervals(employeeSchedule1.toArray(new Interval[0])));
		
		System.out.println(nonOverlappingIntervals.eraseOverlapIntervalsSortByEndTime(employeeSchedule1.toArray(new Interval[0])));

	}

}
