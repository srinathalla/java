package com.sri.algo.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import com.sri.algo.greedy.domain.Interval;

/**
 * 
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms
 * required.
 * 
 * Example 1:
 * 
 * Input: [[0, 30],[5, 10],[15, 20]] Output: 2 Example 2:
 * 
 * Input: [[7,10],[2,4]] Output: 1
 *
 */
public class MeetingRooms2 {

	public static class Event {
		int time;
		int eventType;

		public Event(int time, int eventType) {
			super();
			this.time = time;
			this.eventType = eventType;
		}
	}

	/**
	 * Approach based on sweep line solution..
	 * 
	 * where we treat start and end of each interval is treated as two events..
	 * 
	 * min meetings rooms is the maximum number of events happening at the same
	 * time..
	 * 
	 * T.C : O(2nlong2n) where is number of intervals.
	 * 
	 * @param intervals
	 * @return
	 */
	public int minMeetingRooms(Interval[] intervals) {

		if (intervals.length < 2) {
			return intervals.length;
		}

		List<Event> events = new ArrayList<>();

		for (Interval interval : intervals) {
			events.add(new Event(interval.start, 0));
			events.add(new Event(interval.end, 1));
		}

		Collections.sort(events, (Event a, Event b) -> a.time != b.time ? a.time - b.time : b.eventType - a.eventType);

		int minMeetingsRooms = 0, currMeetingsRooms = 0;
		for (Event event : events) {

			if (event.eventType == 0) {
				currMeetingsRooms++;

				minMeetingsRooms = Integer.max(minMeetingsRooms, currMeetingsRooms);
			} else {
				currMeetingsRooms--;
			}
		}
		return minMeetingsRooms;
	}

	/**
	 * Solution using priority queue..
	 * T.C : O(nlogn) where n is the number  intervals.
	 * 
	 * @param intervals
	 * @return
	 */
	public int minMeetingRoomsWithPQ(Interval[] intervals) {

		int n = intervals.length;

		if (n < 2) {
			return intervals.length;
		}

		// Sort based on start time.
		Arrays.sort(intervals, (Interval a, Interval b) -> a.start - b.start);
		
		// Prioritize items based on end time.
		PriorityQueue<Interval> pq = new PriorityQueue<>((Interval a, Interval b) -> a.end - b.end);
		pq.add(intervals[0]);

		for (int i = 1; i < n; i++) {

			Interval interval = pq.poll();

			if (intervals[i].start >= interval.end) {
				interval.end = intervals[i].end;
			} else {
				pq.add(intervals[i]);
			}
			
			pq.add(interval);
		}

		return pq.size();
	}

	public static void main(String[] args) {

		List<Interval> employeeSchedule1 = new ArrayList<>();
		employeeSchedule1.add(new Interval(0, 30));
		employeeSchedule1.add(new Interval(5, 10));
		employeeSchedule1.add(new Interval(15, 20));

		MeetingRooms2 mr = new MeetingRooms2();

		System.out.println(mr.minMeetingRooms(employeeSchedule1.toArray(new Interval[0])));
		
		System.out.println(mr.minMeetingRoomsWithPQ(employeeSchedule1.toArray(new Interval[0])));

	}

}
