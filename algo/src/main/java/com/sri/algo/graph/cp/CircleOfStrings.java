package com.sri.algo.graph.cp;

import java.util.Scanner;

/**
 * Given an array of strings A[ ], determine if the strings can be chained
 * together to form a circle. A string X can be chained together with another
 * string Y if the last character of X is same as first character of Y. If every
 * string of the array can be chained, it will form a circle.
 * 
 * For eg for the array arr[] = {"for", "geek", "rig", "kaf"} the answer will be
 * Yes as the given strings can be chained as "for", "rig", "geek" and "kaf"
 * 
 *
 * 
 */
public class CircleOfStrings {

	static class Chainable {
		boolean val;
	}

	public static boolean isChainable(String[] arr) {
		Chainable chainable = new Chainable();

		permutate(arr, 0, arr.length - 1, chainable);

		return chainable.val;
	}

	/**
	 * Try all permutations and check atleast one of the permutation is chainable.
	 * 
	 * Time Complexity O(n*n!) as there are n! permutations and at each permutation 
	 * we check it is chainable which takes n time.
	 * @param arr
	 * @param l
	 * @param h
	 * @param chainable
	 */
	public static void permutate(String[] arr, int l, int h, Chainable chainable) {

		if (l == h) {
			
			if (isChained(arr)) {
				chainable.val = true;
			}
			return;
		}

		for (int i = l; i <= h; i++) {
			swap(arr, l, i);
			permutate(arr, l+1, h, chainable);
			swap(arr, l, i);

			// The moment we recognize the current permutation is chained stop 
			// permutating further.
			if (chainable.val) {
				return;
			}
		}
	}

	private static void swap(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static boolean isChained(String[] arr) {
		
		if(arr.length == 1)
		{
			return arr[0].charAt(0) == arr[0].charAt(arr[0].length() -1);
		}

		String prev = arr[0];
		String curr = null;

		for (int i = 1; i < arr.length; i++) {
			curr = arr[i];
			if (prev.charAt(prev.length() - 1) != curr.charAt(0)) {
				return false;
			}
			prev = curr;
		}

		if (curr.charAt(curr.length() - 1) != arr[0].charAt(0)) {
			return false;
		}

		return true;
	}
	
	public static void main(String[] args) {
		
		/*String[] input = {"for", "geek", "rig", "kaf"};
		System.out.println(isChainable(input));
		
		String[] input1 = {"abc" ,"bcd", "cdf"};
		System.out.println(isChainable(input1));
		*/
		try (Scanner in = new Scanner(System.in)) {
			int testCount = in.nextInt();

			for (int i = 0; i < testCount; i++) {
				int n = in.nextInt();
				String input = in.nextLine();
				
				while(input.isEmpty())
				{
				    input = in.nextLine();
				}
				
				input.trim();
				String[] arr = input.split(" ");
				if(isChainable(arr))
				{
				    	System.out.print(1);
				}
				else
				{
				    	System.out.println(0);
				}
			

			}
		}
		
	}

}
