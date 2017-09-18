package com.sri.algo.array;

public class TrappingRainWater {
	
	/**
	 * Time Complexity O(n).
	 * Loop through given array 3 times.
	 * 
	 * @param elevation
	 * @return
	 */
	public static int maxWater(int[] elevation) 
	{
		// Each entry stores maximum elevation to the left till current index.
		int[] lElevation = new int[elevation.length];
		
		// Each entry stores maximum elevation to the right till current index.
		int[] rElevation = new int[elevation.length];
		
		lElevation[0] = elevation[0];
		rElevation[elevation.length - 1] =  elevation[elevation.length -1];
		
		for (int index = 1; index < elevation.length ; index++)
		{
			lElevation[index] = Integer.max(elevation[index], lElevation[index -1]);
		}
		
		for (int index = elevation.length -2 ; index >= 0 ; index--)
		{
			rElevation[index] = Integer.max(elevation[index], rElevation[index +1]);
		}
		
		int sum = 0;
		
		for (int index = 0; index < elevation.length ; index++)
		{
			sum = sum + Integer.min(
					lElevation[index], 
					rElevation[index]) - elevation[index];
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		
		System.out.println(maxWater(new int[] {2,0,2}));	
		
		System.out.println(maxWater(new int[] {3,0,0,2,0,4}));
		
		System.out.println(maxWater(new int[] {6,9,9}));
	}

}
