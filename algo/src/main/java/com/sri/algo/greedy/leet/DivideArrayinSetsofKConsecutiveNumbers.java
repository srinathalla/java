package com.sri.algo.greedy.leet;

import java.util.TreeMap;

public class DivideArrayinSetsofKConsecutiveNumbers {

	public boolean isPossibleDivide(int[] nums, int k) {

		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int no : nums) {
			map.put(no, map.getOrDefault(no, 0) + 1);
		}

		int pk;
		while (!map.isEmpty()) {
			pk = 0;
			Integer key = map.firstKey();
			while (!map.isEmpty() && pk < k) {
				
				if (map.get(key) > 1) {
					map.put(key, map.get(key) - 1);
				} else {
					map.remove(key);
				}

				pk++;
				Integer higher = pk == k || map.isEmpty() ? 0 : map.higherKey(key);
				if(higher != 0 && higher != key + 1)
				{
					return false;
				}
				key = higher;
			}
			if (pk < k) {
				return false;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		
		DivideArrayinSetsofKConsecutiveNumbers divideArrayinSetsofKConsecutiveNumbers = new
				DivideArrayinSetsofKConsecutiveNumbers();

		System.out.println(
			divideArrayinSetsofKConsecutiveNumbers
				.isPossibleDivide(new int[] 
						{15,16,17,18,19,16,17,18,19,20,6,7,8,9,10,3,4,5,6,20}
						, 5));
	}

}
