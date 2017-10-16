package com.sri.algo.array.tranform;

import java.util.Scanner;

/**
 * Given an array containing integers, zero is considered an invalid number and 
 * rest all other numbers are valid. If two nearest valid numbers are equal then 
 * double the value of the first one and make the second number as 0.
 * At last move all the valid numbers on the left.
 * 
 * 	Input:
	1
	12
	2 4 5 0 0 5 4 8 6 0 6 8
	
	Output:
	2 4 10 4 8 12 8 0 0 0 0 0
 *
 */
public class TranformArrayWithValidNosLeftAndZerosRight {

	public static int[] tranform(int[] arr, int n) {
		
		if (arr.length <= 1) {
			return arr;
		}

		int i = -1, j = 0;

		while (j < n) {
			
			// j points to a valid no. i.e not 0.
			while (j < n && arr[j] == 0) {
				j++;
			}
			
			// if prev(i.e i) valid no and curr(i.e j) valid no are same double prev no,
			// set curr to 0 and increment curr(i.e j).
			if (i != -1 && j < n && arr[i] == arr[j]) {
				arr[i] = arr[i] + arr[i];
				arr[j] = 0;
				j++;
			} else {
				i = j;
				j++;
			}
		}

		i = 0;
		j = 0;

		while (j < n) {
			while (i < n && arr[i] != 0) {
				i++;
			}

			j = j == 0 ? i + 1 : j;

			while (j < n && arr[j] == 0) {
				j++;
			}

			if (j < n) {
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
				i++;
				j++;
			}
		}

		return arr;
	}

	public static void main(String[] args) {

		/*
		 * int[] arr1 = tranform(new int[] {2 ,4 ,5 ,0 ,0 ,5 ,4 ,8 ,6, 0 ,6 ,8} ,12);
		 * 
		 * PrintArray.print(arr1);
		 */

		try (Scanner in = new Scanner(System.in)) {
			int testCount = in.nextInt();

			for (int i = 0; i < testCount; i++) {
				int n = in.nextInt();
				int[] arr = new int[n];

				for (int j = 0; j < n; j++) {
					arr[j] = in.nextInt();
				}

				tranform(arr, n);

				for (int no : arr) {
					System.out.print(no + " ");
				}
				System.out.println();
			}
		}
	}

}
