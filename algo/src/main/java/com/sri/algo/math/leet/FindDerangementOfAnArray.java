package com.sri.algo.math.leet;

/**
 * In combinatorial mathematics, a derangement is a permutation of the elements
 * of a set, such that no element appears in its original position.
 * 
 * There's originally an array consisting of n integers from 1 to n in ascending
 * order, you need to find the number of derangement it can generate.
 * 
 * Also, since the answer may be very large, you should return the output mod
 * 109 + 7.
 * 
 * Example 1: Input: 3 Output: 2 Explanation: The original array is [1,2,3]. The
 * two derangements are [2,3,1] and [3,1,2].
 * 
 * @author salla
 *
 */
public class FindDerangementOfAnArray {

	/**
	 * Get all permutations and check if current permutation is a derangement ..
	 * 
	 * 
	 * @param n
	 * @return
	 */
	public int findDerangementNaive(int n) {

		int[] arrangement = new int[n];

		for (int i = 1; i <= n; i++) {
			arrangement[i - 1] = i;
		}

		int[] count = { 0 };
		permutate(arrangement, 0, n - 1, count);

		return count[0];
	}

	private void permutate(int[] nos, int l, int h, int[] count) {

		if (l > h) {
			if (isDerangement(nos)) {
				count[0]++;
			}
			return;
		}

		for (int i = l; i <= h; i++) {
			int temp = nos[i];
			nos[i] = nos[l];
			nos[l] = temp;

			permutate(nos, l + 1, h, count);

			temp = nos[i];
			nos[i] = nos[l];
			nos[l] = temp;
		}
	}

	private boolean isDerangement(int[] nos) {

		for (int i = 0; i < nos.length; i++) {
			if (nos[i] == i + 1) {
				return false;
			}
		}

		return true;
	}

	public int findDerangementWithRecursion(int n) {
		Integer[] memo = new Integer[n + 1];
		return find(n, memo);
	}

	public int find(int n, Integer[] memo) {

		if (n == 0) {
			return 1;
		}

		if (n == 1) {
			return 0;
		}

		if (memo[n] != null) {
			return memo[n];
		}

		memo[n] = ((n - 1) * (find(n - 1, memo) + find(n - 2, memo))) % 1000000007;

		return memo[n];
	}

	public int findDerangement(int n) {
		Integer[] table = new Integer[n + 1];
		table[0] = 1;
		table[1] = 0;

		for (int i = 2; i <= n; i++) {
			table[i] = ((i - 1) * (table[i - 1] + table[i - 2])) % 1000000007;
		}

		return table[n];
	}

	public static void main(String[] args) {

		FindDerangementOfAnArray derange = new FindDerangementOfAnArray();

		System.out.println(derange.findDerangement(3));
	}

}
