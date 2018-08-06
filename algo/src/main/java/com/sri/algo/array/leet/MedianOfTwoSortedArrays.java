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
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

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

	public static void main(String[] args) {

		MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays();

		System.out.println(median.findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 }));

		System.out.println(median.findMedianSortedArrays(new int[] { 1, 2 }, new
		int[] { 3, 4 }));

		System.out.println(median.findMedianSortedArrays(new int[] { 4, 5, 6, 8, 9 }, new int[] {}));

	}

}
