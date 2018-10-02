package com.sri.algo.math.leet;

/**
 * You have n super washing machines on a line. Initially, each washing machine
 * has some dresses or is empty.
 * 
 * For each move, you could choose any m (1 ≤ m ≤ n) washing machines, and pass
 * one dress of each washing machine to one of its adjacent washing machines at
 * the same time .
 * 
 * Given an integer array representing the number of dresses in each washing
 * machine from left to right on the line, you should find the minimum number of
 * moves to make all the washing machines have the same number of dresses. If it
 * is not possible to do it, return -1.
 * 
 * Example1
 * 
 * Input: [1,0,5]
 * 
 * Output: 3
 * 
 * Explanation: 1st move: 1 0 <-- 5 => 1 1 4 2nd move: 1 <-- 1 <-- 4 => 2 1 3
 * 3rd move: 2 1 <-- 3 => 2 2 2 Example2
 * 
 * Input: [0,3,0]
 * 
 * Output: 2
 * 
 * Explanation: 1st move: 0 <-- 3 0 => 1 2 0 2nd move: 1 2 --> 0 => 1 1 1
 * Example3
 * 
 * Input: [0,2,0]
 * 
 * Output: -1
 * 
 * Explanation: It's impossible to make all the three washing machines have the
 * same number of dresses. Note: The range of n is [1, 10000]. The range of
 * dresses number in a super washing machine is [0, 1e5].
 * 
 * @author salla
 *
 */
public class SuperWashingMachines {

	/**
	 * T.C : O(n)
	 * 
	 * @param machines
	 * @return
	 */
	public int findMinMovesWithMath(int[] machines) {

		int total = 0, max = 0, cnt = 0;

		for (int val : machines) {
			total += val;
		}

		if (total % machines.length != 0) {
			return -1;
		}

		int avg = total / machines.length;

		for (int val : machines) {
			cnt += val - avg;
			max = Integer.max(Integer.max(max, Math.abs(cnt)), val - avg);
		}

		return max;
	}

	public int findMinMoves(int[] machines) {

		int total = 0, res = 0, n = machines.length, target = 0,count = 0;

		for (int v : machines) {
			total += v;
		}

		if (total % n != 0) {
			return -1;
		}

		target = total / n;

		for (int i = 0; i < n; i++) {

			int diff = machines[i] - target;
			count += diff;
			res = Integer.max(Integer.max(res, Math.abs(count)),diff);
		}

		return res;
	}

	public static void main(String[] args) {

		SuperWashingMachines superWash = new SuperWashingMachines();

		System.out.println(superWash.findMinMoves(new int[] { 1, 2, 4, 1 })); 
		
		System.out.println(superWash.findMinMoves(new int[] { 1, 0, 4, 3 })); 
		System.out.println(superWash.findMinMoves(new int[] { 0, 0, 4, 3,3 })); 
		
		System.out.println(superWash.findMinMoves(new int[] { 1, 3, 4, 0 })); 
		System.out.println(superWash.findMinMoves(new int[] { 1, 3,0, 4})); 
		System.out.println(superWash.findMinMoves(new int[] { 1, 3,1, 3})); 

	}

}
