package com.sri.algo.string.leet;

import java.util.HashMap;
import java.util.Map;

/**
 * You are playing the following Bulls and Cows game with your friend: You write
 * down a number and ask your friend to guess what the number is. Each time your
 * friend makes a guess, you provide a hint that indicates how many digits in
 * said guess match your secret number exactly in both digit and position
 * (called "bulls") and how many digits match the secret number but locate in
 * the wrong position (called "cows"). Your friend will use successive guesses
 * and hints to eventually derive the secret number.
 * 
 * Write a function to return a hint according to the secret number and friend's
 * guess, use A to indicate the bulls and B to indicate the cows.
 * 
 * Please note that both secret number and friend's guess may contain duplicate
 * digits.
 * 
 * Example 1:
 * 
 * Input: secret = "1807", guess = "7810"
 * 
 * Output: "1A3B"
 * 
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 * 
 * @author srialla
 *
 */
public class BullsAndCows {

	public String getHint(String secret, String guess) {

		int a = 0, b = 0;

		int[] map = new int[256];
		
		for(char ch : secret.toCharArray())
		{
			map[ch]++;
		}
		
		for (int i = 0; i < secret.length(); i++) {
			char ch = secret.charAt(i);
			if (ch == guess.charAt(i)) {
				a++;
				map[ch]--;
			} 
		}
		
		for (int i = 0; i < secret.length(); i++) {
			char ch1 = secret.charAt(i);
			char ch2 = guess.charAt(i);
			if (ch1 != ch2 && map[ch2] > 0) {
				b++;
				map[ch2]--;
			} 
		}

		return a + "A" + b + "B";
	}

	public static void main(String[] args) {

		BullsAndCows bullsAndCows = new BullsAndCows();
		String secret = "1807", guess = "7810";
		// System.out.println(bullsAndCows.getHint(secret, guess));
		System.out.println(bullsAndCows.getHint("1123", "0111"));
		


	}

}
