package com.sri.algo.hashing.leet;

import java.util.HashMap;
import java.util.Map;

import com.sri.algo.array.PrintArray;

/**
 * Given two lists Aand B, and B is an anagram of A. B is an anagram of A means
 * B is made by randomizing the order of the elements in A.
 * 
 * We want to find an index mapping P, from A to B. A mapping P[i] = j means the
 * ith element in A appears in B at index j.
 * 
 * These lists A and B may contain duplicates. If there are multiple answers,
 * output any of them.
 * 
 * For example, given
 * 
 * A = [12, 28, 46, 32, 50] B = [50, 12, 32, 46, 28] We should return [1, 4, 3,
 * 2, 0] as P[0] = 1 because the 0th element of A appears at B[1], and P[1] = 4
 * because the 1st element of A appears at B[4], and so on. Note:
 * 
 * A, B have equal lengths in range [1, 100]. A[i], B[i] are integers in range
 * [0, 10^5].
 * 
 * @author salla
 *
 */
public class FindAnangramMappings {

	/**
	 * T.C : O(n)
	 * S.C : O(n)
	 * @param A
	 * @param B
	 * @return
	 */
	public int[] anagramMappings(int[] A, int[] B) {

		Map<Integer, Integer> numerToIndexMap = new HashMap<>();

		for (int i = 0; i < B.length; i++) {
			numerToIndexMap.put(B[i], i);
		}

		int[] p = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			p[i] = numerToIndexMap.get(A[i]);
		}

		return p;
	}

	public static void main(String[] args) {

		FindAnangramMappings am = new FindAnangramMappings();

		int[] result = am.anagramMappings(new int[] { 12, 28, 46, 32, 50 }, new int[] { 50, 12, 32, 46, 28 });

		PrintArray.print(result);
	}
}
