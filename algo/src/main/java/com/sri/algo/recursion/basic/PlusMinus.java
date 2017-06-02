package com.sri.algo.recursion.basic;

import java.util.Scanner;

public class PlusMinus {
	

	/**
	 * 
	 *        i/p :
	 *         6
			  -4 3 -9 0 4 1  
			  
			  o/p : 
			  
			  0.500000
			  0.333333
			  0.166667
	 * @param args
	 */
	public static void main(String[] args) {
		
		    Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        
	        int[] numbers = new int[n];
	        
	        for(int i=0; i < n; i++){
	        	numbers[i] = in.nextInt();
	        }
	        
	        int plusCount = 0;
	        int minusCount = 0;
	        int zeroCount = 0;
	        
	        for(int no : numbers)
	        {
	        	
	        	if(no == 0)
	        	{
	        		zeroCount++;
	        	}
	        	else if(no > 0)
	        	{
	        		plusCount++;
	        	}
	        	else
	        	{
	        		minusCount++;
	        	}
	        }
	        
	        System.out.println((double)plusCount/(double)numbers.length);
	        System.out.println((double)minusCount/(double)numbers.length);
	        System.out.println((double)zeroCount/(double)numbers.length);
	}

}
