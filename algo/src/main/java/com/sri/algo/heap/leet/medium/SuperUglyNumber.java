package com.sri.algo.heap.leet.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Write a program to find the nth super ugly number.
 * 
 * Super ugly numbers are positive numbers whose all prime factors are in the
 * given prime list primes of size k.
 * 
 * Example:
 * 
 * Input: n = 12, primes = [2,7,13,19] Output: 32 Explanation:
 * [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 super ugly
 * numbers given primes = [2,7,13,19] of size 4. Note:
 * 
 * 1 is a super ugly number for any given primes. The given numbers in primes
 * are in ascending order. 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000. The
 * nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 * 
 * @author salla
 *
 */
public class SuperUglyNumber {

	public int nthSuperUglyNumber(int n, int[] primes) {

		int[] ugly = new int[n];

		ugly[0] = 1;

		int[] fp = Arrays.copyOf(primes, primes.length);

		int[] ip = new int[primes.length];

		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> fp[a] - fp[b]);

		for (int i = 0; i < fp.length; i++) {
			pq.add(i);
		}

		for (int i = 1; i < n; i++) {

			ugly[i] = fp[pq.peek()];

			while (fp[pq.peek()] == ugly[i]) {
				int mI = pq.poll();
				ip[mI]++;
				fp[mI] = ugly[ip[mI]] * primes[mI];
				pq.add(mI);
			}

		}

		return ugly[n - 1];

	}

	public static void main(String[] args) {

		SuperUglyNumber superUglyNumber = new SuperUglyNumber();

		System.out.println(superUglyNumber.nthSuperUglyNumber(12, new int[] { 2, 7, 13, 19 }));

	}

}
