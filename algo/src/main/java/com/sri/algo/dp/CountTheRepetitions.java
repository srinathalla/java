package com.sri.algo.dp;

/**
 * Define S = [s,n] as the string S which consists of n connected strings s. For
 * example, ["abc", 3] ="abcabcabc".
 * 
 * On the other hand, we define that string s1 can be obtained from string s2 if
 * we can remove some characters from s2 such that it becomes s1. For example,
 * “abc” can be obtained from “abdbec” based on our definition, but it can not
 * be obtained from “acbbe”.
 * 
 * You are given two non-empty strings s1 and s2 (each at most 100 characters
 * long) and two integers 0 ≤ n1 ≤ 106 and 1 ≤ n2 ≤ 106. Now consider the
 * strings S1 and S2, where S1=[s1,n1] and S2=[s2,n2]. Find the maximum integer
 * M such that [S2,M] can be obtained from S1.
 * 
 * Example:
 * 
 * Input: s1="acb", n1=4 s2="ab", n2=2
 * 
 * Return: 2
 * 
 * @author salla
 *
 */
public class CountTheRepetitions {

	/**
	 * Brute force solution ..
	 * 
	 *  Observations string is converted to char array..
	 *  
	 * @param s1
	 * @param n1
	 * @param s2
	 * @param n2
	 * @return
	 */
	public int getMaxRepetitions(String s1, int n1, String s2, int n2) {

	
		int i = 0, j = 0;
		int count2 = 0;
		int count1 = 0;

		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();

		while (count1 < n1) {
			if (arr1[i] == arr1[j]) {
				j++;

				if (j == arr2.length) {
					count2++;
					j = 0;
				}
			}

			i++;
			if (i == arr1.length) {
				i = 0;
				count1++;
			}
		}

		return count2 / n2;

	}

	public static void main(String[] args) {

		CountTheRepetitions cr = new CountTheRepetitions();

		System.out.println(cr.getMaxRepetitions("acb", 4, "ab", 2));

		System.out.println(cr.getMaxRepetitions("acb", 1, "acb", 1));

		// this needs to be revisited as it prints 3 where as it is 4..
		System.out.println(cr.getMaxRepetitions("aaa", 3, "aa", 1));

	}

}
