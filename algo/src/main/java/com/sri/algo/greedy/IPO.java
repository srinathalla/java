package com.sri.algo.greedy;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Suppose LeetCode will start its IPO soon. In order to sell a good price of
 * its shares to Venture Capital, LeetCode would like to work on some projects
 * to increase its capital before the IPO. Since it has limited resources, it
 * can only finish at most k distinct projects before the IPO. Help LeetCode
 * design the best way to maximize its total capital after finishing at most k
 * distinct projects.
 * 
 * You are given several projects. For each project i, it has a pure profit Pi
 * and a minimum capital of Ci is needed to start the corresponding project.
 * Initially, you have W capital. When you finish a project, you will obtain its
 * pure profit and the profit will be added to your total capital.
 * 
 * To sum up, pick a list of at most k distinct projects from given projects to
 * maximize your final capital, and output your final maximized capital.
 * 
 * Example 1: Input: k=2, W=0, Profits=[1,2,3], Capital=[0,1,1].
 * 
 * Output: 4
 * 
 * Explanation: Since your initial capital is 0, you can only start the project
 * indexed 0. After finishing it you will obtain profit 1 and your capital
 * becomes 1. With capital 1, you can either start the project indexed 1 or the
 * project indexed 2. Since you can choose at most 2 projects, you need to
 * finish the project indexed 2 to get the maximum capital. Therefore, output
 * the final maximized capital, which is 0 + 1 + 3 = 4.
 * 
 * @author salla
 *
 */
public class IPO {

	/**
	 * 
	 * 
	 * The idea is each time we find a project with max profit and within current
	 * capital capability. Algorithm:
	 * 
	 * 1) Create (capital, profit) pairs and put them into PriorityQueue pqCap. This
	 * PriorityQueue sort by capital increasingly.
	 * 
	 * 2) Keep polling pairs from pqCap until the project out of current capital
	 * capability. Put them into PriorityQueue pqPro which sort by profit
	 * decreasingly.
	 * 
	 * 3) Poll one from pqPro, it's guaranteed to be the project with max profit and
	 * within current capital capability. Add the profit to capital W.
	 * 
	 * 4) Repeat step 2 and 3 till finish k steps or no suitable project
	 * (pqPro.isEmpty()).
	 * 
	 * Time Complexity: For worst case, each project will be inserted and polled
	 * from both PriorityQueues once, so the overall runtime complexity should be
	 * O(NlgN), N is number of projects.
	 * 
	 * 
	 * @param k
	 * @param W
	 * @param Profits
	 * @param Capital
	 * @return
	 */
	public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {

		if (k == 0 || Profits.length == 0 || Capital.length == 0) {
			return W;
		}

		Queue<int[]> pqCap = new PriorityQueue<>((int[] a, int[] b) -> a[0] - b[0]);

		Queue<int[]> pqPro = new PriorityQueue<>((int[] a, int[] b) -> b[1] - a[1]);

		for (int i = 0; i < Profits.length; i++) {
			pqCap.add(new int[] { Capital[i], Profits[i] });
		}

		int i = 0;
		while (i < k) {

			while (!pqCap.isEmpty() && W >= pqCap.peek()[0]) {
				pqPro.add(pqCap.poll());
			}

			if (pqPro.isEmpty()) {
				break;
			}

			W = W + pqPro.poll()[1];
			i++;
		}

		return W;

	}

	public static void main(String[] args) {

		IPO ipo = new IPO();

		System.out.println(ipo.findMaximizedCapital(2, 0, new int[] { 1, 2, 3 }, new int[] { 0, 1, 1 }));

	}

}
