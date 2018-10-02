package com.sri.algo.math.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 * 
 * Find all strobogrammatic numbers that are of length = n.
 * 
 * Example:
 * 
 * Input: n = 2 Output: ["11","69","88","96"]
 * 
 * @author salla
 *
 */
public class StrobogrammaticNumber2 {

	private static char[][] pairs = { { '0', '0' }, { '1', '1' }, { '6', '9' }, { '8', '8' }, { '9', '6' } };

	public List<String> findStrobogrammatic(int n) {

		List<String> res = new ArrayList<>();

		char[] chars = new char[n];

		dfs(chars, 0, n - 1, res);

		return res;

	}

	void dfs(char[] c, int left, int right, List<String> res) {

		if (left > right) {
			res.add(new String(c));
			return;
		}

		for (char[] p : pairs) {
			c[left] = p[0];
			c[right] = p[1];

			if (c[0] == '0' && c.length != 1) {
				continue;
			}

			if (left == right && p[0] != p[1]) {
				continue;
			}

			dfs(c, left + 1, right - 1, res);
		}

	}

	public static void main(String[] args) {

		StrobogrammaticNumber2 sn = new StrobogrammaticNumber2();

		System.out.println(sn.findStrobogrammatic(2));

	}

}
