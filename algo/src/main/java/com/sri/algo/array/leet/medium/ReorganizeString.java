package com.sri.algo.array.leet.medium;

import java.util.PriorityQueue;

public class ReorganizeString {

	public String reorganizeString(String s) {

		int[] counter = new int[26];
		for (char c : s.toCharArray()) {
			counter[c - 'a']++;
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

		for (int i = 0; i < 26; i++) {
			if (counter[i] > 0)
				pq.add(new int[] { i, counter[i] });
		}

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			
			if(pq.size() >= 2)
			{
				int[] first = pq.poll();
				int[] second = pq.poll();
				
				if(sb.length() > 0 && sb.charAt(sb.length() -1) == (char) ('a' + first[0]))
				{
					int[]tmp = first;
					first = second;
					second = tmp;
				}
				sb.append((char) ('a' + first[0]));
				sb.append((char) ('a' + second[0]));
				first[1]--;
				second[1]--;
	

			if (first[1] > 0)
				pq.add(first);
			
			if (second[1] > 0)
				pq.add(second);
			}
			else
			{
				int[] first = pq.poll();
				if(first[1] > 1)
					return "";
				
				sb.append((char) ('a' + first[0]));
			}
				
		}

		return sb.toString();

	}
	
	public static void main(String[] args) {
		
		String s = "abbabbaaab";
		
		ReorganizeString rs = new ReorganizeString();
		System.out.println(
			rs.reorganizeString(s));
	}

}
