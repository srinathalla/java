package com.sri.algo.string;

public class CheckStrRotatedByTwoPlaces {
	
	
	public static int checkStringRotatedByTwoPlaces(String str,String rotStr)
	{
		if (str == null || rotStr == null || rotStr.length() != str.length())
		{
			return 0;
		}
		
		// Anti Clock wise rotated.
		if (rotStr.substring(rotStr.length() -2).equals(str.substring(0,2)) &&
			rotStr.substring(0, rotStr.length() -2).equals(str.substring(2)))
		{
			return 1;
		}
		
		
		// Clock wise rotated check.
		if (rotStr.substring(0,2).equals(str.substring(rotStr.length() -2)) &&
			rotStr.substring(2).equals(str.substring(0,rotStr.length() -2)))
		{
			return 1;
		}
		
		return 0;
	
	}
	
	public static void main(String[] args)
	{
		
		System.out.println(checkStringRotatedByTwoPlaces("amazon","azonam"));

		System.out.println(checkStringRotatedByTwoPlaces("amazon","onamaz"));
		System.out.println(checkStringRotatedByTwoPlaces("geeksforgeeks","geeksgeeksfor"));
	}

}
