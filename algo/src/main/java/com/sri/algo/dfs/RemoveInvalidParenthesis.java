package com.sri.algo.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Remove the minimum number of invalid parentheses in order to make the input
 * string valid. Return all possible results.
 * 
 * Note: The input string may contain letters other than the parentheses ( and
 * ).
 * 
 * Example 1:
 * 
 * Input: "()())()" Output: ["()()()", "(())()"]
 * 
 * @author srialla
 *
 */
public class RemoveInvalidParenthesis {

	public List<String> removeInvalidParentheses(String s) {
		List<String> output = new ArrayList<>();
		removeHelper(s, output, 0, 0, '(', ')');
		return output;
	}

	public void removeHelper(String s, List<String> output, int is, int js, char open, char closed) {

		int numopen = 0, numclosed = 0;

		for (int i = is; i < s.length(); i++) {

			if (s.charAt(i) == open) {
				numopen++;
			}
			if (s.charAt(i) == closed) {
				numclosed++;
			}

			if (numclosed > numopen) {
				for (int j = js; j <= i; j++) {
					if (s.charAt(j) == closed && (j == js || s.charAt(j - 1) != closed)) {
						removeHelper(s.substring(0, j) + s.substring(j + 1), output, i, j, open, closed);
					}

				}
				return;
			}
		}
		s = new StringBuilder(s).reverse().toString();
		if (open == '(') {
			removeHelper(s, output, 0, 0, closed, open);
		} else {
			output.add(s);
		}

	}

	public static void main(String[] args) {

		RemoveInvalidParenthesis removeInvalidParenthesis = new RemoveInvalidParenthesis();
		System.out.println(removeInvalidParenthesis.removeInvalidParentheses("()))"));

	}

}
