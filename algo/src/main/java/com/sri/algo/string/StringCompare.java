package com.sri.algo.string;

import java.util.Scanner;

/**
 * In a native language the increasing order of priority of characters is a, b,
 * c, d, e, f, g, h, i, j, k, l, m, n, ’ng’ , o, p, q, r, s, t, u, v, w, x, y,
 * z. You are given two strings string1 and string2 and your task is to compare
 * them on the basis of the given priority order.
 * 
 * Print ‘0’ if both the strings are equal, ‘1’ if string1 is greater than
 * string2 and ‘-1’ if string1 is lesser than string2. All the strings consist
 * of lowercase English alphabets only.
 * 
 *
 *	3
	adding addio
	
	abcng abcno
	
	abngc abngc

	Output:

	-1

	1

	0
 */
public class StringCompare {

	public static int compare(String s1, String s2) {
		if (s1 == null && s2 == null) {
			return 0;
		}

		if (s1 == null) {
			return -1;
		}
		if (s2 == null) {
			return 1;
		}

		int m = s1.length();
		int n = s2.length();
		int i = 0;
		int j = 0;

		while (i < m && j < n) {

			while (i < m && j < n && s1.charAt(i) == s2.charAt(j)) {
				i++;
				j++;
			}

			if (i < m && j < n) {

				if (i > 0 && s1.charAt(i) == 'g' && s1.charAt(i - 1) == 'n') {
					return 1;
				}

				if (j > 0 && s2.charAt(j) == 'g' && s2.charAt(j - 1) == 'n') {
					return -1;
				}

				int diff = s1.charAt(i) - s2.charAt(j);

				return diff > 0 ? 1 : (diff < 0 ? -1 : 0);
			}

			return i < m ? 1 : (j < n ? -1 : 0);
		}

		return -1;
	}

	public static void main(String[] args) {

		/*
		 * System.out.println(compare("adding", "addio"));
		 * System.out.println(compare("abcng", "abcno"));
		 * System.out.println(compare("abngc", "abngc"));
		 */

		try (Scanner in = new Scanner(System.in)) {
			int testCount = in.nextInt();

			for (int i = 0; i < testCount; i++) {

				String s = in.nextLine();

				while (s.isEmpty()) {
					s = in.nextLine();
				}
				s.trim();
				String[] strArr = s.split(" ");

				System.out.print(compare(strArr[0], strArr[1]));
				System.out.println();
			}
		}
	}

}
