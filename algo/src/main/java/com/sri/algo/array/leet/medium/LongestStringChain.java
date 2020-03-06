package com.sri.algo.array.leet.medium;

import java.util.Arrays;
import java.util.Collections;

/**
 * Given a list of words, each word consists of English lowercase letters.
 * 
 * Let's say word1 is a predecessor of word2 if and only if we can add exactly
 * one letter anywhere in word1 to make it equal to word2. For example, "abc" is
 * a predecessor of "abac". O A word chain is a sequence of words [word_1,
 * word_2, ..., word_k] with k >= 1, where word_1 is a predecessor of word_2,
 * word_2 is a predecessor of word_3, and so on.
 * 
 * Return the longest possible length of a word chain with words chosen from the
 * given list of words.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: ["a","b","ba","bca","bda","bdca"] Output: 4 Explanation: one of the
 * longest word chain is "a","ba","bda","bdca".
 * 
 * @author srialla
 *
 */
public class LongestStringChain {

	public int longestStrChain(String[] words) {

		int[] dp = new int[words.length];
		Arrays.fill(dp, 1);

		Arrays.sort(words, (a, b) -> a.length() != b.length() ? a.length() - b.length() : a.compareTo(b));

		int max = 1;
		for (int i = 1; i < words.length; i++) {
			for (int j = 0; j < i; j++) {
				if (isPreDecessor(words[j], words[i]) && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
			max = Math.max(max, dp[i]);
		}

		return max;
	}

	private boolean isPreDecessor(String a, String b) {

		if (a.length() != b.length() - 1) {
			return false;
		}

		int i = 0, j = 0, diff = 0;
		while (i < a.length() && j < b.length()) {
			if (a.charAt(i) == b.charAt(j)) {
				i++;
				j++;
			} else {
				diff++;
				if (diff > 1) {
					return false;
				}
				j++;
			}
		}

		return true;
	}
	
	public static void main(String[] args) {
		
		LongestStringChain LongestStringChain = new LongestStringChain();
		System.out.println(
			LongestStringChain.longestStrChain(new String[] {"a","b","ba","bca","bda","bdca"}));
		
	}

}
