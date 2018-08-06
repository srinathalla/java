package com.sri.algo.array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Input: A = [1], K = 1 Output: 1 Example 2:
 * 
 * Input: A = [1,2], K = 4 Output: -1 Example 3:
 * 
 * Input: A = [2,-1,2], K = 3 Output: 3
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 50000 -10 ^ 5 <= A[i] <= 10 ^ 5 1 <= K <= 10 ^ 9
 * 
 * @author salla
 *
 */
public class ShortestSubArrayWithSumAtleastK {

	/**
	 * Naive approach with trying all sub arrays.. T.C : O(n*n)
	 * 
	 * @param A
	 * @param K
	 * @return
	 */
	public int shortestSubarrayNaive(int[] A, int K) {

		int n = A.length;

		int minLen = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {

			long sum = 0;
			for (int j = i; j < n; j++) {

				sum += A[j];

				if (sum >= K) {
					minLen = Integer.min(minLen, j - i + 1);
					break;
				}

			}
		}
		return minLen != Integer.MAX_VALUE ? minLen : -1;
	}

	/**
	 * T.C O(n)
	 * 
	 * @param A
	 * @param K
	 * @return
	 */
	public int shortestSubarray(int[] A, int K) {
		int n = A.length;

		if (n == 0) {
			return K == 0 ? 0 : -1;
		}

		if (n == 1) {
			return K <= A[0] ? 1 : -1;
		}

		int min = n + 1; // impossible as the size is max n.
		int[] p = new int[n];
		p[0] = A[0];
		
		for (int i = 1; i < n; i++) {
			p[i] = p[i - 1] + A[i];
		}

		Deque<Integer> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {

			while (!q.isEmpty() && p[i] <= p[q.peekLast()]) {
				q.removeLast(); // we need to keep the increasing sequence ..
			}

			while (!q.isEmpty() && p[i] >= p[q.peekFirst()] + K) {
				min = Integer.min(min, i - q.removeFirst());
			}

			q.addLast(i);
		}

		return min < n + 1 ? min : -1;

	}

	public static void main(String[] args) {

		ShortestSubArrayWithSumAtleastK shortestSubArrar = new ShortestSubArrayWithSumAtleastK();

		/*
		 * System.out.println(shortestSubArrar.shortestSubarraySlidingWindow(new int[] {
		 * 1 }, 1));
		 * System.out.println(shortestSubArrar.shortestSubarraySlidingWindow(new int[] {
		 * 1, 2 }, 4));
		 * 
		 * System.out.println(shortestSubArrar.shortestSubarraySlidingWindow(new int[] {
		 * 2, -1, 2 }, 3));
		 */

		System.out.println(shortestSubArrar.shortestSubarray(new int[] { 84, -37, 32, 40, 95 }, 167));

	}

}
