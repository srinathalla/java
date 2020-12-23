package com.sri.algo.array.leet.medium;

import java.util.Arrays;

public class RandomPickWithWeight {
	
	
	      double [] p;
	    public RandomPickWithWeight(int[] w) {
	        this.p = new double[w.length];
	        
	        int s = 0;
	        for(int a : w)
	            s += a;
	            
	        for(int i=0; i< w.length;i++)
	        {
	            w[i] += i > 0 ? w[i-1] : 0;
	            this.p[i] = w[i]/s;
	        }
	        
	        for(double pr : this.p)
	             System.out.print(pr + " ");
	    }
	    
	    public int pickIndex() {
	       
	        return Math.abs(Arrays.binarySearch(this.p,Math.random())) - 1;
	        
	    }
	    
	    public static void main(String[] args) {
	    	
	    	  RandomPickWithWeight rpw = new RandomPickWithWeight(new int[] {1});
	  	    System.out.println(
  	    		rpw.pickIndex());
			
		}

	  
	   
}
