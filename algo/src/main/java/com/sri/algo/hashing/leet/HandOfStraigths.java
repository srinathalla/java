package com.sri.algo.hashing.leet;

import java.util.TreeMap;

public class HandOfStraigths {

	public boolean isNStraightHand(int[] hand, int W) {

		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int h : hand) {
			map.put(h, map.getOrDefault(h, 0) + 1);
		}

		while (!map.isEmpty()) {
			Integer key = map.firstKey();
			for (int i = key; i < key + W; i++) {
				if (map.containsKey(i)) {
					return false;
				}

				map.put(i, map.get(i) - 1);
				if (map.get(i) == 0) {
					map.remove(i);
				}
			}
		}

		return true;
	}

}
