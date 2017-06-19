package com.sri.algo.stack;

import java.util.Scanner;
import java.util.Stack;

public class GameOfTwoStacks {
	
	public static void main(String[] args) {
        
		Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for(int a0 = 0; a0 < g; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            long x = in.nextLong();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            int[] b = new int[m];
            for(int b_i=0; b_i < m; b_i++){
                b[b_i] = in.nextInt();
            }
            // your code goes here
            
            Stack<Integer> s1 = new Stack<>();
	        long sum = 0;
	        for(int index = a.length -1 ;index >=0 ;index--)
	        {
	        	s1.push(a[index]);
	        }
	        
	        Stack<Integer> s2 = new Stack<>();
	        for(int index = b.length -1 ;index >=0 ;index--)
	        {
	        	s2.push(b[index]);
	        }
	        
	        // Score is the number of pop's done from either of the stacks.
	        // keeping sum of pop's less than given x.
	        int score = 0;
	        while(sum  < x)
	        {
	        	if(s1.peek() < s2.peek())
	        	{
	        		if(sum + s1.peek() <= x)
	        		{
	        			sum = sum + s1.pop();
	        			score++;
	        		}
	        		else
	        		{
	        			break;
	        		}
	        	}
	        	else
	        	{
	        		if(sum + s2.peek() <= x)
	        		{
	        			sum = sum + s2.pop();
	        			score++;
	        		}
	        		else
	        		{
	        			break;
	        		}
	        	}	
	        }
	        System.out.println(score);
        }
    }

}
