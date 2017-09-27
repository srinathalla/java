package com.sri.algo.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given arrival and departure times of all trains that reach a railway station, 
 * find the minimum number of platforms required for the railway station so that no train waits.
 * 
 *  1
	6 
	900  940 950  1100 1500 1800
	910 1200 1120 1130 1900 2000
	
	OUTPUT:

	3
 *
 */
public class MinPlatforms {
	
	
	/**
	 * Time Complexity : O(nlogn)
	 * Auxillary space : O(1).
	 * 
	 * Sorting activities takes O(nlogn).
	 * 
	 
	 * @param start
	 * @param end
	 * @return
	 */
	public static int countMinPlatforms(int[] start,int[] end)
	{
		 
		 Arrays.sort(start);
		 Arrays.sort(end);
		 
		 int minPlatforms = 1;
		 int platformsRequired = 1;
		 
		 int i = 1,j = 0;
		
		 // This code works like a merge routine
		 while(i < start.length && j < end.length)
		 {		 
			 // If a new train arrived before departure of jth train,
			 // new train needs a new platform.
			 if (start[i] < end[j])
			 {
				 platformsRequired++;
				 minPlatforms = Integer.max(minPlatforms, platformsRequired);
				 i++;
			 }
			 else
			 {
				 // Since jth train departed from platform 'platformsRequired' decrease by 1.
				 platformsRequired--;
				 j++;	 
			 }
		 }
			 
		 return minPlatforms;	
	}
	
	public static void main(String[] args) {
		
		/*System.out.println(countMaxActivities(new int[] {1, 3, 0, 5, 8, 5},
				new int[] {2 ,4 ,6,7,9, 9}));*/
		
		try(Scanner in = new Scanner(System.in))
		{
	        int testCount = in.nextInt();
	        
	        for (int i =0 ;i < testCount ; i++)
	        {
	        	int n = in.nextInt();
	        	int[] arr = new int[n];
	        	
	        	for (int j = 0 ;j < n ; j++)
	        	{
	        		arr[j] = in.nextInt();
	        	}
	        	
	        	int[] arr1 = new int[n];
	        	
	        	for (int j = 0 ;j < n ; j++)
	        	{
	        		arr1[j] = in.nextInt();
	        	}
	        	
	    		System.out.println(countMinPlatforms(arr,arr1));
	        }
		}
		
	}
	

}
