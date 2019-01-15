package com.sri.algo.graph.leet;

import com.sri.algo.array.PrintArray;

public class SortColors {
	
	/**
	 * Single pass solution T.C : O(n).
	 * 
	 * @param A
	 */
	public void sortColors(int A[]) {
	  int zero =0 ,second = A.length -1;
	  
	  for (int i=zero; i<=second; i++)
	  {  
		  if (A[i] == 0 && i > zero)
		  {
			  int tmp = A[i];
			  A[i--] = A[zero]; // we should not increment i as the number swapped might be zero or 2.
			  A[zero++] = tmp;
		  }
		  else if (A[i] == 2 && i < second)
		  {
			  int tmp = A[i];
			  A[i--] = A[second]; // we should not increment i as the number swapped might be zero or 2.
			  A[second--] = tmp;
		  }
	  }
	}
	
	public static void main(String[] args) {
	
		SortColors sortColors = new SortColors();
		// int[] arr = new int[] { 2,0,2,1,1,0 };
		int[] arr = new int[] { 1,2,0 };
		sortColors.sortColors(arr);
		
		PrintArray.print(arr);
	}


}
