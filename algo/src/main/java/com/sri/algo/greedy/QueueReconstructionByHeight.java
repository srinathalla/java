package com.sri.algo.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.sri.algo.array.PrintArray;

public class QueueReconstructionByHeight {

	
	/**
	 * T.C : O(n^2)
	 * 
	 * sort : nlongn + insertion O(n^2) as we are using arraylist.
	 * @param people
	 * @return
	 */
	public int[][] reconstructQueue(int[][] people) {
		
		if (people.length < 2)
		{
			return people;
		}

		Arrays.sort(people, (int[] a, int[] b) -> (a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]));

		List<int[]> arrangedList = new ArrayList<>();
		for (int[] person : people) {
			arrangedList.add(person[1], person);
		}

		return arrangedList.toArray(new int[0][0]);
	}
	
	/**
	 * T.C : O(nlongn)
	 * 
	 * sort : O(nlongn) + insertion O(n) as we are using linked list.
	 * @param people
	 * @return
	 */
     public int[][] reconstructQueueUsingLL(int[][] people) {
		
		if (people.length < 2)
		{
			return people;
		}

		Arrays.sort(people, (int[] a, int[] b) -> (a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]));

		List<int[]> arrangedList = new LinkedList<>();
		for (int[] person : people) {
			arrangedList.add(person[1], person);
		}

		return arrangedList.toArray(new int[0][0]);
	}
	
	
	

	public static void main(String[] args) {

		int[][] q = new int[][] { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };

		QueueReconstructionByHeight qr = new QueueReconstructionByHeight();

		// q = qr.reconstructQueue(q);
		
		q = qr.reconstructQueueUsingLL(q);

		for (int[] a : q) {
			PrintArray.print(a);
		}

	}

}
