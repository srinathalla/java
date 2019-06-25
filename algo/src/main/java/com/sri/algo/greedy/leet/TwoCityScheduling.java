package com.sri.algo.greedy.leet;

import java.util.Arrays;


/**
 * 	There are 2N people a company is planning to interview. The cost of flying the i-th person to 
 *  city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].

	Return the minimum cost to fly every person to a city such that exactly N people arrive in 
	each city. 
	
	Example 1:
	
	Input: [[10,20],[30,200],[400,50],[30,20]]
	Output: 110
	Explanation: 
	The first person goes to city A for a cost of 10.
	The second person goes to city A for a cost of 30.
	The third person goes to city B for a cost of 50.
	The fourth person goes to city B for a cost of 20.
	
	The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 * @author salla
 *
 */
public class TwoCityScheduling {

	
	/**
	 * T.C : O(nlogn)
	 * 
	 * @param costs
	 * @return
	 */
	public int twoCitySchedCost(int[][] costs) {

		int cost = 0;
		int n = costs.length / 2;
		Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));

		for (int i = 0; i < n; i++) {
			cost += costs[i][0] + costs[i + n][1];
		}

		return cost;
	}
	
	
	public static void main(String[] args) {
		
		
		TwoCityScheduling twoCityScheduling = new TwoCityScheduling();
		System.out.println(
			twoCityScheduling.twoCitySchedCost(
				new int[][] {{10,20},{30,200},{400,50},{30,20}}));
		
	}

}
