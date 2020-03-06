package com.sri.algo.array.leet.medium;

public class New21Game {

	public double new21Game(int N, int K, int W) {

		if (K == 0 || N > K + W - 1) {
			return 1;
		}
		double[] dp = new double[N + 1];
		dp[0] = 1;
		double ws = 1, res = 0;

		for (int i = 1; i <= N; i++) {

			dp[i] = ws / W;
			if (i < K) {
				ws += dp[i];
			} else {
				res += dp[i];
			}

			if (i > W) {
				ws -= dp[i - W];
			}
		}

		return res;

	}

}
