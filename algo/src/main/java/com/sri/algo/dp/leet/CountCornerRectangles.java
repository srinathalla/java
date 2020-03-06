package com.sri.algo.dp.leet;

import java.util.HashMap;
import java.util.Map;

public class CountCornerRectangles {
	
	public int countCornerRectangles(int[][] grid) 
	{
		int ans = 0;
		for(int i=0; i< grid.length -1; i++)
		{
			for(int j=i+1; j < grid.length;j++)
			{
				int counter = 0;
				for(int k=0; k < grid[0].length;k++)
				{
					if(grid[i][k] == 1 && grid[j][k] == 1)
					{
						counter++;
					}
				}
				
				ans += counter * (counter -1)/2;
			}
		}
		return ans;
	}

	public int countCornerRectanglesUsingMap(int[][] grid) {
		
		Map<Integer,Integer> count = new HashMap<>();
		int ans = 0;
		for(int[] row : grid)
		{
			for(int c1 =0; c1<row.length;c1++)
			{	
				if(row[c1] == 1)
				{
				
					for(int c2 = c1 + 1; c2 < row.length;c2++)
					{
						if(row[c2] == 1)
						{
							int pos = c1*200 + c2;
							int val = count.getOrDefault(pos, 0);
							ans += val;
							count.put(pos, val + 1);
							
						}
					}
				}
			}
		}
		
		
		return ans;
	}

	public static void main(String[] args) {

		int[][] matrix = { { 1, 0, 0, 1, 0 }, { 0, 0, 1, 0, 1 }, { 0, 0, 0, 1, 0 }, { 1, 0, 1, 0, 1 } };
		
		CountCornerRectangles countCornerRectangles = new CountCornerRectangles();
		System.out.println(
			countCornerRectangles.countCornerRectangles(matrix));

	}

}
