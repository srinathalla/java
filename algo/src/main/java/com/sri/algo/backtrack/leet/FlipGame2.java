package com.sri.algo.backtrack.leet;

import com.sri.algo.array.PrintArray;

/**
 *  You are playing the following Flip Game with your friend: Given a string that contains only 
 *  these two characters: + and -, you and your friend take turns to flip two consecutive "++" 
 *  into "--". The game ends when a person can no longer make a move and therefore the other person
 *  will be the winner.

	Write a function to determine if the starting player can guarantee a win.
	
	Example:
	
	Input: s = "++++"
	Output: true 
	
	Explanation: The starting player can guarantee a win by flipping the middle "++" to become 
	"+--+".
	
 * @author salla
 *
 */
public class FlipGame2 {
	
	int len;
	char[] ss;
	
	boolean canWin(String s) {
	  len = s.length();
	  
	  ss = s.toCharArray();
	  
	  return canWin();
	}
	
	boolean canWin() 
	{	
		PrintArray.print(ss);
		for (int i = 0; i <= ss.length - 2; i++) {
			if (ss[i] == '+' && ss[i + 1] == '+') {
				ss[i] = '-';
				ss[i + 1] = '-';

				boolean wins = !canWin();

				ss[i] = '+';
				ss[i + 1] = '+';
				
				PrintArray.print(ss);

				if (wins) {
					return true;
				}
			}
		}
		
		return false;
	} 
	
	
	public static void main(String[] args) {
		
		FlipGame2 flipGame2 = new FlipGame2();
		
		System.out.println(
			flipGame2.canWin("++++++"));
		
	}

}
