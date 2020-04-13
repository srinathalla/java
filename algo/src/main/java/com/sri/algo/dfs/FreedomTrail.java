package com.sri.algo.dfs;

import com.sri.algo.array.PrintArray;

public class FreedomTrail {
	
	public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        int[][] dp = new int[m + 1][n];
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (ring.charAt(k) == key.charAt(i)) {
                        int diff = Math.abs(j - k);
                        int step = Math.min(diff, n - diff);
                        dp[i][j] = Math.min(dp[i][j], step + dp[i + 1][k]);
                        PrintArray.print2dArray(dp);
                    }
                }
            }
        }
        
        return dp[0][0] + m;
    }
	
	public static void main(String[] args) {
		String ring = "godding", key = "gd";
		
		FreedomTrail freedomTrail = new
				FreedomTrail();
		System.out.println(
			freedomTrail.findRotateSteps(ring, key));
	}

}
