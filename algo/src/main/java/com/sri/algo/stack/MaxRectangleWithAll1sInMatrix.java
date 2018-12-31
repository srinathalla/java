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
	
	public int maximalRectangle(char[][] matrix) {
		   
		
		 int n = matrix.length;
        int m = matrix[0].length;
        
        int[][] table = new int[n][m];
        
        for (int i=0; i< n; i++)
        {
            for (int j=0; j< m; j++)
            {
               table[i][j] = matrix[i][j] == '1' ? 1 : 0;
            }
        }
        
		int max_area = largestRectangleArea(table[0]);
		
		for (int i=1; i< n; i++)
		{
			for (int j=0; j< m; j++)
			{
				table[i][j] += table[i][j] == 1 ? table[i-1][j] :  0;
			}
			max_area = Integer.max(max_area, largestRectangleArea(table[i]));
		}
		
		
		return max_area;
	}
	 
	 
	 public static int largestRectangleArea(int[] heights) {
			
			Stack<Integer> stack = new Stack<>();
			stack.push(-1);
			int maxArea = 0;
			
			for (int i=0; i< heights.length;i++)
			{
				while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
					maxArea = Integer.max(maxArea, heights[stack.pop()] * (i - stack.peek() -1));
				}
				stack.push(i);
			}
			
			while (stack.peek() != -1)
			{
				maxArea = Integer.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() -1));
			}
			
			
			return maxArea;
	    }

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
		int max_area = largestRectangleArea(table[0]);
		
		for (int i=1; i< n; i++)
		{
			for (int j=0; j< table[0].length; j++)
			{
				table[i][j] += table[i][j] == 1 ? table[i-1][j] :  0;
			}
			max_area = Integer.max(max_area, largestRectangleArea(table[i]));
		}
		
		
		return max_area;
	}
	 
	
	public static void main(String[] args) {
		
		MaxRectangleWithAll1sInMatrix maxRect = new MaxRectangleWithAll1sInMatrix();
/*
		System.out
				.println(maxArea(new int[][] { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } }, 4, 4));
	


		System.out.println(
				maxRect.maximalRectangle(new int[][] { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } }));
	*/
		System.out.println(
				maxRect.maximalRectangle(new char[][]
						{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}} ));
	
	}

}
