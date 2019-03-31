package com.sri.algo.bit;

import com.sri.algo.array.PrintArray;

/**
 *  Given a non negative integer number num. 
 *  For every numbers i in the range 0 ≤ i ≤ num calculate the number 
 *  of 1's in their binary representation and return them as an array.

	Example 1:
	
	Input: 2
	Output: [0,1,1]
 * @author salla
 *
 */
public class CountBits {
	
	/**
	 * 	T.C :  O(nk) For each integer x, we need O(k)
	 *  operations where k is the number of bits in x.
	 *  
	 *  S.C : O(n)
	 * @param num
	 * @return
	 */
	 public int[] countBits(int num) {
	        int[] ans = new int[num + 1];
	        
	        for (int i=0; i <= num; i++)
	        {
	        	ans[i] = popcount(i);
	        }
	        
	        return ans;
	    }
	 
	 
	    private int popcount(int x) {
	    	
	    	int c = 0;
	    	
	    	for (c=0; x != 0; c++)
	    	{
	    		x &= x-1;
	    	}
	    	
	    	return c;
	      
	    }
	    
	    public static void main(String[] args) {
	    	
	    	
	    	CountBits countBits = new CountBits();
	    	
	    	int[] res = countBits.countBits(10);
	    	
	    	PrintArray.print(res);
	    	
	    	
			
		}

}
