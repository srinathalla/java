package com.sri.algo.backtrack;


/**
 * Backtracking is an algorithmic paradigm that tries different solutions until finds a solution that “works”. 
 * Problems which are typically solved using backtracking technique have following property in common. 
 * These problems can only be solved by trying every possible configuration and each configuration is tried only once. 
 * A Naive solution for these problems is to try all configurations and output a configuration that follows given 
 * problem constraints. Backtracking works in incremental way and is an optimization over the Naive solution 
 * where all possible configurations are generated and tried.
 * 
 */
public class KnightTour 
{
	static class Step
	{
		public int val = 0;
	}
	
	public static boolean knightTour(int[][] table)
	{	
		Step step = new Step();
		
		table[0][0] = 0;
		
		 if (KTUtil(table, 0, 0, step))
		 {
			 print(table);
			 return true;
		 }
		 
		return false; 
	}
	
	private static void print(int[][] table)
	{
		 for (int i =0;i < table.length ;i++)
		 {
			for (int j =0 ;j < table[0].length ; j++)
			{
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		 }
	}
	
	private static boolean KTUtil(int[][] table,int r,int c,Step step)
	{
		if (tourComplete(table))
		{
			return true;
		}
		
		int[] row = new int [] {-1, -1 ,1, 1, -2,-2 ,2,2};
		int[] col = new int [] {-2,  2,-2, 2, -1, 1, -1,1};
		
		for (int i =0; i < 8 ; i++)
		{
			int adjR = row[i] + r;
			int adjC = col[i] + c;
			if (isSafe(table, adjR, adjC))
			{
				table[adjR][adjC] = ++step.val;
				
				if (KTUtil(table, adjR, adjC, step))
				{
					return true;
				}
				
				table[adjR][adjC] = -1;
				step.val--;
			}
		}
		
		return false;
	}
	
	private static boolean isSafe(int[][] table ,int r,int c)
	{
		return (r >= 0 && r < table.length) && (c >=0 && c < table[0].length) && table[r][c] == -1;
		
	}
	
	private static boolean tourComplete(int[][] table) 
	{ 
		for (int i =0;i < table.length ;i++)
		{
			for (int j =0 ;j < table[0].length ; j++)
			{
				if (table[i][j] == -1)
				{
					return false;
				}
			}
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		
		int[][] table = new int[8][8];
		
		for (int i =0;i < table.length ;i++)
		{
			for (int j =0 ;j < table[0].length ; j++)
			{
				table[i][j] = -1 ;
				
			}
		}
		
		System.out.println(knightTour(table));
	}
	
}
