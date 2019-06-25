package com.sri.algo.string.leet;


/**
 * 	Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

	Example:
	Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
	
	Input: word1 = “coding”, word2 = “practice”
	Output: 3
	Input: word1 = "makes", word2 = "coding"
	Output: 1
 * @author salla
 *
 */
public class ShortestDistanceBetweenTwoWords {
	
	
	public int shortestDistance(String[] words, String word1, String word2) {

		int id1 = -1, id2 = -1;
		int dist = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {

			if (words[i].equals(word1)) {
				id1 = i;
			} else if (words[i].equals(word2)) {
				id2 = i;
			}

			if (id1 != -1 && id2 != -1) {
				dist = Math.min(dist, Math.abs(id1 - id2));
			}
		}

		return dist;

	}
	
	public static void main(String[] args) {
		
		ShortestDistanceBetweenTwoWords shortestDistanceBetweenTwoWords = new 
				ShortestDistanceBetweenTwoWords();
		
		System.out.println(
			shortestDistanceBetweenTwoWords.shortestDistance(new String[] {"practice", "makes", "perfect", "coding", "makes"}, 
				"coding", "practice"));
		System.out.println(
		shortestDistanceBetweenTwoWords.shortestDistance(new String[] {"practice", "makes", "perfect", "coding", "makes"}, 
				"makes", "coding"));
		
	}

}
