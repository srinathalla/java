package com.sri.algo.backtrack.leet;

import com.sri.algo.array.PrintArray;

/**
 *  Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

	Example:
	
	Input: 2
	Output: 91 
	Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100, 
	             excluding 11,22,33,44,55,66,77,88,99
	             
 * @author salla
 *
 */
public class CountNumbersWithUniqueDigits {
	
	  public int countNumbersWithUniqueDigits(int n) {
	        return doCount(n, new boolean[10], 0);
	    }
	    
	    private int doCount(int n, boolean[] used, int d) {
	    	System.out.println("n:" + n + " d:" + d);
	    	PrintArray.print(used);
	    	
	        if (d == n) return 1;
	        int total = 1;
	        for (int i = (d == 0) ? 1 : 0; i <= 9; i++) {
	            if (!used[i]) {
	                used[i] = true;
	                total += doCount(n, used, d + 1);
	                used[i] = false;
	            }
	        }
	        return total;
	    }
	    
	    public static void main(String[] args) {
	    	
	    	CountNumbersWithUniqueDigits countNumbersWithUniqueDigits
			= new CountNumbersWithUniqueDigits();
	    	
	    	System.out.println(
    			countNumbersWithUniqueDigits.countNumbersWithUniqueDigits(2));
		}

}
