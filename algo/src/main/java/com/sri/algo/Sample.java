package com.sri.algo;

import java.util.Arrays;

public class Sample {

	static int getLazyEscalations(int k, int[] escalations) {

		Arrays.sort(escalations);

		int minEscalations = 0;

		for (int i = escalations.length - 1; i >= 0; i--) {
			if (k <= 0) {
				break;
			}

			k = k - escalations[i];
			minEscalations++;
		}

		if (k > 0) {
			return -1;
		}

		return minEscalations;
	}

	
	static int getLongestBalancedChromosome(String c) {
		
		int max = -1;
		for (int i=0;i < c.length();i++)
		{
			
			for (int j=i;j < c.length();j++)
			{
				
				if(isBalanced(c,i,j))
				{
					max = Math.max(max, (j-i +1));
				}
			}
		}
		
		return max;

    }
	
	private static boolean isBalanced(String c,int i,int j)
	{
		
		int zC =0;
		int oC = 0;
		
		for (int l =i; l <= j;l++)
		{
			if (c.charAt(l) == '0')
			{
				zC++;
			}
			if (c.charAt(l) == '1')
			{
				oC++;
			}
		}
		
		return zC == oC;
		
	}
	
	
	
	// driver program
	public static void main(String args[]) {

		// System.out.println(getLazyEscalations(5, new int[] { 1, 1, 1, 1, 2, 2, 3, 2, 2, 1, 1, 1 }));
		
		System.out.println(getLongestBalancedChromosome("11010111"));
	}

}
