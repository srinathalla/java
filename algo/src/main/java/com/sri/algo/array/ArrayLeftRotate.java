package com.sri.algo.array;

import java.util.Scanner;

public class ArrayLeftRotate {
	
	public static void leftRotate()
	{

		  Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int d = in.nextInt();
	        int arr[] = new int[n];
	        for(int arr_i=0; arr_i < n; arr_i++){
	            arr[arr_i] = in.nextInt();
	        }
	        
	        for(int i = 1 ; i<=d ;i++)
	        {
	        	int curr = arr.length -1;
	        	int right = arr[curr];
	        	while(curr > 0)
	        	{   
	        		int prev = arr[curr-1];	
		        	arr[curr -1] = right;
		        	right = prev;
		        	curr--;
	        	}
	        	
	        	arr[arr.length -1] = right;
	        }
	        
	         for(int i = 0 ;i <= arr.length -1; i++){
	            System.out.print(arr[i] + " ");
	        }
	}
	
	public static void main(String[] args) {
		
		leftRotate();
		
	}

}
