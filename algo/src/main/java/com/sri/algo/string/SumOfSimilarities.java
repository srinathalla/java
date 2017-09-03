package com.sri.algo.string;

public class SumOfSimilarities {
	
	/**
	 * Compute lenght of longest common prefix for given String with all its possible suffixes.
	 * 
	 * @param inputs
	 * @return
	 */
	public static int[] sumOfSimilarities(String[] inputs)
	{
		int[] result = new int[inputs.length];
		
		for (int j = 0; j < inputs.length ; j++)
		{
			int sum =0 ;
			char[] currString = inputs[j].toCharArray();
			for (int i = 0 ;i < currString.length ; i++)
			{
				sum = sum + lcp(currString, i);
			}	
			result[j] = sum;
		}
		
		return result;
	}
	
	/**
	 * Gets the common prefix of given string and its subString
	 * @param c1
	 * @param j
	 * @return
	 */
	private static int lcp(char[] c1,int j)
	{
			
		int i = 0;
		
		int lcp = 0;
		while (i < c1.length && j < c1.length)
		{		
			if (c1[i] != c1[j])
			{
				break;
			}
			
			lcp++;
			i++;
			j++;
		}
		
		return lcp;	
	}
	
	public static void main(String[] args) {
		
		System.out.println(sumOfSimilarities(new String[] {"ababaa","aa"}));
	

		
		
	}

}
