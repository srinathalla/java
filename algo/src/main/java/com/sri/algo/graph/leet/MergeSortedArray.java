package com.sri.algo.graph.leet;

import com.sri.algo.array.PrintArray;

/**
 *  Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

	Note:
	
	The number of elements initialized in nums1 and nums2 are m and n respectively.
	You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
	Example:
	
	Input:
	nums1 = [1,2,3,0,0,0], m = 3
	nums2 = [2,5,6],       n = 3
	
	Output: [1,2,2,3,5,6]
 * @author salla
 *
 */
public class MergeSortedArray {
	
	/**
	 * T.C O(m+n)
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		
		int i = m -1, j = n-1, k = m + n -1;
		
		while (i > -1 && j > -1)
		{
			nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
		}
		
		while (j > -1)
		{
			nums1[k--] = nums2[j--];
		}
        
    }
	
	public static void main(String[] args) {
		
		MergeSortedArray mergeSortedArray = new MergeSortedArray();
		int[] a = new int[] {1,2,3,0,0,0};
		mergeSortedArray.merge(a, 3, new int[] {2,5,6}, 3);
		
		PrintArray.print(a);
		
	}

}
