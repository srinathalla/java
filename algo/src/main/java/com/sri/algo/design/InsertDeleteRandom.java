package com.sri.algo.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class InsertDeleteRandom {

    private List<Integer> nums;
    private Map<Integer,Integer> locs;
    java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public InsertDeleteRandom() {
        
        nums = new ArrayList<>();
        locs = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        
        if(locs.containsKey(val))
        {
            return false;
        }
        
        nums.add(val);
        locs.put(val,nums.size() -1);
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        
        if(!locs.containsKey(val))
        {
            return false;
        }
        
        int idx = locs.get(val);
        nums.set(idx, nums.get(nums.size() -1));
       
        locs.put(nums.get(idx),idx);
        
        nums.remove(nums.size() -1);
        locs.remove(val);
        
        return true;
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
    
    public static void main(String[] args) {
    	
    	InsertDeleteRandom randomizedSet = new InsertDeleteRandom();
    	System.out.println(randomizedSet.remove(0));
    	System.out.println(randomizedSet.remove(0));
    	System.out.println(randomizedSet.insert(0));
    	System.out.println(
			randomizedSet.getRandom());
    	System.out.println(randomizedSet.remove(0));
    	System.out.println(randomizedSet.insert(0));
		
	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
