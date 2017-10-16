package com.sri.algo.stack;

import java.util.Stack;

/**
 * Find the largest rectangular area possible in a given histogram where the largest 
 * rectangle can be made of a number of contiguous bars.
 * For simplicity, assume that all bars have same width and the width is 1 unit.
 * 
 * Time Complexity : O(n).
 * 
 * As each element is added and removed from once from stack. O(2n) => O(n)
 *
 */
public class MaxRectangleArea {


	public static int getMaxArea(int hist[], int n) {

		// Holds indices of each element in array.
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		int max = Integer.MIN_VALUE;

		while (i < n) {
			
			// Push curr element onto stack if it is bigger than the top of the stack.
			if (stack.isEmpty() || hist[stack.peek()] < hist[i]) {
				stack.push(i++);
			} else {
				int tp = stack.pop();
				int len = hist[tp];

				// Calculate area of each rectangle with current bar as the smallest.
				int area = len * (
					stack.isEmpty() ? // Means curr element popped from stack is the smallest till i-1.
					i : // No of bars present with atleast curr element height is i. 
					(i - stack.peek() - 1)); // No of bars present with height >= len 
				                             // is difference of two bar indices -1.
				max = Integer.max(max, area);
			}
		}
		
		while(!stack.isEmpty())
		{
			int tp = stack.pop();
			int len = hist[tp];

			// Calculate area of each rectangle with current bar as the smallest.
			int area = len * (stack.isEmpty() ? i : (i - stack.peek() - 1));

			max = Integer.max(max, area);
		}
		
		return max;

	}

	// Driver program to test above function
	public static void main(String[] args) {
		int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
		System.out.println("Maximum area is " + getMaxArea(hist, hist.length));
	}

	// This code is Contributed by Sumit Ghosh

}
