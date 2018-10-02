package com.sri.algo.math.leet;

public class RabbitsInForest {

	public int numRabbits(int[] answers) {
		int[] count = new int[1000];
		for (int x : answers)
			count[x]++;

		int ans = 0;
		for (int k = 0; k < 1000; ++k)
			ans += Math.floorMod(-count[k], k + 1) + count[k];
		return ans;
	}

	public static void main(String[] args) {

		RabbitsInForest rabbitsInForest = new RabbitsInForest();

		System.out.println(rabbitsInForest.numRabbits(new int[] { 1, 1, 2 }));

	}

}
