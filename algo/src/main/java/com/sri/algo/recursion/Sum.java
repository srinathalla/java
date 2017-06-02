package com.sri.algo.recursion;

import java.util.Scanner;

public class Sum {
	
	
	
	
	public static void main(String[] args) 
	{	
	    Scanner in = new Scanner(System.in);
	    long sum = 0;
        int n = in.nextInt();
        for(int arr_i=0; arr_i < n; arr_i++){
        	sum = sum +  in.nextInt();
        }
        System.out.println(sum);
        
        
	}

}
