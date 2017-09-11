package com.sri.algo.array.rotate;

public class ArrayLeftRotate {
	
	public static void leftRotate(int[] arr, int d)
	{
	        
	        for(int i = 1 ; i<= d ;i++)
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
	
	public static void leftRotateFromStart(int[] arr, int d)
	{
		    // Only one element present in array
		    // or rotations required is zero return.
	        if (arr.length == 1 || d == 0)
	        {
	        	return;
	        }
	        
	        for(int i = 1 ; i<= d ;i++)
	        {
	        	int curr = 1;
	        	int left = arr[curr -1];
	        	while(curr < arr.length)
	        	{   
	        		int temp = arr[curr];	
		        	arr[curr -1] = temp;
		        	curr++;
	        	}
	        	
	        	arr[arr.length -1] = left;
	        }
	        
	         for(int i = 0 ;i <= arr.length -1; i++){
	            System.out.print(arr[i] + " ");
	           
	        }
	         System.out.println();
	}
	

	
	public static void main(String[] args) {
		
		leftRotateFromStart(new int[] {1,2,3,4,5},1);
		leftRotateFromStart(new int[] {1,2,3,4,5},2);
		leftRotateFromStart(new int[] {1,2,3,4,5},3);
		
	}

}
