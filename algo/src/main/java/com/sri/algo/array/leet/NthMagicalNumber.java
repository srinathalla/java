package com.sri.algo.array.leet;

/**
 * A positive integer is magical if it is divisible by either A or B.
 * 
 * Return the N-th magical number. Since the answer may be very large, return it
 * modulo 10^9 + 7.
 * 
 * @author salla
 *
 */
public class NthMagicalNumber {

	/**
	 * T.C is exponential. as we loop through N times in the worst case.
	 * 
	 * @param N
	 * @param A
	 * @param B
	 * @return
	 */
	public int nthMagicalNumberNaive(int N, int A, int B) {

		if (N == 1) {
			return Integer.min(A, B);
		}

		int count = 0;
		int secMax, curr;

		if (A < B) {

			secMax = A;
		} else {

			secMax = B;
		}
		curr = secMax;

		while (count < N) {

			if (curr % A == 0 || curr % B == 0) {
				count++;
			}
			curr++;
		}

		return curr - 1;
	}

	/**
	 * T.C : O(N)..
	 * 
	 * T.L.E
	 * 
	 * @param N
	 * @param A
	 * @param B
	 * @return
	 */
	public int nthMagicalNumberWithTwoPointers(int N, int A, int B) {

		int MOD = 1_000_000_007;

		if (N == 1) {
			return Integer.min(A, B);
		}

		long count = 0;
		long aSeq = A, bSeq = B;

		long curr = 0;
		while (count != N) {

			if (aSeq < bSeq) {
				curr = aSeq;
				aSeq += A;
			} else if (aSeq > bSeq) {
				curr = bSeq;
				bSeq += B;
			} else {
				curr = aSeq;
				aSeq += A;
				bSeq += B;
			}
			count++;
		}

		return (int) (curr % MOD);
	}

	/**
	 * Time Complexity: O(A+B)O(A+B), assuming a model where integer math operations
	 * are O(1)O(1). The calculation of q * L is O(1)O(1). The calculation of the
	 * rr-th magical number after q*Mq∗M is O(M)O(M) which is O(A+B)O(A+B).
	 * 
	 * Space Complexity: O(1)O(1).
	 * 
	 * @param N
	 * @param A
	 * @param B
	 * @return
	 */
	public int nthMagicalNumber(int N, int A, int B) {

		int mod = 1000000007;
		int L = (A * B) / gcd(A, B);

		int M = L / A + L / B - 1;

		int q = N / M, r = N % M;

		long ans = (long) q * L % mod;

		if (r == 0) {
			return (int) ans;
		}

		int[] heads = new int[] { A, B };

		for (int i = 0; i < r - 1; i++) {
			if (heads[0] <= heads[1]) {
				heads[0] += A;
			} else {
				heads[1] += B;
			}
		}

		ans += Math.min(heads[0], heads[1]);

		return (int) (ans % mod);

	}

	public int gcd(int x, int y) {

		if (x == 0) {
			return y;
		}

		return gcd(y % x, x);
	}

	public static void main(String[] args) {

		NthMagicalNumber nthMagical = new NthMagicalNumber();

		// System.out.println(nthMagical.nthMagicalNumber(1, 2, 3));
		// System.out.println(nthMagical.nthMagicalNumber(4, 2, 3));
		// System.out.println(nthMagical.nthMagicalNumber(5, 2, 4));
		// System.out.println(nthMagical.nthMagicalNumber(3, 6, 4));

		System.out.println(nthMagical.nthMagicalNumber(1000000000, 40000, 40000));

		System.out.println(nthMagical.nthMagicalNumberWithTwoPointers(1000000000, 40000, 40000));

		// System.out.println(nthMagical.gcd(60, 24));

	}

}
