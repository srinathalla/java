package com.sri.algo.array.leet.medium;

import java.util.Stack;

public class MinimumCostTreeFromLeafValues {

	public int mctFromLeafValues(int[] A) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        
        for(int no : A)
        {
        	while(stack.peek() <= no)
        	{
        		int mid = stack.pop();
        		res += mid * Math.min(stack.peek(), no);
        	}
        	
        	stack.push(no);
        }
        
        while(stack.size() > 2)
        {
        	res += stack.pop() * stack.peek();
        }
        
        return res;
        
    }
	
	public static void main(String[] args) {
		
		MinimumCostTreeFromLeafValues mct = new MinimumCostTreeFromLeafValues();
		System.out.println(
			mct.mctFromLeafValues(new int[] {6,2,4}));
		
	}
	
	

}
