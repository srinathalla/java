package com.sri.algo.string;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * Example:
 * 
 * Input: "aab" Output: 1 Explanation: The palindrome partitioning ["aa","b"]
 * could be produced using 1 cut.
 * 
 * 
 * @author salla
 *
 */
public class PalindromeCut {

	/**
	 * recursive solution, there are repeated sub problems ..
	 * 
	 * is a candidate for dynamic programming ..
	 * 
	 * @param s
	 * @return
	 */
	public int minCut(String s) {
		int n = s.length();

		if (n < 2) {
			return 0;
		}

		return minCut(s, 0, n - 1);
	}

	private int minCut(String s, int l, int h) {
		if (isPalindrome(s, l, h)) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int i = l; i < h; i++) {

			int cuts = minCut(s, l, i) + minCut(s, i + 1, h) + 1;
			min = Integer.min(min, cuts);
		}

		return min;

	}

	private boolean isPalindrome(String s, int l, int h) {
		int i = l, j = h;

		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}

			i++;
			j--;
		}

		return true;
	}

	public static void main(String[] args) {
		
		PalindromeCut pc = new PalindromeCut();
		
		System.out.println(pc.minCut("aab"));

	}

}
