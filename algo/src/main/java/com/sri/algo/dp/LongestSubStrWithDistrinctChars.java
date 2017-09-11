package com.sri.algo.dp;

public class LongestSubStrWithDistrinctChars 
{
	   static final int NO_OF_CHARS = 256;
     
	    static int longestUniqueSubsttr(String str)
	    {
	       int max_len =1;
	       int startIndex = 0;
	       int endIndex = 0;
	       int curr_len = 1;
	       int[] visited = new int[NO_OF_CHARS];
	       
	       
	       for (int i =0 ;i < NO_OF_CHARS ; i ++)
	       {
	    	   visited[i] = -1;
	       }

	       visited[str.charAt(0)] = 0;
	       
	       for (int i =1;i < str.length() ; i++)
	       {
	    	   int prevIndex = visited[str.charAt(i)];
	    	   
	    	   if (prevIndex == -1 || i - curr_len > prevIndex)
	    	   {
	    		   curr_len++;
	    	   }
	    	   
	    	   else
	    	   {
	    		   if (curr_len > max_len)
	    		   {
	    			   max_len = curr_len;
	    			   startIndex = i - curr_len;
					   endIndex = i;
	    			  
	    		   }
	    		   
	    		   curr_len = i - prevIndex;
	    	   }
	    	   
	    	   visited[str.charAt(i)] = i;
	    	   
	       }
	       
	       if (curr_len > max_len)
		   {
			   max_len = curr_len;
			   
		   }
	       
	       System.out.println(str.substring(startIndex, endIndex));
		  
	       return max_len;   
	    }
	    
	    public static void main(String[] args)
	    {
			System.out.println(longestUniqueSubsttr("ABDEFGABEF"));
		}

}
