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
	
	public static void main(String[] args) {
		
		System.out.println(atoi("12345"));
	}

}
