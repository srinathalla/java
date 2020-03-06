package com.sri.algo.dp.leet.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CanIWin {

	Map<String, Boolean> map = new HashMap<>();
	int[] used;

	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
		if (sum < desiredTotal) {
			return false;
		}

		if (desiredTotal <= 0) {
			return true;
		}

		used = new int[maxChoosableInteger];
		return helper(desiredTotal);
	}

	public boolean helper(int desiredTotal) {

		if (desiredTotal <= 0) {
			return false;
		}

		String key = Arrays.toString(used);
		if (!map.containsKey(key)) {
			for (int i = 0; i < used.length; i++) {
				if (used[i] == 0) {
					used[i] = 1;
					if (!helper(desiredTotal - (i + 1))) {
						map.put(key, true);
						used[i] = 0;
						return true;
					}
					used[i] = 0;
				}
			}
			map.put(key, false);
		}

		return map.get(key);
	}

	public static void main(String[] args) {

		CanIWin canIWin = new CanIWin();
		System.out.println(canIWin.canIWin(10, 11));

	}

}
