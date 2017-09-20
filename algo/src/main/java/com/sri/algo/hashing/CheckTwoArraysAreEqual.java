package com.sri.algo.hashing;

import java.util.HashSet;
import java.util.Set;

public class CheckTwoArraysAreEqual {

	public static boolean arraysAreEqual(int[] arr1, int[] arr2) {
		if (arr1.length != arr2.length) {
			return false;
		}

		Set<Integer> otherSet = new HashSet<>();

		for (int ele : arr2) {
			otherSet.add(ele);
		}

		for (int ele : arr1) {
			if (!otherSet.contains(ele)) {
				return false;
			}
		}

		return true;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(arraysAreEqual(new int[] {1, 2, 5, 4, 0}, new int[] {2, 4, 5, 0, 1}));
		
		System.out.println(arraysAreEqual(new int[] {1, 2, 5}, new int[] {2, 4, 15}));
		
	}

}
