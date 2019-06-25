package com.sri.algo.dp.leet;

import java.util.HashMap;
import java.util.Map;

import com.sri.algo.array.PrintArray;

/**
 * 
 *  You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

	The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
	
	Example 1:
	Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
	Output: [-1,3,-1]
	
    Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1
 *  
 *  @author salla
 *
 */
public class NextGreaterElement1 {
	
	 public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		 
			Map<Integer, Integer> map = new HashMap<>();
	
			int[] p = new int[nums2.length];
	
			int pidx = -1;
			for (int i = 0; i < nums2.length; i++) {
				while (pidx != -1 && nums2[i] > nums2[p[pidx]]) {
					map.put(nums2[p[pidx]], nums2[i]);
					pidx--;
				}
	
				pidx++;
				p[pidx] = i;
			}
	
			int[] r = new int[nums1.length];
			for (int i = 0; i < nums1.length; i++) {
				r[i] = map.getOrDefault(nums1[i], -1);
			}
	
			return r;    
	    }
	 
	 public static void main(String[] args) {
				 
		 NextGreaterElement1 next = new NextGreaterElement1();
		 
		 int[] res = next.nextGreaterElement(new int[] {4,1,2}, new int[] {1,3,4,2});
		 
		 PrintArray.print(res);
	}

}
