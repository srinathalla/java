package com.sri.algo.array.leet.medium;

import java.util.ArrayList;
import java.util.List;

public class BestCoordinate {
	
	    public int[] bestCoordinate(int[][] towers, int radius) {
	        
	        int n = towers.length;
	        List<int[]> res= new ArrayList<>();
	        
	        int maxVal = 0;
	        for(int i=0 ; i < n;i++)
	        {
	            int x1 = towers[i][0], y1 = towers[i][1];
	            int q = 0;
	            for(int j=0 ; j < n;j++)
	            {
	                int x2 = towers[j][0], y2 = towers[j][1];
	                Double d= towers[j][2]/ (1 + distance(x1,y1,x2,y2));
	                q += d.intValue();
	                
	            }
	            if(q > maxVal)
                {
                    maxVal = q;
                    res= new ArrayList<>();
                    res.add(new int[]{x1,y1});
                }
                else if(q == maxVal)
                {
                    res.add(new int[]{x1,y1});
                }
	        }
	        
	        res.sort((a,b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
	        
	        return res.get(0);
	        
	    }
	    
	    private double distance(int x1, int y1, int x2, int y2)
	    {
	        return Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
	    }
	public static void main(String[] args) {
		
		BestCoordinate bc = new BestCoordinate();
		int[][] towers = new int[][] {{1,2,5},{2,1,7},{3,1,9}};
		int radius = 2;
		
		System.out.println(
			bc.bestCoordinate(towers, radius));
		
	}

}
