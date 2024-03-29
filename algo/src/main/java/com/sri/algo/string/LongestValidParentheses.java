package com.sri.algo.string;

import java.util.Stack;

/**
 *  Given a string containing just the characters '(' and ')', find the length of the 
 *  longest valid (well-formed) parentheses substring.

	Example 1:
	
	Input: "(()"
	Output: 2
	Explanation: The longest valid parentheses substring is "()"
	Example 2:
	
	Input: ")()())"
	Output: 4
	Explanation: The longest valid parentheses substring is "()()"
	
 * @author salla
 *
 */
public class LongestValidParentheses {

	/**
	 * Naive approach.
	 * 
	 * Compute all substrings and in each sub string compute the longest valid
	 * parentheses.
	 * 
	 * T.c : O (n ^ 3)
	 * 
	 * @param s
	 * @return
	 */
	public int longestValidParenthesesNaive(String s) {
		int n = s.length();

		int max_len = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int len = getLength(s, i, j);
				max_len = Integer.max(max_len, len);
			}
		}

		return max_len;
	}

	private int getLength(String s, int i, int j) {
		int len = 0;

		if (s.charAt(i) != '(') {
			return len;
		}

		for (int l = i; l < j; l = l + 2) {

			if (s.charAt(l) == '(' && s.charAt(l + 1) == ')') {
				len = len + 2;
			} else {
				break;
			}
		}

		return len;
	}

	/**
	 * Stack based solution 
	 * 
	 * T. C : O (n) as each element is pushed and popped from stack only once.
	 * 
	 * S.C : O(n)
	 * 
	 * Can we do without stack ? yes, need to refer leet code solutions.
	 * 
	 * Auxillary space : O(n) .
	 * 
	 * @param s
	 * @return
	 */
	
	
	public int longestValidParanthesis(String s)
	{
		int n = s.length();
		
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		
		int max = 0;
		
		for (int i=0 ; i< n ;i ++ )
		{
			char ch = s.charAt(i);
			
			if (ch == '(')
			{
				stack.push(i);
			}
			else
			{
				stack.pop();
				
				if (stack.isEmpty())
				{
					stack.push(i);
				}
				else
				{
					max = Integer.max(max, i - stack.peek());
				}
			}
		}
		
		return max;
	}
	
	/**
	 * T.C : O(n)
	 * Two pass solution.
	 * 
	 * @param s
	 * @return
	 */
	public int longestValidParanthesisWithoutStack(String s)
	{
		 if (s.length() < 2)
         {
             return 0;
         }
         
	    	int left =0, right = 0, max = 0;
	    	
	    	for (char ch : s.toCharArray())
	    	{
	    		if (ch == '(')
	    		{
	    			left++;
	    		}
	    		else
	    		{
	    			right++;
	    		}
	    		
	    		if(left == right)
	    		{
	    			max = Integer.max(max, 2 * right);
	    		}
	    		if (right > left)
	    		{
	    			left = right = 0;
	    		}
	    	}
	    	
	    	left = right = 0;
	    	for (int i=s.length()-1; i>=0; i--)
	    	{
	    		char ch = s.charAt(i);
	    		
	    		if (ch == '(')
	    		{
	    			left++;
	    		}
	    		else
	    		{
	    			right++;
	    		}
	    		
	    		if(left == right)
	    		{
	    			max = Integer.max(max, 2 * right);
	    		}
	    		
	    		if (left > right)
	    		{
	    			left = right = 0;
	    		}
	    	}

	    	return max;
		
	}

	public static void main(String[] args) {

		LongestValidParentheses lvp = new LongestValidParentheses();

		System.out.println(lvp.longestValidParanthesis("(()"));
		System.out.println(lvp.longestValidParanthesis(")()())"));
		System.out.println(lvp.longestValidParanthesis(")("));
		
		System.out.println(lvp.longestValidParanthesis("(())()"));
		
		System.out.println(lvp.longestValidParanthesis("())"));

	}
}
