package com.sri.algo.string;

/**
 * Given an input string , reverse the string word by word.
 * 
 * Example:
 * 
 * Input: ['t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'] Output:
 * ['b','l','u','e',' ','i','s',' ','s','k','y',' ','t','h','e'] Note:
 * 
 * A word is defined as a sequence of non-space characters. The input string
 * does not contain leading or trailing spaces. The words are always separated
 * by a single space.
 * 
 * @author salla
 *
 */
public class ReverseWordsInString {

	/**
	 * Three pass solution
	 * 
	 * T.C : O(n)... Auxillary space : O(n) ..
	 * 
	 * @param str
	 */
	public void reverseWordsWithExtraSpace(char[] str) {

		int n = str.length;

		if (n < 2) {
			return;
		}

		char[] rev = new char[n];
		int i = n - 1, j = n - 1;
		int l = 0;

		while (i >= 0) {

			while (i >= 0 && str[i] != ' ') {
				i--;
			}

			int m = i + 1;

			int c = j - i;
			while (c > 0) {
				rev[l++] = str[m++];
				c--;
			}

			if (i >= 0) {
				rev[l++] = ' ';
			}

			i--;
			j = i;
		}

		i = 0;
		while (i < n) {
			str[i] = rev[i];
			i++;
		}
	}

	/**
	 * Two pass solution, no extra space required ..
	 * 
	 * T.C : O(n)...
	 * 
	 * idea is to 1) reverse the entire string 2) reverse each word in the string ..
	 * 
	 * 
	 * 
	 * @param str
	 */
	public void reverseWords(char[] str) {

		if (str.length == 0 || str == null) {
			return;
		}

		reverse(str, 0, str.length - 1);

		int l = 0, r = 0;

		for (; r < str.length; r++) {
			if (str[r] == ' ') {
				reverse(str, l, r - 1);
				l = r + 1;
			}
		}

		reverse(str, l, r - 1);

	}

	private void reverse(char[] str, int l, int r) {
		while (l < r) {
			char tmp = str[l];
			str[l] = str[r];
			str[r] = tmp;
			l++;
			r--;
		}
	}

	public static void main(String[] args) {

		ReverseWordsInString rwis = new ReverseWordsInString();

		char[] input = new char[] { 't', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e' };
		rwis.reverseWords(input);
		System.out.println(input);

		char[] input1 = new char[] { 't', 'h', 'e' };
		rwis.reverseWords(input1);
		System.out.println(input1);
	}

}
