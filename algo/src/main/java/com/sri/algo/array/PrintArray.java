package com.sri.algo.array;

import java.util.List;

public class PrintArray {

	public static void print(int[] arr) {

		for (int no : arr) {
			System.out.print(no + " ");
		}

		System.out.println();
	}

	public static void print(List<Integer> list) {

		for (int no : list) {
			System.out.print(no + " ");
		}

		System.out.println();
	}

	public static void print(Integer[] arr) {

		for (int no : arr) {
			System.out.print(no + " ");
		}

		System.out.println();
	}

	public static void print(boolean[] arr) {

		for (boolean no : arr) {
			System.out.print(no + " ");
		}
	}

	public static void print(char[] arr) {

		for (char ch : arr) {
			System.out.print(ch);
		}

		System.out.println();

	}

	public static void print(double[] arr) {

		for (double no : arr) {
			System.out.print(no + " ");
		}

		System.out.println();

	}

	public static void print(long[] arr) {

		for (long no : arr) {
			System.out.print(no + " ");
		}

		System.out.println();

	}

	public static void print2dArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}

	public static void print2dArray(Integer[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}
}
