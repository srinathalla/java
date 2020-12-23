package com.sri.algo.backtrack.leet;

import java.util.HashMap;
import java.util.Map;

public class ConfusingNo2 {

	int[] valid;
	Map<Integer, Integer> mapping;
	int cnt;

	public int confusingNumberII(int N) {

		this.valid = new int[] { 0, 1, 6, 8, 9 };
		this.mapping = Map.of(0, 0, 1, 1, 6, 9, 8, 8, 9, 6);
		this.cnt = 0;

		backtrack(1, 1, 10, N);
		backtrack(6, 9, 10, N);
		backtrack(8, 8, 10, N);
		backtrack(9, 6, 10, N);

		return this.cnt;

	}

	private void backtrack(int v, int rot, int digit, int N) {

		if (v > 0) {
			if (v != rot) {
				cnt++;
			}
		}

		for (int a : valid) {
			if (v * 10 + a > N) {
				break;
			} else {
				backtrack(v * 10 + a, mapping.get(a) * digit + rot, digit * 10, N);
			}
		}
	}

	
	public static void main(String[] args) {
		
		for(int i=1; i <= 20;i++)
		{
			// System.out.println("i: " + i + " ,"+ isConfusing(i));
		}
		
		System.out.println(Integer.MAX_VALUE);

	}

}
