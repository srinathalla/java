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
	 * Can we do without stack ? yes, need to refer leet code solutions.
	 * 
	 * Auxillary space : O(n) .
	 * 
	 * @param s
	 * @return
	 */
	public int longestValidParentheses(String s) {
		int n = s.length();

		if (n < 2) {
			return 0;
		}

		int max_len = 0;
		int i = 0;

		Stack<Integer> pStack = new Stack<>();
		pStack.push(i++);

		while (i < n) {
			

			while (i < n && s.charAt(i) == '(')
			{
				pStack.push(i++); // Push elements onto stack till u get a closing bracket.
			}

			if(i >= n)
			{
				break;
			}
			System.out.println(pStack);
			if (!pStack.isEmpty() && s.charAt(pStack.peek()) == '(') 
			{
				pStack.pop();	
				int len = pStack.empty() ? i + 1 : i - pStack.peek();
				max_len = Integer.max(max_len, len);
			}
			else
			{
				pStack.push(i);
			}
			i++;
		}

		return max_len;
	}
	
	private int longestValidParanthesis(String s)
	{
		int n =s.length();
		
		if (n < 2)
		{
			return 0;
		}
		
		int max = 0;
		Stack<Integer> stack = new Stack<>();
	
		for (int i=0; i < s.length(); i++)
		{
			char ch = s.charAt(i);
			
			if(ch == '(')
			{
				stack.push(i);
			}
			else if(ch == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(')
			{
				stack.pop();
				max = Integer.max(max, i - (stack.isEmpty() ? -1 : stack.peek()));
			}
			else
			{
				stack.push(i);
			}
		}
		
		return max;
		
	}
	
	private int longestValidParanthesisWithoutStack(String s)
	{
		int n =s.length();
		
		if (n < 2)
		{
			return 0;
		}
		
		int max = 0;
		
	     int left = 0, right = 0;
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
			
			if (left == right)
			{
				max = Integer.max(max, 2 * right);
			}
			
			if (right >= left)
			{
				left = right = 0;
			}
		}
		
		for (int i = s.length() -1; i>=0; i--)
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
			
			if (left == right)
			{
				max = Integer.max(max, 2 * right);
			}
			
			if (left >= right)
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
