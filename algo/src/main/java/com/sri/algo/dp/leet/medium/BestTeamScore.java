package com.sri.algo.dp.leet.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BestTeamScore {
	
	
	 public int bestTeamScore(int[] scores, int[] ages) {
	        
	        var ageScores = new ArrayList<int[]>();
	        
	        int n = scores.length;
	        for(int i=0; i< n;i++)
	        {
	            ageScores.add(new int[]{ages[i],scores[i]});
	        }
	        
	        Collections.sort(ageScores,Comparator.comparing(a -> -a[0]));
	        
	        int result = 0;
	        
	        int[] dp = new int[n];
	        for(int i=0; i< ageScores.size();i++)
	        {
	            dp[i] = ageScores.get(i)[1];
	            int score = ageScores.get(i)[1];
	            for(int j=0; j< i;j++)
	            {
	                if(ageScores.get(i)[0] == ageScores.get(j)[0] ||
	                		ageScores.get(j)[1] >= ageScores.get(i)[1])
	                {
	                    dp[i] = Math.max(dp[i], dp[j] + score);
	                }
	            }
	            
	            result = Math.max(result,dp[i]);
	        }
	        return result;
	    }
	 
	

}
