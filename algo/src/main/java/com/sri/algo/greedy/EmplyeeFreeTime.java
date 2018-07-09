package com.sri.algo.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * We are given a list schedule of employees, which represents the working time
 * for each employee.
 * 
 * Each employee has a list of non-overlapping Intervals, and these intervals
 * are in sorted order.
 * 
 * Return the list of finite intervals representing common, positive-length free
 * time for all employees, also in sorted order.
 * 
 * Example 1: Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]] Output: [[3,4]]
 * Explanation: There are a total of three employees, and all common free time
 * intervals would be [-inf, 1], [3, 4], [10, inf]. We discard any intervals
 * that contain inf as they aren't finite. Example 2: Input: schedule =
 * [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]] Output: [[5,6],[7,9]]
 * 
 * @author salla
 *
 */
public class EmplyeeFreeTime {

	public static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public String toString() {
			return new StringBuilder().append("start :").append(start).append(" end :").append(end).toString();
		}
	}

	public static class Job {

		int id;
		int idx;

		public Job(int id, int idx) {

			this.id = id;
			this.idx = idx;
		}
	}

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
	 * T.C : O(2Clog2C) - > O(ClogC) where C is the total number of intervals across all employees
	 * ..
	 * 
	 * @param schedule
	 * @return
	 */
	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

		List<Interval> result = new ArrayList<>();

		List<Event> events = new ArrayList<>();
		for (List<Interval> intervals : schedule) {

			for (Interval interval : intervals) {

				events.add(new Event(interval.start, 0));
				events.add(new Event(interval.end, 1));
			}
		}

		Collections.sort(events,
				(Event a, Event b) -> (a.time != b.time ? (a.time - b.time) : a.eventType - b.eventType));

		int bal = 0, prev = -1;
		for (Event event : events) {

			if (bal == 0 && prev > 0) {
				result.add(new Interval(prev, event.time));
			}
			bal += event.eventType == 0 ? 1 : -1;
			prev = event.time;
		}
		return result;
	}


	/**
	 * T.C :O(Clogn) where C is the total number of intervals across all employees
	 * n is number of employess..
	 * ..
	 * 
	 * @param schedule
	 * @return
	 */
	public List<Interval> employeeFreeTimewithPQ(List<List<Interval>> schedule) {

		List<Interval> result = new ArrayList<>();

		PriorityQueue<Job> pq = new PriorityQueue<>(
				(Job a, Job b) -> (schedule.get(a.id).get(a.idx).start - schedule.get(b.id).get(b.idx).start));

		int id = 0;
		int anchor = Integer.MAX_VALUE;
		for (List<Interval> intervals : schedule) {
			pq.offer(new Job(id++, 0));

			anchor = Integer.min(anchor, intervals.get(0).start);
		}

		while (!pq.isEmpty()) {

			Job job = pq.poll();

			Interval interval = schedule.get(job.id).get(job.idx);
			
			int jobStartTime = interval.start;
			
			if (anchor < jobStartTime) {
				result.add(new Interval(anchor, jobStartTime));
			}
			
			anchor = Integer.max(anchor,interval.end);

			if (++job.idx < schedule.get(job.id).size()) {
				pq.offer(job);
			}

		}

		return result;
	}

	public static void main(String[] args) {

		EmplyeeFreeTime eft = new EmplyeeFreeTime();

		List<List<Interval>> employeesSchedule = new ArrayList<>();

		List<Interval> employeeSchedule1 = new ArrayList<>();
		employeeSchedule1.add(new Interval(1, 2));
		employeeSchedule1.add(new Interval(5, 6));
		employeesSchedule.add(employeeSchedule1);

		List<Interval> employeeSchedule2 = new ArrayList<>();
		employeeSchedule2.add(new Interval(1, 3));
		employeesSchedule.add(employeeSchedule2);

		List<Interval> employeeSchedule3 = new ArrayList<>();
		employeeSchedule3.add(new Interval(4, 10));
		employeesSchedule.add(employeeSchedule3);

		System.out.println(eft.employeeFreeTime(employeesSchedule));

		System.out.println(eft.employeeFreeTimewithPQ(employeesSchedule));

	}

}
