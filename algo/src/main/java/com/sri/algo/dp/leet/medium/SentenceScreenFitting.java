package com.sri.algo.dp.leet.medium;

public class SentenceScreenFitting {
	
	public int wordsTyping(String[] sentence, int rows, int cols) {
	    String s = String.join(" ", sentence) + " ";
	    int len = s.length(), count = 0;
	    int[] map = new int[len];
	    for (int i = 1; i < len; ++i) {
	        map[i] = s.charAt(i) == ' ' ? 1 : map[i-1] - 1;
	    }
	    for (int i = 0; i < rows; ++i) {
	        count += cols;
	        count += map[count % len];
	    }
	    return count / len;
	}
	
	
	public static void main(String[] args) {
		
		SentenceScreenFitting sentenceScreenFitting = new SentenceScreenFitting();
		//System.out.println(
		//	sentenceScreenFitting.wordsTyping(new String[]{"hello", "world"}, 2, 8));
		System.out.println(
				sentenceScreenFitting.wordsTyping(new String[]{"a", "bcd","e"}, 3, 6));
		
	}

}
