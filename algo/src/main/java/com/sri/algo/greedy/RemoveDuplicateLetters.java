package com.sri.algo.greedy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a string which contains only lowercase letters, remove duplicate
 * letters so that every letter appear once and only once. You must make sure
 * your result is the smallest in lexicographical order among all possible
 * results.
 * 
 * Example 1:
 * 
 * Input: "bcabc" Output: "abc" Example 2:
 * 
 * Input: "cbacdcbc" Output: "acdb"
 * 
 * @author salla
 *
 */
public class RemoveDuplicateLetters {

	/**
	 * T.C : O(26 * n)
	 * 
	 * recursive method is called 26 times at max..
	 * 
	 * 
	 * Idea is to get the first smallest character among the repeated chars.
	 * 
	 * @param s
	 * @return
	 */
	public String removeDuplicateLetters(String s) {

		if (s.length() == 0) {
			return "";
		}

		int[] cnt = new int[26];

		for (char ch : s.toCharArray()) {
			cnt[ch - 'a']++;
		}

		int pos = 0;
		for (int i = 0; i < s.length(); i++) {

			// pos points to first smallest char from left in the String s.
			if (s.charAt(i) < s.charAt(pos)) {
				pos = i;
			}

			// if char at pos i is already unique we need to break and remove duplicates
			// from the rest of the String.
			if (--cnt[s.charAt(i) - 'a'] == 0) {
				break;
			}
		}
		String remainingString = s.substring(pos + 1).replaceAll("" + s.charAt(pos), "");

		return s.charAt(pos) + removeDuplicateLetters(remainingString);
	}

	/**
	 * Deque based solution 
	 * 
	 * T.C : O(n).
	 * 
	 * where n is length of the String.
	 * 
	 * 
	 * @param s
	 * @return
	 */
	public String removeDuplicateLettersWithIteration(String s) {

		if (s.length() == 0) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < 26; j++) {

			if (s.length() == 0) {
				break;
			}

			int[] cnt = new int[26];

			for (char ch : s.toCharArray()) {
				cnt[ch - 'a']++;
			}

			int pos = 0;
			for (int i = 0; i < s.length(); i++) {

				// pos points to first smallest char from left in the String s.
				if (s.charAt(i) < s.charAt(pos)) {
					pos = i;
				}

				// if char at pos i is already unique we need to break and remove duplicates
				// from the rest of the String.
				if (--cnt[s.charAt(i) - 'a'] == 0) {
					break;
				}
			}
			sb.append(s.charAt(pos));

			s = s.substring(pos + 1).replaceAll(Character.toString(s.charAt(pos)), "");

		}

		return sb.toString();
	}

	public String removeDuplicateLettersWithDeQueue(String s) {

		if (s.length() == 0) {
			return "";
		}

		boolean[] visited = new boolean[26];
		int[] cnt = new int[26];

		Deque<Character> q = new LinkedList<>();

		for (char ch : s.toCharArray()) {
			cnt[ch - 'a']++;
		}

		for (char ch : s.toCharArray()) {

			cnt[ch - 'a']--;
			
			if (!visited[ch - 'a']) {

				while (!q.isEmpty() && cnt[q.peekLast() - 'a'] != 0 && q.peekLast() > ch) {
					visited[q.pollLast() - 'a'] = false;
				}

				q.addLast(ch);
				visited[ch - 'a'] = true;
			}
		}

		StringBuilder sb = new StringBuilder();

		while (!q.isEmpty()) {
			sb.append(q.poll());
		}

		return sb.toString();

	}

	public static void main(String[] args) {
		RemoveDuplicateLetters rdl = new RemoveDuplicateLetters();

		System.out.println(rdl.removeDuplicateLetters("bcabc"));

		System.out.println(rdl.removeDuplicateLettersWithIteration("bcabc"));
		
		System.out.println(rdl.removeDuplicateLettersWithDeQueue("bcabc"));
		
		System.out.println(rdl.removeDuplicateLettersWithDeQueue("bbccac"));

	}
}
