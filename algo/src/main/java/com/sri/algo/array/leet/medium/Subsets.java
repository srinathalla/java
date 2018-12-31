package com.sri.algo.array.leet.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	
	 public List<List<Integer>> subsets1(int[] nums) {
	        List<List<Integer>> set = new ArrayList<List<Integer>>();
	        int max = 1 << nums.length;
	        for (int i = 0; i < max; i++) {
	            ArrayList<Integer> arr = new ArrayList<Integer>();
	            for (int j = 0; j < nums.length; j++) {
	                if ((i & (1 << j)) != 0) {
	                    arr.add(nums[j]);
	                }
	            }
	            set.add(arr);
	        }
	        return set;
	    }
	 
	 public List<List<Integer>> subsets(int[] nums) {
	        List<List<Integer>> set = new ArrayList<List<Integer>>();
	        
	        backtrack(set, new ArrayList<>(), nums, 0);
	       
	        return set;
	    }
	 
	 private void backtrack(List<List<Integer>> set, List<Integer> cset, int[] nums,int start)
	 {
		 
		 set.add(new ArrayList<>(cset));
		 
		 for (int i=start;i < nums.length; i++)
		 {
			 cset.add(nums[i]);	 
			 backtrack(set, cset, nums, i + 1);
			 cset.remove(cset.size() -1);
		 }
	 }
	 
	 
	 
	 public static void main(String[] args) {
		 
		 Subsets subsets = new Subsets();
		 
		 System.out.println(
			 subsets.subsets(new int[] {1,2,3}));
		
	}

}
