package com.sri.algo.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InsertDeleteRandomWithDuplicates {
	
	    private List<Integer> nums;
	    private Map<Integer,Set<Integer>> locs;
	    java.util.Random rand = new java.util.Random();
	    
	    /** Initialize your data structure here. */
	    public InsertDeleteRandomWithDuplicates() {
	        nums = new ArrayList<>();
	        locs = new HashMap<>();
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	        
	        boolean isAbsent = true;
	        if(locs.containsKey(val))
	        {
	            isAbsent = true;
	        }
	        
	        if(!locs.containsKey(val))
	        {
	            locs.put(val, new HashSet<>());
	        }
	        
	        nums.add(val);
	        locs.get(val).add(nums.size()-1);
	        
	        return isAbsent;
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	        
	        if(!locs.containsKey(val))
	        {
	            return false;
	        }
	        
	        int idx = locs.get(val).iterator().next();
	        locs.get(val).remove(idx);
	        
	        if(idx < nums.size() -1)
	        {
	        	int lastone = nums.get(nums.size() -1);
		        nums.set(idx, lastone);
		        locs.get(lastone).remove(nums.size() -1);
		        locs.get(lastone).add(idx);
	        }
	        
            nums.remove(nums.size() -1);
	        if(locs.get(val).isEmpty())
	        {
	            locs.remove(val);
	        }
	        
	        return true;
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	        return nums.get(rand.nextInt(nums.size()));
	    }
	    
	    public static void main(String[] args) {
	    	InsertDeleteRandomWithDuplicates insertDeleteRandomWithDuplicates = new
	    			InsertDeleteRandomWithDuplicates();
	    	System.out.println(
    			insertDeleteRandomWithDuplicates.insert(4));
	    	System.out.println(insertDeleteRandomWithDuplicates.insert(3));
	    	System.out.println(insertDeleteRandomWithDuplicates.insert(4));
	    	System.out.println(insertDeleteRandomWithDuplicates.insert(2));
	    	System.out.println(insertDeleteRandomWithDuplicates.insert(4));
	    	System.out.println(insertDeleteRandomWithDuplicates.remove(4));
	    	System.out.println(insertDeleteRandomWithDuplicates.remove(3));
	    	System.out.println(insertDeleteRandomWithDuplicates.remove(4));
	    	System.out.println(insertDeleteRandomWithDuplicates.remove(4));
	    	
	    
			
		}

}
