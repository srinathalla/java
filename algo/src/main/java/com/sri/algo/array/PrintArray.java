package com.sri.algo.array;

public class PrintArray {

	public static void print(int[] arr) {

		for (int no : arr) {
			System.out.print(no + " ");
		}

	}
	
	public static void print2dArray(int[][] arr) 
	{
		for (int i = 0; i < arr.length; i++) 
		{
			for (int j = 0; j < arr[0].length; j++) 
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}
}
