package com.sri.algo.heap.leet.hard;

import java.util.PriorityQueue;

/**
 * Median is the middle value in an ordered integer list. If the size of the
 * list is even, there is no middle value. So the median is the mean of the two
 * middle value.
 * 
 * For example, [2,3,4], the median is 3
 * 
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * 
 * Design a data structure that supports the following two operations:
 * 
 * void addNum(int num) - Add a integer number from the data stream to the data
 * structure. double findMedian() - Return the median of all elements so far.
 * 
 * @author salla
 *
 */
public class MedianFromDataStream {

	PriorityQueue<Integer> minH;
	PriorityQueue<Integer> maxH;

	/** initialize your data structure here. */
	public MedianFromDataStream() {
		minH = new PriorityQueue<Integer>();
		/*
		 * By default Java provides min heap. For max heap, we need to pass in a
		 * appropriate comparator
		 */
		maxH = new PriorityQueue<Integer>((a, b) -> b - a);
	}

	public void addNum(int num) {
		maxH.add(num);

		minH.add(maxH.poll());

		if (minH.size() > maxH.size()) {
			maxH.add(minH.poll());
		}
	}

	public double findMedian() {
		
		
		if (minH.size() == maxH.size())
		{
			return (minH.peek() + maxH.peek()) * 0.5;
		}
		else
		{
			return maxH.peek();
		}
	}

	public static void main(String[] args) {

		MedianFromDataStream medianFromDataStream = new MedianFromDataStream();

		//medianFromDataStream.addNum(5);
		// medianFromDataStream.addNum(4);
		medianFromDataStream.addNum(3);
		medianFromDataStream.addNum(2);
		medianFromDataStream.addNum(1);

		System.out.println(medianFromDataStream.findMedian());

	}

}
