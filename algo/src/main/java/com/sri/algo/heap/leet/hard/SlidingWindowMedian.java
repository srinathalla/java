package com.sri.algo.heap.leet.hard;

import java.util.PriorityQueue;

import com.sri.algo.array.PrintArray;

/**
 * Median is the middle value in an ordered integer list. If the size of the
 * list is even, there is no middle value. So the median is the mean of the two
 * middle value.
 * 
 * Examples: [2,3,4] , the median is 3
 * 
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * 
 * Given an array nums, there is a sliding window of size k which is moving from
 * the very left of the array to the very right. You can only see the k numbers
 * in the window. Each time the sliding window moves right by one position. Your
 * job is to output the median array for each window in the original array.
 * 
 * For example, Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * 
 * Window position Median --------------- ----- [1 3 -1] -3 5 3 6 7 1 1 [3 -1
 * -3] 5 3 6 7 -1 1 3 [-1 -3 5] 3 6 7 -1 1 3 -1 [-3 5 3] 6 7 3 1 3 -1 -3 [5 3 6]
 * 7 5 1 3 -1 -3 5 [3 6 7] 6 Therefore, return the median sliding window as
 * [1,-1,-1,3,5,6].
 * 
 * @author salla
 *
 */
public class SlidingWindowMedian {
	
	PriorityQueue<Integer> maxH;
	PriorityQueue<Integer> minH;

	/**
	 * T.C : O(nlogk)
	 * 
	 * Idea is to use two heaps .
	 * similar to finding median from two streams.
	 * 
	 * where k is the window size.
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public double[] medianSlidingWindow(int[] nums, int k) {
		
		if (nums.length == 0)
		{
			return new double[0];
		}

		maxH = new PriorityQueue<>((a, b) -> (long)nums[b] - nums[a] > 0 ? 1 : -1);
		minH = new PriorityQueue<>((a, b) -> (long)nums[a] - nums[b] > 0 ? 1 : -1);

		double[] result = new double[nums.length - k + 1];

		int l =0;
		for (int i = 0; i < nums.length; i++) {
			
			if (i >= k)
			{
				boolean isRemoved = false;
				if (nums[i-k] <= nums[maxH.peek()])
				{
					isRemoved = maxH.remove(i - k);
				}
				else if (!isRemoved)
				{
					minH.remove(i-k);
					minH.add(maxH.poll());
				}
			}

			insertIntoWindow(i);
			
			if (i >= k - 1) {
				double median = maxH.size() == minH.size() ? 
					((long)nums[maxH.peek()] + nums[minH.peek()]) * 0.5 : nums[maxH.peek()];
				result[l++] = median;
			}
		}
		
		return result;
	}
	
	private void insertIntoWindow(int i)
	{
		maxH.add(i);
		minH.add(maxH.poll());

		if (minH.size() > maxH.size()) {
			maxH.add(minH.poll());
		}
	}
	
	public static void main(String[] args) {
		
		SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
		
		/*double[] result = 
			slidingWindowMedian.medianSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);
		
		PrintArray.print(result);*/
		
		double[] result1 = slidingWindowMedian.medianSlidingWindow(
			new int[] {-2147483648,-2147483648,2147483647,-2147483648,1,3,-2147483648,-100,8,17,22,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648},
				6);
				
				PrintArray.print(result1);
				
				System.out.println((long)2147483647 - (-2147483648));
				
				
		
	}

}
