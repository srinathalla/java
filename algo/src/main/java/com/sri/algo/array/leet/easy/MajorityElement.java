package com.sri.algo.array.leet.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Example 1:
 * 
 * Input: [3,2,3] Output: 3
 * 
 * @author salla
 *
 */
public class MajorityElement {

	/**
	 * T.C : O(n)
	 * S.C : O(n)
	 * 
	 * @param nums
	 * @return
	 */
	public int majorityElementWithMap(int[] nums) {
		
		int mc = nums.length/2;
		
		Map<Integer,Integer> map = new HashMap<>();
		
		for (int no : nums)
		{
			map.put(no, map.getOrDefault(no, 0) + 1);
			
			if(map.get(no) > mc)
			{
				return no;
			}
		}
		
		return -1;

	}
	
	public int majorityElement(int[] nums) {
		int count = 0;
		Integer candidate = null;

		for (int no : nums) {
			if (count == 0) {
				candidate = no;
			}

			count += candidate == no ? 1 : -1;
		}

		return candidate;

	}
	
	
	public static void main(String[] args) {
		MajorityElement majorityElement = new MajorityElement();
		
		System.out.println(
			majorityElement.majorityElement(new int[] {2,2,1,1,1,2,2}));
	}

}
