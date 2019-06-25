package com.sri.algo.stack;

import java.util.Stack;

public class MinStack {
	
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> minStack = new Stack<>();
	
	 /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
    	
    	
    	if (minStack.isEmpty() || minStack.peek() >= x)
    	{
    		minStack.push(x);
    	}
    	
    	stack.push(x);
        
    }
    
    public void pop() {
    	
    	if(stack.peek().equals(minStack.peek()))
    	{
    		minStack.pop();
    	}
    	
    	stack.pop();
        
    }
    
    public int top() {
    	
    	
    	return stack.peek();
        
    }
    
    public int getMin() {
    	
    	return minStack.peek();
        
    }
    
    
    public static void main(String[] args) {
    	
    	MinStack minStack = new MinStack();
    	
    	minStack.push(512);
    	minStack.push(-1024);
    	minStack.push(-1024);
    	minStack.push(512);
    	minStack.pop();
    	System.out.println(
			minStack.getMin());
    	minStack.pop();
    	System.out.println(
			minStack.getMin());
    	minStack.pop();
    	System.out.println(
			minStack.getMin());
		
	}

}
