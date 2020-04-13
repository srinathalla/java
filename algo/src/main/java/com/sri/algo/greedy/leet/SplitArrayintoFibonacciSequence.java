package com.sri.algo.greedy.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S of digits, such as S = "123456579", we can split it into a
 * Fibonacci-like sequence [123, 456, 579].
 * 
 * Formally, a Fibonacci-like sequence is a list F of non-negative integers such
 * that:
 * 
 * 0 <= F[i] <= 2^31 - 1, (that is, each integer fits a 32-bit signed integer
 * type); F.length >= 3; and F[i] + F[i+1] = F[i+2] for all 0 <= i < F.length -
 * 2. Also, note that when splitting the string into pieces, each piece must not
 * have extra leading zeroes, except if the piece is the number 0 itself.
 * 
 * Return any Fibonacci-like sequence split from S, or return [] if it cannot be
 * done.
 * 
 * Example 1:
 * 
 * Input: "123456579" Output: [123,456,579]
 * 
 * @author srialla
 *
 */
public class SplitArrayintoFibonacciSequence {

	public List<Integer> splitIntoFibonacci(String s) {

		List<Integer> res = new ArrayList<>();

		recurse(s, 0, res);

		return res;
	}

	private boolean recurse(String s, int idx, List<Integer> res) {
		if (idx == s.length() && res.size() >= 3) {
			return true;
		}

		for (int i = idx; i < s.length(); i++) {
			
			if(s.charAt(idx) == '0' && i > idx)
			{
				break;
			}
			long num = Long.parseLong(s.substring(idx, i + 1));

			if (num > Integer.MAX_VALUE) {
				break;
			}
			int size = res.size();
			if (size >= 2 && num > res.get(size - 2) + res.get(size - 1)) {
				break;
			}

			if (size <= 1 || size >= 2 && num == res.get(size - 2) + res.get(size - 1)) {
				res.add((int) num);
				if (recurse(s, i + 1, res)) {
					return true;
				}
				res.remove(res.size() - 1);
			}
		}

		return false;
	}
	
	public static void main(String[] args) {
		
		SplitArrayintoFibonacciSequence splitArrayintoFibonacciSequence = new
				SplitArrayintoFibonacciSequence();
		System.out.println(
			splitArrayintoFibonacciSequence.splitIntoFibonacci("123456579"));
		
	}

}
