package com.sri.algo.math.leet;

/**
 * Let's say a positive integer is a superpalindrome if it is a palindrome, and
 * it is also the square of a palindrome.
 * 
 * Now, given two positive integers L and R (represented as strings), return the
 * number of superpalindromes in the inclusive range [L, R].
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: L = "4", R = "1000" Output: 4 Explanation: 4, 9, 121, and 484 are
 * superpalindromes. Note that 676 is not a superpalindrome: 26 * 26 = 676, but
 * 26 is not a palindrome.
 * 
 * 
 * Note:
 * 
 * 1 <= len(L) <= 18 1 <= len(R) <= 18 L and R are strings representing integers
 * in the range [1, 10^18). int(L) <= int(R)
 * 
 * @author salla
 *
 */
public class SuperPalindromes {

	/**
	 * Complexity Analysis
	 * 
	 * Time Complexity: O((W ^​ ​1/4) ∗logW), where W = W=10^ ​18 ​​ is our upper
	 * limit for RR. The WlogW term comes from checking whether each candidate
	 * is the root of a palindrome.
	 * 
	 * Space Complexity: O(logW), the space used to create the candidate palindrome.
	 * 
	 * @param sL
	 * @param sR
	 * @return
	 */
	public int superpalindromesInRange(String sL, String sR) {

		long L = Long.valueOf(sL);
		long R = Long.valueOf(sR);
		int MAGIC = (int) Math.pow(10, 18 * 0.25);
		int ans = 0;

		for (int k = 1; k < MAGIC; k++) {

			StringBuilder sb = new StringBuilder(Integer.toString(k));

			for (int i = sb.length() - 2; i >= 0; i--) {
				sb.append(sb.charAt(i));
			}

			long v = Long.parseLong(sb.toString());

			v *= v;

			if (v > R) {
				break;
			}

			if (v >= L && isPalindrome(v)) {
				ans++;
			}
		}

		for (int k = 1; k < MAGIC; k++) {

			StringBuilder sb = new StringBuilder(Integer.toString(k));

			for (int i = sb.length() - 1; i >= 0; i--) {
				sb.append(sb.charAt(i));
			}

			long v = Long.parseLong(sb.toString());

			v *= v;

			if (v > R) {
				break;
			}

			if (v >= L && isPalindrome(v)) {
				ans++;
			}
		}

		return ans;
	}

	public boolean isPalindrome(long x) {
		return x == reverse(x);
	}

	public long reverse(long x) {
		long ans = 0;

		while (x > 0) {
			ans = ans * 10 + x % 10;

			x /= 10;
		}

		return ans;
	}

	public static void main(String[] args) {

		SuperPalindromes sp = new SuperPalindromes();

		System.out.println(sp.superpalindromesInRange("4", "1000"));
		
		System.out.println(Math.pow(10, 18 * 0.25));

	}

}
