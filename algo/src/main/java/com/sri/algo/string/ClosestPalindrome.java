package com.sri.algo.string;

/**
 * Given an integer n, find the closest integer (not including itself), which is
 * a palindrome.
 * 
 * The 'closest' is defined as absolute difference minimized between two
 * integers.
 * 
 * Example 1: Input: "123" Output: "121" Note: The input n is a positive integer
 * represented by string, whose length will not exceed 18. If there is a tie,
 * return the smaller one as answer.
 * 
 * @author salla
 *
 */
public class ClosestPalindrome {

	public String nearestPalindromic(String n) {

		StringBuilder sb = new StringBuilder();

		int len = n.length(), i, j;
		
		if (len == 1)
		{
			sb.append(Integer.valueOf(n) -1);
			return sb.toString();
		}
		int mid = len / 2;

		if ((len & 1) == 1) {
			i = mid - 1;
			j = mid + 1;
			sb.append(n.charAt(mid));
		} else {
			i = mid - 1;
			j = mid;
		}

		while (i >= 0 && j < len) {

			if (n.charAt(i) == n.charAt(j)) {
				sb.insert(0, n.charAt(i--));
				sb.append(n.charAt(j++));
			} else {
				sb.insert(0, n.charAt(i));
				sb.append(n.charAt(i));
				i--;
				j++;
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		ClosestPalindrome cp = new ClosestPalindrome();
		
		System.out.println(cp.nearestPalindromic("1234"));
		System.out.println(cp.nearestPalindromic("1"));
		
	}

}
