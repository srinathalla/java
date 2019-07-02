package com.sri.algo.array.leet;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.

	Example 1:
	
	Input: [10,2]
	Output: "210"
	Example 2:
	
	Input: [3,30,34,5,9]
	Output: "9534330"
 * @author salla
 *
 */
public class LargestNumber {
	
	private class LargerNumberComparator implements Comparator<String> {
		@Override
		public int compare(String a, String b) {

			String o1 = a + b;
			String o2 = b + a;

			return o2.compareTo(o1);
		}
	}

	public String largestNumber(int[] nums) {

		String[] nos = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			nos[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(nos, new LargerNumberComparator());
		
		if(nos[0].equals("0"))
		{
			return "0";
		}

		StringBuilder sb = new StringBuilder();
		for (String no : nos) {
			sb.append(no);
		}

		return sb.toString();
	}
	    
	    
	    public static void main(String[] args) {
	    	
	    	LargestNumber largestNumber = new 
	    			LargestNumber();
	    	
	    	/*System.out.println(
    			largestNumber.largestNumber(new int[] {3,30,34,5,9}));*/
	    	
	    	System.out.println(
	    			largestNumber.largestNumber(new int[] {0, 0}));
			
		}

}
