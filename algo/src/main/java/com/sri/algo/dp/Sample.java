package com.sri.algo.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Sample {

		
		
		 public static void main(String args[] ) throws Exception {
		        
		      
		        //BufferedReader
		        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
		        {
		        String line = br.readLine();
		        int NTests = Integer.parseInt(line);

		        while(NTests > 0)
		        {
			        //Scanner
			        Scanner s = new Scanner(System.in);
			        int N = s.nextInt();
	
			        for (int i = 1; i <= N; i++) {
			            
			        	
			        	if (i % 3 == 0 && i % 5 ==0)
			        	{
			        		System.out.println("FizzBuzz");
			        	}
			        	else if (i % 3 == 0)
			        	{
			        		System.out.println("Fizz");
			        	}
			        	else if (i % 5 ==0)
			        	{
			        		System.out.println("Buzz");
			        	}
			        	else
			        	{
			        		System.out.println(i);
			        	}
			        }
			        NTests --;
		        }
		        

		     
		        		}
		    
	}

}
