package com.sri.algo.array;

import java.util.Scanner;

public class ArrayAddElementToIndicesInRange {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			String input = in.nextLine();

			int n = Integer.valueOf(input.split(" ")[0]);
			int op = Integer.valueOf(input.split(" ")[1]);

			long[] arr = new long[n];

			for (int i = 0; i < op; i++) {
				input = in.nextLine();
				int p = Integer.valueOf(input.split(" ")[0]);
				int q = Integer.valueOf(input.split(" ")[1]);
				int element = Integer.valueOf(input.split(" ")[2]);

				arr[p-1] = arr[p-1] + element;

				if (q  < n) {
					arr[q] -= element;
				}
				for(long entry : arr)
				{
					System.out.print(entry + " ");
				}
				System.out.println();
			}

			long max =0,x =0;
			for(int i=0;i<n;i++)
		    {
		       x=x+arr[i];
		       if(max < x) max=x;

		    }

			System.out.println(max);
		}
	}

}
