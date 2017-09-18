package com.sri.algo.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class RelativeSorting {

	/**
	 * Time Complexity O(nlongn) where n is size of a1.
	 * 
	 * Auxillary space O(n).
	 * 
	 * @param a1
	 * @param a2
	 */
	public static void relativeSort(int[] a1, int[] a2) {

		final Map<Integer, Integer> noToIndexMap = new HashMap<>();

		for (int index = 0; index < a2.length; index++) {
			noToIndexMap.put(a2[index], index);
		}

		Integer[] integerArray = intToIntegerArray(a1);

		Comparator<Integer> relSortComparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {

				// If both keys are present element in a2 then they should be ordered
				// based on their indexes.
				if (noToIndexMap.containsKey(o1) && noToIndexMap.containsKey(o2)) {
					return noToIndexMap.get(o1).intValue() - noToIndexMap.get(o2).intValue();
				}

				if (noToIndexMap.containsKey(o1)) {
					return -1;
				}

				if (noToIndexMap.containsKey(o2)) {
					return 1;
				}

				return o1 - o2;
			}
		};

		Arrays.sort(integerArray, relSortComparator);

		for (int index = 0; index < integerArray.length; index++) {
			a1[index] = Integer.valueOf(integerArray[index]);
		}

	}

	private static Integer[] intToIntegerArray(int[] intArr) {

		Integer[] integerArr = new Integer[intArr.length];

		for (int index = 0; index < intArr.length; index++) {
			integerArr[index] = Integer.valueOf(intArr[index]);
		}

		return integerArr;
	}

	public static void main(String[] args) {

		int[] A1 = new int[] { 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};

		int[] A2 = new int[] { 2, 1, 8, 3 };

		relativeSort(A1, A2);

		for (int a : A1) {
			System.out.print(a + " ");
		}
	}

}
