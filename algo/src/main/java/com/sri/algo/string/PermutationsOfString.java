package com.sri.algo.string;

public class PermutationsOfString 
{

	public static void permutate(String str)
	{
		permutate(str.toCharArray(),0,str.length() -1);
	}
	
	private static void permutate(char[] input, int l,int h)
	{
		System.out.println("current str:" + String.valueOf(input).substring(l, h +1));
		if (l == h)
		{
			System.out.println("permutation :" + String.valueOf(input));
			return;
		}
		
		
		for (int i = l ; i <= h ; i++)
		{
			swap(input,l,i);
			permutate(input,l +1,h);
			swap(input,l,i);
		}
		
		
	}
	
	private static void swap(char[] input,int i,int j)
	{
		char temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
	
	public static void main(String[] args) {
		
		permutate("ABC");
		
	}
}
