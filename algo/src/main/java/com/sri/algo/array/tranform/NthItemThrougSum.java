package com.sri.algo.array.tranform;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given two sorted arrays, we can get a set of sums(add one element from the
 * first and one from second). Find the N’th element in the set considered in
 * sorted order. Note: Set of sums should have unique elements.
 * 
 * Input : arr1[] = {1, 2}
        arr2[] = {3, 4}
        N = 3
	Output : 6
	We get following elements set of sums.
	4(1+3), 5(2+3 or 1+4), 6(2+4)
	Third element in above set is 6.
 *
 *
 */
public class NthItemThrougSum {

	public static int sum(int[] arr1, int[] arr2, int k) {

		if (arr1.length == 0 && k < arr2.length) {
			return arr2[k - 1];
		}

		if (arr2.length == 0 && k < arr1.length) {
			return arr1[k - 1];
		}

		Set<Integer> sortedNos = new TreeSet<>();
		for (int no1 : arr1) {
			for (int no2 : arr2) {
				sortedNos.add(no1 + no2);
			}
		}

		int i = 0;
		for (int no : sortedNos) {
			i++;

			if (i == k) {
				return no;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		/*int[] a = new int[] { 1, 2 };
		int[] b = new int[] { 3, 4 };

		System.out.println(sum(a, b,3));*/
	
			try (Scanner in = new Scanner(System.in)) {
				int testCount = in.nextInt();

				for (int i = 0; i < testCount; i++) {
					int n = in.nextInt();
					int m = in.nextInt();
					int[] arr = new int[n];

					for (int j = 0; j < n; j++) {
						arr[j] = in.nextInt();
					}
					
					int[] arr1 = new int[m];

					for (int j = 0; j < m; j++) {
						arr1[j] = in.nextInt();
					}

					System.out.println(sum(arr, arr1, in.nextInt()));

				}
			}
		

	}

}
