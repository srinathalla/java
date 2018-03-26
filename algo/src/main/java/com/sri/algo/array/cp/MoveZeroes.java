package com.sri.algo.array.cp;


/**
 * Given an array nums, write a function to move all 0's to the end of it while 
 * maintaining the relative order of the non-zero elements.

  For example, given nums = [0, 1, 0, 3, 12], after calling your function, 
  nums should be [1, 3, 12, 0, 0].
  
   You must do this in-place without making a copy of the array.
	Minimize the total number of operations.
	
 * @author salla
 *
 */
public class MoveZeroes
{

	/**
	 * T.C : O(n).
	 * Single Pass Solution.
	 * 
	 * Using backup array.
	 * 
	 * @param nums
	 */
	 public void moveZeroesWithBackUpArray(int[] nums) 
	 {
		 
		 	int n = nums.length;
		 	
		 	if (n == 0)
		 	{
		 		return;
		 	}
		 	
		 	int[] numsC = new int[n];
		 	int j = 0;
		 	
		 	int zC = 0;
		 
		 	for (int i=0 ;i < n; i++)
		 	{
		 		if (nums[i] == 0)
		 		{
		 			zC++;
		 		}
		 		else
		 		{
		 			numsC[j] = nums[i];
		 			j++;
		 		}
		 	}
		 	
		 	for (int i=1;i <zC;i++)
		 	{
		 		numsC[j] =0;
		 		j++;
		 	}
		 	
		 	for (int i=0 ;i < n; i++)
		 	{
		 		nums[i] = numsC[i];
		 	}	
	 }
	 
	 /**
	  * T.C : O(n).
	  * 
	  * Two pointer solution both pointers starts at 0 index.
	  * 
	  * @param nums
	  */
	 public void moveZeroesWithTwoPointersStartingAtIndexZero(int[] nums) 
	 {
		 	int n = nums.length;	
		 	if (n == 0)
		 	{
		 		return;
		 	}
		 	
		  
		    int zp =0;
		    int nzp = 0;
		    
		    while(zp < n && nzp < n)
		    {
		    	
		    	 while (zp < n && nums[zp] != 0)
		    	 {
		    		 zp++;
		    	 }
		    	 
		    	 while (nzp < n && (nums[nzp] == 0 || nzp < zp))
		    	 {
		    		 nzp++;
		    	 }
		    	 
		    	 if(zp < n && nzp < n)
		    	 {
			    	 int tmp = nums[zp];
			    	 nums[zp] = nums[nzp];
			    	 nums[nzp] = tmp;	
		    	 }
		    } 	
	 }
	 
	 /**
	  * T.C : O(n).
	  * 
	  * Copy all non zero elements to the left and fill the remaining slots with zero.
	  * 
	  * @param nums
	  */
	 public void moveZeroes(int[] nums) 
	 {
	 	  int n = nums.length;	
	 	  if (n == 0)
	 	  {
	 	 	return;
	 	  }
		 	
		  int pos = 0;
		  for (int no : nums)
		  {
			  if (no != 0)
			  {
				  nums[pos++] = no;
			  }
		  }
		  
		  while(pos < n)
		  {
			  nums[pos++] = 0;
		  }
		  
	 }
	 
	 private static void printArray( int[] arr)
	 {
		 System.out.println();
		 for (int i=0 ;i < arr.length; i++)
	 	 {
			 	System.out.print(arr[i] + " ");
	 	 }
	 }
	 
	 public static void main(String[] args) {
		 
		 int[] arr =  new int[] {0, 1, 0, 3, 12};
		 int[] arr1 =  new int[] {1, 0};
		 MoveZeroes mZ = new MoveZeroes();
	/*	 mZ.moveZeroesWithBackUpArray(arr);
		 mZ.moveZeroesWithBackUpArray(arr1);*/
		 
		 
		 mZ.moveZeroes(arr);
		 mZ.moveZeroes(arr1);
		 
		 printArray(arr);
		 printArray(arr1);
		 
	 	
		
	}
}
