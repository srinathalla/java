package com.sri.algo.array.leet;

public class KthSmallestNumberInMultiplicationTable {

	public int count(int x, int m, int n) {
		int count = 0;

		for (int i = 1; i <= m; i++) {
			count += Integer.min(x / i, n); // in ith row number we are trying to count the number of elements less than
											// mid if count has to be less than n
		}

		return count;
	}

	/**
	 * T.C Om(logm*n)
	 * 
	 * Time Complexity: O(m∗log(m∗n)). Our binary search divides the interval [lo,
	 * hi] into half at each step. At each step, we call enough which requires O(m)
	 * time.
	 * 
	 * Space Complexity: O(1)O(1). We only keep integers in memory during our
	 * intermediate calculations.
	 * 
	 * @param m
	 * @param n
	 * @param k
	 * @return
	 */
	public int findKthNumber(int m, int n, int k) {

		int l = 1, h = m * n;

		while (l < h) {

			int mid = l + (h - l) / 2;

			if (count(mid, m, n) < k) {
				l = mid + 1;
			} else {
				h = mid;
			}
		}

		return l;
	}

	public static void main(String[] args) {

		KthSmallestNumberInMultiplicationTable kthsmallestNo = new KthSmallestNumberInMultiplicationTable();

		System.out.println(kthsmallestNo.findKthNumber(3, 3, 5));
	}

}
