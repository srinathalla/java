package com.sri.algo.string;

import com.sri.algo.dp.LongestCommonSubSequence;

public class MinInsertionsToFormAPalindrome 
{
	
	
	public static int minInsertions(char[] input, int l ,int h)
	{
		if (l > h)
		{
			return Integer.MAX_VALUE;
		}
		
		if (l == h)
		{
			return 0;
		}
		
		else if (l == h-1)
		{
			return input[l] == input[h] ? 0 : 1;
		}
		
		if (input[l] == input[h])
		{
			return minInsertions(input , l +1 ,h-1);
		}
		
		return 
			Integer.min(
				minInsertions(input, l +1, h),
				minInsertions(input, l, h-1)) + 1;
	}
	
	// A DP function to find minimum number
    // of insersions
    static int findMinInsertionsDP(char[] chars, int n)
    {
      
    	int[][] table = new int[n][n]; 	
    	int l,h,len;
    	
    	
    	// Fill the recursion tree bottom up 
    	// last level has nodes (0,1),(1,2)(2,3)..
    	//               (0-4)
    	//         (0-3)                (1-4)
    	//    (0-2)    (1-3)       (1-3)      (2-4)
    	// (0-1)(1-2) (1-2)(2-3) (1-2)(2-3) (2-3)(3-4)
    	//
    	for (len =1 ;len < n ;len ++)
    	{
    		for (l = 0,h=len ; h <n; l++, h++)
    		{	
    			table[l][h] = 
					(chars[l] == chars[h]) ? 
						table[l+1][h-1] :
						Integer.min(table[l][h-1], table[l +1][h]) + 1;
    		}
    		
    	}
    	
    	return table[0][n-1];   	
    }
    
    // A DP function to find minimum number
    // of insersions
    static int findMinInsertionsUsingLCS(char[] str, int n)
    {
    	char[] revStr = new char[str.length];
    
    	int index = 0;
    	for (int i = str.length -1 ;i >= 0 ; i--)
    	{
    		revStr[index] = str[i];
    		index++;
    	}
 
        // Return minimum number of insertions
        // for str[0..n-1]
        return str.length - LongestCommonSubSequence.lcsWithDP(str, revStr, str.length, str.length);
    }
	
	
	public static void main(String[] args) {
		
		/*System.out.println(minInsertions("ab".toCharArray(),0,1));
		System.out.println(minInsertions("abc".toCharArray(),0,2));
		System.out.println(minInsertions("abcd".toCharArray(),0,3));*/
		
		
		/*System.out.println(findMinInsertionsDP("ab".toCharArray(),2));
		System.out.println(findMinInsertionsDP("abc".toCharArray(),3));*/
		System.out.println(findMinInsertionsDP("abcde".toCharArray(),5));
		
		System.out.println(findMinInsertionsUsingLCS("abcde".toCharArray(),5));
		
	}

}
