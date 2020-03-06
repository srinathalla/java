package com.sri.algo.bit;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND
 * of all numbers in this range, inclusive.
 * 
 * Example 1:
 * 
 * Input: [5,7] Output: 4
 */
public class BitwiseANDofNumbersRange {
	
	public int rangeBitwiseAnd(int m, int n) {
        
		if(m == 0)
		{
			return 0;
		}
		
		int i = 0;
		while(m != n)
		{
			m >>= 1;
			n >>= 1;
			i++;
		}
		
		return m << i;
    }
	
	public static void main(String[] args) {
		
		BitwiseANDofNumbersRange bitwiseANDofNumbersRange = new BitwiseANDofNumbersRange();
		System.out.println(
			bitwiseANDofNumbersRange.rangeBitwiseAnd(7,9));
		
	}



}
