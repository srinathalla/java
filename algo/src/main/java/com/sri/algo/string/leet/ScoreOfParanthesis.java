package com.sri.algo.string.leet;


/**
*   Given a balanced parentheses string S, compute the score of the string based 
*   on the following rule:

	() has score 1
	AB has score A + B, where A and B are balanced parentheses strings.
	(A) has score 2 * A, where A is a balanced parentheses string.
 * @author salla
 *
 */
public class ScoreOfParanthesis {

	public int scoreOfParentheses(String S) {

		int ans = 0, bal = 0;

		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			if (ch == '(') {
				bal++;
			} else {
				bal--;

				if (S.charAt(i - 1) == '(') {
					ans += 1 << bal;
				}
			}
		}

		return ans;
    }

    
    public static void main(String[] args) {
    	
    	ScoreOfParanthesis scoreOfParanthesis = new 
    			ScoreOfParanthesis();
    	
    	System.out.println(
			scoreOfParanthesis.scoreOfParentheses("(()(()))"));
    	
    	System.out.println(
    			scoreOfParanthesis.scoreOfParentheses("()(())"));
		
	}

}
