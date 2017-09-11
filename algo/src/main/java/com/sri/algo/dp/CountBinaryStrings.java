package com.sri.algo.dp;

import java.util.ArrayList;
import java.util.List;

public class CountBinaryStrings {

	/**
	 * Time Complexity O(n).
	 * TODO : Need to implement this in O(logn) time.
	 * @param n
	 * @return
	 */
	public static int countStrings(int n) {
		// a[i] stores binary Strings of length i + 1 ending with 0;
		int[] a = new int[n];

		// b[i] stores binary Strings of length i + 1 ending with 1;
		int[] b = new int[n];

		List<String> prevaList = new ArrayList<>();
		List<String> prevbList = new ArrayList<>();

		// base cases
		a[0] = 1;
		b[0] = 1;

		prevaList.add("0");
		prevbList.add("1");

		for (int i = 1; i < n; i++) {

			a[i] = a[i - 1] + b[i - 1];
			b[i] = a[i - 1];

			// Use to store actual Strings.
			List<String> curraList = new ArrayList<>();
			List<String> currbList = new ArrayList<>();

			for (String s : prevaList) {
				curraList.add(s + "0");
				currbList.add(s + "1");
			}

			for (String s : prevbList) {
				curraList.add(s + "0");
			}

			prevaList = curraList;
			prevbList = currbList;
		}

		printList(prevaList);
		printList(prevbList);

		return a[n - 1] + b[n - 1];
	}

	private static void printList(List<String> list) {
		for (String s : list) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {

		System.out.println(countStrings(5));
	}

}
