package com.sri.algo.string.leet;

public class SwapAdjacent {

	public boolean canTransform(String start, String end) {

		char[] s = start.toCharArray();
		char[] e = end.toCharArray();

		for (int i = 0; i < s.length; i++) {
			
			if (s[i] != e[i] && i < s.length - 1) {
				if ((s[i] == 'R' && s[i + 1] == 'X') || (s[i] == 'L' && s[i + 1] == 'R')) {
					char tmp = s[i];
					s[i] = s[i + 1];
					s[i + 1] = tmp;
				}
			}

			if (s[i] != e[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		SwapAdjacent sa = new SwapAdjacent();
		String start = "RXXLRXRXL", end = "XRLXXRRLX";
		System.out.println(sa.canTransform(start, end));

	}

}
