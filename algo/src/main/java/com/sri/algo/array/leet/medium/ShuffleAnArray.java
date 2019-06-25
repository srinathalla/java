package com.sri.algo.array.leet.medium;

import java.util.Random;

import com.sri.algo.array.PrintArray;

/**
 *  Shuffle a set of numbers without duplicates.

	Example:
	
	// Init an array with set 1, 2, and 3.
	int[] nums = {1,2,3};
	Solution solution = new Solution(nums);
	
	// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
	solution.shuffle();
	
	// Resets the array back to its original configuration [1,2,3].
	solution.reset();
	
	// Returns the random shuffling of array [1,2,3].
	solution.shuffle();
	
 * @author salla
 *
 */
public class ShuffleAnArray {
	
		ShuffleAnArray(int[] nums)
		{
			 array = nums;
		     original = nums.clone();
		}
	
	    private int[] array;
	    private int[] original;

	    Random rand = new Random();

	    private int randRange(int min, int max) {
	        return rand.nextInt(max - min) + min;
	    }

	    private void swapAt(int i, int j) {
	        int temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	    }
	    
	    public int[] reset() {
	        array = original;
	        original = original.clone();
	        return original;
	    }
	    
	    public int[] shuffle() {
	        for (int i = 0; i < array.length; i++) {
	            swapAt(i, randRange(i, array.length));
	        }
	        return array;
	    }
	    
	    public static void main(String[] args) {
	    	
	    	
	    	ShuffleAnArray shuffleAnArray  = new ShuffleAnArray(new int[] {1,2,3});
	    	
	    	
	    	for (int i=0; i< 6; i++)
	    	{
	    		PrintArray.print(
	    				shuffleAnArray.shuffle());
	    	}
	    	
	    	
	    	
	    	
			
		}

}
