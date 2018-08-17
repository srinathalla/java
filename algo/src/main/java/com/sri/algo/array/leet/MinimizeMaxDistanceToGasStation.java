package com.sri.algo.array.leet;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * On a horizontal number line, we have gas stations at positions stations[0],
 * stations[1], ..., stations[N-1], where N = stations.length.
 * 
 * Now, we add K more gas stations so that D, the maximum distance between
 * adjacent gas stations, is minimized.
 * 
 * Return the smallest possible value of D.
 * 
 * Example:
 * 
 * Input: stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], K = 9 Output: 0.500000
 * Note:
 * 
 * stations.length will be an integer in range [10, 2000]. stations[i] will be
 * an integer in range [0, 10^8]. K will be an integer in range [1, 10^6].
 * Answers within 10^-6 of the true value will be accepted as correct.
 * 
 * @author salla
 *
 */
public class MinimizeMaxDistanceToGasStation {

	/**
	 * T.C Klogn where n is no of stations k will be new stations to be added.
	 * 
	 * This will lead to time limit exceeded error..
	 * 
	 * @param stations
	 * @param K
	 * @return
	 */
	public double minmaxGasDistWithPQ(int[] stations, int K) {

		int n = stations.length;

		Queue<int[]> q = new PriorityQueue<>((a, b) -> (double) a[0] / a[1] > (double) b[0] / b[1] ? -1 : 1);

		for (int i = 0; i < n - 1; i++) {
			q.add(new int[] { stations[i + 1] - stations[i], 1 });
		}

		for (int i = 0; i < K; i++) {
			int[] element = q.poll();
			element[1]++;

			q.add(element);
		}

		int[] res = q.poll();

		return (double) res[0] / res[1];
	}

	/**
	 * Time Complexity: O(NlogW) where N is the length of stations, and W = 10^14
	 * 
	 * is the range of possible answers (10^8), divided by the acceptable level of
	 * precision (10^-6). ​​​
	 * 
	 * 
	 * Space Complexity: O(1) in additional space complexity.
	 * 
	 * @param stations
	 * @param K
	 * @return
	 */
	public double minmaxGasDist(int[] stations, int K) {
		double lo = 0.0, hi = 1e8;

		while (hi - lo > 1e-6) {

			double mid = (lo + hi) / 2.0;

			if (possible(mid, stations, K)) {
				hi = mid;
			} else {
				lo = mid;
			}
		}

		return lo;
	}

	public boolean possible(double D, int[] stations, int K) {

		int used = 0;
		for (int i = 0; i < stations.length - 1; i++) {
			used += (int) (stations[i + 1] - stations[i]) / D;
		}

		return used <= K;
	}

	public static void main(String[] args) {

		MinimizeMaxDistanceToGasStation minMaxdist = new MinimizeMaxDistanceToGasStation();

		System.out.println(minMaxdist.minmaxGasDist(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 9));

	}

}
