package com.sri.algo.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		
		
		List<List<Integer>> all = new ArrayList<>();
		
		permutate(nums, 0, nums.length -1 ,all);
		
		return all;
    }
	
	private void permutate(int[] nums,int l,int h,List<List<Integer>> all)
	{
		if (l == h)
		{		
			List<Integer> list = new ArrayList<>();
			for(int no :nums)
			{
				list.add(no);
			}
			if(!all.contains(list))
			{
				all.add(list);
			}
			
			return;
		}
		
		for (int i =l;i <= h ;i++)
		{
			
			swap(nums,l,i);
			
			permutate(nums,l +1,h, all);
			swap(nums,l,i);
			
		}
	}
	
	private void swap(int[] nums,int i,int j)
	{
		
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		
		Permutations perm = new Permutations();
		System.out.println(perm.permuteUnique(new int[] {1,1,2}));
		
	}

}
