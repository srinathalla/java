package com.sri.algo.backtrack.leet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * 
 * @author salla
 *
 */
public class GenerateParanthesis {

	Set<String> result;

	public List<String> generateParenthesisUsingPermutation(int n) {

		result = new HashSet<>();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append('(').append(')');
		}

		generateParanthesis(sb.toString().toCharArray(),0,0);

		return new ArrayList<>(result);

	}

	private boolean isValid(char[] input) {
		int count = 0;

		for (char ch : input) {
			if (ch == '(') {
				count++;
			} else {
				count--;
			}

			if (count < 0) {
				return false;
			}
		}

		return true;
	}

	private void generateParanthesis(char[] input, int l,int sum) {
		
		if (sum < 0) {
			return;
		}

		if (l == input.length) {

			if (isValid(input)) {
				result.add(new String(input));
			}
			return;
		}

		for (int i = l; i < input.length; i++) {
			char tmp = input[l];
			input[l] = input[i];
			input[i] = tmp;

			generateParanthesis(input, l + 1, input[l] == '(' ? sum + 1 : sum - 1);

			tmp = input[l];
			input[l] = input[i];
			input[i] = tmp;
		}

	}
	
	List<String> res;
	public List<String> generateParenthesisWithOpenClosed(int n) {

		res = new ArrayList<>();

		generateParenthesis("", 0, 0,n);

		return res;
	}

	public void generateParenthesis(String input, int open, int closed, int n) {
		
		System.out.println("input: " + input + " open: " + open + " closed: " + closed + " n:" + n);

		if (input.length() == 2 * n) {
			res.add(input);
			return;
		}

		if (open < n) {
			generateParenthesis(input + '(', open + 1, closed, n);
		}

		if (closed < open) {
			generateParenthesis(input + ')', open, closed + 1, n);
		}

	}
	
	public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();
		
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left: generateParenthesis(c))
                {
                	 System.out.println("left:" + left);
                    for (String right: generateParenthesis(n-1-c))
                    {
                    	 System.out.println("right:" + right);
                        ans.add("(" + left + ")" + right);
                    }
                }
        }
        
       
        return ans;
    }
	
	public static void main(String[] args) {
		
		GenerateParanthesis generateParanthesis = new GenerateParanthesis();
		
		
		System.out.println(generateParanthesis.generateParenthesis(2));
		
	}

}
