package com.sri.algo.dp.leet.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestDistanceToColor {
	
	
	    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
	        
	        int n = colors.length;
	        int[][] dp = new int[n][4];
	        
	        for(int i=0; i<n;i++)
	        {
	            Arrays.fill(dp[i], Integer.MAX_VALUE);
	        }
	       
	        
	        for(int i=1;i < colors.length; i++)
	        {
	           int c = colors[i];
	           
	            for(int j=0; j < 4;j++)
	            {
	            	
	                dp[i][j] = j == c ? 0 : dp[i-1][j] != Integer.MAX_VALUE ? 
	                		dp[i-1][j] + 1 : dp[i][j];
	            }
	        }
	        
	         for(int i=colors.length-2;i >= 0; i--)
	         {
	           int c = colors[i];
	           
	            for(int j=0; j < 4;j++)
	            {
	                dp[i][j] = j == c ? 0 : dp[i+1][j] !=  Integer.MAX_VALUE ? 
	                		Math.min(dp[i][j],dp[i+1][j] + 1) : dp[i][j];
	            }
	          }
	        
	        
	        var res = new ArrayList<Integer>();
	        
	        
	        for(int[] q : queries)
	        {
	        	int val = dp[q[0]][q[1]] == Integer.MAX_VALUE ? -1 : dp[q[0]][q[1]];
	            res.add(val);
	        }
	                       
	        return res;   
	    }
	    
	public static void main(String[] args) {
		
		int[] colors = new int[] {1,1,2,1,3,2,2,3,3};
		
		int[][] queries = new int[][] {{1,3},{2,2},{6,1}};
		ShortestDistanceToColor sd = new ShortestDistanceToColor();
		System.out.println(sd.shortestDistanceColor(colors, queries));
		
	}

}
