package com.sri.algo.string.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStrings {
	
	 // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
    	StringBuilder sb = new StringBuilder();
    	
    	for (String s : strs)
    	{
    		sb.append(s.length()).append('/').append(s);
    	}
    	
    	return sb.toString();
        
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
    	
    	int i =0;
    	List<String> result = new ArrayList<>();
    	while(i < s.length())
    	{
    		int slash = s.indexOf('/', i);
    		
    		int len = Integer.valueOf(s.substring(i, slash));
    		
    		String str = s.substring(slash + 1, slash + 1 + len);
    		
    		result.add(str);
    		
    		i = slash + 1 + len;
    	}
    	
    	return result;
        
    }
    
    public static void main(String[] args) {
    	
    	EncodeAndDecodeStrings encodeAndDecodeStrings = new 
    			EncodeAndDecodeStrings();
    	String s = 	
    			encodeAndDecodeStrings.encode(Arrays.asList(new String[] {"Hello","srinath"}));
    	List<String> list = encodeAndDecodeStrings.decode(s);
    	
    	
    	System.out.println(list);
	}

}
