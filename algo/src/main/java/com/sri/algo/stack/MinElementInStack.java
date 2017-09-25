package com.sri.algo.stack;

import java.util.Scanner;
import java.util.Stack;

public class MinElementInStack {

	private Stack<Integer> origStack = new Stack<>();
	private Stack<Integer> minElementStack = new Stack<>();

	/* returns min element from stack */
	int getMin() {

		return minElementStack.peek();

	}

	/* returns popped element from stack */
	int pop() {
		
		if (origStack.isEmpty())
		{
			return -1;
		}

		int ele = origStack.pop();

		if (minElementStack.peek() == ele) {
			minElementStack.pop();
		}

		return ele;

	}

	/* push element x into the stack */
	void push(int x) {

		origStack.push(x);
		
		if (minElementStack.isEmpty())
		{
			minElementStack.push(x);
		}
		else if (x <= minElementStack.peek())
		{
			minElementStack.push(x);
		}

	}
	
	public static void main(String[] args) {
		
		MinElementInStack minElementInStack = new MinElementInStack();
		
		/*minElementInStack.push(2);
		minElementInStack.push(3);
		minElementInStack.pop();
		
		System.out.println(minElementInStack.getMin());
		minElementInStack.push(1);
		System.out.println(minElementInStack.getMin());*/
		
		try(Scanner in = new Scanner(System.in))
		{
	        int testCount = in.nextInt();
	        
	        for (int i =0 ;i < testCount ; i++)
	        {
	        	int queries = in.nextInt();
	        	
	        	 for (int j =0 ;j < queries ; j++)
	 	         {
	        		 
	        		 int op = in.nextInt();
	        		 
	        		 if (op == 1)
	        		 {
	        			 minElementInStack.push(in.nextInt());
	        		 }
	        		 else if (op == 2)
	        		 {
	        			 minElementInStack.pop();
	        		 }
	        		 else if (op == 3)
	        		 {
	        			 int min = minElementInStack.getMin();
	        			 System.out.print(min);
	        		 }
	     	        
	 	         }
	        }
	       
		}
		
	}

}
