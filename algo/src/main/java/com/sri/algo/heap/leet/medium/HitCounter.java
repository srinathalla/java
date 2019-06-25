package com.sri.algo.heap.leet.medium;

import java.util.Deque;
import java.util.LinkedList;

public class HitCounter {
	
	private Deque<Integer> q;
	
	/** Initialize your data structure here. */
    public HitCounter() {
    	
    	q = new LinkedList<>();
        
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
    		
    	q.addLast(timestamp);
        
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
    	
    	while(!q.isEmpty() && timestamp - q.getFirst() >= 300)
    	{
    		q.poll();
    	}
    	
    	return q.size();
        
    }
    
    public static void main(String[] args) {
    	
    	HitCounter counter = new HitCounter();
    	
    	// hit at timestamp 1.
    	counter.hit(1);

    	// hit at timestamp 2.
    	counter.hit(2);

    	// hit at timestamp 3.
    	counter.hit(3);

    	// get hits at timestamp 4, should return 3.
    	System.out.println(counter.getHits(4));

    	// hit at timestamp 300.
    	counter.hit(300);

    	// get hits at timestamp 300, should return 4.
    	System.out.println(counter.getHits(300));

    	// get hits at timestamp 301, should return 3.
    	System.out.println(counter.getHits(301)); 
		
	}

}
