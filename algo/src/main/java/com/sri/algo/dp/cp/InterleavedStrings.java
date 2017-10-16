package com.sri.algo.dp.cp;

/**
 * Given three strings A, B and C. Write a function that checks whether C is an
 * interleaving of A and B. C is said to be interleaving A and B,if it contains
 * all characters of A and B and order of all characters in individual strings
 * is preserved.
 *
 */
public class InterleavedStrings {

	/**
	 * Time Complexity is O(2^n)
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static boolean isInterLeave(String a, String b, String c) {

		return isInterLeave(a, b, c, a.length(), b.length(), c.length());
	}

	public static boolean isInterLeave(String a, String b, String c, int i, int j, int k) {

		if (i == 0 && j == 0 && k == 0) {
			return true;
		}

		if (k == 0) {
			return false;
		}

		return (i > 0 && a.charAt(i - 1) == c.charAt(k - 1) && isInterLeave(a, b, c, i - 1, j, k - 1))
				|| (j > 0 && b.charAt(j - 1) == c.charAt(k - 1) && isInterLeave(a, b, c, i, j - 1, k - 1));

	}

	public static boolean isInterLeaveWithDP(String a, String b, String c) {

		int n = a.length();
		int m = b.length();

		boolean[][] table = new boolean[n + 1][m + 1];

		// base case.

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {

				if (i == 0 && j == 0) {
					table[i][j] = true;
				}

				else if (i == 0 && b.charAt(j - 1) == c.charAt(j - 1)) {
					table[i][j] = table[i][j - 1];
				}

				else if (j == 0 && a.charAt(i - 1) == c.charAt(i - 1)) {
					table[i][j] = table[i - 1][j];
				}

				else if (i > 0 && j > 0 && a.charAt(i - 1) == c.charAt(i + j - 1)
						&& b.charAt(j - 1) == c.charAt(i + j - 1)) {
					table[i][j] = table[i - 1][j] || table[i][j - 1];
				}

				else if (i > 0 && a.charAt(i - 1) == c.charAt(i + j - 1)) {
					table[i][j] = table[i - 1][j];
				}

				else if (j > 0 && b.charAt(j - 1) == c.charAt(i + j - 1)) {
					table[i][j] = table[i][j - 1];
				}

			}
		}

		return table[n][m];

	}

	public static void main(String[] args) {

		System.out.println(isInterLeaveWithDP("YX", "X", "XXY"));
		System.out.println(isInterLeaveWithDP("XY", "X", "XXY"));
		System.out.println(isInterLeaveWithDP("YXXYXX", "YYYXX", "YXXYYXXXXYX"));

		System.out.println(isInterLeaveWithDP("aab", "axy", "aaxaby"));
		System.out.println(isInterLeaveWithDP("YXY", "XYXYX", "XXXXYYXY"));
		System.out.println(isInterLeaveWithDP("XXXXY", "YXXXY", "XYXXXXYXXY"));

	}
}
