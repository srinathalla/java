package com.sri.algo.string;

/**
 * Given two strings s and t, determine if they are both one edit distance
 * apart.
 * 
 * Note:
 * 
 * There are 3 possiblities to satisify one edit distance apart:
 * 
 * Insert a character into s to get t Delete a character from s to get t Replace
 * a character of s to get t
 * 
 * @author salla
 *
 */
public class OneEditDistance {

	/**
	 * T.C : O(n) ..
	 * 
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isOneEditDistance(String s, String t) {

		int slen = s.length();
		int tlen = t.length();
        
        int sizeDiff = Math.abs(slen - tlen);

		if (sizeDiff > 1)
		{
			return false;
		}
		
		for (int i = 0; i < Math.min(slen, tlen); i++) {

			//If characters don't match in s and t
			// there are 3 conditions.
			
			if (s.charAt(i) != t.charAt(i)) {

				if (slen == tlen) {
					
					// Eg : abc , adc
					return s.substring(i + 1).equals(t.substring(i + 1));
				}
				
				else if (slen < tlen) {
					
					// Eg : acd, abcd
					return s.substring(i).equals(t.substring(i + 1));
				}
				
				else if (slen > tlen) {
					// cab , cb
					return s.substring(i + 1).equals(t.substring(i));
				}
			}

		}

		return sizeDiff == 1;        
	}
	
	public static void main(String[] args) {
		
		OneEditDistance oed = new OneEditDistance();
		
		System.out.println(oed.isOneEditDistance("ab", "acb"));
		
		System.out.println(oed.isOneEditDistance("cab", "ad"));
		
		System.out.println(oed.isOneEditDistance("1203", "1213"));
		
	}

}
