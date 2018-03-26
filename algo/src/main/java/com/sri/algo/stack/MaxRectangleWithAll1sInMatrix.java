package com.sri.algo.stack;

import java.util.Stack;

/**
 * Given a binary matrix, Your task is to complete the function maxArea which
 * the maximum size rectangle area in a binary-sub-matrix with all 1’s. The
 * function takes 3 arguments the first argument is the Matrix M[ ] [ ] and the
 * next two are two integers n and m which denotes the size of the matrix M.
 * Your function should return an integer denoting the area of the maximum
 * rectangle .
 * 
 *
 * 
 */
public class MaxRectangleWithAll1sInMatrix {

	public static int maxArea(int a[][], int m, int n) {

		int max = 0;

		// Copy first row as is.
		max = Integer.max(max, MaxRectangleArea.getMaxArea(a[0],n));
		

		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 1) {
					a[i][j] = a[i-1][j] + 1;
				} 
			}

			int area = MaxRectangleArea.getMaxArea(a[i], n);
			max = Integer.max(max, area);
		}

		return max;
	}
	
	/**
	 * Idea is to use maxRectangle Area in a histogram.
	 * 
	 * At each row we compute max rectangle area of all bars present in histogram.
	 * 
	 * @param table
	 * @return
	 */
	 public int maximalRectangle(int[][] table) {
	   
		 
		 int n = table.length;
		 
		  if (n == 0)
		  {
			  return 0;
		  }
		  
		 int m = table[0].length;

		 int max = maxRectangleArea(table[0]);
		 
		 for (int i =1 ; i <n; i++)
		 { 
			 for (int j =0 ;j <m;j++)
			 { 
				 table[i][j] +=  table[i][j] == 1 ? table[i-1][j] : 0;
			 }
			 
			 max = Integer.max(max, maxRectangleArea(table[i]));
		 }
		 
	    return max;
	}
	 
	 
	 private int maxRectangleArea(int[] arr)
	 {
		 
		 Stack<Integer> stack = new Stack<>();
		 
		 int i = 0;
		 int max = Integer.MIN_VALUE;
		 while (i < arr.length)
		 {

			 if (stack.isEmpty() || arr[stack.peek()] <= arr[i])
			 {
				 stack.push(i++);
			 }
			 else
			 {
				 int top = stack.pop();
				 
				 int len = stack.isEmpty() ? i : i-1-stack.peek();
				 
				 max = Integer.max(max, arr[top] * len); 
			 }
		 }
		 
		 while (!stack.isEmpty())
		 {
			 int top = stack.pop();
			 
			 int len = stack.isEmpty() ? i : i-1-stack.peek();
			 
			 max = Integer.max(max, arr[top] * len); 
		 }
		 
		 return max;
	 }

	public static void main(String[] args) {

		System.out
				.println(maxArea(new int[][] { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } }, 4, 4));
	
MaxRectangleWithAll1sInMatrix maxRect = new MaxRectangleWithAll1sInMatrix();

		System.out.println(
				maxRect.maximalRectangle(new int[][] { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } }));
	
	}

}
