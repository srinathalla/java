package com.sri.algo.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount {
	
	public static void main(String[] args) {
		
		
		 try(Scanner in = new Scanner(System.in))
		 {
	        int n = in.nextInt();
	        
	        Map<String,Integer> wordCount = new HashMap<>();
	        
	        for(int arr_i=0; arr_i < n; arr_i++){
	            String word = in.next();
	            
	            if(!wordCount.containsKey(word))
	            {
	            	wordCount.put(word, 0);
	            }
	            
	            Integer count = wordCount.get(word);
	            wordCount.put(word,++count);
	        }
	        
	        int queries = in.nextInt();
	        for(int i = 0 ; i< queries ;i++)
	        {
	        	Integer count = wordCount.get(in.next());
	        	
	        	System.out.println( count != null ? count :  0);
	        }
	       
		 }
	}

}
