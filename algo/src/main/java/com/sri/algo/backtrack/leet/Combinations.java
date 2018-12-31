package com.sri.algo.backtrack.leet;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	
	private List<List<Integer>> result;
	public List<List<Integer>> combine(int n, int k) {

		result = new ArrayList<>();
		
		combine(1,n,k,new ArrayList<>());

		return result;
	}
	
	private void combine(int l, int n,int k,List<Integer> c)
	{
		if (c.size() == k)
		{
			result.add(new ArrayList<>(c));
			return;
		}
		
		if(l > n)
		{
			return;
		}
		
		c.add(l);
		combine(l + 1, n,k,c);
		c.remove(c.size() -1);
		
		combine(l + 1, n,k,c);
	}
	
	public static void main(String[] args) {
		
		
		Combinations combinations = new Combinations();
		
		System.out.println(combinations.combine(4, 2));
		
		System.out.println(combinations.combine(2, 1));
		
	}

}
