package com.sri.algo;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution {

	
	  public int findKthLargest(int[] nums, int k) {
	        
	        
	        var pq = new PriorityQueue<Integer>();
	        
	        for(var a : nums)
	        {
	        	pq.add(a);
	        	
	        	if(pq.size() > k)
	        	{
	        		pq.poll();
	        	}
	        }
	        
	        return pq.poll();
	        
	    }
	  

	public static void main(String[] args) {

		Solution s = new Solution();
		System.out.println(
			s.maxResult(new int[]{1,-5,-20,4,-1,3,-6,-3}, 2));
		
	
		//System.out.println(
		// 	s.reformatNumber("123 4-567"));

	}

}
