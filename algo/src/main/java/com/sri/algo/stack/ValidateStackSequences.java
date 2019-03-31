package com.sri.algo.stack;

import java.util.Stack;

/**
 *  Given two sequences pushed and popped with distinct values, return true if and 
 *  only if this could have been the result of a sequence of push and
 *  pop operations on an initially empty stack.
 *  
 *  Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
	Output: true
	Explanation: We might do the following sequence:
	push(1), push(2), push(3), push(4), pop() -> 4,
	push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 *  
 * @author salla
 *
 */
public class ValidateStackSequences {
	
	public boolean validateStackSequences(int[] pushed, int[] popped) {

		Stack<Integer> stack = new Stack<>();
		int n = pushed.length;

		int j = 0;
		for (Integer ele : pushed) {

			stack.push(ele);

			while (!stack.isEmpty() && j < n && stack.peek() == popped[j]) {
				stack.pop();
				j++;
			}
		}

		return j == n;
	}
	
	public static void main(String[] args) {
		
		ValidateStackSequences validateStackSequences = new ValidateStackSequences();
		
		System.out.println(
			validateStackSequences.validateStackSequences(new int[] {1,2,3,4,5}, new int[] {4,5,3,2,1}));
		
		
		System.out.println(
				validateStackSequences.validateStackSequences(new int[] {1,2,3,4,5}, new int[] {4,3,5,1,2}));
			
	}

}
