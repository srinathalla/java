package com.sri.algo.string.leet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * You are given an array A of strings.
 * 
 * Two strings S and T are special-equivalent if after any number of moves, S ==
 * T.
 * 
 * A move consists of choosing two indices i and j with i % 2 == j % 2, and
 * swapping S[i] with S[j].
 * 
 * Now, a group of special-equivalent strings from A is a non-empty subset S of
 * A such that any string not in S is not special-equivalent with any string in
 * S.
 * 
 * Return the number of groups of special-equivalent strings from A.
 * 
 * @author salla
 *
 */
public class GroupsOfSpecialEquivalentStrings {

	/**
	 *  T.C Sum of lengths of A.
	 *  S.C O(n) where n is no of Strings.
	 *  
	 * @param A
	 * @return
	 */
	public int numSpecialEquivGroups(String[] A) {

		Set<String> res = new HashSet<>();

		for (String s : A) {
			int[] count = new int[52];

			for (int i = 0; i < s.toCharArray().length; i++) {
				count[s.charAt(i) - 'a' + 26 * (i % 2)]++;
			}

			res.add(Arrays.toString(count));
		}

		return res.size();
	}
	
	public static void main(String[] args) {
		
		GroupsOfSpecialEquivalentStrings groups = new GroupsOfSpecialEquivalentStrings();
		
		System.out.println(groups.numSpecialEquivGroups(new String[] {"a","b","c","a","c","c"}));
		
		System.out.println(groups.numSpecialEquivGroups(new String[] {"aa","bb","ab","ba"}));
		
		System.out.println(groups.numSpecialEquivGroups(new String[] {"abc","acb","bac","bca","cab","cba"}));
		
		System.out.println(groups.numSpecialEquivGroups(new String[] {"abcd","cdab","adcb","cbad"}));
		
	}

}
