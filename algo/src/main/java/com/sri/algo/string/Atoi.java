package com.sri.algo.string;

public class Atoi {
	
	public static int atoi(String s)
	{
		int result = 0;
		for (char ch : s.toCharArray())
		{
			result = result * 10 + Character.getNumericValue(ch);
		}
		
		return result;
	}
	
	  public static int myAtoi(String str) {
	        
	        int res = 0; 	
	    	int i =0; 
	        
	    	// is string empty or null.
	        if (str == null || str.length() == 0)
	    	{
	    		return 0;
	    	}
	    	
			char[] chars = str.toCharArray();
			
			// strip white spaces.
			while (i < chars.length && chars[i] == ' ') {
				i++;
			}

			int sign = 1;
			// modify sign.
			if (i < chars.length && (chars[i] == '-' || chars[i] == '+')) {
				sign = chars[i++] == '-' ? -1 : 1;
			}
	    	
	    	while (i < chars.length)
	    	{	
	    		int digit  = chars[i] - '0';	
	    		
	    		// break when a character is not digit.
	    		if (digit < 0 || digit > 9)
	    		{
	    			break;
	    		}
	    		
	    		// If the result is going out of range, return Integer.Max or Integer.Min based on the sign.
	    		if (Integer.MAX_VALUE/10 < res || (Integer.MAX_VALUE/10 == res && Integer.MAX_VALUE % 10 < digit))
	    		{
	    			return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
	    		}
	    		res = res * 10 + digit;
	    		i++;
	    	}
	    	
	    	return res * sign;
	        
	    }
	
	public static void main(String[] args) {
		
	
			// System.out.println(myAtoi("42"));
			
			 // System.out.println(myAtoi("4193 with words"));
			
			System.out.println(myAtoi("words and 987"));
			
			// System.out.println(myAtoi("-4193 with words"));
			
			// System.out.println(myAtoi("-91283472332"));
	}

}
