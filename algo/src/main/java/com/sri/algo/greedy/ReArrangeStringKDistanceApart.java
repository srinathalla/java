package com.sri.algo.greedy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a non-empty string s and an integer k, rearrange the string such that
 * the same characters are at least distance k from each other.
 * 
 * All input strings are given in lowercase letters. If it is not possible to
 * rearrange the string, return an empty string "".
 * 
 * Example 1: s = "aabbcc", k = 3
 * 
 * Result: "abcabc"
 * 
 * The same letters are at least distance 3 from each other. Example 2: s =
 * "aaabc", k = 3
 * 
 * Answer: ""
 * 
 * It is not possible to rearrange the string. Example 3: s = "aaadbbcc", k = 2
 * 
 * Answer: "abacabcd"
 * 
 * Another possible answer is: "abcabcda"
 * 
 * The same letters are at least distance 2 from each other.
 * 
 * @author salla
 *
 */
public class ReArrangeStringKDistanceApart {

	/**
	 * T.C : O(n*26) => O(n)
	 * 
	 * where n is the length of the string.
	 * 
	 * 
	 * @param str
	 * @param k
	 * @return
	 */
	public String rearrangeString(String str, int k) {

		int len = str.length();

		int[] count = new int[26];
		int[] valid = new int[26];

		for (char ch : str.toCharArray()) {
			count[ch - 'a']++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {

			int pos = findValidMax(count, valid, i);

			if (pos == -1) {
				return "";
			}

			count[pos]--;
			valid[pos] = i + k;
			sb.append((char) ('a' + pos));
		}

		return sb.toString();
	}

	private int findValidMax(int[] count, int[] valid, int index) {

		int max = Integer.MIN_VALUE;
		int pos = -1;

		for (int i = 0; i < count.length; i++) {

			if (count[i] > 0 && count[i] > max && index >= valid[i]) {

				max = count[i];
				pos = i;
			}
		}

		return pos;
	}

	public String rearrangeStringwithPQ(String str, int k) {

		StringBuilder rearranged = new StringBuilder();
		// count frequency of each char
		Map<Character, Integer> map = new HashMap<>();
		for (char c : str.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 0);
			}
			map.put(c, map.get(c) + 1);
		}

		// construct a max heap using self-defined comparator, which holds all Map
		// entries, Java is quite verbose
		Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
				new Comparator<Map.Entry<Character, Integer>>() {
					public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
						return entry2.getValue() - entry1.getValue();
					}
				});

		Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();
		maxHeap.addAll(map.entrySet());

		while (!maxHeap.isEmpty()) {

			Map.Entry<Character, Integer> current = maxHeap.poll();
			rearranged.append(current.getKey());
			current.setValue(current.getValue() - 1);
			waitQueue.offer(current);

			if (waitQueue.size() < k) { // intial k-1 chars, waitQueue not full yet
				continue;
			}
			// release from waitQueue if char is already k apart
			Map.Entry<Character, Integer> front = waitQueue.poll();
			// note that char with 0 count still needs to be placed in waitQueue as a place
			// holder
			if (front.getValue() > 0) {
				maxHeap.offer(front);
			}
		}

		return rearranged.length() == str.length() ? rearranged.toString() : "";
	}

	public static void main(String[] args) {

		ReArrangeStringKDistanceApart rs = new ReArrangeStringKDistanceApart();

		System.out.println(rs.rearrangeString("aabbcc", 3));

		System.out.println(rs.rearrangeString("aaabc", 3));

		System.out.println(rs.rearrangeString("aaadbbcc", 2));
		
		System.out.println(rs.rearrangeStringwithPQ("aabbcc", 3));

		System.out.println(rs.rearrangeStringwithPQ("aaabc", 3));

		System.out.println(rs.rearrangeStringwithPQ("aaadbbcc", 2));

	}

}
