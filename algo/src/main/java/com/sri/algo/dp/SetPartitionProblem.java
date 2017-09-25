package com.sri.algo.dp;

public class SetPartitionProblem {
	
	
	/**
	 * Partition problem is to determine whether a given set can be partitioned
	 * into two subsets such that the sum of elements in both subsets is same.
	 * 
	 *  arr[] = {1, 5, 11, 5}
		Output: true 
		The array can be partitioned as {1, 5, 5} and {11}

		arr[] = {1, 5, 3}
		Output: false 
		
		 T.C : O(2^n)
		 as each node has two children.
	 * @param arr
	 * @return
	 */
	public static boolean isPartionable(int[] arr)
	{
		int sum = 0;
		
		for (int a :arr)
		{
			sum = sum + a;
		}
		
		if (sum % 2 == 1)
		{
			return false;
		}
		
		return isSubSetSum(arr,arr.length,sum/2,"");
	}
	
	
	public static boolean isSubSetSum(int[] arr,int n,int sum,String path)
	{
		if (sum == 0)
		{
			System.out.println(path);
			return true;		
		}
		
		if (sum < 0 || n <= 0)
		{
			return false;
		}
		
		return 
			isSubSetSum(arr,n-1,sum,path) || 
			isSubSetSum(arr, n-1, sum - arr[n-1], arr[n-1] + "," + path);	
	}
	
	public static boolean isPartionableWithDP(int[] arr)
	{
		int sum = 0;
		
		for (int a :arr)
		{
			sum = sum + a;
		}
		
		if (sum % 2 == 1)
		{
			return false;
		}
		
		boolean[][] table = new boolean[arr.length +1][sum/2 + 1];
		
		// Fill first column, if sum is zero all true.
		// just {} is the partiontion.
		for (int i =0 ;i < table.length ; i++)
		{
			table[i][0] = true;
		}
		
		// Fill first row.i.e if no elements there 
		// can only be empty set. other than sum 0 all are false.
		for (int j =1 ;j < table[0].length  ; j++)
		{
			table[0][j] = false;
		}
		
		for (int i =1 ;i < table.length ; i++)
		{
			for (int j =1 ;j < table[0].length ; j++)
			{
				
				if (arr[i-1] <= j)
				{		
					// Include the current element in subset/exclude it.
					table[i][j] = table[i][j- arr[i-1]] || table[i-1][j]  ;
				}
				else
				{
					// If curr element is bigger than sum it has to be excluded.
					table[i][j] = table[i-1][j];
				}
			}
		}
			
		return table[arr.length -1][sum/2];
	}
	
	public static void main(String[] args) {
		
		System.out.println(isPartionable(new int[] {1, 5, 11, 5}));
		
		System.out.println(isPartionable(new int[] {1, 5, 3}));	
		
		System.out.println(isPartionableWithDP(new int[] {1, 5, 11, 5}));
		
		System.out.println(isPartionableWithDP(new int[] {1, 5, 3}));	
		
	}

}
