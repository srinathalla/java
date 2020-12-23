package com.sri.algo.array.leet.hard;

import java.util.ArrayList;
import java.util.List;

public class BusiestServers {
	
	
	    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
	        
	        
	        int res = 0;
	      
	        int[][] servers = new int[k][2];
            for(int i= 0; i< servers.length; i++)
            {
                servers[i][0] = 1;   
            }        
	        for(int i=0 ; i < arrival.length; i++)
	        {
	               int at = arrival[i];
	               int s = i % k;
	               for(int j=0; j < k;j++)
	               {
	            	   
	                   if(servers[s][0] <= at)
	                   {
	                       servers[s][0] = at + load[i];
	                       servers[s][1] += 1;
	                       res= Math.max(res, servers[s][1]);
	                       break;     
	                    }   
	                    s = (s + 1) % k; 
	               }
	        }
	       
	        List<Integer> result = new ArrayList<>();
	        for(int i= 0; i< servers.length; i++)
	        {
	           if(servers[i][1] == res)
	           {
	               result.add(i);
	           }
	            
	        }
	        
	        return result;
	        
	    }
	    
	    public static void main(String[] args) {
	    	
	    	BusiestServers bs = new BusiestServers();
	    	
	    	int k = 3;
	    	int[] arrival = new int[] {1,2,3,4,8,9,10};			
	    	int[] load = new int[] {5,2,10,3,1,2,2};
	    	System.out.println(
    			bs.busiestServers(k, arrival, load));
			
		}
	

}
