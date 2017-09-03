package com.sri.algo.string;

public class RemoveDuplicates {
	
	
	public static String removeDuplicatesRecursively(String input)
	{
		
		String prevStr = input;
		String currStr = input;
		while(true){
			currStr = removeDuplicates(currStr);
			if (currStr.equals(prevStr))
			{
				break;
			}
			
			prevStr = currStr;
		}
		
		
		return currStr;
		
	}
	
	private static String removeDuplicates(String input)
	{
		char[] inputChars = input.toCharArray();
		
		
		for (int i = 0; i < inputChars.length ; i++)
		{
			int j;
			for (j = i +1 ;j < inputChars.length ; j++)
			{
				 if (inputChars[i] != inputChars[j])
				 {
					 break;
				 }
			}
			
			if (j - i >1)
			{
				for (int l = i; l < j; l++)
				{
					inputChars[l] = '0';
				}
				i = j -1;
			}	
		}
		
		char[] subStr= new char[inputChars.length];
		
		int i =0 ;
		for (char ch : inputChars)
		{
			
			if (ch != '0')
			{
				subStr[i] = ch;
				i++;
			}
		}
		
		return String.valueOf(subStr);
	}
	
	public static void main(String[] args) {
		
		System.out.println(removeDuplicatesRecursively("geeksforgeeg"));
		System.out.println(removeDuplicatesRecursively("azxxxzy"));
		System.out.println(removeDuplicatesRecursively("caaabbbaac"));
		System.out.println(removeDuplicatesRecursively("acaaabbbacdddd"));
		System.out.println(removeDuplicatesRecursively("acbbcddc"));
	}

}
