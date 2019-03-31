package com.sri.algo.stack;

import java.util.TreeMap;

/**
 * 
 * N cars are going to the same destination along a one lane road.  
 * The destination is target miles away.

   Each car i has a constant speed speed[i] (in miles per hour), and 
   initial position position[i] miles towards the target along the road.

   A car can never pass another car ahead of it, but it can catch up to it, 
   and drive bumper to bumper at the same speed.

   The distance between these two cars is ignored - they are assumed to have 
   the same position.

   A car fleet is some non-empty set of cars driving at the same position and 
   same speed.  Note that a single car is also a car fleet.

   If a car catches up to a car fleet right at the destination point, it will 
   still be considered as one car fleet.


   How many car fleets will arrive at the destination?
 * @author salla
 *
 */
public class CarFleet {
	
	/**
	 * Calculate time needed to arrive the target, sort by the start position.
       Loop on each car from the end to the beginning. cur records the current 
       biggest time (the slowest).
       If another car needs less or equal time than cur, it can catch up this car.
       Otherwise it will become the new slowest car, that is new lead of a car fleet.
	 * @param target
	 * @param position
	 * @param speed
	 * @return
	 */
	public int carFleet(int target, int[] position, int[] speed) {

		TreeMap<Integer, Double> map = new TreeMap<>();

		int n = position.length;
		for (int i = 0; i < n; i++) {
			map.put(-position[i], (double) (target - position[i]) / speed[i]);
		}

		int ans = 0;
		double curr = 0.0;

		for (double t : map.values()) {
			if (t > curr) {
				curr = t;
				ans++;
			}
		}

		return ans;

	}
	
	
	public static void main(String[] args) {
		
		CarFleet carFleet = new CarFleet();
		
		
		System.out.println(
			carFleet.carFleet(12, new int[] { 10,8,0,5,3 }, new int[] { 2,4,1,1,3 }));
		
		
	}

}
