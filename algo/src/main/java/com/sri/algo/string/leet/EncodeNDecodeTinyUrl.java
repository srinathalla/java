package com.sri.algo.string.leet;

import java.util.HashMap;
import java.util.Map;

/**
 *  TinyURL is a URL shortening service where you enter a URL such
 *  as https://leetcode.com/problems/design-tinyurl and it 
 *  returns a short URL such as http://tinyurl.com/4e9iAk.
 *  
 * @author salla
 *
 */
public class EncodeNDecodeTinyUrl {
	
	Map<Integer,String> map = new HashMap<>();
	int i = 0;
	
	  // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
    		
    	map.put(i, longUrl);
    	
    	String url = "http://tinyurl.com/" + i++;
    	
    	return url;
    	    
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
    	
    	int code = Integer.parseInt(
    			shortUrl.replace("http://tinyurl.com/", ""));
    	
    	return map.get(code);
        
    }

}
