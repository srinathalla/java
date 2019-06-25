package com.sri.algo.stack;

import java.util.Stack;

/**
 * 	Design a max stack that supports push, pop, top, peekMax and popMax.

	push(x) -- Push element x onto stack.
	pop() -- Remove the element on top of the stack and return it.
	top() -- Get the element on the top.
	peekMax() -- Retrieve the maximum element in the stack.
	popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
	Example 1:
	MaxStack stack = new MaxStack();
	stack.push(5); 
	stack.push(1);
	stack.push(5);
	stack.top(); -> 5
	stack.popMax(); -> 5
	stack.top(); -> 1
	stack.peekMax(); -> 5
	stack.pop(); -> 1
	stack.top(); -> 5
	
	T.C : O(n), S.C O(n)
 * @author salla
 *
 */
public class MaxStack {
	
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> maxStack = new Stack<>();
    public MaxStack() {
        
    }
    
    public void push(int x) {
    	
    	if (maxStack.isEmpty() || x >= maxStack.peek())
    	{
    		maxStack.push(x);
    	}
    	else
    	{
    		maxStack.push(maxStack.peek());
    	}
    	
    	stack.push(x);
        
    }
    
    public int pop() {
    	
    	
    	maxStack.pop();
    	
        
    	return stack.pop();
    }
    
    public int top() {
    	
    	return stack.peek();    
    }
    
    public int peekMax() {
    	
    	return maxStack.peek(); 
        
    }
    
    public int popMax() {
    	
    	Stack<Integer> buffer = new Stack<>();
    	
    	int max = maxStack.peek();
    	while(top() != max)
    	{
    		int x = pop();
    		buffer.push(x);
    	}
        pop();
        while(!buffer.isEmpty())
        {
        	push(buffer.pop());
        }
        
    	return max;
    }
    
    public static void main(String[] args) {
    	
    	
    	MaxStack stack = new MaxStack();
    	stack.push(5); 
    	stack.push(1);
    	// stack.push(5);
    	// System.out.println(stack.top()); // -> 5
    	System.out.println(stack.popMax()); // -> 5
    	// System.out.println(stack.top()); // -> 1
    	System.out.println(stack.peekMax()); // -> 5
    	// System.out.println(stack.pop()); // -> 1
    	// System.out.println(stack.top()); 
		
	}

}
