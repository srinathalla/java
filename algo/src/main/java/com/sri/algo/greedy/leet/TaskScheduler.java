package com.sri.algo.greedy.leet;

/**
 * Given a char array representing tasks CPU need to do. It contains capital
 * letters A to Z where different letters represent different tasks. Tasks could
 * be done without original order. Each task could be done in one interval. For
 * each interval, CPU could finish one task or just be idle.
 * 
 * However, there is a non-negative cooling interval n that means between two
 * same tasks, there must be at least n intervals that CPU are doing different
 * tasks or just be idle.
 * 
 * You need to return the least number of intervals the CPU will take to finish
 * all the given tasks.
 * 
 * 
 * 
 * Example:
 * 
 * Input: tasks = ["A","A","A","B","B","B"], n = 2 Output: 8 Explanation: A -> B
 * -> idle -> A -> B -> idle -> A -> B.
 * 
 * @author srialla
 *
 */
public class TaskScheduler {

	public int leastInterval(char[] tasks, int n) {

		int[] count = new int[26];
		int max = 0;
		int mc = 0;

		for (char c : tasks) {
			count[c - 'A']++;
			if (max == count[c - 'A']) {
				mc++;
			} else if (max < count[c - 'A']) {
				max = count[c - 'A'];
				mc = 1;
			}
		}

		int partCount = max - 1;
		int partLength = n - (mc - 1);
		int emptySlots = partCount * partLength;
		int availableTaks = tasks.length - (max) * mc;
		int idles = Math.max(0, emptySlots - availableTaks);

		return tasks.length + idles;
	}

	public static void main(String[] args) {

		char[] in = new char[] { 'A', 'A', 'A', 'B', 'B', 'B' };
		TaskScheduler taskScheduler = new TaskScheduler();
		System.out.println(taskScheduler.leastInterval(in, 2));

	}

}
