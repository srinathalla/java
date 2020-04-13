package com.sri.algo.hashing.leet;

import java.util.TreeMap;

public class ContainsDuplicate3 {

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

		TreeMap<Integer, Integer> map = new TreeMap<>();

		for (int i = 0; i < nums.length; i++) {
			Integer higher = map.ceilingKey(nums[i]);
			Integer lower = map.floorKey(nums[i]);

			while (higher != null && Math.abs(higher - nums[i]) <= t) {
				if(Math.abs(map.get(higher) - i) <= k)
				{
					return true;
				}
				higher = map.higherKey(higher);
			}

			while (lower != null && Math.abs(lower - nums[i]) <= t) {
				if(Math.abs(map.get(lower) - i) <= k)
				{
					return true;
				}
				lower = map.lowerKey(lower);
			}

			map.put(nums[i], i);

		}
		return false;
	}

	public static void main(String[] args) {
			
	    	
	    	int[] nums = new int[] {10,100,11,9};
	    	int k = 1;
	    	int t = 2;
	    	
	    	ContainsDuplicate3 containsDuplicate3 = new
	    			ContainsDuplicate3();
	    	System.out.println(
    			containsDuplicate3.containsNearbyAlmostDuplicate(nums, k, t));
		}

}
