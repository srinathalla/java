package com.sri.algo.stack;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string may contain open ( and closing parentheses ), the plus
 * + or minus sign -, non-negative integers and empty spaces .
 * 
 * Example 1:
 * 
 * Input: "1 + 1" Output: 2 Example 2:
 * 
 * Input: " 2-1 + 2 " Output: 3 Example 3:
 * 
 * Input: "(1+(4+5+2)-3)+(6+8)" Output: 23
 * 
 * @author salla
 *
 */
public class BasicCalculator {

	
	/**
	 * T.C O(n)
	 * @param s
	 * @return
	 */
	public int calculate(String s) {

		int result = 0, number = 0, sign = 1;
		Stack<Integer> stack = new Stack<>();

		for (char ch : s.toCharArray()) {

			if (Character.isDigit(ch)) {
				number = 10 * number + (int) (ch - '0');
			} else if (ch == '+') {
				result += sign * number;
				sign = 1;
				number = 0;
			} else if (ch == '-') {
				result += sign * number;
				sign = -1;
				number = 0;
			} else if (ch == '(') {

				stack.push(result);
				stack.push(sign);

				result = 0;
				sign = 1;
				number = 0;
			} else if (ch == ')') {
				result += sign * number;

				result = result * stack.pop();

				result += stack.pop();
				sign = 1;
				number = 0;
			}
		}

		result += sign * number;

		return result;
	}

	public static void main(String[] args) {

		BasicCalculator bc = new BasicCalculator();

		/*
		 * System.out.println(bc.calculate("1 + 1"));
		 * 
		 * System.out.println(bc.calculate(" 2-1 + 2 "));
		 */

		System.out.println(bc.calculate("(1+(4+5+2)-3)+(6+8)"));

	}

}
