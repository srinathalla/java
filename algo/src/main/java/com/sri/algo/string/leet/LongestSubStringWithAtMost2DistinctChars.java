package com.sri.algo.string.leet;

public class LongestSubStringWithAtMost2DistinctChars {
	
	
	/**
	 * T.C : O(n)
	 * We add and remove entry once to the map.
	 * we maintain a sliding window of size 2 distinct chars.
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstringTwoDistinct(String s)
	{		
			int n = s.length();
			
			if (n <= 2)
			{
				return s.length();
			}
			
			int max = Integer.MIN_VALUE;
			int j = 0;
			int count = 0;		
			int[] map = new int[256];
			
			for (int i= 0; i< s.length(); i++ )		
			{
				char ch = s.charAt(i);
				if (map[ch]++ == 0)
				{
					count++;
				}				
				
				while (count > 2)
				{
					if(--map[s.charAt(j++)] == 0)
					{
						count--;
					}
				}
				
				max = Integer.max(max, i -j + 1);	
			}
			
			return max;
	    }
	
	public static void main(String[] args) {
		
		LongestSubStringWithAtMost2DistinctChars longestSubStr =
				
				new LongestSubStringWithAtMost2DistinctChars();
		
		System.out.println(longestSubStr.lengthOfLongestSubstringTwoDistinct("abaccc"));
		System.out.println(longestSubStr.lengthOfLongestSubstringTwoDistinct("abaccc"));
	}

}
