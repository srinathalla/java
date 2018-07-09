package com.sri.algo.string;

import com.sri.algo.array.PrintArray;

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
	public int minCutWithRecursion(String s) {
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

	/**
	 * T.C : O (n * n) .. Auxiallary space : O(n).
	 * 
	 * @param s
	 * @return
	 */
	public int minCut(String s) {
		int len = s.length();

		int[] cuts = new int[len];

		if (len < 2) {
			return 0;
		}

		for (int i = 0; i < len; i++) {
			cuts[i] = i;
		}

		for (int i = 0; i < len; i++) {
			extend(s, i, i, cuts);
			extend(s, i, i + 1, cuts);
		}

		// System.out.println(Arrays.toString(f));
		return cuts[len - 1];
	}

	private void extend(String s, int left, int right, int[] cuts) {

		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {

			if (left == 0) {
				// sub string 0 ..right is a palinndrome, no cuts are required ..
				cuts[right] = 0;
			} else {
				cuts[right] = Integer.min(cuts[right], cuts[left - 1] + 1);
			}
			left--;
			right++;
		}

	}

	public static void main(String[] args) {

		PalindromeCut pc = new PalindromeCut();

		System.out.println(pc.minCut("aab"));

	}

}
