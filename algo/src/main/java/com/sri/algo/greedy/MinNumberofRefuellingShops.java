package com.sri.algo.greedy;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * A car travels from a starting position to a destination which is target miles
 * east of the starting position.
 * 
 * Along the way, there are gas stations. Each station[i] represents a gas
 * station that is station[i][0] miles east of the starting position, and has
 * station[i][1] liters of gas.
 * 
 * The car starts with an infinite tank of gas, which initially has startFuel
 * liters of fuel in it. It uses 1 liter of gas per 1 mile that it drives.
 * 
 * When the car reaches a gas station, it may stop and refuel, transferring all
 * the gas from the station into the car.
 * 
 * What is the least number of refueling stops the car must make in order to
 * reach its destination? If it cannot reach the destination, return -1.
 * 
 * Note that if the car reaches a gas station with 0 fuel left, the car can
 * still refuel there. If the car reaches the destination with 0 fuel left, it
 * is still considered to have arrived.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: target = 1, startFuel = 1, stations = [] Output: 0 Explanation: We can
 * reach the target without refueling.
 * 
 * @author salla
 *
 */
public class MinNumberofRefuellingShops {

	/**
	 * T.C O(nlogn)
	 * 
	 * Idea is to refuel the tank when it becomes empty. while refuelling we should
	 * pick the stop with highest fuel. we do this till the destination is reached..
	 * 
	 * as we are doing greedily we will get minimum fuel stops.
	 * 
	 * @param target
	 * @param startFuel
	 * @param stations
	 * @return
	 */
	public int minRefuelStops(int target, int startFuel, int[][] stations) {

		int currPos = 0;

		if (currPos + startFuel >= target) {
			return 0;
		}

		int n = stations.length, minStops = 0, i = 0;
		if (n == 0 || (currPos + startFuel < stations[0][0])) {
			return -1;
		}

		currPos += startFuel;
		Queue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> b[1] - a[1]);
		while (currPos < target) {
			if (i < n && stations[i][0] <= currPos) {
				pq.add(stations[i++]);
			} else {
				if (pq.isEmpty()) {
					return -1;
				}

				currPos += pq.poll()[1];
				minStops++;
			}
		}

		return minStops;
	}

	public static void main(String[] args) {

		MinNumberofRefuellingShops minStops = new MinNumberofRefuellingShops();

		System.out.println(minStops.minRefuelStops(1, 1, new int[0][0]));

		System.out.println(minStops.minRefuelStops(100, 1, new int[][] { { 10, 100 } }));

		System.out.println(
				minStops.minRefuelStops(100, 10, new int[][] { { 10, 60 }, { 20, 30 }, { 30, 30 }, { 60, 40 } }));

	}

}
