package com.sri.algo.array.leet.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * 	Numbers can be regarded as product of its factors. For example,

	8 = 2 x 2 x 2;
	  = 2 x 4.
	Write a function that takes an integer n and return all possible combinations of its factors.
	
	Note:
	
	You may assume that n is always positive.
	Factors should be greater than 1 and less than n.
	Example 1:
	
	Input: 1
	Output: []
	Example 2:
	
	Input: 37
	Output:[]
	Example 3:
	
	Input: 12
	Output:
	[
	  [2, 6],
	  [2, 2, 3],
	  [3, 4]
	]
	Example 4:
	
	Input: 32
	Output:
	[
	  [2, 16],
	  [2, 2, 8],
	  [2, 2, 2, 4],
	  [2, 2, 2, 2, 2],
	  [2, 4, 4],
	  [4, 8]
	]
 * @author salla
 *
 */
public class Factorials {
	
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> result = new ArrayList<>();
		
		helper(result, new ArrayList<>(), n, 2);
		return result;
	}

	public void helper(List<List<Integer>> result, List<Integer> item, int n, int start){
		
		for (int i= start; i * i <= n; i++)
		{
			
			if (n % i == 0)
			{
				item.add(i);
				item.add(n/i);
				result.add(new ArrayList<>(item));
				item.remove(item.size() -1);
				
				helper(result, item, n/i, i);
				item.remove(item.size() -1);
				
				
			}
		}
	}
	
	public static void main(String[] args) {
		
		Factorials factorials = new Factorials();
		
		System.out.println(factorials.getFactors(8));
		System.out.println(factorials.getFactors(12));
		System.out.println(factorials.getFactors(16));
		
	}

}
