package com.sri.algo.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MyCalendar2 {
	
	 TreeMap<Integer, Integer> delta;

	public MyCalendar2() {
		delta = new TreeMap<>();
	}

	/**
	 * 	When booking a new event [start, end), count delta[start]++ and delta[end]--. 
	 *  When processing the values of delta in sorted order of their keys, the 
	 *  running sum active is the number of events open at that time. 
	 *  If the sum is 3 or more, that time is (at least) triple booked.
	 *  
	 * @param start
	 * @param end
	 * @return
	 */
	List<int[]> overlap = new ArrayList<>();
	List<int[]> calendar = new ArrayList<>();


	public boolean book(int start, int end) 
	{
		for (int[] o : overlap)
		{
			if(start < o[1] && end > o[0])
			{
				return false;
			}
		}
		
		for (int[] cal : calendar)
		{
			if(start < cal[1] && end > cal[0])
			{
				overlap.add(new int[] { 
						Math.max(start, cal[0]), Math.min(end, cal[1])
						
				});
			}
		}
		
		calendar.add(new int[] {start, end});
		
		return true;
		
	}
	
	public boolean book1(int start, int end) {

		delta.put(start, delta.getOrDefault(start, 0) + 1);
		delta.put(end, delta.getOrDefault(end, 0) - 1);

		int active = 0;

		for (int v : delta.values()) {
			active += v;

			if (active >= 3) {
				delta.put(start, delta.get(start) - 1);
				delta.put(end, delta.get(end) + 1);
				
				return false;
			}

		
		}

		return true;
	}
	    
	    public static void main(String[] args) {
	    	
	    	MyCalendar2 myCalendar2 = new MyCalendar2();
	
	    	System.out.println(myCalendar2.book(10, 20)); // returns true
	    	System.out.println(myCalendar2.book(50, 60)); // returns true
	    	System.out.println(myCalendar2.book(10, 40));// returns true
	    	System.out.println(myCalendar2.book(5, 15));
	    	System.out.println(myCalendar2.book(5, 10)); // returns true
	    	System.out.println(myCalendar2.book(25, 55));
			
		}

}
