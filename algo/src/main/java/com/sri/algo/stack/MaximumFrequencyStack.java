package com.sri.algo.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/***
 * Implement FreqStack, a class which simulates the operation of a stack-like data
 * structure.

   FreqStack has two functions:

   push(int x), which pushes an integer x onto the stack.
   pop(), which removes and returns the most frequent element in the stack.
   If there is a tie for most frequent element, the element closest to the top of the 
   stack is removed and returned.
 
 * @author salla
 *
 */
public class MaximumFrequencyStack {
	
	Map<Integer, Integer> freq;
	Map<Integer, Stack<Integer>> freqStack;
	int maxFreq;
 	
	 public MaximumFrequencyStack() {
		 freq = new HashMap<>();
		 freqStack = new HashMap<>();
	    }
	    
	    public void push(int x) {
	
			freq.put(x, freq.getOrDefault(x, 0) + 1);
	
			if (freq.get(x) > maxFreq) {
				maxFreq++;
			}
	
			if (!freqStack.containsKey(freq.get(x))) {
				freqStack.put(freq.get(x), new Stack<>());
			}
	
			freqStack.get(freq.get(x)).push(x);      
	    }
	    
	    public int pop() {
	    	
	    	    if (maxFreq == 0)
	            {
	                return -1;
	            }
		    	
		    	int x = freqStack.get(maxFreq).pop();
	            
	            freq.put(x,freq.get(x) -1 );
		    	
		    	if (freqStack.get(maxFreq).isEmpty())
		    	{
		    		maxFreq--;
		    	}
		    	
		    	
		    	return x;
		        
	        
	    }
	    
	    public static void main(String[] args) {
	    	
	    	MaximumFrequencyStack maxFreqStack = new MaximumFrequencyStack();
	    	
	    	maxFreqStack.push(5);
	    	maxFreqStack.push(7);
	    	maxFreqStack.push(5);
	    	maxFreqStack.push(7);
	    	maxFreqStack.push(4);
	    	maxFreqStack.push(5);
	    	System.out.println(maxFreqStack.pop());
	    	System.out.println(maxFreqStack.pop());
	    	System.out.println(maxFreqStack.pop());
	    	System.out.println(maxFreqStack.pop());
	    	
			
		}

}
