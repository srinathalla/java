package com.sri.algo.string.leet;

public class MaxDepth {
	
	 public int maxDepth(String s) {
	        
	        int depth = 0;
	        int res = 0;
	        
	        for(char c : s.toCharArray())
	        {
	            if(c == '(')
	            {
	                depth++;
	                res = Math.max(res, depth);
	            }
	            else if(c == ')')
	            {
	                depth--;
	            }
	        }
	    
	        return res;
	        
	    }
	 
	 public static void main(String[] args) {
		 
		 String s = "(1+(2*3)+((8)/4))+1";
		 MaxDepth md = new MaxDepth();
		 md.maxDepth(s);
		
	}

}
