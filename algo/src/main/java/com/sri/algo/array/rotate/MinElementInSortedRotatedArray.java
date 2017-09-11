package com.sri.algo.array.rotate;

public class MinElementInSortedRotatedArray {

	public static int getMin(int[] arr, int l, int h) {
		if (l == h) {
			return arr[l];
		}

		// Not rotated at all, Since it is sorted min will be arr[l].
		if (arr[l] < arr[h]) {
			return arr[l];
		}

		int mid = l + (h - l) / 2;

		// Check if mid is the minimum element.
		if (mid > 0 && arr[mid] < arr[mid - 1]) {
			return arr[mid];
		}
		// Check if mid + 1 is the minimum element.
		else if (mid < h && arr[mid + 1] < arr[mid]) {
			return arr[mid + 1];
		}

		else if (arr[mid] > arr[h]) {
			return getMin(arr, mid + 1, h);
		} else {
			return getMin(arr, l, mid - 1);
		}

	}

	public static void main(String[] args) {

		// No rotation.
		System.out.println(getMin(new int[] { 1, 2, 3, 4, 5, 6 }, 0, 5));

		// Rotated by 1
		System.out.println(getMin(new int[] { 6, 1, 2, 3, 4, 5 }, 0, 5));

		// Rotated by 2
		System.out.println(getMin(new int[] { 5, 6, 1, 2, 3, 4 }, 0, 5));

		// Array with 1 Element
		System.out.println(getMin(new int[] { 1 }, 0, 0));

		// Array with 1 Element
		System.out.println(getMin(new int[] { 2, 1 }, 0, 1));

	}

}
