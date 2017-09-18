package com.sri.algo.array;

public class SegregateZerosAndOnes {
	
	
	/**
	 * Time Complexity O(n).
	 * In Single pass we will be able to arrange zeros followed by ones.
	 * 
	 * @param arr
	 */
	public static void segregateZerosAndOnes(int[] arr)
	{
		
		int i = 0;
		int j = arr.length -1;
		
		while (i  < j)
		{
			// Keep incrementing till u see 0.
			// This exits once it encounter's 1.
			while (arr[i] == 0)
			{
				i++;
			}
			
			// Keep decrementing till u see 1.
			// This exits once it encounter's 0.
			while (arr[j] == 1)
			{
				j--;
			}
			
			// Swap both pointers if both have not crossed yet.
			if (i < j)
			{
				int temp = arr[i] ;
				arr[i] = arr[j] ;
				arr[j] = temp ;
				i++;
				j--;
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
		segregateZerosAndOnes(arr); 
		
		for (int i : arr)
		{
			System.out.print(i + " ");
		}	
	}

}
