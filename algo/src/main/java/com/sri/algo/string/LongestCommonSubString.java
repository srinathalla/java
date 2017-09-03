package com.sri.algo.string;

public class LongestCommonSubString {
	
	
	public static int getLongestCommonSubStr(String s1,String s2)
	{
		
		int[][] arr = new int[s1.length() + 1][s2.length() + 1];
		int lcs = 0;
		int l =0;
		
		for (int i =0; i <= s1.length() ; i++)
		{	
			for (int j =0; j <= s2.length() ; j++)
			{
				
				 if (i ==0 || j ==0)
				 {
					 arr[i][j] = 0;
				 }
				 else if (s1.charAt(i -1) == s2.charAt(j -1))
				 {
					 arr[i][j] = arr[i-1][j-1] + 1;
					 
					 if (arr[i][j] > lcs)
					 {
						 lcs = arr[i][j];
						 l = i;
					 }
				 }
				 else
				 {
					 arr[i][j] = 0;	 
				 }	
			}
		}
		
		
		
		System.out.println(s1.substring(l -lcs, l));
	
		 
		
		return lcs;
	}
	
	public static void main(String[] args) {
		
		System.out.println(
			getLongestCommonSubStr(
				"GeeksforGeeks.org" , 
				"GeeksQuiz.com"));
		
	}

}
