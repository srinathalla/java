package com.sri.algo.array.leet.medium;

import java.util.Map.Entry;
import java.util.TreeMap;


/**
 * Implement a MyCalendar class to store your events. A new event can be added if adding the event will not cause a double booking.

   Your class will have the method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), 
   the range of real numbers x such that start <= x < end.

	A double booking happens when two events have some non-empty intersection (ie., there is some time that is common to both events.)
	
	For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a 
	double booking. Otherwise, return false and do not add the event to the calendar.
	
	Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
	Example 1:
	
	MyCalendar();
	MyCalendar.book(10, 20); // returns true
	MyCalendar.book(15, 25); // returns false
	MyCalendar.book(20, 30); // returns true
	Explanation: 
	The first event can be booked.  The second can't because time 15 is already booked by another event.
	The third event can be booked, as the first event takes every time less than 20, but not including 20.
	 * @author salla
 *
 */
public class MyCalendar1 {

	TreeMap<Integer, Integer> map = new TreeMap<>();

	/**
	 * T.C : O(nlogn) as tree map arranges keys in sorted order.
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public boolean book(int start, int end) {

		Entry<Integer, Integer> smaller = map.floorEntry(start);
		Entry<Integer, Integer> bigger = map.ceilingEntry(start);

		if ((smaller == null ||start >= smaller.getValue()) && 
				(bigger == null || end <= bigger.getKey())) {
			map.put(start, end);
			return true;
		}
		
		return false;

	}
	
	public static void main(String[] args) {
		
		
		MyCalendar1 myCalendar1 = new MyCalendar1();
		
		System.out.println(myCalendar1.book(10, 20));
		System.out.println(myCalendar1.book(15, 25));
		System.out.println(myCalendar1.book(20, 30));
		
	}

}
