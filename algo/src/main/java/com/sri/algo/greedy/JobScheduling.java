package com.sri.algo.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Given a set of n jobs where each job i has a deadline and profit associated to it. 
 * Each job takes 1 unit of time to complete and only one job can be scheduled at a time.
 * We earn the profit if and only if the job is completed by its deadline. 
 * The task is to find the maximum profit and the number of jobs done.
 * 
 * 		
 *        Sample : 
 *          2
			4
			1 4 20 2 1 10 3 1 40 4 1 30
			5
			1 2 100 2 1 19 3 2 27 4 1 25 5 1 15
			
			Output:
			2 60
			2 127
		 
 * 
 *
 */
public class JobScheduling {
	
	static class Job
	{
		int id;
		int deadline;
		int profit;
		
		public Job(int id, int deadline, int profit) {
			super();
			this.id = id;
			this.deadline = deadline;
			this.profit = profit;
		}	
	}
	
	public static void scheduleJobs(Job[] jobs)
	{
		// Sort the elements based on profit in descending order.
		Arrays.sort(jobs,new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				
				return o2.profit - o1.profit;
			}
		});
		
		int total = 0;
		int profit = 0;
		int[] scheduledJobs = new int[jobs.length];
		
		for (Job job : jobs)
		{	
			// Pick the job with maximum profit and try to allocate slot available 
			// just before its deadline, break once slot is booked for the job.
			// this greedy approach works because each job takes same time 1 unit.
			// if each job takes different time we should use dp to get max profit.
			for (int j = Integer.min(job.deadline,scheduledJobs.length) -1; j >=0; j--)
			{
				// Book if slot available.
				if (scheduledJobs[j] == 0)
				{
					scheduledJobs[j] = job.id; // updates slot with job id.
					total++;
					profit = profit + job.profit;
					break;
				}
			}
		}
			
		System.out.println(total +" " + profit);	
	}
	
	public static void main(String[] args) {
		
		/**
		 * Sample : 
		 *  2
			4
			1 4 20 2 1 10 3 1 40 4 1 30
			5
			1 2 100 2 1 19 3 2 27 4 1 25 5 1 15
			
			Output:
			2 60
			2 127
		 */
		try(Scanner in = new Scanner(System.in))
		{
	        int testCount = in.nextInt();
	        
	        for (int i =0 ;i < testCount ; i++)
	        {
	        	int n = in.nextInt();
	        	Job[] jobs = new Job[n];
	        	
	        	for (int j = 0 ;j < n ; j++)
	        	{	
	        		int jobId = in.nextInt();
	        		int deadline = in.nextInt();
	        		int profit = in.nextInt();
	        		jobs[j] = new Job(jobId,deadline,profit);
	        	}
	        	
	    		scheduleJobs(jobs);
	        }
		}
		
		
	}

}
