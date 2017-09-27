package com.sri.algo.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Given N activities with their start and finish times.
 * Select the maximum number of activities that can be performed by a
 * single person, assuming that a person can only work on a single activity
 * at a time.
 *
 *
 */
public class ActivitySelection {
	
	static class Activity
	{
		int start;
		int end;
		
		Activity(int start , int end)
		{
			this.start = start;
			this.end = end;
		}
	}
	
	/**
	 * Time Complexity : O(nlogn)
	 * Auxillary space : O(n).
	 * 
	 * Sorting activities takes O(nlogn),
	 * Activity array takes O(n) space for n activity objects.
	 * 
	 
	 * @param start
	 * @param end
	 * @return
	 */
	public static int countMaxActivities(int[] start,int[] end)
	{
		 Activity[] activities = new Activity[start.length];		
		 for (int i = 0; i<start.length ; i++)
		 {
			 activities[i] = new Activity(start[i],end[i]);
		 }
		 
		 // Sort activities by their end times in ascending order.
		 // i.e smallest end time as the first and biggest end time
		 // as the last.
		 Arrays.sort(activities, new Comparator<Activity>() {

			@Override
			public int compare(Activity o1, Activity o2) {
				
				return o1.end -o2.end;
			}
		});
		 
		 int activityCount = 1;
		 
		 // First activity that ends early is performed.
		 Activity prevScheduled = activities[0];
		
		 // current activity can be scheduled only if it starts 
		 // after previous activity scheduled ends.
		 for(int i =1; i < activities.length;i++)
		 {
			 Activity currActivity = activities[i];
			 
			 if (currActivity.start >= prevScheduled.end)
			 {
				 activityCount++;
				 prevScheduled = currActivity;		 
			 }
		 }
			 
		 return activityCount;	
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
	        	
	    		System.out.println(countMaxActivities(arr,arr1));
	        }
		}
		
	}
	
	

}
