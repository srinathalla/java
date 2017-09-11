package com.sri.algo.array.rotate;

public class RotationCountInSortedRotatedArray {
	
	public static int getRotationCount(int[] arr, int l, int h) {
		if (l == h) {
			return l;
		}

		// Not rotated at all, Since it is sorted rotation count will be 0.
		if (arr[l] < arr[h]) {
			return l;
		}

		int mid = l + (h - l) / 2;

		// Check if mid is the minimum element, 
		// index of mid gives the rotation count.
		if (mid > 0 && arr[mid] < arr[mid - 1]) {
			return mid;
		}
		// Check if mid + 1 is the minimum element.
		else if (mid < h && arr[mid + 1] < arr[mid]) {
			return mid + 1;
		}

		// Min element has to be in the right portion of mid.
		else if (arr[mid] > arr[h]) {
			return getRotationCount(arr, mid + 1, h);
		} else {
			//  min element has to be in left portion of mid.
			return getRotationCount(arr, l, mid - 1);
		}

	}

	public static void main(String[] args) {

		// No rotation.
		System.out.println(getRotationCount(new int[] { 1, 2, 3, 4, 5, 6 }, 0, 5));

		// Rotated by 1
		System.out.println(getRotationCount(new int[] { 6, 1, 2, 3, 4, 5 }, 0, 5));

		// Rotated by 2
		System.out.println(getRotationCount(new int[] { 5, 6, 1, 2, 3, 4 }, 0, 5));

		// Array with 1 Element
		System.out.println(getRotationCount(new int[] { 1 }, 0, 0));

		// Array with 1 Element
		System.out.println(getRotationCount(new int[] { 2, 1 }, 0, 1));

	}


}
