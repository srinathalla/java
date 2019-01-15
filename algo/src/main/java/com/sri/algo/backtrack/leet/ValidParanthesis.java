package com.sri.algo.backtrack.leet;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 	Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

	An input string is valid if:
	
	Open brackets must be closed by the same type of brackets.
	Open brackets must be closed in the correct order.
	Note that an empty string is also considered valid.
	
	Example 1:
	
	Input: "()"
	Output: true
	Example 2:
	
	Input: "()[]{}"
	Output: true
	Example 3:
	
	Input: "(]"
	Output: false
	 * @author salla
	 *
 */
public class ValidParanthesis {
	
	
	 public boolean isValid(String s) {
		 
		 Map<Character, Character> map = new HashMap<>();
		 map.put(')', '(');
		 map.put(']', '[');
		 map.put('}', '{');
		 
		 Stack<Character> stack = new Stack<>();
		 
		 for (char ch : s.toCharArray())
		 {
			 if (map.containsKey(ch))
			 {	 
				 if(stack.isEmpty() || stack.pop() != map.get(ch))
				 {
					 return false;
				 }
			 }
			 else
			 {
				stack.push(ch);
			 }
		 }
		 
		 return stack.isEmpty();
		         
	}

}
