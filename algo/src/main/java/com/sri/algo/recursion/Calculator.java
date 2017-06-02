package com.sri.algo.recursion;

import java.util.Scanner;

public class Calculator {
	
	
	private static boolean isDivisibleby101(long result,int[] arr,int index,char[] operations,String expression)
	{
		boolean resultFound = false;
		if(index == arr.length)
		{
			resultFound = result % 101 == 0;
		}
		

		if(index < arr.length)
		{ 
			for(char operation : operations)
			{	
				String newExpr = expression + operation + arr[index];
				switch (operation)
				{	
				 			
				   case '-' : 
					   resultFound = isDivisibleby101(result - arr[index],arr,index + 1,operations,newExpr);
					   break;
					   
				   case '+' : 
					   resultFound = isDivisibleby101(result + arr[index],arr,index + 1,operations,newExpr);
					break;
					   
				   case '*' : 
					   resultFound = isDivisibleby101(result * arr[index],arr,index + 1,operations,newExpr);
					break;
							
				}
				if(resultFound)
				{
					if(index == arr.length -1)
					{
						System.out.println(newExpr);
					}
					return resultFound;
				}
			}
		}
		return resultFound;			
	}
	
	public static void main(String[] args) {
			
	    Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        int[] nos = new int[n];
        for(int i=0; i < n;i++){
        	nos[i] =  in.nextInt();
        }
        
        char[] operations = new char[]{'+','-','*'};
        
       System.out.println(isDivisibleby101(nos[0],nos,1,operations,String.valueOf(nos[0])));
       
	}
	
}
