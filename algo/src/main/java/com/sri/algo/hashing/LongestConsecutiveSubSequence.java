package com.sri.algo.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Given an array of integers, find the length of the longest sub-sequence 
 * such that elements in the subsequence are consecutive integers, 
 * the consecutive numbers can be in any order.
 * 
 * Input: arr[] = {1, 9, 3, 10, 4, 20, 2};
 * Output: 4
 * 
 * The subsequence 1, 3, 4, 2 is the longest subsequence
 * of consecutive elements
 * @author KH2024
 *
 */
public class LongestConsecutiveSubSequence {
	
	/**
	 * T.C : O(n).
	 * AuxSpace : O(n).
	 * 
	 * @param arr
	 * @return
	 */
	public static int longestConsecutiveSubSequence(int[] arr)
	{	
		Set<Integer> noSet = new HashSet<>();
		
		for (int no : arr)
		{
			noSet.add(no);
		}
		
		int maxLen = Integer.MIN_VALUE;
		for (int no : arr)
		{
			// Idea is to look for starting element and process 
			// ele + 1,ele + 2.... and update maxLen.
			// We ignore those elements that are not starting elements in consecutive 
			// sequence i.e if ele -1 is present in array skip processing ele as this will
			// be covered when ele -1 is visited..
			if (!noSet.contains(no -1))
			{
				int j = no;
				int len = 0;
				while(noSet.contains(j))
				{
					len++;
					j = j + 1;
				}
				
				maxLen = Integer.max(maxLen, len);
			}
		}
		
		return maxLen;
		
	}
	
	public int longestConsecutive(int[] nums) 
	{
		if (nums.length == 0) {
			return 0;
		}

		Set<Integer> ele = new HashSet<>();

		for (int no : nums) {
			ele.add(no);
		}

	
		int max = Integer.MIN_VALUE;
		for (int no : ele) {

			// Check for previous element of every consecutive sequence. 
			// so that we can skip processing already processed elements.
			if (!ele.contains(no - 1)) {
		
				int count = 1;

				// Count all consecutive numbers starting with current no.
				while (ele.contains(no + 1)) {
					no = no + 1;
					count++;
				}

				max = Integer.max(max, count);
			}

		}

		return max;

	}
	
	public static void main(String[] args) {
		
		System.out.println(
			longestConsecutiveSubSequence(new int[]{1, 9, 3, 10, 4, 20, 2}));
		
		System.out.println(
			longestConsecutiveSubSequence(new int[]{36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}));
			
	}

}
