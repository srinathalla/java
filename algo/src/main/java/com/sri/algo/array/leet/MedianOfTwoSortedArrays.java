package com.sri.algo.array.leet;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * @author salla
 *
 */
public class MedianOfTwoSortedArrays {

	
	/**
	 *  O(n + m).
	 *  
	 *  using merge of two sorted arrays we traverse till (n+m)/2 + 1 elements are merged 
	 *  use curr, prev pointers to store elements..
	 *  
	 *  if odd return 
	 *  
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public double findMedianSortedArraysNaive(int[] nums1, int[] nums2) {

		int n = nums1.length, m = nums2.length;

		double result = 0;
		if (n == 0) {

			if (m == 1) {
				return nums2[0];
			}

			if (m % 2 == 0) {
				return (nums2[m / 2] + nums2[m / 2 - 1]) / 2.0;

			} else {
				return nums2[m / 2];
			}
		}

		if (m == 0) {

			if (n == 1) {
				return nums1[0];
			}

			if (n % 2 == 0) {
				result = (nums1[n / 2] + nums1[n / 2 - 1]) / 2.0;
				return result;
			} else {
				return nums1[n / 2];
			}
		}

		int i = 0, j = 0;
		int count = 0, prev = -1, curr = -1;
		while (count < ((n + m) / 2 + 1) && i < n && j < m) {

			prev = curr;
			if (nums1[i] <= nums2[j]) {
				curr = nums1[i++];
			} else {
				curr = nums2[j++];
			}
			count++;
		}

		while (count < ((n + m) / 2 + 1) && i < n) {
			prev = curr;
			curr = nums1[i++];
			count++;
		}

		while (count < ((n + m) / 2 + 1) && j < m) {
			prev = curr;
			curr = nums2[j++];
			count++;
		}

		if ((n + m) % 2 == 0) {
			return (prev + curr) / 2.0;
		}

		return curr;
	}
	
	double findMedianSortedArrays(int[] nums1, int[] nums2) {
	    int N1 = nums1.length;
	    int N2 = nums2.length;
	    if (N1 < N2) return findMedianSortedArrays(nums2, nums1);	// Make sure A2 is the shorter one.
	    
	    int lo = 0, hi = N2 * 2;
	    while (lo <= hi) {
	        int mid2 = (lo + hi) / 2;   // Try Cut 2 
	        int mid1 = N1 + N2 - mid2;  // Calculate Cut 1 accordingly
	        
	        double L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1-1)/2];	// Get L1, R1, L2, R2 respectively
	        double L2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2-1)/2];
	        double R1 = (mid1 == N1 * 2) ? Integer.MAX_VALUE : nums1[(mid1)/2];
	        double R2 = (mid2 == N2 * 2) ? Integer.MAX_VALUE : nums2[(mid2)/2];
	        
	        if (L1 > R2) lo = mid2 + 1;		// A1's lower half is too big; need to move C1 left (C2 right)
	        else if (L2 > R1) hi = mid2 - 1;	// A2's lower half too big; need to move C2 left.
	        else return (Double.max(L1,L2) + Double.min(R1, R2)) / 2;	// Otherwise, that's the right cut.
	    }
	    
	    return -1;
	} 

	public static void main(String[] args) {

		MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays();

		// System.out.println(median.findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 }));

		System.out.println(median.findMedianSortedArrays(new int[] { 1, 2 }, new
		int[] { 3, 4 }));

		// System.out.println(median.findMedianSortedArrays(new int[] { 4, 5, 6, 8, 9 }, new int[] {}));

	}

}
