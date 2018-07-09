package com.sri.algo.dp;

/**
 * There are a row of n houses, each house can be painted with one of the k
 * colors. The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the
 * same color.
 * 
 * The cost of painting each house with a certain color is represented by a n x
 * k cost matrix. For example, costs[0][0] is the cost of painting house 0 with
 * color 0; costs[1][2] is the cost of painting house 1 with color 2, and so
 * on... Find the minimum cost to paint all houses.
 * 
 * Note: All costs are positive integers.
 * 
 * Example:
 * 
 * Input: [[1,5,3],[2,9,4]] Output: 5 Explanation: Paint house 0 into color 0,
 * paint house 1 into color 2. Minimum cost: 1 + 4 = 5; Or paint house 0 into
 * color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.
 * 
 * @author salla
 *
 */
public class PaintHouse {

	/**
	 * 
	 * T. C : O (n*k)
	 * Auxillary space : O(1).
	 * 
	 * @param costs
	 * @return
	 */
	public int minCostII(int[][] costs) {

		int n = costs.length;

		if (n == 0) {
			return 0;
		}

		int m = costs[0].length;

		if (n == 1 && m == 1) {
			return costs[0][0];
		}

		int prevMin = 0, prevMinInd = -1, prevSecMin = 0;
		for (int i = 0; i < n; i++) {

			int min = Integer.MAX_VALUE, minInd = -1, secMin = Integer.MAX_VALUE;
			for (int j = 0; j < m; j++) {
				int cost = costs[i][j] + (j == prevMinInd ? prevSecMin : prevMin);

				if (minInd < 0) {
					min = cost;
					minInd = j;
				} else if (cost < min) {
					secMin = min;
					min = cost;
					minInd = j;
				} else if (cost < secMin) {
					secMin = cost;
				}
			}

			prevMin = min;
			prevMinInd = minInd;
			prevSecMin = secMin;
		}

		return prevMin;
	}

	public static void main(String[] args) {

		PaintHouse ph = new PaintHouse();

		
		  int[][] table = new int[][] { { 1, 5, 3 }, { 2, 9, 4 } };
		  
		 
		 
		  System.out.println(ph.minCostII(table));
		  
		  int[][] table1 = new int[][] { { 1, 5, 3 }, { 2, 9, 4 }, { 3, 3, 3 } };
		  
		  System.out.println(ph.minCostII(table1));
		 

		int[][] table2 = new int[][] { { 1, 5, 2 }, { 2, 9, 2 }, { 3, 3, 1 } };

		System.out.println(ph.minCostII(table2));

	}

}
