package com.sri.algo.dp.cp;

public class LongestPalindromeInAString {
	
	public static int lcs(char[] X, char[] Y, int n, int m) {

		int[][] table = new int[n + 1][m + 1];

		int max = Integer.MIN_VALUE;
		int l =-1;

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == 0 || j == 0) {
					table[i][j] = 0;
				} else if (X[i - 1] == Y[j - 1]) {
					table[i][j] = table[i - 1][j - 1] + 1;

					if(max < table[i][j])
					{
						max = table[i][j];
						l = i;
					}
				} else {
					table[i][j] = 0;
				}
			}
		}

		if (max == Integer.MIN_VALUE) {
			max = 0;
		}
		
		StringBuilder s = new StringBuilder();
		for (int i = l- max;i < l ; i++)
		{
			s.append(X[i]);
		}
		
		System.out.println(s.toString());

		return max;
	}
	
	public static void main(String[] args) {
		
		System.out.println(lcs("aaaabbaa".toCharArray(),"aabbaaaa".toCharArray(),8,8));
		
	}

}
