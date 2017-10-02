package com.sri.algo.dp;

import java.util.Scanner;

public class LongestIncreasingSubSequence {

	public static int longIncreasingSubSequence(int[] arr) {
		int seqCount[] = new int[arr.length];

		for (int i = 0; i < seqCount.length; i++) {
			seqCount[i] = 1;
		}

		for (int i = 1; i < arr.length; i++) {

			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					seqCount[i] = Math.max(seqCount[j] + 1, seqCount[i]);
				}
			}
		}

		int max = 0;
		for (int i = 0; i < seqCount.length; i++) {
			max = Math.max(seqCount[i], max);
		}

		return max;
	}
	
	public static int longIncreasingSSWithDP(int[] arr) {
		int seqCount[] = new int[arr.length];

		for (int i = 0; i < seqCount.length; i++) {
			seqCount[i] = 1;
		}

		for (int i = 1; i < arr.length; i++) {

			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					seqCount[i] = Math.max(seqCount[j] + 1, seqCount[i]);
				}
			}
		}

		int max = 0;
		for (int i = 0; i < seqCount.length; i++) {
			max = Math.max(seqCount[i], max);
		}

		return max;
	}

	public static void main(String[] args) {
		/*System.out.println(LongestIncreasingSubSequence
				.longIncreasingSubSequence(new int[] { 10, 22, 9, 33, 21, 50, 41, 60, 80 }));*/
		
		try(Scanner in = new Scanner(System.in))
		{
	        int testCount = in.nextInt();
	        
	        for (int i =0 ;i < testCount ; i++)
	        {
	        	int n = in.nextInt();
	        	int[] arr = new int[n];
	        	
	        	for (int j = 0 ;j < n ; j++)
	        	{
	        		arr[j] = in.nextInt();
	        	}
	        	
	    		System.out.println(longIncreasingSubSequence(arr));
	        }
		}

	}

}
