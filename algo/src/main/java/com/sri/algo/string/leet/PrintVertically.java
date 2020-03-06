package com.sri.algo.string.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s. Return all the words vertically in the same order in which
 * they appear in s. Words are returned as a list of strings, complete with
 * spaces when is necessary. (Trailing spaces are not allowed). Each word would
 * be put on only one column and that in one column there will be only one word.
 * 
 * Input: s = "HOW ARE YOU" Output: ["HAY","ORO","WEU"]
 * 
 * Input: s = "TO BE OR NOT TO BE" Output: ["TBONTB","OEROOE"," T"]
 * 
 * @author srialla
 *
 */
public class PrintVertically {

	/**
	 * T.C : O(w) + O(n) + O(w*n) + O(n) => O(w*n)
	 * 
	 * w : no of words
	 * n : length of longest word
	 * 
	 * @param s
	 * @return
	 */
	public List<String> printVertically(String s) {

		List<String> result = new ArrayList<>();

		String[] words = s.split(" ");

		int max = 0;
		for (String word : words) {
			max = Math.max(max, word.length());
		}

		for (int i = 0; i < max; i++) {
			result.add("");
		}

		for (int i = 0; i < words.length; i++) {
			int k = 0;
			for (int j = 0; j < max; j++) {
				String word = result.get(k) + (j < words[i].length() ? words[i].charAt(j) : ' ');
				result.set(k, word);
				k++;
			}
		}

		for (int i = 0; i < result.size(); i++) {
			String word = result.get(i);
			int j = word.length() - 1;
			while (j > 0 && word.charAt(j) == ' ') {
				j--;
			}
			word = word.substring(0, j + 1);

			result.set(i, word);
		}

		return result;
	}

}
