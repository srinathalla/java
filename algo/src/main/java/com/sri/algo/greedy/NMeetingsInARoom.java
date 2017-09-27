package com.sri.algo.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * There is one meeting room in Flipkart. There are n meetings in the form of 
 * (S [ i ], F [ i ]) where S [ i ] is start time of meeting i and F [ i ] is finish
 *  time of meeting i What is the maximum number of meetings that can be
 * accommodated in the meeting room 
 * 
 * 	Input:
 *
	2
	6
	1 3 0 5 8 5
	2 4 6 7 9 9
	8
	75250 50074 43659 8931 11273 27545 50879 77924
	112960 114515 81825 93424 54316 35533 73383 160252  

	Output: indexes of meeting scheduled.
	
	1 2 4 5
	6 7 1
 *
 */
public class NMeetingsInARoom {
	
	static class Meeting
	{
		int start;
		int end;
		int arrayIndex;
		
		Meeting(int start , int end,int arrayIndex)
		{
			this.start = start;
			this.end = end;
			this.arrayIndex = arrayIndex;
		}
	}
	
	/**
	 * Time Complexity : O(nlogn)
	 * Auxillary space : O(n).
	 * 
	 * Sorting activities takes O(nlogn),
	 * Meeting array takes O(n) space for n Meeting objects.
	 * 
	 
	 * @param start
	 * @param end
	 * @return
	 */
	public static int printMeetingOrder(int[] start,int[] end)
	{
		 Meeting[] meetings = new Meeting[start.length];		
		 for (int i = 0; i<start.length ; i++)
		 {
			 meetings[i] = new Meeting(start[i],end[i],i);
		 }
		 
		 // Sort activities by their end times in ascending order.
		 // i.e smallest end time as the first and biggest end time
		 // as the last.
		 Arrays.sort(meetings, new Comparator<Meeting>() {

			@Override
			public int compare(Meeting o1, Meeting o2) {
				
				return o1.end -o2.end;
			}
		});
		 
		 int meetingCount = 1;
		 
		 // First Meeting that ends early is performed.
		 Meeting prevScheduled = meetings[0];
		 System.out.println();
		 System.out.print(meetings[0].arrayIndex + 1 + " ");
		
		 // current Meeting can be scheduled only if it starts 
		 // after previous Meeting scheduled ends.
		 for(int i =1; i < meetings.length;i++)
		 {
			 Meeting currMeeting = meetings[i];
			 
			 if (currMeeting.start >= prevScheduled.end)
			 {
				 meetingCount++;
				 prevScheduled = currMeeting;
				 System.out.print(currMeeting.arrayIndex + 1 + " ");
			 }
		 }
			 
		 return meetingCount;	
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
	        	
	    		printMeetingOrder(arr,arr1);
	        }
		}
		
	}

}
