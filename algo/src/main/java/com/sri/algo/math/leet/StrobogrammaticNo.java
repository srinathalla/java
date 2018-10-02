package com.sri.algo.math.leet;

import java.util.HashMap;
import java.util.Map;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 * 
 * Write a function to determine if a number is strobogrammatic. The number is
 * represented as a string.
 * 
 * Example 1:
 * 
 * Input: "69" Output: true Example 2:
 * 
 * Input: "88" Output: true Example 3:
 * 
 * Input: "962" Output: false
 * 
 * @author salla
 *
 */
public class StrobogrammaticNo {

	public boolean isStrobogrammatic(String num) {

		Map<Character, Character> map = new HashMap<>();

		map.put('0', '0');
		map.put('1', '1');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');

		int i = 0, j = num.length() - 1;

		while (i <= j && map.containsKey(num.charAt(i)) && num.charAt(j) == map.get(num.charAt(i))) {
			i++;
			j--;
		}

		return i > j;
	}

	public static void main(String[] args) {

		StrobogrammaticNo sn = new StrobogrammaticNo();

		System.out.println(sn.isStrobogrammatic("0"));
		System.out.println(sn.isStrobogrammatic("1"));
		System.out.println(sn.isStrobogrammatic("8"));
		System.out.println(sn.isStrobogrammatic("6"));
		System.out.println(sn.isStrobogrammatic("11"));
		System.out.println(sn.isStrobogrammatic("69"));
		System.out.println(sn.isStrobogrammatic("88"));
		System.out.println(sn.isStrobogrammatic("96"));
		System.out.println(sn.isStrobogrammatic("090"));

	}

}
