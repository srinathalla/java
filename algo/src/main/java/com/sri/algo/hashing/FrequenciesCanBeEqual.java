package com.sri.algo.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FrequenciesCanBeEqual {
	
	/**
	 * T.C :  O(n) where n is length of String.
	 * Auxillary space O(n).
	 * where we use map to keep track of frequencies of each char.
	 * 
	 * @param input
	 * @return
	 */
	public static int canFrequenciesOfAllCharsBeMadeEqual(String input)
	{
		
		char[] chars = input.toCharArray();
		
		Map<Character,Integer> charToFreqMap = new HashMap<>();
		
		int max = Integer.MIN_VALUE;
		int nextMax = Integer.MIN_VALUE;
		for (char ch : chars)
		{		
			if (!charToFreqMap.containsKey(ch))
			{
				charToFreqMap.put(ch, 0);
			}
			
			charToFreqMap.put(ch, charToFreqMap.get(ch) + 1);
			
			if (charToFreqMap.get(ch) > max)
			{
				max = charToFreqMap.get(ch);
			}
			else if (nextMax <  charToFreqMap.get(ch) && charToFreqMap.get(ch) < max)
			{
				nextMax = charToFreqMap.get(ch);
			}
		}
		
		int count = 0;
		if (max - nextMax == 1)
		{
			for (Entry<Character,Integer> entry : charToFreqMap.entrySet())
			{
				if (entry.getValue() == nextMax)
				{
					count++;
				}
			}
			return charToFreqMap.size() == count + 1 ? 1 : 0;
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
	
		System.out.println(canFrequenciesOfAllCharsBeMadeEqual("xyyz"));
		System.out.println(canFrequenciesOfAllCharsBeMadeEqual("xxxxyyzz"));
	}

}
