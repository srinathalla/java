package com.sri.algo.string.leet;


/**
 * 	Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

	Any left parenthesis '(' must have a corresponding right parenthesis ')'.
	Any right parenthesis ')' must have a corresponding left parenthesis '('.
	Left parenthesis '(' must go before the corresponding right parenthesis ')'.
	'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
	An empty string is also valid.
	
 * @author salla
 *
 */
public class ValidParanthesisString {

	public boolean checkValidString(String s) {

		int l = 0, h = 0;

		for (char ch : s.toCharArray()) {

			if (ch == '(') {
				l++;
				h++;
			} else if (ch == ')') {
				if (l > 0) {
					l--;
				}

				h--;
			} else {
				if (l > 0) {
					l--;
				}
				h++;
			}

			if (h < 0) {
				return false;
			}
		}

		return l == 0;

	}

	public static void main(String[] args) {
		
		ValidParanthesisString validParanthesisString = new ValidParanthesisString();
		
		System.out.println(
			validParanthesisString.checkValidString("(*))"));

	}

}
