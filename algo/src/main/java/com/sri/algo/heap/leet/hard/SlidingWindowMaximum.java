package com.sri.algo.heap.leet.hard;

import java.util.ArrayDeque;
import java.util.Deque;

import com.sri.algo.array.PrintArray;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

	Example:
	
	Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
	Output: [3,3,5,5,6,7] 
	Explanation: 
	
	Window position                Max
	---------------               -----
	[1  3  -1] -3  5  3  6  7       3
	 1 [3  -1  -3] 5  3  6  7       3
	 1  3 [-1  -3  5] 3  6  7       5
	 1  3  -1 [-3  5  3] 6  7       5
	 1  3  -1  -3 [5  3  6] 7       6
	 1  3  -1  -3  5 [3  6  7]      7
	Note: 
	You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
	
	Follow up:
	Could you solve it in linear time?
 * @author salla
 *
 */
public class SlidingWindowMaximum {
	
	/**
	 * T.C : O(n)
	 * Idea is to maintain monotonic decreasing sequence. 
	 * 
	 * @param a
	 * @param k
	 * @return
	 */
	public int[] maxSlidingWindow(int[] a, int k) {		
		
		if (a == null ||  a.length == 0 || a.length < k)
		{
			return new int[0];
		}
		
		int[] r = new int[a.length - k + 1];
		
		Deque<Integer> q  = new ArrayDeque<>();
		
		int ri =0;
		for (int i=0; i< a.length;i++)
		{
			
			while (!q.isEmpty() && q.peekFirst() <= i - k)
			{
				q.poll();
			}
			
			while (!q.isEmpty() &&  a[q.peekLast()] < a[i])
			{
				q.pollLast();
			}
			
			q.offer(i);
			
			if (i >= k -1)
			{
				r[ri++] = a[q.peek()];
			}
		}
		
		return r;
	}
	
	public static void main(String[] args) {
		
		SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
		
		// int[] result = slidingWindowMaximum.maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);
		
		int[] result = slidingWindowMaximum.maxSlidingWindow(new int[] {7,2,4}, 2);
		
	    PrintArray.print(result);
	}

}
