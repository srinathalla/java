package com.sri.algo.array.leet;

import java.util.Arrays;
import java.util.Comparator;

/**
 * u have a number of envelopes with widths and heights given as a pair of
 * integers (w, h). One envelope can fit into another if and only if both the
 * width and height of one envelope is greater than the width and height of the
 * other envelope.
 * 
 * What is the maximum number of envelopes can you Russian doll? (put one inside
 * other)
 * 
 * Example: Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of
 * envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 * 
 * 
 * @author salla
 *
 */
public class RussianDollEnvelopes {

	/**
	 * T.C :O(nlogn) + O(n*n) => O(n*n)
	 * 
	 * @param envelopes
	 * @return
	 */
	public int maxEnvelopes(int[][] envelopes) {
		int n = envelopes.length;
		if (n < 2) {
			return n;
		}

		// O(nlogn)
		Arrays.sort(envelopes, (a, b) -> a[0] * a[1] - b[0] * b[1]);

		int[] count = new int[n];
		Arrays.fill(count, 1);

		int max = 1;

		// O(n*n)
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {

				if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
					count[i] = Integer.max(count[i], count[j] + 1);

					max = Integer.max(max, count[i]);
				}
			}
		}

		return max;
	}

	/**
	 * T.C O(nlogn) + O(nlogn) => O(nlogn).
	 * 
	 * This problem is asking for LIS in two dimensions, width and height. Sorting
	 * the width reduces the problem by one dimension. If width is strictly
	 * increasing, the problem is equivalent to finding LIS in only the height
	 * dimension. However, when there is a tie in width, a strictly increasing
	 * sequence in height may not be a correct solution. 
	 * 
	 * For example, [[3,3] cannot
	 * fit in [3,4]]. Sorting height in descending order when there is a tie
	 * prevents such a sequence to be included in the solution.
	 * 
	 * The same idea can be applied to problems of higher dimensions. For example,
	 * box fitting is three dimensions, width, height, and length. Sorting width
	 * ascending and height descending reduces the problem by one dimension. Finding
	 * the LIS by height further reduces the problem by another dimension. When find
	 * LIS based on only length, it becomes a standard LIS problem.
	 * 
	 * Two step process this is basically
	 * 
	 * @param envelopes
	 * @return
	 */
	public int maxEnvelopesWithBSearch(int[][] envelopes) {

		int n = envelopes.length;

		if (n < 2) {
			return 1;
		}

		// O(nlogn)
		Arrays.sort(envelopes, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

		int len = 0;
		int[] dp = new int[n];

		for (int[] envelope : envelopes) {

			// O(logn) for 1 element, for n elements O(nlogn)
			int idx = Arrays.binarySearch(dp, 0,len,envelope[1]);

			if (idx < 0) {
				idx = -(idx + 1);
			}

			dp[idx] = envelope[1];

			if (idx == len) {
				len++;
			}
		}

		return len;
	}

	public static void main(String[] args) {

		RussianDollEnvelopes rd = new RussianDollEnvelopes();
		int[][] envelopes = new int[][] { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };

		// System.out.println(rd.maxEnvelopesWithBSearch(envelopes));

		// int[][] envelopes = new int[][] { { 3, 5 }, { 3, 4 }, { 3, 2 }, { 2, 3 }, { 4, 5 } };

		System.out.println(rd.maxEnvelopesWithBSearch(envelopes));

	}

}
