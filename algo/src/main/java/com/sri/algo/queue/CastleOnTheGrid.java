package com.sri.algo.queue;

import java.util.Scanner;

public class CastleOnTheGrid {
	
	private int count;
	
	private void findLeastPath(char[][] grid,int i,int j,int x,int y)
	{
		
		if(i >=0 && j >=0 && i < grid.length && j < grid.length && grid[i][j] != 'X')
		{
			if(i == x && j==y)
			{
				return;
			}
			
			count++;
			
			if (i == 0 || i == grid.length -1)
			{
				findLeastPath(grid,i,j + 1,x,y);
				findLeastPath(grid,i,j -1,x,y);
			}
			
			if (j== 0 || j == grid.length -1)
			{
				findLeastPath(grid,i + 1,j,x,y);
				findLeastPath(grid,i -1,j,x,y);
			}
			
			if (i != 0 && i != grid.length -1 && j != 0 && j != grid.length -1)
			{
				findLeastPath(grid,i,j + 1,x,y);
				findLeastPath(grid,i,j -1,x,y);
				findLeastPath(grid,i + 1,j,x,y);
				findLeastPath(grid,i -1,j,x,y);
			}
		}
	}
	
	public static void main(String[] args) {
		
		CastleOnTheGrid castle = new CastleOnTheGrid();
		
		try(Scanner in = new Scanner(System.in))
		{
			int n = in.nextInt();		
			char[][] grid = new char[n][n];
			
			for(int i =0 ; i < n ; i++)
			{
				String input = in.nextLine();
				input = !input.isEmpty() ? input : in.nextLine();
				
				char[] inputChars = input.toCharArray();
				for(int j =0;j < n;j++)
				{
					grid[i][j] = inputChars[j];
				}
			}
			
			String input = in.nextLine();
			input = !input.isEmpty() ? input : in.nextLine();
			
			int i = Integer.valueOf(input.split(" ")[0]);
			int j = Integer.valueOf(input.split(" ")[1]);
			int x = Integer.valueOf(input.split(" ")[2]);
			int y = Integer.valueOf(input.split(" ")[3]);
			castle.findLeastPath(grid,i,j,x,y);
			
			System.out.println(castle.count);
		}
	}

}
