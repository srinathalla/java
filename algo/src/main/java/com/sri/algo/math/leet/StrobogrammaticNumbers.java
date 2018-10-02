package com.sri.algo.math.leet;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 * 
 * Write a function to count the total strobogrammatic numbers that exist in the
 * range of low <= num <= high.
 * 
 * Example:
 * 
 * Input: low = "50", high = "100" Output: 3 Explanation: 69, 88, and 96 are
 * three strobogrammatic numbers. Note: Because the range might be a large
 * number, the low and high numbers are represented as string.
 * 
 * @author salla
 *
 */
public class StrobogrammaticNumbers {

	private static final char[][] pairs = { { '0', '0' }, { '1', '1' }, { '6', '9' }, { '8', '8' }, { '9', '6' } };

	public int strobogrammaticInRange(String low, String high) {

		int[] count = { 0 };

		for (int len = low.length(); len <= high.length(); len++) {
			dfs(low, high, new char[len], 0, len - 1, count);
		}

		return count[0];
	}

	public void dfs(String low, String high, char[] c, int left, int right, int[] count) {

		if (left > right) {
			String s = new String(c);
			if ((s.length() == low.length() && s.compareTo(low) < 0)
					|| (s.length() == high.length() && s.compareTo(high) > 0)) {
				return;
			}
			System.out.println(s);
			count[0]++;
			return;
		}

		for (char[] p : pairs) {
			c[left] = p[0];
			c[right] = p[1];

			// Include 0 only when length of string is of size 1.
			if (c[0] == '0' && c.length != 1) {
				continue;
			}

			if (left == right && p[0] != p[1]) {
				continue;
			}

			dfs(low, high, c, left + 1, right - 1, count);
		}

	}

	public static void main(String[] args) {

		StrobogrammaticNumbers sn = new StrobogrammaticNumbers();

		System.out.println(sn.strobogrammaticInRange("100", "1000"));
	}

}
