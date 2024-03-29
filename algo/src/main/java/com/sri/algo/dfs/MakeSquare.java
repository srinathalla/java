package com.sri.algo.dfs;

import java.util.Arrays;

import com.sri.algo.array.PrintArray;

public class MakeSquare {
	
	 public boolean makesquare(int[] nums) {
	    	if (nums == null || nums.length < 4) return false;
	        int sum = 0;
	        for (int num : nums) sum += num;
	        if (sum % 4 != 0) return false;
	        
	        Arrays.sort(nums);
	        reverse(nums);
	        
	    	return dfs(nums, new int[4], 0, sum / 4);
	    }
	    
	    private boolean dfs(int[] nums, int[] sums, int index, int target) {
	    	if (index == nums.length) {
	    	    if (sums[0] == target && sums[1] == target && sums[2] == target) {
	    		return true;
	    	    }
	    	    return false;
	    	}
	    	
	    	PrintArray.print(sums);
	    	for (int i = 0; i < 4; i++) {
	    	    if (sums[i] + nums[index] > target) continue;
	    	    sums[i] += nums[index];
	            if (dfs(nums, sums, index + 1, target)) return true;
	    	    sums[i] -= nums[index];
	    	}
	    	
	    	return false;
	    }
	    
	    private void reverse(int[] nums) {
	        int i = 0, j = nums.length - 1;
	        while (i < j) {
	            int temp = nums[i];
	            nums[i] = nums[j];
	            nums[j] = temp;
	            i++; j--;
	        }
	    }
	    
	    public static void main(String[] args) {
			
	    	int[] arr = new int[] {4,3,3,3,3};
	    	
	    	MakeSquare makeSquare = new MakeSquare();
	    	System.out.println(
    			makeSquare.makesquare(arr));
		}

}
