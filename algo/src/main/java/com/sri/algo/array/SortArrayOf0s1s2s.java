package com.sri.algo.array;

import java.io.IOException;
import java.util.Scanner;

public class SortArrayOf0s1s2s
{
	private static void sort(int[] array)
	{
	
        int[] counterArray = new int[3];
		
		for (int no : array)
		{
			counterArray[no]  = counterArray[no] + 1; 
		}
		
		int j=0;
		for(int index = 0 ; index < 3 ; index++)
		{
			int count = counterArray[index];
			while (count > 0)
			{
				array[j] = index;
				count--;
				j++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {

		try (Scanner in = new Scanner(System.in)) {

			int tests = in.nextInt();

			for (int test = 0; test < tests; test++) {

				int n = in.nextInt();
				
				int arr[] = new int[n];
			    for (int i =0 ; i < n; i++)
			    {
			    	arr[i] = in.nextInt();
			    }
			    
			    sort(arr);
			   
			    for (int no : arr)
			    {
			    	System.out.print(no + " ");
			    }
			    System.out.println();
			   

			}
		}
	}

}
