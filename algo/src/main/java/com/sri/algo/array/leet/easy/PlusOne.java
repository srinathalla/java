package com.sri.algo.array.leet.easy;

import com.sri.algo.array.PrintArray;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus
 * one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list, and each element in the array contain a single digit.
 * 
 * You may assume the integer does not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example 1:
 * 
 * Input: [1,2,3] Output: [1,2,4] Explanation: The array represents the integer
 * 123.
 * 
 * @author salla
 *
 */
public class PlusOne {

	public int[] plusOne(int[] digits) {

		int carry = 1;

		int i = digits.length - 1;
		while (i >= 0) {
			digits[i] += carry;

			if (digits[i] == 10) {
				digits[i] = 0;
				carry = 1;
				i--;
			} else {
				carry = 0;
				break;
			}

		}

		if (carry == 1) {
			int[] arr = new int[digits.length + 1];

			arr[0] = 1;
			return arr;
		}
		return digits;
	}
	
	public static void main(String[] args) {
		
		PlusOne plusOne = new PlusOne();
		
		PrintArray.print(
			plusOne.plusOne(new int[] {1,2,3}));
		
		PrintArray.print(
				plusOne.plusOne(new int[] {4,3,2,1}));
		
		PrintArray.print(
				plusOne.plusOne(new int[] {9,8,9,9}));
		
		
		
	}

}
