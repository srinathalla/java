package com.sri.algo.hashing.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string, we can "shift" each of its letter to its successive letter,
 * for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 * 
 * "abc" -> "bcd" -> ... -> "xyz" Given a list of strings which contains only
 * lowercase alphabets, group all strings that belong to the same shifting
 * sequence.
 * 
 * Example:
 * 
 * Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], Output: [
 * ["abc","bcd","xyz"], ["az","ba"], ["acef"], ["a","z"] ]
 * 
 * @author salla
 *
 */
public class GroupShiftedStrings {

	public List<List<String>> groupStrings(String[] strings) {

		List<List<String>> groupsList = new ArrayList<>();

		Map<String, List<String>> groupsMap = new HashMap<>();

		for (String str : strings) {

			String numericVal = getHash(str);

			List<String> list = groupsMap.getOrDefault(numericVal, new ArrayList<>());
			list.add(str);

			groupsMap.put(numericVal, list);
		}

		groupsList.addAll(groupsMap.values());

		return groupsList;
	}

	private String getHash(String s) {

		StringBuilder sb = new StringBuilder();

		int start = s.charAt(0);
		for (char ch : s.toCharArray()) {

			int val = ch - start;

			val = val < 0 ? val + 26 : val;
			sb.append(val);
		}
		
		sb.append(s.length());
		return sb.toString();
	}
	
	public List<List<String>> groupStringsConvertingToString(String[] strings) {

		List<List<String>> groupsList = new ArrayList<>();

		Map<String, List<String>> groupsMap = new HashMap<>();

		for (String str : strings) {

			String numericVal = getHashValue(str);

			List<String> list = groupsMap.getOrDefault(numericVal, new ArrayList<>());
			list.add(str);

			groupsMap.put(numericVal, list);
		}

		groupsList.addAll(groupsMap.values());

		return groupsList;
	}

	private String getHashValue(String s) {

		StringBuilder sb = new StringBuilder();

		int start = s.charAt(0) - 'a';
		for (char ch : s.toCharArray()) {

			int val = ch - start;

			val = val < 'a' ? val + 26 : val;
			sb.append((char)val);
		}
		
		// sb.append(s.length());
		return sb.toString();
	}

	public static void main(String[] args) {

		GroupShiftedStrings gshift = new GroupShiftedStrings();

		System.out.println(gshift.groupStrings(new String[] { "abc", "bcd", "acef",
		 "xyz", "az", "ba", "a", "z" }));

		// System.out.println(gshift.groupStringsConvertingToString(new String[] { "abc", "am" }));

	}

}
