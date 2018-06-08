package com.sri.algo.queue;

import java.util.LinkedList;
import java.util.List;

/**
 *  Given a digit string, return all possible letter combinations that the number could represent.

    A mapping of digit to letters (just like on the telephone buttons) is given below.
   
	Input:Digit string "23"
	Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
	Note:
	Although the above answer is in lexicographical order, your answer could be in any order you want.
	
 *  @author salla
 *
 */
public class LetterCombinationsOfPhoneNo {

	/**
	 * Iterative solution by using queue.
	 * 
	 * Idea is queue should hold String's of length equal to the number of digits pressed on Phone.
	 * 
	 * @param digits
	 * @return
	 */
	public List<String> letterCombinationsWithStringBuilder(String digits) {

		LinkedList<String> q = new LinkedList<String>();

		if (digits.isEmpty()) {
			return q;
		}

		String[] mappedChars = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		StringBuilder sb = new StringBuilder();
		q.add("");

		for (int i = 0; i < digits.length(); i++) 
		{	
			int idx = Character.getNumericValue(digits.charAt(i));
			
			while (q.peek().length() == i) 
			{
				String s = q.poll();
				sb.append(s);

				for (char ch : mappedChars[idx].toCharArray()) 
				{
					q.add(sb.append(ch).toString());
					sb.setLength(sb.length() -1);
				}
				
				sb.setLength(0); // Reset StringBuilder to empty.
			}
		}

		return q;
	}
	
	   public List<String> letterCombinations(String digits) 
	   { 
	       LinkedList<String> q = new LinkedList<String>();

			if (digits.isEmpty()) {
				return q;
			}

			String[] mappedChars = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

			q.add("");

			for (int i = 0; i < digits.length(); i++) {	
				int idx = Character.getNumericValue(digits.charAt(i));
				
				while (q.peek().length() == i) {
					String s = q.poll();
					for (char ch : mappedChars[idx].toCharArray()) {
						q.add(s + ch);
					}
				}
			}

			return q;
	    }
	    

	/**
	 * Back tracking solution. T.C Exponential.
	 * 
	 * @param digits
	 * @return
	 */
	public List<String> letterCombinationsWithBT(String digits) {

		LinkedList<String> ans = new LinkedList<String>();
		if (digits.isEmpty())
			return ans;
		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		StringBuilder sb = new StringBuilder();
		letterCombinations(digits, 0, mapping, ans, sb);

		return ans;
	}

	private void letterCombinations(String digits, int i, String[] mapping, LinkedList<String> ans, StringBuilder sb) {
		if (i == digits.length()) {
			ans.add(sb.toString());
			return;
		}

		int idx = Character.getNumericValue(digits.charAt(i));
		for (char ch : mapping[idx].toCharArray()) {
			sb.append(ch);

			letterCombinations(digits, i + 1, mapping, ans, sb);

			sb.deleteCharAt(sb.length() - 1); // backtrack.
		}
	}

	public static void main(String[] args) {

		LetterCombinationsOfPhoneNo lc = new LetterCombinationsOfPhoneNo();
		System.out.println(lc.letterCombinations("23"));

		System.out.println(lc.letterCombinationsWithBT("23"));

	}

}
