package com.sri.algo.hashing.leet;

/**
 * Given a list of words and two words word1 and word2, return the shortest
 * distance between these two words in the list.
 * 
 * word1 and word2 may be the same and they represent two individual words in
 * the list.
 * 
 * Example: Assume that words = ["practice", "makes", "perfect", "coding",
 * "makes"].
 * 
 * Input: word1 = “makes”, word2 = “coding” Output: 1 Input: word1 = "makes",
 * word2 = "makes" Output: 3
 * 
 * @author salla
 *
 */
public class ShortestDistance3 {

	/**
	 * T.C O(n)
	 * 
	 * Single pass solution ..
	 * 
	 * @param words
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int shortestWordDistance(String[] words, String word1, String word2) {

		int min = Integer.MAX_VALUE;
		int x = -1, y = -1;

		if (!word1.equals(word2)) {
			for (int i = 0; i < words.length; i++) {

				if (words[i].equals(word1)) {
					x = i;
				} else if (words[i].equals(word2)) {
					y = i;
				}

				min = x != -1 && y != -1 ? Integer.min(min, Math.abs(x - y)) : min;

			}
		} else {
			for (int i = 0; i < words.length; i++) {
				if (words[i].equals(word1)) {
					y = x;
					x = i;

					min = x != -1 && y != -1 ? Integer.min(min, x - y) : min;
				}
			}
		}

		return min;
	}

	public static void main(String[] args) {

		ShortestDistance3 sd3 = new ShortestDistance3();

		System.out.println(sd3.shortestWordDistance(new String[] { "practice", "makes", "perfect", "coding", "makes" },
				"makes", "coding"));
	}

}
