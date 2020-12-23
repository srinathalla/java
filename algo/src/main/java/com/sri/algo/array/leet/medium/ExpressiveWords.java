package com.sri.algo.array.leet.medium;

public class ExpressiveWords
{
	    public int expressiveWords(String s, String[] words) {
	        
	        int cnt = 0;
	        for(String w : words)
	        {
	            if(stretchy(s,w))
	                cnt++;
	        }
	            
	        return cnt;   
	    }
	    
	    private boolean stretchy(String s, String w)
	    {
	        int i = 0;
	        int j = 0;
	        
	        while(i < s.length() && j < w.length())
	        {
	            if(s.charAt(i) == w.charAt(j))
	            {
	                int scnt = getRepeatedCharsLength(s,i);
	                int wcnt = getRepeatedCharsLength(w,j);
	                if((scnt < 3 && scnt != wcnt) || (scnt >= 3 && wcnt > scnt))
	                    return false;
	                
	                i += scnt;
	                j += wcnt;
	            }
	            else
	                return false;
	        }
	        
	        return i == s.length() && j == w.length();
	    }
	    
	    private int getRepeatedCharsLength(String word,int i)
	    {
	        int j = i;
	        while(j < word.length() && word.charAt(j) == word.charAt(i))
	            j++;
	        
	        return j - i;
	    }
	
	    public static void main(String[] args) {
			
	    	String s = "heeellooo";
	    	String[] words = new String[] {"hello", "hi", "helo"};
	    	
	    	ExpressiveWords ew = new ExpressiveWords();
	    	System.out.println(
    			ew.expressiveWords(s, words));
		}

}
