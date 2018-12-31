package com.sri.algo.string.leet;

/**
 * An encoded string S is given. To find and write the decoded string to a tape,
 * the encoded string is read one character at a time and the following steps
 * are taken:
 * 
 * If the character read is a letter, that letter is written onto the tape. If
 * the character read is a digit (say d), the entire current tape is repeatedly
 * written d-1 more times in total. Now for some encoded string S, and an index
 * K, find and return the K-th letter (1 indexed) in the decoded string.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: S = "leet2code3", K = 10 Output: "o" Explanation: The decoded string
 * is "leetleetcodeleetleetcodeleetleetcode". The 10th letter in the string is
 * "o". Example 2:
 * 
 * Input: S = "ha22", K = 5 Output: "h" Explanation: The decoded string is
 * "hahahaha". The 5th letter is "h". Example 3:
 * 
 * Input: S = "a2345678999999999999999", K = 1 Output: "a" Explanation: The
 * decoded string is "a" repeated 8301530446056247680 times. The 1st letter is
 * "a".
 * 
 * @author salla
 *
 */
public class DecodedStringAtIndex {

	/**
	 * 
	 * @param S
	 * @param K
	 * @return
	 */
	public String decodeAtIndex(String s, int k) {

		int cnt = 0;
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while (cnt != k) {

			while (Character.isLowerCase(s.charAt(i))) {
				cnt++;
				sb.append(s.charAt(i));
				if (cnt == k) {
					return String.valueOf(s.charAt(i));
				}
				i++;
			}

			while (Character.isDigit(s.charAt(i))) {

				int digit = Character.getNumericValue(s.charAt(i));

				for (int j = 1; j < digit; j++) {

					cnt += cnt;
					if (cnt >= k) {

						int idx = k - cnt / 2;

						idx = idx % sb.length();

						return String.valueOf(sb.charAt(idx == 0 ? sb.length() - 1 : idx - 1));
					}
				}
				i++;
			}
		}

		return "";

	}

	public static void main(String[] args) {

		DecodedStringAtIndex ds = new DecodedStringAtIndex();

		System.out.println(ds.decodeAtIndex("leet2code3", 10));

		System.out.println(ds.decodeAtIndex("ha22", 5));

		System.out.println(ds.decodeAtIndex("a23", 6));
		
		/**
		 * 
		 * "a2b3c4d5e6f7g8h9"
			9
			
			    output  : "a"
				Expected:"b"
		 * 
		 */
	}

}
