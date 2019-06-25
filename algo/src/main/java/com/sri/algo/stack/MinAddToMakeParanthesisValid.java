package com.sri.algo.stack;

public class MinAddToMakeParanthesisValid {
	
/**
	 * Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses 
	 * ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.

	Formally, a parentheses string is valid if and only if:
	
	It is the empty string, or
	It can be written as AB (A concatenated with B), where A and B are valid strings, or
	It can be written as (A), where A is a valid string.
	Given a parentheses string, return the minimum number of parentheses we must add to make the 
	resulting string valid.

 
 * @param S
 * @return
 */
    public int minAddToMakeValid(String s) {
	
		int ans =0, bal =0;
		
		for (char ch : s.toCharArray())
		{
			
			bal += ch == '(' ? 1 : -1;
			
			if (bal < 0)
			{
				ans++;
				bal++;
			}
		}
		
		return ans + bal;
        
    }
    
    public static void main(String[] args) {
    	
    	MinAddToMakeParanthesisValid minAddToMakeParanthesisValid = 
    			new MinAddToMakeParanthesisValid();
    	
    	
    	System.out.println(
			minAddToMakeParanthesisValid.minAddToMakeValid("((("));
    	System.out.println(minAddToMakeParanthesisValid.minAddToMakeValid(")))"));
    	System.out.println(minAddToMakeParanthesisValid.minAddToMakeValid("((())("));
    	System.out.println(minAddToMakeParanthesisValid.minAddToMakeValid("((())()"));
		
	}

}
