package com.sri.algo.array.cp;

import java.util.Arrays;

import com.sri.algo.array.PrintArray;

/**
 * Given a sorted array of integers nums and integer values a, b and c. Apply a
 * quadratic function of the form f(x) = ax2 + bx + c to each element x in the
 * array.
 * 
 * The returned array must be in sorted order.
 * 
 * Expected time complexity: O(n)
 * 
 * Example: nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,
 * 
 * Result: [3, 9, 15, 33]
 * 
 * nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5
 * 
 * Result: [-23, -5, 1, 7]
 * 
 * @author salla
 *
 */
public class SortTransformedArray {

	/**
	 * T.C O(nlogn)
	 * 
	 * @param nums
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {

		for (int i = 0; i < nums.length; i++) {
			int x = nums[i];
			nums[i] = quadratic(x,a,b,c);
		}

		Arrays.sort(nums);

		return nums;

	}
	
	private int quadratic(int x, int a, int b, int c)
	{
		return  a * (x * x) + b * x + c;
	}

	public static void main(String[] args) {

		SortTransformedArray sta = new SortTransformedArray();

		int[] result = sta.sortTransformedArray(new int[] { -4, -2, 2, 4 }, 1, 3, 5);
		
		PrintArray.print(result);
		
		result = sta.sortTransformedArray(new int[] { -4, -2, 2, 4 }, -1, 3, 5);
		
		PrintArray.print(result);

	}

}
