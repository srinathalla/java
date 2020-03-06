package com.sri.algo.greedy.leet;

/**
 * Given a non-negative integer N, find the largest number that is less than or
 * equal to N with monotone increasing digits.
 * 
 * (Recall that an integer has monotone increasing digits if and only if each
 * pair of adjacent digits x and y satisfy x <= y.)
 * 
 * Example 1: Input: N = 10 Output: 9
 * 
 * @author srialla
 *
 */
public class MonotoneIncreasingDigits {

	public int monotoneIncreasingDigits(int N) {

		char[] chars = String.valueOf(N).toCharArray();
		int marker = chars.length;
		
		for(int i= chars.length -1; i> 0;i--)
		{
			if(chars[i-1] > chars[i])
			{
				chars[i-1] -=1;
				marker = i;
			}
		}
		
		for(int i= marker; i < chars.length;i++)
		{
			chars[i] = '9';
		}
		
		return Integer.valueOf(new String(chars));
	}
	
	public static void main(String[] args) {
		
		MonotoneIncreasingDigits monotoneIncreasingDigits = new
				MonotoneIncreasingDigits();
		System.out.println(
			monotoneIncreasingDigits.monotoneIncreasingDigits(332));
		
	}

}
