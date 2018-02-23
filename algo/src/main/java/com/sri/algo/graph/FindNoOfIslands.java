package com.sri.algo.graph;


/**
 * Given a boolean 2D matrix, find the number of islands.
 * A group of connected 1s forms an island. For example, the below matrix contains 5 islands

  Input : mat[][] = {{1, 1, 0, 0, 0},
                     {0, 1, 0, 0, 1},
                     {1, 0, 0, 1, 1},
                     {0, 0, 0, 0, 0},
                     {1, 0, 1, 0, 1} 
  Output : 5
  
  Time Complexity : O(n*m).
  Auxillay space : O(n*m).
 *
 *
 */
public class FindNoOfIslands 
{
	
	 public int numIslands(char[][] grid) {
	        
	        int count =0 ;
	        
	        int n = grid.length;
	        int m = grid[0].length;
	        boolean[][] visited = new boolean[n][m];
	       
	        
	        for (int i=0;i<n;i++)
	        {
	            for (int j=0;j<m;j++)
	            {
	            
	                if(grid[i][j] == '1' && !visited[i][j])
	                {
	                    count++;
	                    dfs(grid, i,j,n,m,visited);
	                }
	            }
	        }
	        return count;
	    }
	    
	 private static boolean isValid(int i,int j,int N,int M)
	 {
			return i >= 0 && i < N && j >=0 && j < M; 
	 }
	 
     private void dfs(char[][] grid,int i,int j,int n,int m, boolean[][] visited) 
     {
    	 visited[i][j] = true;
    	 
    	 
    	 int[] adjRows = new int[] { 0,  0,-1, 1};
    	 int[] adjCols = new int[] { -1, 1, 0, 0};
    	 
    	 for (int l=0 ;l  < 4 ;l ++)
    	 {	 
    		 int adjR = i + adjRows[l];
    		 int adjC = j + adjCols[l];
    		 
    		if (isValid(adjR,adjC,n,m) && !visited[adjR][adjC] && grid[adjR][adjC] == '1')
    		{
    			 dfs(grid, adjR, adjC, n, m, visited);
    		}
    	 }
       
        
     }
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
