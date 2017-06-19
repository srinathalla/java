package com.sri.algo.graph;

public class FindNoOfIslands 
{
	
	
	public int countIslands(int[][] array)
	{
		int[][] visitedNodes = new int[array.length][array[0].length];
		
		int count = 0 ;
		for (int i =0 ;i < array.length ; i++)
		{
			for (int j =0 ;j < array[0].length ; j++)
			{
				
				if (array[i][j] == 1 && visitedNodes[i][j] != 1)
				{	
					count++;
					dfs(i,j, array,visitedNodes);
				}
			}
		}
		
		return count;
	}
	
	
	private void dfs(int i, int j, int[][] array,int[][] visitedNodes)
	{
		if (i < array.length && 
			j < array[0].length &&
			i >=0 &&
			j >=0 &&
		    visitedNodes[i][j] == 0 &&
		    array[i][j] == 1)
		{
			visitedNodes[i][j] = 1;
			
			dfs(i,j+1,array,visitedNodes);
			dfs(i,j-1,array,visitedNodes);
			dfs(i+1,j,array,visitedNodes);
			dfs(i+1,j-1,array,visitedNodes);
			dfs(i+1,j+1,array,visitedNodes);
			dfs(i-1,j,array,visitedNodes);
			dfs(i-1,j+1,array,visitedNodes);
			dfs(i-1,j-1,array,visitedNodes);
		}
	}
	
	public static void main(String[] args) 
	{
		FindNoOfIslands find = new FindNoOfIslands();
		
		int count = find.countIslands(new int[][]{  
			{1, 1, 0, 0, 0},
	        {0, 1, 0, 0, 1},
	        {1, 0, 0, 1, 1},
	        {0, 0, 0, 0, 0},
	        {1, 0, 1, 0, 1}
	    });
		
		System.out.println(count);
		
	}

}
