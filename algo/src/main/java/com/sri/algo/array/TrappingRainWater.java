package com.sri.algo.array;

public class TrappingRainWater {

	/**
	 * Time Complexity O(n). Loop through given array 3 times.
	 * 
	 * 3 pass solution.
	 * 
	 * @param elevation
	 * @return
	 */
	public static int maxWater(int[] elevation) {
		// Each entry stores maximum elevation to the left till current index.
		int[] lElevation = new int[elevation.length];

		// Each entry stores maximum elevation to the right till current index.
		int[] rElevation = new int[elevation.length];

		lElevation[0] = elevation[0];
		rElevation[elevation.length - 1] = elevation[elevation.length - 1];

		for (int index = 1; index < elevation.length; index++) {
			lElevation[index] = Integer.max(elevation[index], lElevation[index - 1]);
		}

		for (int index = elevation.length - 2; index >= 0; index--) {
			rElevation[index] = Integer.max(elevation[index], rElevation[index + 1]);
		}

		int sum = 0;

		for (int index = 0; index < elevation.length; index++) {
			sum = sum + Integer.min(lElevation[index], rElevation[index]) - elevation[index];
		}

		return sum;
	}

	/**
	 * Single pass solution.
	 * Using two pointers.
	 * 
	 * T.C : O(n).
	 * 
	 * @param height
	 * @return
	 */
	public int trap(int[] height) 
	{	
	   int n = height.length;
   	   int sum = 0, lmax = height[0], rmax = height[n-1];
   	   
   	   int l = 0;
   	   int r = n-1;
   	   
   	   while(l < r)
   	   {   		  
   		 
   		   // Current building will be able to hold water if its height is less than atleast one building to the right.
   		   // The amount of water held is lmax - height[l];
   		   if (height[l] < height[r])
   		   {
   			   lmax = Integer.max(lmax, height[l]);   
   			   sum = sum + lmax - height[l++];
   		   }
   		   else
   		   {
   			   rmax = Integer.max(rmax, height[r]);   
 			   sum = sum + rmax - height[r--];
   		   }  
   		   
   	
   	   }
   	   
   	   return sum;
	}
	
	public int trapWater(int[] height) {
	
			int sum = 0;
			int n = height.length;
	
			if (n == 0) {
				return 0;
			}
			int lmax = height[0], rmax = height[n - 1];
	
			int l = 0, r = n - 1;
	
			while (l <= r) {
	
				if (height[l] < height[r]) {
					if (height[l] < lmax) {
						sum += lmax - height[l];
					} else {
						lmax = height[l];
					}
					l++;
				} else {
					if (height[r] < rmax) {
						sum += rmax - height[r];
					} else {
						rmax = height[r];
					}
					r--;
				}
			}
	
			return sum;
	    }

	public static void main(String[] args) {

		TrappingRainWater tr = new TrappingRainWater();

	/*	System.out.println(maxWater(new int[] { 2, 0, 2 }));

		System.out.println(maxWater(new int[] { 3, 0, 0, 2, 0, 4 }));

		System.out.println(maxWater(new int[] { 6, 9, 9 }));*/

		System.out.println(tr.trap(new int[] { 2, 0, 2 }));
		System.out.println(tr.trapWater(new int[] { 4, 2, 3 }));

		/*System.out.println(tr.trap(new int[] { 3, 0, 0, 2, 0, 4 }));

		System.out.println(tr.trap(new int[] { 6, 9, 9 }));*/

	}

}
