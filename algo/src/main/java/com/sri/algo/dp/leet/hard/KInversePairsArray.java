package com.sri.algo.dp.leet.hard;

public class KInversePairsArray {



	public int kInversePairs(int n, int k) {

		int mod = 1000000007;
		if (k < 0 || k > n * (n - 1) / 2)
			return 0;

		if (k == 0 || k == n * n - 1 / 2) {
			return 1;
		}
		long[][] dp = new long[n + 1][k + 1];

		dp[2][0] = 1;
		dp[2][1] = 1;
		for (int i=3;i<=n;i++) {
			dp[i][0] =1;
			
			for (int j=1;j <= Math.min(k, i*(i-1)/2); j++) {
			dp[i][j] = dp[i-1][j] + dp[i][j-1];
				if(j >= i)
				{
					dp[i][j] -= dp[i-1][j-i];
				}
				dp[i][j] = (dp[i][j] + mod) % mod;
			}
		}
		return (int) dp[n][k];

	}

	public static void main(String[] args) {

		KInversePairsArray kinversePairsArray = new KInversePairsArray();
		System.out.println(kinversePairsArray.kInversePairs(3, 0));

	}

}
