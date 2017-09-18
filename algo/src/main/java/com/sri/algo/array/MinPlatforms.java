package com.sri.algo.array;

public class MinPlatforms {

	/**
	 * Returns minimum number of platforms required.
	 * 
	 * @param arr
	 * @param dep
	 * @param n
	 * @return
	 */
	public static int findMinPlatforms(int arr[], int dep[], int n) 
	{
		int result = 1, platformNeeded = 1;
		int i = 1, j = 0;

		while (i < n && j < n) {
			if (arr[i] < dep[j]) {
				
				// If arrival time of current train is less than departure time of prev train,
				// current train arrived needs a new platform. 
				platformNeeded++;

				result = Integer.max(result, platformNeeded);
				i++;
			} else {
				platformNeeded--;
				j++;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };

		System.out.println(findMinPlatforms(arr, dep, dep.length));
	}

}
