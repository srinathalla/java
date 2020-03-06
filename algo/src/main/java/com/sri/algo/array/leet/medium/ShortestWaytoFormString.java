package com.sri.algo.array.leet.medium;

/**
 * From any string, we can form a subsequence of that string by deleting some
 * number of characters (possibly no deletions).
 * 
 * Given two strings source and target, return the minimum number of
 * subsequences of source such that their concatenation equals target. If the
 * task is impossible, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: source = "abc", target = "abcbc" Output: 2 Explanation: The target
 * "abcbc" can be formed by "abc" and "bc", which are subsequences of source
 * "abc".
 * 
 * @author srialla
 *
 */
public class ShortestWaytoFormString {

	public int shortestWay(String source, String target) {

		boolean[] map = new boolean[26];
		for (char ch : source.toCharArray()) {
			map[ch - 'a'] = true;
		}

		int j = 0, res = 0;
		for (int i = 0; i < target.length(); i++, j++) {
			char ch = target.charAt(i);
			if (!map[ch- 'a']) {
				return -1;
			}

			while (j < source.length() && source.charAt(j) != target.charAt(i)) {
				j++;
			}

			if (j == source.length()) {
				j = -1;
				res++;
				i--;
			}
		}
		return res + 1;
	}

	public static void main(String[] args) {

		ShortestWaytoFormString shortestWaytoFormString = new ShortestWaytoFormString();
		System.out.println(shortestWaytoFormString.shortestWay("abc", "abcbc"));

	}

}
