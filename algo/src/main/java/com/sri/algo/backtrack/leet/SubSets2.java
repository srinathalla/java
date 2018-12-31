package com.sri.algo.backtrack.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets2 {

	public List<List<Integer>> subsetsWithDup(int[] nums) {

		Arrays.sort(nums);

		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());

		for (int no : nums) {

			generateSubsets(result, no);
		}

		return result;

	}

	private void generateSubsets(List<List<Integer>> result, int no) {
		List<List<Integer>> entriesList = new ArrayList<>();
		for (List<Integer> entry : result) {

			List<Integer> clonedList = new ArrayList<>(entry);
			clonedList.add(no);

			entriesList.add(clonedList);
		}

		for (List<Integer> entry : entriesList) {
			if (!result.contains(entry)) {
				result.add(entry);
			}
		}
	}
	
	 public List<List<Integer>> subsets(int[] nums) {
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
	
	public static void main(String[] args) {
		
		
		SubSets2 subSets2 = new SubSets2();
		
		System.out.println(subSets2.subsetsWithDup(new int[] {1,2,2}));
		
		System.out.println(subSets2.subsets(new int[] {1,2,2}));
	}

}
