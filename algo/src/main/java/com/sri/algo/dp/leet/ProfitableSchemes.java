package com.sri.algo.dp.leet;

/**
 * There are G people in a gang, and a list of various crimes they could commit.
 * 
 * The i-th crime generates a profit[i] and requires group[i] gang members to
 * participate.
 * 
 * If a gang member participates in one crime, that member can't participate in
 * another crime.
 * 
 * Let's call a profitable scheme any subset of these crimes that generates at
 * least P profit, and the total number of gang members participating in that
 * subset of crimes is at most G.
 * 
 * How many schemes can be chosen? Since the answer may be very large, return it
 * modulo 10^9 + 7.
 * 
 * @author salla
 *
 */
public class ProfitableSchemes {

	private int count = 0;

	public int profitableSchemes(int G, int P, int[] group, int[] profit) {

		this.count = 0;
		profitableSchemes(G, P, group, profit, 0, 0);

		return count;
	}

	private void profitableSchemes(int G, int P, int[] group, int[] profit, int i, int cprofit) {

		if (G <= 0 || i == group.length) {
			return;
		}

		if(G - group[i] >= 0)
		{
			if (cprofit + profit[i] >= P) {
				count++;
			}
	
			profitableSchemes(G - group[i], P, group, profit, i + 1, cprofit + profit[i]);
		}

		profitableSchemes(G, P, group, profit, i + 1, cprofit);
	}

	public static void main(String[] args) {

		ProfitableSchemes ps = new ProfitableSchemes();

		System.out.println(ps.profitableSchemes(10, 5, new int[] { 2, 3, 5 }, new int[] { 6, 7, 8 }));
		
		
		System.out.println(ps.profitableSchemes(1, 1, new int[] { 2, 2,2,2,2}, new int[] { 1,2,1,1,0 }));


	}

}
